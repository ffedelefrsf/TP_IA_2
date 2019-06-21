/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memorias;

import Memorias.Regla.Tipo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author faust
 */
public class Produccion {
    
    private List<Regla> reglas;
    
    private Produccion() {
        // Initialize REGLA ( ANTECENDETES , CONSECUENTES )
        reglas = new ArrayList();
        reglas.add(new Regla(new ArrayList<String>(Arrays.asList("computadora", "i5")), new ArrayList<String>(Arrays.asList("notebook")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<String>(Arrays.asList("empleado", "nocliente")), new ArrayList<String>(Arrays.asList("noempleado")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<String>(Arrays.asList("empleado", "nocliente")), new ArrayList<String>(Arrays.asList("empleado")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<String>(Arrays.asList("cliente", "noempleado")), new ArrayList<String>(Arrays.asList("nocliente")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<String>(Arrays.asList("cliente", "noempleado")), new ArrayList<String>(Arrays.asList("cliente")), Tipo.AGREGAR));
    }
    
    public static Produccion getInstance() {
        return ProduccionHolder.INSTANCE;
    }
    
    private static class ProduccionHolder {

        private static final Produccion INSTANCE = new Produccion();
        
    }
    
    
    public List<Regla> getReglas() {
        return reglas;
    }

    public void setReglas(List<Regla> reglas) {
        this.reglas = reglas;
    }
}
