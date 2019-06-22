/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ale_b
 */
public class ProductController {
    ArrayList<Notebook> notebooks;
    ArrayList<Tv> tvs;
    ArrayList<Smartphone> smartphones;
    ArrayList<Tablet> tablets;
    
    public ProductController(){
        this.notebooks= new ArrayList<>();
        this.tvs= new ArrayList<>();
        this.smartphones= new ArrayList<>();
        this.tablets= new ArrayList<>();

        try {
            this.instanciar();
        } catch (IOException ex) {
            Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void instanciar() throws IOException{
        //Obtención de archivos
        URL url = ProductController.class.getClassLoader().getResource("notebooks.txt");
        FileController nbs = new FileController(url.getPath());
        URL url1 = ProductController.class.getClassLoader().getResource("smartphones.txt");
        FileController phones = new FileController(url1.getPath());
        URL url2 = ProductController.class.getClassLoader().getResource("tablets.txt");
        FileController tabletas = new FileController(url2.getPath());
        URL url3 = ProductController.class.getClassLoader().getResource("tvs.txt");
        FileController tvss = new FileController(url3.getPath());
        
        //Lectura de los txt
                //Notebooks
        String linea;
        while ((linea=nbs.getBr().readLine())!=null){
            StringTokenizer st = new StringTokenizer(linea);
            String modelo=new String();
            String procesador=new String();
            String tamanio=new String();
            String ram=new String();
            String disco=new String();
            String uso=new String();
            
            while (st.hasMoreElements()){
                String token = st.nextToken(";");
                switch (token){
                    case "MODELO":
                        modelo=st.nextToken(";");
                        break;
                    case "PROCESADOR":
                        procesador=st.nextToken(";");
                        break;
                    case "TAMANIO":
                        tamanio=st.nextToken(";");
                        break;
                    case "RAM":
                        ram=st.nextToken(";");
                        break;
                    case "DISCO":
                        disco=st.nextToken(";");
                        break;
                    case "USO":
                        uso=st.nextToken(";");
                        break;
                }
            }
            Notebook nb = new Notebook(modelo,procesador,tamanio,ram,disco,uso);
            this.notebooks.add(nb); 
        }
        
            //Smartphones
        String linea1;
        while ((linea1=phones.getBr().readLine())!=null){
            StringTokenizer st = new StringTokenizer(linea1);
            String modelo=new String();
            String tamanio=new String();
            String camara=new String();
            String uso=new String();
            
            while (st.hasMoreElements()){
                String token = st.nextToken(";");
                switch (token){
                    case "MODELO":
                        modelo=st.nextToken(";");
                        break;
                    case "TAMANIO":
                        tamanio=st.nextToken(";");
                        break;
                    case "CAMARA":
                        camara=st.nextToken(";");
                        break;
                    case "USO":
                        uso=st.nextToken(";");
                        break;
                }
            }
            Smartphone sp = new Smartphone(modelo,tamanio,camara,uso);
            this.smartphones.add(sp); 
        }
        
            //Tablets
        String linea2;
        while ((linea2=tabletas.getBr().readLine())!=null){
            StringTokenizer st = new StringTokenizer(linea2);
            String modelo=new String();
            String tamanio=new String();
            String resolucion=new String();
            String uso=new String();
            
            while (st.hasMoreElements()){
                String token = st.nextToken(";");
                switch (token){
                    case "MODELO":
                        modelo=st.nextToken(";");
                        break;
                    case "TAMANIO":
                        tamanio=st.nextToken(";");
                        break;
                    case "RESOLUCION":
                        resolucion=st.nextToken(";");
                        break;
                    case "USO":
                        uso=st.nextToken(";");
                        break;
                }
            }
            Tablet tb = new Tablet(modelo,tamanio,resolucion,uso);
            this.tablets.add(tb); 
        }
        
            //Tvs
        String linea3;
        while ((linea3=tvss.getBr().readLine())!=null){
            StringTokenizer st = new StringTokenizer(linea3);
            String modelo=new String();
            String tamaño=new String();
            String resolucion=new String();
            String uso=new String();
            
            while (st.hasMoreElements()){
                String token = st.nextToken(";");
                switch (token){
                    case "MODELO":
                        modelo=st.nextToken(";");
                        break;
                    case "TAMANIO":
                        tamaño=st.nextToken(";");
                        break;
                    case "RESOLUCION":
                        resolucion=st.nextToken(";");
                        break;
                    case "USO":
                        uso=st.nextToken(";");
                        break;
                }
            }
            Tv tv = new Tv(modelo,tamaño,resolucion,uso);
            this.tvs.add(tv); 
        }
        System.out.println(this.notebooks.get(0).getTamanio());
    }
    
}
