/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author ale_b
 */
public class FileController{
    public String path;
    public File archivo;
    public FileReader fr;
    public BufferedReader br;
    
    
    public FileController (String path){
        this.path=path;
        try{
            this.archivo = new File (this.path);
            this.fr = new FileReader (archivo);
            this.br = new BufferedReader(fr);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void cerrar(){
        try{                    
            if(this.fr != null){   
               this.fr.close();
            }                  
         }
         catch (Exception e2){ 
            e2.printStackTrace();
          }
    }

    public File getArchivo() {
        return archivo;
    }

    public FileReader getFr() {
        return fr;
    }

    public BufferedReader getBr() {
        return br;
    }
}
