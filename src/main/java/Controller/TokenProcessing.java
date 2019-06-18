/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import edu.stanford.nlp.ling.CoreAnnotations.LemmaAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import java.util.List;
import java.util.Properties;

/**
 *
 * @author ale_b
 */
public class TokenProcessing {
    private StanfordCoreNLP pipeline;
    private StringBuilder string;
    
    public TokenProcessing(){
        Properties props = new Properties();
        
        props.setProperty("annotators", "tokenize,ssplit,pos,lemma");
        props.setProperty("pos.model", "edu/stanford/nlp/models/pos-tagger/spanish/spanish-distsim.tagger");
        props.setProperty("tokenize.language", "es");
        props.setProperty("lemma.model", "edu/stanford/nlp/models/lemma/spanish/spanish-distsim.tagger");
        this.pipeline= new StanfordCoreNLP(props);
        this.string= new StringBuilder();
        System.out.println(this.getAnnotators("Hola José, was usando una computadora 10"));
    }
    public String getAnnotators(String entry){
        Annotation document = new Annotation(entry);
        
        pipeline.annotate(document);
        
        List<CoreMap> sentences = document.get(SentencesAnnotation.class);

        for(CoreMap sentence: sentences) {
          // traversing the words in the current sentence
          // a CoreLabel is a CoreMap with additional token-specific methods
          for (CoreLabel token: sentence.get(TokensAnnotation.class)) {
            
            // this is the text of the token
            String word = token.get(TextAnnotation.class);
            String lema = token.get(LemmaAnnotation.class);
            // this is the POS tag of the token
            String pos = token.get(PartOfSpeechAnnotation.class);
            // this is the NER label of the token
            String ne = token.get(NamedEntityTagAnnotation.class);
            
            this.string.append(token.lemma() + " [" + pos + "]\n");
          }
        }
        return this.string.toString();
    }
}
