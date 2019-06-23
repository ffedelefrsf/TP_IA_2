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
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "nocliente")), new ArrayList<>(Arrays.asList("noempleado", "saludo")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "nocliente")), new ArrayList<>(Arrays.asList("empleado", "usuario")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("cliente", "noempleado")), new ArrayList<>(Arrays.asList("nocliente", "saludo")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("cliente", "noempleado")), new ArrayList<>(Arrays.asList("cliente", "usuario")), Tipo.AGREGAR));
  
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "notebook", "noproducto")), new ArrayList<>(Arrays.asList("notebook", "producto")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "smartphone", "noproducto")), new ArrayList<>(Arrays.asList("smartphone", "producto")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "tablet", "noproducto")), new ArrayList<>(Arrays.asList("tablet", "producto")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "smart tv", "noproducto")), new ArrayList<>(Arrays.asList("smart tv", "producto")), Tipo.AGREGAR));
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "nocaracteristica", "producto", "especial")), new ArrayList<>(Arrays.asList("caracteristica")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "nocaracteristica", "producto", "especial")), new ArrayList<>(Arrays.asList("nocaracteristica")), Tipo.BORRAR));
        
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "nocaracteristica", "disponibilidad")), new ArrayList<>(Arrays.asList("producto")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "nocaracteristica", "disponibilidad")), new ArrayList<>(Arrays.asList("noproducto")), Tipo.BORRAR));
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "nocaracteristica", "disponibilidad")), new ArrayList<>(Arrays.asList("disponibilidad")), Tipo.AGREGAR));

        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "notebook", "noproducto", "nocaracteristica")), new ArrayList<>(Arrays.asList("noproducto")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "smartphone", "noproducto", "nocaracteristica")), new ArrayList<>(Arrays.asList("noproducto")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "tablet", "noproducto", "nocaracteristica")), new ArrayList<>(Arrays.asList("noproducto")), Tipo.BORRAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("usuario", "smart tv", "noproducto", "nocaracteristica")), new ArrayList<>(Arrays.asList("noproducto")), Tipo.BORRAR));
        
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
        
        // INFORMACIÓN AL VENDEDOR
        
        // NOTEBOOKs
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "hp", "elite", "a9")), new ArrayList<>(Arrays.asList("HP ELITE A9", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "dell", "inspiron", "3585")), new ArrayList<>(Arrays.asList("DELL INSPIRON 3585", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "lenovo", "v330")), new ArrayList<>(Arrays.asList("LENOVO V330", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "hp", "omen", "35000")), new ArrayList<>(Arrays.asList("HP OMEN 35000", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "asus", "vivobook", "e406")), new ArrayList<>(Arrays.asList("ASUS VIVOBOOK E406", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "asus", "fx504")), new ArrayList<>(Arrays.asList("ASUS FX504", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "dell", "alienware", "17")), new ArrayList<>(Arrays.asList("DELL ALIENWARE 17", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "acer" ,"aspire", "3")), new ArrayList<>(Arrays.asList("ACER ASPIRE 3", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "acer", "predator", "helios", "300")), new ArrayList<>(Arrays.asList("ACER PREDATOR HELIOS 300", "consulta")), Tipo.AGREGAR));
        
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "hp", "elite", "a9")), new ArrayList<>(Arrays.asList("intel i7", "17.3", "16gb", "1000hdd", "trabajar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "dell", "inspiron", "3585")), new ArrayList<>(Arrays.asList("amd a9", "15.6", "8gb", "8gb", "500hdd", "trabajar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "lenovo", "v330")), new ArrayList<>(Arrays.asList("intel i5", "15.6", "8gb", "256ssd", "trabajar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "hp", "omen", "35000")), new ArrayList<>(Arrays.asList("intel i7", "17.3", "16gb", "500ssd", "jugar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "asus", "vivobook", "e406")), new ArrayList<>(Arrays.asList("intel i3", "14", "8gb", "256ssd", "trabajar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "asus", "fx504")), new ArrayList<>(Arrays.asList("amd a10", "17.3", "16gb", "500ssd", "jugar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "dell", "alienware", "17")), new ArrayList<>(Arrays.asList("intel i7", "15.6", "16gb", "1000hdd", "jugar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "acer" ,"aspire", "3")), new ArrayList<>(Arrays.asList("intel i3", "13.3", "8gb", "500hdd", "trabajar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "acer", "predator", "helios", "300")), new ArrayList<>(Arrays.asList("intel i7", "17.3", "24gb", "1000ssd", "jugar")), Tipo.AGREGAR));
        
        // SMARTPHONEs
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "xiaomi", "mi", "8", "pro")), new ArrayList<>(Arrays.asList("XIAOMI MI 8 PRO", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "xiaomi", "redmi", "note", "7")), new ArrayList<>(Arrays.asList("XIAOMI REDMI NOTE 7", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "samsung", "galaxy", "note", "9")), new ArrayList<>(Arrays.asList("SAMSUNG GALAXY NOTE 9", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "samsung", "galaxy", "a50")), new ArrayList<>(Arrays.asList("SAMSUNG GALAXY A50", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "oneplus", "6t")), new ArrayList<>(Arrays.asList("ONEPLUS 6T", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "oneplus", "7", "pro")), new ArrayList<>(Arrays.asList("ONEPLUS 7 PRO", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "huawei", "mate", "20", "pro")), new ArrayList<>(Arrays.asList("HUAWEI MATE 20 PRO", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "huawei", "p20", "lite")), new ArrayList<>(Arrays.asList("HUAWEI P20 LITE", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "moto", "g7", "plus")), new ArrayList<>(Arrays.asList("MOTO G7 PLUS", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "moto", "e5", "plus")), new ArrayList<>(Arrays.asList("MOTO E5 PLUS", "consulta")), Tipo.AGREGAR));
        
        
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "xiaomi", "mi", "8", "pro")), new ArrayList<>(Arrays.asList("6.21\"", "12mp", "camara")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "xiaomi", "redmi", "note", "7")), new ArrayList<>(Arrays.asList("6.3\"", "48mp", "economico")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "samsung", "galaxy", "note", "9")), new ArrayList<>(Arrays.asList("6.4\"", "12mp", "camara")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "samsung", "galaxy", "a50")), new ArrayList<>(Arrays.asList("6.4\"", "12mp", "economico")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "oneplus", "6t")), new ArrayList<>(Arrays.asList("6.21\"", "12mp", "camara")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "oneplus", "7", "pro")), new ArrayList<>(Arrays.asList("6.41\"", "48mp", "camara")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "huawei", "mate", "20", "pro")), new ArrayList<>(Arrays.asList("6.4\"", "12mp", "economico")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "huawei", "p20", "lite")), new ArrayList<>(Arrays.asList("6.2\"", "16mp", "camara")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "moto", "g7", "plus")), new ArrayList<>(Arrays.asList("6.0\"", "12mp", "economico")), Tipo.AGREGAR));
      
        //TABLETs
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "samsung", "smt560")), new ArrayList<>(Arrays.asList("SAMSUNG SM-T560", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "samsung", "smt580")), new ArrayList<>(Arrays.asList("SAMSUNG SM-T580", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "gadnic", "tab038Bk")), new ArrayList<>(Arrays.asList("GADNIC TAB038BK", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "gadnic", "fenix", "phone")), new ArrayList<>(Arrays.asList("GADNIC FENIX PHONE", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "lenovo", "tB3710f")), new ArrayList<>(Arrays.asList("LENOVO TB3-710F", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "lenovo", "yoga", "tab")), new ArrayList<>(Arrays.asList("LENOVO YOGA TAB 3", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "ipad", "pro")), new ArrayList<>(Arrays.asList("IPAD PRO", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "ipad", "2")), new ArrayList<>(Arrays.asList("IPAD 2", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "huawei", "bg2w09")), new ArrayList<>(Arrays.asList("HUAWEI BG2-W09", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "huawei", "t3", "10")), new ArrayList<>(Arrays.asList("HUAWEI T3 10", "consulta")), Tipo.AGREGAR));
        
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "samsung", "smt560")), new ArrayList<>(Arrays.asList("10\"", "HD", "jugar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "gadnic", "tab038Bk")), new ArrayList<>(Arrays.asList("7\"", "FHD", "economico")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "gadnic", "fenix", "phone")), new ArrayList<>(Arrays.asList("10\"", "HD", "trabajar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "lenovo", "tB3710f")), new ArrayList<>(Arrays.asList("7\"", "FHD", "jugar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "lenovo", "yoga", "tab")), new ArrayList<>(Arrays.asList("8\"", "HD", "camara")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "ipad", "pro")), new ArrayList<>(Arrays.asList("13\"", "FHD", "trabajar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "ipad", "2")), new ArrayList<>(Arrays.asList("10\"", "HD", "jugar")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "huawei", "bg2w09")), new ArrayList<>(Arrays.asList("7\"", "FHD", "camara")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "huawei", "t3", "10")), new ArrayList<>(Arrays.asList("10\"", "HD", "camara")), Tipo.AGREGAR));
        
        // SMART TVs
        
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "lg", "43lk5700")), new ArrayList<>(Arrays.asList("LG 43LK5700", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "lg", "32lj600B")), new ArrayList<>(Arrays.asList("LG 32LJ600B", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "samsung", "un49k5500")), new ArrayList<>(Arrays.asList("SAMSUNG UN49K5500", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "samsung", "j4300")), new ArrayList<>(Arrays.asList("SAMSUNG J4300", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "noblex", "ea43x5100")), new ArrayList<>(Arrays.asList("NOBLEX EA43X5100", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "noblex", "di49x6500")), new ArrayList<>(Arrays.asList("NOBLEX DI49X6500", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "tcl", "l32S6500")), new ArrayList<>(Arrays.asList("TCL L32S6500", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "tcl", "l49S62")), new ArrayList<>(Arrays.asList("TCL L49S62", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "phillips", "55oled873")), new ArrayList<>(Arrays.asList("PHILIPS 55OLED873", "consulta")), Tipo.AGREGAR));
        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "phillips", "32prg5102")), new ArrayList<>(Arrays.asList("PHILIPS 32PHG5102", "consulta")), Tipo.AGREGAR));
        
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "lg", "43lk5700")), new ArrayList<>(Arrays.asList("43\"", "FHD", "pelicula", "asdfads", "sadfasdf")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "lg", "32lj600B")), new ArrayList<>(Arrays.asList("32\"", "HD", "economico", "asdfads", "sadfasdf")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "samsung", "un49k5500")), new ArrayList<>(Arrays.asList("49\"", "FHD", "pelicula", "asdfads", "sadfasdf")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "samsung", "j4300")), new ArrayList<>(Arrays.asList("32\"", "HD", "economico", "asdfads", "sadfasdf")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "noblex", "ea43x5100")), new ArrayList<>(Arrays.asList("43\"", "FHD", "economico", "asdfads", "sadfasdf")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "noblex", "di49x6500")), new ArrayList<>(Arrays.asList("49\"", "4K", "pelicula", "asdfads", "sadfasdf")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "tcl", "l32S6500")), new ArrayList<>(Arrays.asList("32\"", "HD", "economico", "asdfads", "sadfasdf")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "tcl", "l49S62")), new ArrayList<>(Arrays.asList("49\"", "4K", "FHD", "pelicula", "sadfasdf")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "phillips", "55oled873")), new ArrayList<>(Arrays.asList("55\"", "4K", "pelicula", "asdfads", "sadfasdf")), Tipo.AGREGAR));
//        reglas.add(new Regla(new ArrayList<>(Arrays.asList("empleado", "noproducto", "caracteristica", "phillips", "32prg5102")), new ArrayList<>(Arrays.asList("32\"", "HD", "economico", "asdfads", "sadfasdf")), Tipo.AGREGAR));
        
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
