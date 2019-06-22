/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.File;

import edu.upc.freeling4.*;
import java.util.ArrayList;
/**
 *
 * @author dertas
 */
public class FreeLing {
    private static final String OS = System.getProperty("os.name").toLowerCase();
    private static LangIdent lgid;
    private static Tokenizer tk;
    private static Splitter sp;
    public static Maco mf;
    public static HmmTagger tg;
    public static DepTxala dep;
    public static Nec neclass;
    public static Senses sen;
    public static Ukb dis;
    
    
  public static void loadFreeLing() throws IOException {
    
      System.out.println(System.getProperty("java.library.path"));
    // connect to FreeLing library
    System.loadLibrary( "Jfreeling" );

    // Check whether we know where to find FreeLing data files
    String FLDIR = "/home/dertas/FreeLing";

    File f = new File(FLDIR+"/share/freeling");
    if (! f.exists()) {
	System.err.println("Folder "+FLDIR+"/share/freeling not found.");
        System.err.println("Please set FREELINGDIR environment variable to FreeLing installation directory");
	System.exit(1);
    }
    
    // Location of FreeLing configuration files.
    String DATA = FLDIR + "/share/freeling/";
    
    // Init locales
    Util.initLocale( "default" );

    // Create options set for maco analyzer.
    String LANG = "en";
    MacoOptions op = new MacoOptions( LANG );

    op.setDataFiles( "", 
                     DATA + "common/punct.dat",
                     DATA + LANG + "/dicc.src",
                     DATA + LANG + "/afixos.dat",
                     "",
                     DATA + LANG + "/locucions.dat", 
                     DATA + LANG + "/np.dat",
                     DATA + LANG + "/quantities.dat",
                     DATA + LANG + "/probabilitats.dat");

    // Create analyzers.

    // language detector. Used just to show it. Results are printed
    // but ignored (after, it is assumed language is LANG)
    lgid = new LangIdent(DATA + "/common/lang_ident/ident-few.dat");

    tk = new Tokenizer( DATA + LANG + "/tokenizer.dat" );
    sp = new Splitter( DATA + LANG + "/splitter.dat" );
    

    mf = new Maco( op );
    mf.setActiveOptions(false, true, true, true,  // select which among created 
                        true, true, false, true,  // submodules are to be used. 
                        true, true, true, true);  // default: all created submodules 
                                                  // are used

    tg = new HmmTagger( DATA + LANG + "/tagger.dat", true, 2 );
    ChartParser parser = new ChartParser(
      DATA + LANG + "/chunker/grammar-chunk.dat" );
    dep = new DepTxala( DATA + LANG + "/dep_txala/dependences.dat",
      parser.getStartSymbol() );
    neclass = new Nec( DATA + LANG + "/nerc/nec/nec-ab-poor1.dat" );

    sen = new Senses(DATA + LANG + "/senses.dat" ); // sense dictionary
    dis = new Ukb( DATA + LANG + "/ukb.dat" ); // sense disambiguator
    System.out.println("FreeLing is loaded!");
  }
  
  public static ArrayList<Word> inputText(String text){
      // Make sure the encoding matches your input text (utf-8, iso-8859-15, ...)
    String line = text;
    System.out.println(text);

    SWIGTYPE_p_splitter_status sid = sp.openSession();
    
    String lg = lgid.identifyLanguage(line);
    System.out.println( "-------- LANG_IDENT results -----------" );
    System.out.println("Language detected (from first line in text): " + lg);
    
      // Extract the tokens from the line of text.
      ListWord l = tk.tokenize( line );

      // Split the tokens into distinct sentences.
      ListSentence ls = sp.split( sid, l, false );

      // Perform morphological analysis
      mf.analyze( ls );

      // Perform part-of-speech tagging.
      tg.analyze( ls );

      // Perform named entity (NE) classificiation.
      neclass.analyze( ls );

      sen.analyze( ls );
      dis.analyze( ls );
      ArrayList<Word> words = getWords(ls);
      sp.closeSession(sid);
      return words;
  }
  
  public static ArrayList<Word> getWords(ListSentence ls){
      ArrayList<Word> words = new ArrayList<Word>();  
      System.out.println( "-------- TAGGER results -----------" );
      // get the analyzed words out of ls.
      ListSentenceIterator sIt = new ListSentenceIterator(ls);
      while (sIt.hasNext()) {
        Sentence s = sIt.next();
        ListWordIterator wIt = new ListWordIterator(s);
        while (wIt.hasNext()) {
          Word w = wIt.next();
            words.add(w);
          System.out.print(
            w.getForm() + " " + w.getLemma() + " " + w.getTag() );
          System.out.println();
        }
        System.out.println();
      }
    return words;
  }
  

  private static void printSenses( Word w ) {
    String ss = w.getSensesString();

    // The senses for a FreeLing word are a list of
    // pair<string,double> (sense and page rank). From java, we
    // have to get them as a string with format
    // sense:rank/sense:rank/sense:rank
    // which will have to be splitted to obtain the info.
    //
    // Here, we just output it:
    System.out.print( " " + ss );
  }

  private static void printResults( ListSentence ls, String format ) {
      
    if (format == "parsed") {
      System.out.println( "-------- CHUNKER results -----------" );

      ListSentenceIterator sIt = new ListSentenceIterator(ls);
      while (sIt.hasNext()) {
	Sentence s = sIt.next();
        ParseTree tree = s.getParseTree();
        printParseTree( 0, tree );
      }
    }
    else if (format == "dep") {
      System.out.println( "-------- DEPENDENCY PARSER results -----------" );

      ListSentenceIterator sIt = new ListSentenceIterator(ls);
      while (sIt.hasNext()) {
	Sentence s = sIt.next();
        DepTree tree = s.getDepTree();
        printDepTree( 0, tree);
      }
    }
  }

  private static void printParseTree( int depth, ParseTree tr ) {
    Word w;
    long nch;

    // Indentation
    for( int i = 0; i < depth; i++ ) {
      System.out.print( "  " );
    }

    nch = tr.numChildren();

    if( nch == 0 ) {
      // The node represents a leaf
        if( tr.begin().getInformation().isHead() ) {
        System.out.print( "+" );
      }
      w = tr.begin().getInformation().getWord();
      System.out.print("(" + w.getForm() + " " + w.getLemma() + " " + w.getTag() );
      printSenses( w );
      System.out.println( ")" );
    }
    else
    {
      // The node is non-terminal
      if ( tr.begin().getInformation().isHead() ) {
        System.out.print( "+" );
      }

      System.out.println( tr.begin().getInformation().getLabel() + "_[" );

      for( int i = 0; i < nch; i++ ) {
        ParseTree child = tr.nthChildRef( i );

        if ( ! child.empty() ) {
          printParseTree( depth + 1, child );
        }
        else {
          System.err.println( "ERROR: Unexpected NULL child." );
        }
      }

      for( int i = 0; i < depth; i++ ) {
        System.out.print( "  " );
      }

      System.out.println( "]" );
    }
  }

  private static void printDepTree( int depth, DepTree tr ) {
    DepTree child = null;
    DepTree fchild = null;
    long nch;
    int last, min;
    Boolean trob;

    for( int i = 0; i < depth; i++ ) {
      System.out.print( "  " );
    }

    System.out.print(
      tr.begin().getLink().getLabel() + "/" +
      tr.begin().getLabel() + "/" );

    Word w = tr.begin().getWord();

    System.out.print(
      "(" + w.getForm() + " " + w.getLemma() + " " + w.getTag() );
    printSenses( w );
    System.out.print( ")" );

    nch = tr.numChildren();

    if( nch > 0 ) {
      System.out.println( " [" );

      for( int i = 0; i < nch; i++ ) {
        child = tr.nthChildRef( i );

        if( child != null ) {
          if( !child.begin().isChunk() ) {
            printDepTree( depth + 1, child );
          }
        }
        else {
          System.err.println( "ERROR: Unexpected NULL child." );
        }
      }

      // Print chunks (in order)
      last = 0;
      trob = true;

      // While an unprinted chunk is found, look for the one with lower
      // chunk_ord value.
      while( trob ) {
        trob = false;
        min = 9999;

        for( int i = 0; i < nch; i++ ) {
          child = tr.nthChildRef( i );

          if( child.begin().isChunk() ) {
            if( (child.begin().getChunkOrd() > last) &&
                (child.begin().getChunkOrd() < min) ) {
              min = child.begin().getChunkOrd();
              fchild = child;
              trob = true;
            }
          }
        }
        if( trob && (child != null) ) {
          printDepTree( depth + 1, fchild );
        }

        last = min;
      }

      for( int i = 0; i < depth; i++ ) {
        System.out.print( "  " );
      }

      System.out.print( "]" );
    }

    System.out.println( "" );
  }
}
