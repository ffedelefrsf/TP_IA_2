/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;
import static Controller.Comparer.match;
import java.util.Collection;

/**
 *
 * @author ale_b
 */
public class WordController {
    private HashMap<String, ArrayList<String>> keywords;

    public WordController() {
        this.keywords=new HashMap<>();
        try {
            loadKeywords();
        } catch (IOException ex) {
            Logger.getLogger(WordController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void loadKeywords() throws IOException{
        URL url = WordController.class.getClassLoader().getResource("keywords.txt");
        FileController kw = new FileController(url.getPath());
        String linea;
        while ((linea=kw.getBr().readLine())!=null){
            ArrayList<String> set = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(linea);
            String key = st.nextToken(";");
            while (st.hasMoreElements()){
                
                set.add(characterReplacement(st.nextToken("*").replaceAll(";","")));
            }
            keywords.put(key, set);
        }
    }
    
    public String getKey(String input) throws IOException{
        
        for (String key: keywords.keySet()){
            if(input.equals(key)){
                return key;
            }
            else{
                if (keywords.get(key).contains(input)){
                    return key;
                }
            }
        }
        
        return "";
    }
    
    public String characterReplacement(String input){
        String replaced = input.replaceAll("ñ", "ni")
                .replaceAll("á", "a")
                .replaceAll("é", "e")
                .replaceAll("í", "i")
                .replaceAll("ó", "o")
                .replaceAll("ú", "u")
                .replaceAll("[^a-z0-9]", "");
        
        return replaced;
    }

}
