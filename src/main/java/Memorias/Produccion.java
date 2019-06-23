/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Memorias;

import Controller.ProductController;
import Memorias.Regla.Tipo;
import Model.Notebook;
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
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "nocliente")), new ArrayList<>(Arrays.asList("noempleado")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "nocliente")), new ArrayList<>(Arrays.asList("empleado")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("cliente", "noempleado")), new ArrayList<>(Arrays.asList("nocliente")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("cliente", "noempleado")), new ArrayList<>(Arrays.asList("cliente")), Tipo.AGREGAR));
  
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "noproducto")), new ArrayList<>(Arrays.asList("notebook", "producto")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smartphone", "noproducto")), new ArrayList<>(Arrays.asList("smartphone", "producto")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("tablet", "noproducto")), new ArrayList<>(Arrays.asList("tablet", "producto")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smart", "tv", "noproducto")), new ArrayList<>(Arrays.asList("smart tv", "producto")), Tipo.AGREGAR));
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "noproducto")), new ArrayList<>(Arrays.asList("noproducto")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smartphone", "noproducto")), new ArrayList<>(Arrays.asList("noproducto")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("tablet", "noproducto")), new ArrayList<>(Arrays.asList("noproducto")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smart tv", "noproducto")), new ArrayList<>(Arrays.asList("noproducto")), Tipo.BORRAR));
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "trabajar", "nouso")), new ArrayList<>(Arrays.asList("trabajar", "uso")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "jugar", "nouso")), new ArrayList<>(Arrays.asList("jugar", "uso")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smartphone", "camara", "nouso")), new ArrayList<>(Arrays.asList("camara", "uso")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smartphone", "economico", "nouso")), new ArrayList<>(Arrays.asList("economico", "uso")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smart tv", "pelicula", "nouso")), new ArrayList<>(Arrays.asList("pelicula", "uso")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smart tv", "economico", "nouso")), new ArrayList<>(Arrays.asList("economico", "uso")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("tablet", "jugar", "nouso")), new ArrayList<>(Arrays.asList("jugar", "uso")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("tablet", "economico", "nouso")), new ArrayList<>(Arrays.asList("economico", "uso")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("tablet", "trabajar", "nouso")), new ArrayList<>(Arrays.asList("trabajar", "uso")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("tablet", "camara", "nouso")), new ArrayList<>(Arrays.asList("camara", "uso")), Tipo.AGREGAR));
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("trabajar", "nouso")), new ArrayList<>(Arrays.asList("nouso")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("jugar", "nouso")), new ArrayList<>(Arrays.asList("nouso")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("camara", "nouso")), new ArrayList<>(Arrays.asList("nouso")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("economico", "nouso")), new ArrayList<>(Arrays.asList("nouso")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("pelicula", "nouso")), new ArrayList<>(Arrays.asList("nouso")), Tipo.BORRAR));
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("no", "producto", "uso")), new ArrayList<>(Arrays.asList("buscarsincaracteristica")), Tipo.AGREGAR));
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "intel", "i7")), new ArrayList<>(Arrays.asList("intel i7", "caracteristica")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "173")), new ArrayList<>(Arrays.asList("173", "caracteristica")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "16gb")), new ArrayList<>(Arrays.asList("16gb", "caracteristica")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "1000hdd")), new ArrayList<>(Arrays.asList("1000hdd", "caracteristica")), Tipo.AGREGAR));
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "173", "intel i7", "16gb", "1000hdd", "trabajar")), new ArrayList<>(Arrays.asList("HP ELITE A9")), Tipo.AGREGAR));

        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("intel", "i7")), new ArrayList<>(Arrays.asList("intel i7")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("173")), new ArrayList<>(Arrays.asList("173")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("16gb")), new ArrayList<>(Arrays.asList("16gb")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("1000hdd")), new ArrayList<>(Arrays.asList("1000hdd")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("trabajar")), new ArrayList<>(Arrays.asList("trabajar")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "173", "intel i7", "16gb", "1000hdd", "trabajar")), new ArrayList<>(Arrays.asList("HP ELITE A9")), Tipo.AGREGAR));
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("intel", "i7")), new ArrayList<>(Arrays.asList("intel i7")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("173")), new ArrayList<>(Arrays.asList("173")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("16gb")), new ArrayList<>(Arrays.asList("16gb")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("1000hdd")), new ArrayList<>(Arrays.asList("1000hdd")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("trabajar")), new ArrayList<>(Arrays.asList("trabajar")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "173", "intel i7", "16gb", "1000hdd", "trabajar")), new ArrayList<>(Arrays.asList("HP ELITE A9")), Tipo.AGREGAR));
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("amd", "a9")), new ArrayList<>(Arrays.asList("amd a9")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("156")), new ArrayList<>(Arrays.asList("156")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("8gb")), new ArrayList<>(Arrays.asList("8gb")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("500hdd")), new ArrayList<>(Arrays.asList("500hdd")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("trabajar")), new ArrayList<>(Arrays.asList("trabajar")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "156", "amd a9", "8gb", "500hdd", "trabajar")), new ArrayList<>(Arrays.asList("DELL INSPIRON 3585")), Tipo.AGREGAR));
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("intel", "i5")), new ArrayList<>(Arrays.asList("amd a9")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("156")), new ArrayList<>(Arrays.asList("156")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("8gb")), new ArrayList<>(Arrays.asList("8gb")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("500hdd")), new ArrayList<>(Arrays.asList("500hdd")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("trabajar")), new ArrayList<>(Arrays.asList("trabajar")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "156", "amd a9", "8gb", "500hdd", "trabajar")), new ArrayList<>(Arrays.asList("LENOVO V330")), Tipo.AGREGAR));
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
