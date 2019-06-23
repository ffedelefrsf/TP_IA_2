/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import edu.stanford.nlp.ling.CoreLabel;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

/**
 *
 * @author ale_b
 */
public class TokenProcessing {
    private String inputStr;
    private List<CoreLabel> listaTokens;
    private List<String> inputStrings;
    
    public TokenProcessing(String input){
        this.inputStr=input;
        listaTokens = new ArrayList();
        inputStrings = new ArrayList();
        this.tokenize();
    }
    
    public List<String> tokenize(){
        StringTokenizer st = new StringTokenizer(inputStr);
        while (st.hasMoreElements()){
            String token = characterReplacement(st.nextToken().toLowerCase());
            if(!token.isEmpty()){
                this.inputStrings.add(token);
            } 
        }
        return this.inputStrings;
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
