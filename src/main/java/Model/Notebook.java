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
public class Notebook {
    private String modelo;
    private String procesador;
    private String tamanio;
    private String ram;
    private String disco;
    private String uso;

    public Notebook(String modelo, String procesador, String tamanio, String ram, String disco, String uso) {
        this.modelo = modelo;
        this.procesador = procesador;
        this.tamanio = tamanio;
        this.ram = ram;
        this.disco = disco;
        this.uso = uso;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDisco() {
        return disco;
    }

    public void setDisco(String disco) {
        this.disco = disco;
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
        sb.append("\t\t■ Procesador: " + this.procesador +"\n");
        sb.append("\t\t■ Tamaño: " + this.tamanio +"\n");
        sb.append("\t\t■ RAM: " + this.ram +"\n");
        sb.append("\t\t■ Disco: " + this.disco +"\n");
        sb.append("\t\t■ Uso recomendado: " + this.uso +"\n");
        
        return sb.toString();
    }
    
    
}
