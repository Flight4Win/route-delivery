/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.util.Pair;

/**
 *
 * @author Diego
 */
public class ConexionCiudades {
    private ArrayList<Integer> _vertices = new ArrayList<>();
    private HashMap<Integer, ArrayList<Arista>> _grafo = new HashMap<>();
    //private ArrayList<Arista> _aristas = new ArrayList<>();
    
    
    /**
     * @return the _grafo
     */
    public HashMap<Integer, ArrayList<Arista>> getGrafo() {
        return _grafo;
    }
    
    public ConexionCiudades(){
        
    }
    
    public void anhadirVertice(int vertice){
        if(!_vertices.contains(vertice)) _vertices.add(vertice);
    }
    
    public void imprimirGrafo(){
        for(int vertice:_grafo.keySet()){
            for(Arista a:_grafo.get(vertice)){
                System.out.println(a.getCiudades());
            }
        }
    }
    
    public void anhadirArista(PlanVuelo planVuelo){
        int ciudadIni,ciudadFin,horaIni,horaFin;        
        ciudadIni = planVuelo.getPartida().getLugar().getCodigo();        
        ciudadFin = planVuelo.getDestino().getLugar().getCodigo();
        
        horaIni = planVuelo.getHora_ini();
        horaFin = planVuelo.getHora_fin();
        
        if(getGrafo().containsKey(ciudadIni)){ //para cada vertice(ciudad)
            Boolean anhadio = false;
            ArrayList<Arista> aristas = _grafo.get(ciudadIni);//se obtienen los destinos actuales
            for(Arista a : aristas){
                Pair<Integer,Integer> par = a.getCiudades();
                if(par.getValue() == ciudadFin){
                    a.agregarHora(horaIni, horaFin);
                    anhadio = true;
                    break;
                }
            }
            if(!anhadio){//si es que no ha anhadido un nuevo vuelo
                Arista arista = new Arista(ciudadIni, ciudadFin);
                arista.agregarHora(horaIni, horaFin);
                aristas.add(arista);
            }
            
            //Arista arista = new Arista(ciudadIni, ciudadFin);            
            //getGrafo().get(ciudadIni).agregarHora(horaIni, horaFin);
        }else{//si no está el vertice en el grafo
            Arista arista = new Arista(ciudadIni, ciudadFin);
            arista.agregarHora(horaIni, horaFin);
            ArrayList<Arista> aristas = new ArrayList<>();
            aristas.add(arista);
            getGrafo().put(ciudadIni, aristas);
        }
        
    }

    
}
