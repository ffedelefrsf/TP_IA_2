/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memorias;

import java.util.List;

/**
 *
 * @author faust
 */
public class Regla {
    
    public enum Tipo {AGREGAR, BORRAR}
    
    private int id;
    private static int count = 0;
    private List<String> antecedentes, consecuentes;
    private Tipo tipo;
    
    public Regla(){
        
    }
    
    public Regla(List<String> antecedentes, List<String> consecuentes, Tipo tipo){
        this.id=count+1;
        this.antecedentes=antecedentes;
        this.consecuentes=consecuentes;
        this.tipo=tipo;
        count++;
    }

    public List<String> getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(List<String> antecedentes) {
        this.antecedentes = antecedentes;
    }

    public List<String> getConsecuentes() {
        return consecuentes;
    }

    public void setConsecuentes(List<String> consecuentes) {
        this.consecuentes = consecuentes;
    }
    
    public static int getCount(){
        return count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    
}
