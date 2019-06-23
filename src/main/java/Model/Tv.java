/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ale_b
 */
public class Tv {
    
    private String modelo;
    private String tamanio;
    private String resolucion;
    private String uso;

    public Tv(String modelo, String tamanio, String resolucion, String uso) {
        this.modelo = modelo;
        this.tamanio = tamanio;
        this.resolucion = resolucion;
        this.uso = uso;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getUso() {
        return uso;
    }

    public void setUso(String uso) {
        this.uso = uso;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\tModelo: " + this.modelo +"\n");
        sb.append("\t\t■ Tamaño: " + this.tamanio +"\n");
        sb.append("\t\t■ Resolución: " + this.resolucion +"\n");
        sb.append("\t\t■ Uso recomendado: " + this.uso +"\n");
        
        return sb.toString();
    }
    
    
}
