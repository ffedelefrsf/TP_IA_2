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
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import java.util.ArrayList;
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
    
    public Analizar(List<CoreLabel> listaTokens){
        inputStrings = new ArrayList();
        reglasActivas = new ArrayList();
        for (CoreLabel token: listaTokens) {
            inputStrings.add(token.get(CoreAnnotations.TextAnnotation.class));
        }
        fillReglasActivas();
        
        solucionarConjuntoConflicto();
        
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
                if (regla.getTipo()==Tipo.AGREGAR){
                    if (!trabajo.getComponentes().containsAll(regla.getConsecuentes()))
                        reglasActivas.add(regla);
                }else{
//                    System.out.println("REGLA CANDIDATA: " + regla.getId());
                    boolean contiene = false;
                    for (String componente : regla.getConsecuentes()){
//                        System.out.println("componente: " + componente);
                        if (trabajo.getComponentes().contains(componente)){
//                            System.out.println("contiene ");
                            contiene = true;
                        }
                    }
                    if (contiene)
                        reglasActivas.add(regla);
                }
            }else{
                flag = true;
            }
        }
    }
    
    private void solucionarConjuntoConflicto(){
        Trabajo trabajo = Trabajo.getInstance();
        for (Regla reglaActiva : reglasActivas){
//        if (reglasActivas.size()>0){
//            Regla reglaActiva = reglasActivas.get(0);
            System.out.println("REGLA ACTIVA: " + reglaActiva.getId());
            for (String componente : reglaActiva.getConsecuentes()){
                if (reglaActiva.getTipo()==Tipo.AGREGAR){
                    if (!trabajo.getComponentes().contains(componente)){
                        trabajo.addComponente(componente);
                    }
                }else{
                    if (trabajo.getComponentes().contains(componente)){
                        trabajo.removeComponente(componente);
                    }
                }
            }
        }
    }
    
}
