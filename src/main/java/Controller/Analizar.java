/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Memorias.Produccion;
import Memorias.Regla;
import Memorias.Regla.Tipo;
import Memorias.Trabajo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author faust
 */
public class Analizar {
    
    public enum Estrategia {PRIORIDAD, NOVEDAD, ESPECIFICIDAD, NO_DUPLICACION};
    
    private List<String> inputStrings;
    private List<Regla> reglasActivas;
    
    public Analizar(){
        inputStrings = new ArrayList();
        reglasActivas = new ArrayList();
    }
    
    public Analizar(List<String> listaStrings){
        inputStrings = listaStrings;
        reglasActivas = new ArrayList();
        List<Regla> clon = new ArrayList();
        System.out.println("-----------------------------------------------------------");
        System.out.println("REGLAS CANDIDATAS");
        System.out.println("-----------------------------------------------------------");
        boolean flag = true;
        do{
            flag = true;
            clon.clear();
            reglasActivas.clear();
            fillReglasActivas();
            for (Regla regla : reglasActivas){
                System.out.println("REGLA CANDIDATA: "+regla.getId()+"\nAntecedente: " + regla.getAntecedentes().toString() + "\nConsecuente: "+regla.getConsecuentes().toString());
            }
            System.out.println("-----------------------------------------------------------\n");
            clon.addAll(reglasActivas);
            solucionarConjuntoConflicto();
            fillReglasActivas();
            for (int i=0; i<reglasActivas.size(); i++){
                try{
                    if (reglasActivas.get(i).getId()!=clon.get(i).getId()){
                        flag = false;
                    }
                }catch (IndexOutOfBoundsException e){
                    flag = false;
                }
            }
        }while(!flag);
        inputStrings.clear();
        reglasActivas.clear();
    }
    
    private void fillReglasActivas(){
        boolean flag = true;
        Trabajo trabajo = Trabajo.getInstance();
        
        for (Regla regla : Produccion.getInstance().getReglas()){
            for (String antecedente : regla.getAntecedentes()){
                if (!inputStrings.contains(antecedente) && !trabajo.getComponentes().contains(antecedente)){
                    flag = false;
                }
            }
            if (flag){
                reglasActivas.add(regla);
            }else{
                flag = true;
            }
        }
    }
    
    private void solucionarConjuntoConflicto(){
        Trabajo trabajo = Trabajo.getInstance();
        System.out.println("-----------------------------------------------------------");
        System.out.println("SOLUCION CONJUNTO DE CONFLICTO");
        System.out.println("-----------------------------------------------------------");
        // NO DUPLICACION
        HashMap<Regla, Integer> cantAntecedentes = new HashMap<>();
        List<Regla> listaAuxiliar = new ArrayList();
        listaAuxiliar.addAll(reglasActivas);
        for (Regla reglaActiva : listaAuxiliar){
            cantAntecedentes.put(reglaActiva, reglaActiva.getAntecedentes().size());
//        if (reglasActivas.size()>0){
//            Regla reglaActiva = reglasActivas.get(0);
//            System.out.println("REGLA ACTIVA: " + reglaActiva.getId());
            boolean duplicada = true;
            if (reglaActiva.getTipo()==Tipo.AGREGAR){
                if (!trabajo.getComponentes().containsAll(reglaActiva.getConsecuentes()))
                    duplicada = false;
            }else{
                boolean contiene = false;
                for (String componente : reglaActiva.getConsecuentes()){
//                        System.out.println("componente: " + componente);
                    if (trabajo.getComponentes().contains(componente)){
//                            System.out.println("contiene ");
                        contiene = true;
                    }
                }
                if (contiene)
                    duplicada = false;
            }
            if (duplicada){
                System.out.println("REGLA DUPLICADA: " +  + reglaActiva.getId());
                reglasActivas.remove(reglaActiva);
                cantAntecedentes.remove(reglaActiva);
            }
        }
        
        
        List<Regla> reglasNovedosas = new ArrayList<>();
        List<Regla> listReglasActivasAux = new ArrayList();
        listReglasActivasAux.addAll(reglasActivas);
        for (Regla reglaActiva : listReglasActivasAux){
            for (String componente : reglaActiva.getAntecedentes()){
                if (trabajo.getComponentes().get(trabajo.getComponentes().size()-1).equals(componente)){
                    System.out.println("REGLA NOVEDOSA: " +  + reglaActiva.getId());
                    reglasNovedosas.add(reglaActiva);
                    reglasActivas.remove(reglaActiva);
                }
            }
        }
        
        if (reglasNovedosas.size()>1){
            List<Regla> reglasEspecificas = new ArrayList<>();
            List<Regla> listAuxiliar = new ArrayList();
            listAuxiliar.addAll(reglasNovedosas);
            
            for (Regla reglaNovedosa : reglasNovedosas){
                Integer cantAntecedentesAux = 0;
                Regla indice = new Regla();
                for (Regla reglaIterator : listAuxiliar){
                    int cantidadAntecedentes = cantAntecedentes.get(reglaIterator);
                    if (cantidadAntecedentes>=cantAntecedentesAux){
                        cantAntecedentesAux=cantidadAntecedentes;
                        indice = reglaIterator;
                    }
                }
                System.out.println("REGLA ESPECIFICA: " + indice.getId());
                reglasEspecificas.add(indice);
                listAuxiliar.remove(indice);
            }
            
            // ESPECIFICIDAD
            
            for (Regla reglaEspecifica : reglasEspecificas){
                for (String componente : reglaEspecifica.getConsecuentes()){
                    if (reglaEspecifica.getTipo()==Tipo.AGREGAR){
                        if (!trabajo.getComponentes().contains(componente)){
                            System.out.println("AGREGADO POR ESPECIFICIDAD: " + componente);
                            trabajo.addComponente(componente);
                        }
                    }else{
                        if (trabajo.getComponentes().contains(componente)){
                            System.out.println("BORRADO POR ESPECIFICIDAD: " + componente);
                            trabajo.removeComponente(componente);
                        }
                    }
                }
            }
        }else{
            if (reglasNovedosas.size()>0){
                for (Regla reglaPorNovedad : reglasNovedosas){
                    for (String componente : reglaPorNovedad.getConsecuentes()){
                        if (reglaPorNovedad.getTipo()==Tipo.AGREGAR){
                            if (!trabajo.getComponentes().contains(componente)){
                                System.out.println("AGREGADO POR NOVEDAD: " + componente);
                                trabajo.addComponente(componente);
                            }
                        }else{
                            if (trabajo.getComponentes().contains(componente)){
                                System.out.println("BORRADO POR NOVEDAD: " + componente);
                                trabajo.removeComponente(componente);
                            }
                        }
                    }
                }
            }
        }
        
        List<Regla> reglasEspecificas = new ArrayList<>();
        List<Regla> listAuxiliar = new ArrayList();
        listAuxiliar.addAll(reglasActivas);
        for (Regla reglaActiva : reglasActivas){
            Integer cantAntecedentesAux = 0;
            Regla indice = new Regla();
            for (Regla reglaIterator : listAuxiliar){
                int cantidadAntecedentes = cantAntecedentes.get(reglaIterator);
                if (cantidadAntecedentes>=cantAntecedentesAux){
                    cantAntecedentesAux=cantidadAntecedentes;
                    indice = reglaIterator;
                }
            }
            System.out.println("REGLA ESPECIFICA: " + indice.getId());
            reglasEspecificas.add(indice);
            listAuxiliar.remove(indice);
        }

        // ESPECIFICIDAD
        for (Regla reglaEspecifica : reglasEspecificas){
            for (String componente : reglaEspecifica.getConsecuentes()){
                if (reglaEspecifica.getTipo()==Tipo.AGREGAR){
                    if (!trabajo.getComponentes().contains(componente)){
                        System.out.println("AGREGADO POR ESPECIFICIDAD: " + componente);
                        trabajo.addComponente(componente);
                    }
                }else{
                    if (trabajo.getComponentes().contains(componente)){
                        System.out.println("BORRADO POR ESPECIFICIDAD: " + componente);
                        trabajo.removeComponente(componente);
                    }
                }
            }
            reglasActivas.remove(reglaEspecifica);
        }
        
        System.out.println("-----------------------------------------------------------\n");
        
    }
    
}
