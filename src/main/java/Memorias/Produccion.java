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
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("computadora")), new ArrayList<>(Arrays.asList("notebook")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("trabajar")), new ArrayList<>(Arrays.asList("trabajar")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("173")), new ArrayList<>(Arrays.asList("173")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("intel", "i7")), new ArrayList<>(Arrays.asList("intel i7")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("16gb")), new ArrayList<>(Arrays.asList("16gb")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("1000hdd")), new ArrayList<>(Arrays.asList("1000hdd")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "173", "intel i7", "16gb", "1000hdd", "trabajar")), new ArrayList<>(Arrays.asList("HP ELITE A9")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "nocliente")), new ArrayList<>(Arrays.asList("noempleado")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "nocliente")), new ArrayList<>(Arrays.asList("empleado")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("cliente", "noempleado")), new ArrayList<>(Arrays.asList("nocliente")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("cliente", "noempleado")), new ArrayList<>(Arrays.asList("cliente")), Tipo.AGREGAR));
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
