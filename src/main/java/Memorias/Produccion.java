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
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "nocliente")), new ArrayList<>(Arrays.asList("empleado", "usuario")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("cliente", "noempleado")), new ArrayList<>(Arrays.asList("nocliente")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("cliente", "noempleado")), new ArrayList<>(Arrays.asList("cliente", "usuario")), Tipo.AGREGAR));
  
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "notebook", "noproducto")), new ArrayList<>(Arrays.asList("notebook", "producto")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "smartphone", "noproducto")), new ArrayList<>(Arrays.asList("smartphone", "producto")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "tablet", "noproducto")), new ArrayList<>(Arrays.asList("tablet", "producto")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "smart tv", "noproducto")), new ArrayList<>(Arrays.asList("smart tv", "producto")), Tipo.AGREGAR));
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "notebook", "noproducto")), new ArrayList<>(Arrays.asList("noproducto")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "smartphone", "noproducto")), new ArrayList<>(Arrays.asList("noproducto")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "tablet", "noproducto")), new ArrayList<>(Arrays.asList("noproducto")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "smart tv", "noproducto")), new ArrayList<>(Arrays.asList("noproducto")), Tipo.BORRAR));
        
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
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "trabajar", "nouso")), new ArrayList<>(Arrays.asList("nouso")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "jugar", "nouso")), new ArrayList<>(Arrays.asList("nouso")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smartphone", "camara", "nouso")), new ArrayList<>(Arrays.asList("nouso")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smartphone", "economico", "nouso")), new ArrayList<>(Arrays.asList("nouso")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smart tv", "pelicula", "nouso")), new ArrayList<>(Arrays.asList("nouso")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smart tv", "economico", "nouso")), new ArrayList<>(Arrays.asList("nouso")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("tablet", "jugar", "nouso")), new ArrayList<>(Arrays.asList("nouso")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("tablet", "economico", "nouso")), new ArrayList<>(Arrays.asList("nouso")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("tablet", "trabajar", "nouso")), new ArrayList<>(Arrays.asList("nouso")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("tablet", "camara", "nouso")), new ArrayList<>(Arrays.asList("nouso")), Tipo.BORRAR));
        
        // NOTEBOOKs
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "trabajar", "uso")), new ArrayList<>(Arrays.asList("HP ELITE A9", "DELL INSPIRON 3585", "LENOVO V330", "ASUS VIVOBOOK E406", "ACER ASPIRE 3")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "jugar", "uso")), new ArrayList<>(Arrays.asList("HP OMEN 35000", "ASUS FX504", "DELL ALIENWARE 17", "ACER PREDATOR HELIOS 300")), Tipo.AGREGAR));
        
        // SMART TVs
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smart tv", "pelicula", "uso")), new ArrayList<>(Arrays.asList("LG 43LK5700", "SAMSUNG UN49K5500", "NOBLEX DI49X6500", "TCL L49S62", "PHILIPS 55OLED873")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smart tv", "economico", "uso")), new ArrayList<>(Arrays.asList("LG 32LJ600B", "NOBLEX EA43X5100", "SAMSUNG J4300", "TCL L32S6500", "PHILIPS 32PHG5102")), Tipo.AGREGAR));
        
        // TABLETs
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("tablet", "jugar", "uso")), new ArrayList<>(Arrays.asList("SAMSUNG SM-T560", "LENOVO TB3-710F", "IPAD 2")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("tablet", "economico", "uso")), new ArrayList<>(Arrays.asList("GADNIC TAB038BK")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("tablet", "trabajar", "uso")), new ArrayList<>(Arrays.asList("GADNIC FENIX PHONE", "IPAD PRO")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("tablet", "camara", "uso")), new ArrayList<>(Arrays.asList("LENOVO YOGA TAB 3", "HUAWEI BG2-W09", "HUAWEI T3 10")), Tipo.AGREGAR));
        
        // SMARTPHONEs
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smartphone", "economico", "uso")), new ArrayList<>(Arrays.asList("XIAOMI REDMI NOTE 7", "SAMSUNG GALAXY A50", "HUAWEI P20 LITE", "MOTO E5 PLUS")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("smartphone", "camara", "uso")), new ArrayList<>(Arrays.asList("XIAOMI MI 8 PRO", "SAMSUNG GALAXY NOTE 9", "ONEPLUS 6T", "ONEPLUS 7 PRO", "HUAWEI MATE 20 PRO", "MOTO G7 PLUS")), Tipo.AGREGAR));
        
        
        //        reglas.add(new Regla(new ArrayList<>(Arrays.asList("tablet", "economico", "uso")), new ArrayList<>(Arrays.asList("asdasdasd", "asdasdasd", "asdasdasd", "asdasdasd", "asdasdasd", "asdasdasd")), Tipo.AGREGAR));
        
        
        
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("no", "producto", "uso")), new ArrayList<>(Arrays.asList("buscarsincaracteristica")), Tipo.AGREGAR));
        
        
        // 1 CARACTERISTICA
        
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "intel", "i7")), new ArrayList<>(Arrays.asList("intel i7")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "intel", "i5")), new ArrayList<>(Arrays.asList("intel i5")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "intel", "i3")), new ArrayList<>(Arrays.asList("intel i3")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "amd", "a9")), new ArrayList<>(Arrays.asList("amd a9")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "amd", "a10")), new ArrayList<>(Arrays.asList("amd a10")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "173")), new ArrayList<>(Arrays.asList("173")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "156")), new ArrayList<>(Arrays.asList("156")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "14")), new ArrayList<>(Arrays.asList("14")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "133")), new ArrayList<>(Arrays.asList("133")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "24gb")), new ArrayList<>(Arrays.asList("16gb")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "16gb")), new ArrayList<>(Arrays.asList("16gb")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "8gb")), new ArrayList<>(Arrays.asList("16gb")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "1000hdd")), new ArrayList<>(Arrays.asList("1000hdd")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "1000ssd")), new ArrayList<>(Arrays.asList("1000hdd")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "500hdd")), new ArrayList<>(Arrays.asList("1000hdd")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "500ssd")), new ArrayList<>(Arrays.asList("1000hdd")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "256ssd")), new ArrayList<>(Arrays.asList("1000hdd")), Tipo.AGREGAR));
        
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "intel", "i7")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "intel", "i5")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "intel", "i3")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "amd", "a9")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "amd", "a10")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "173")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "156")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "14")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "133")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "24gb")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "16gb")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "8gb")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "1000hdd")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "1000ssd")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "500hdd")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "500ssd")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "uso", "256ssd")), new ArrayList<>(Arrays.asList("no1caracteristica")), Tipo.BORRAR));
        
        
        // 2 CARACTERISTICAS
        
        
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "intel", "i7", "16gb")), new ArrayList<>(Arrays.asList("DELL INSPIRON 3585")), Tipo.BORRAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "intel", "i7", "16gb")), new ArrayList<>(Arrays.asList("no2caracteristicas")), Tipo.BORRAR));
        
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "173", "intel i7", "16gb", "1000hdd", "trabajar")), new ArrayList<>(Arrays.asList("HP ELITE A9")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "intel i7", "16gb", "trabajar")), new ArrayList<>(Arrays.asList("HP ELITE A9")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "intel i7", "trabajar")), new ArrayList<>(Arrays.asList("HP ELITE A9")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "intel i7", "8gb", "trabajar")), new ArrayList<>(Arrays.asList("DELL INSPIRON 3585")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "intel i7", "trabajar")), new ArrayList<>(Arrays.asList("DELL INSPIRON 3585")), Tipo.AGREGAR));
        
        
        
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("intel", "i7")), new ArrayList<>(Arrays.asList("intel i7")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("173")), new ArrayList<>(Arrays.asList("173")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("16gb")), new ArrayList<>(Arrays.asList("16gb")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("1000hdd")), new ArrayList<>(Arrays.asList("1000hdd")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("trabajar")), new ArrayList<>(Arrays.asList("trabajar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "173", "intel i7", "16gb", "1000hdd", "trabajar")), new ArrayList<>(Arrays.asList("HP ELITE A9")), Tipo.AGREGAR));
//        
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("intel", "i7")), new ArrayList<>(Arrays.asList("intel i7")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("173")), new ArrayList<>(Arrays.asList("173")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("16gb")), new ArrayList<>(Arrays.asList("16gb")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("1000hdd")), new ArrayList<>(Arrays.asList("1000hdd")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("trabajar")), new ArrayList<>(Arrays.asList("trabajar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "173", "intel i7", "16gb", "1000hdd", "trabajar")), new ArrayList<>(Arrays.asList("HP ELITE A9")), Tipo.AGREGAR));
//        
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("amd", "a9")), new ArrayList<>(Arrays.asList("amd a9")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("156")), new ArrayList<>(Arrays.asList("156")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("8gb")), new ArrayList<>(Arrays.asList("8gb")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("500hdd")), new ArrayList<>(Arrays.asList("500hdd")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("trabajar")), new ArrayList<>(Arrays.asList("trabajar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "156", "amd a9", "8gb", "500hdd", "trabajar")), new ArrayList<>(Arrays.asList("DELL INSPIRON 3585")), Tipo.AGREGAR));
//        
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("intel", "i5")), new ArrayList<>(Arrays.asList("amd a9")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("156")), new ArrayList<>(Arrays.asList("156")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("8gb")), new ArrayList<>(Arrays.asList("8gb")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("500hdd")), new ArrayList<>(Arrays.asList("500hdd")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("trabajar")), new ArrayList<>(Arrays.asList("trabajar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("notebook", "156", "amd a9", "8gb", "500hdd", "trabajar")), new ArrayList<>(Arrays.asList("LENOVO V330")), Tipo.AGREGAR));
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
