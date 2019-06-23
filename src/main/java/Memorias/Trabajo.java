/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memorias;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author faust
 */
public class Trabajo {
    
    private List<String> componentes;
    
    private Trabajo() {
        componentes = new ArrayList(Arrays.asList("noempleado", "nocliente", "noproducto", "nouso", "nocaracteristica"));
    }
    
    public static Trabajo getInstance() {
        return TrabajoHolder.INSTANCE;
    }
    
    private static class TrabajoHolder {

        private static final Trabajo INSTANCE = new Trabajo();
    }
    
    public List<String> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<String> componentes) {
        this.componentes = componentes;
    }
    
    public void addComponentes (List<String> listComponentes){
        this.componentes.addAll(listComponentes);
    }
    
    public void addComponente (String componente){
        componentes.add(componente);
    }
    
    public void removeComponentes (List<String> listComponentes){
        this.componentes.removeAll(listComponentes);
    }
    
    public void removeComponente (String componente){
        componentes.remove(componente);
    }
    
    public void reset(String usuario){
        componentes = new ArrayList(Arrays.asList(usuario, "usuario", "noproducto", "nouso", "nocaracteristica"));
    }
    
}
