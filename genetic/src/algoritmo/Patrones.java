/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import clases.PlanVuelo;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author joe
 * @param <T>
 */
public class Patrones<T>{
    
    private final GrafoAeropuerto<T> grafo;

    /**
     * Takes in a graph. This graph should not be changed by the client
     * @param graph
     */
    public Patrones(GrafoAeropuerto<T> graph) {
        if (graph == null) {
            throw new NullPointerException("The input graph cannot be null.");
        }
        this.grafo = graph;
    }

    private void validar(T partida, T destino) {

        if (partida == null) {
            throw new NullPointerException("The source: " + partida + " cannot be  null.");
        }
        if (destino == null) {
            throw new NullPointerException("The destination: " + destino + " cannot be  null.");
        }
        if (partida.equals(destino)) {
            throw new IllegalArgumentException("The source and destination: " + partida + " cannot be the same.");
        }
    }

    /**
     * Retorna una lista de patrones, where path itself is a list of nodes.
     * 
     * @param partida            the source node
     * @param destino       the destination node
     * @param tiempo
     * @return                  List of all paths
     */
    public List<List<T>> getPatrones(T partida, T destino,double tiempo,int horaActual) {
        validar(partida, destino);

        List<List<T>> patrones = new ArrayList<List<T>>();
        recursivo(partida, destino, patrones, new LinkedHashSet<T>(),1,tiempo,horaActual);
        return patrones;
    }

    // so far this dude ignore's cycles.
    private void recursivo(T actual, T destination, List<List<T>> soluciones, LinkedHashSet<T> patron,int veces,double tiempo,int horaActual) {
        patron.add(actual);
        
        if (actual.equals(destination) && tiempo>=0){
            System.out.println(patron.toString()+ " -> " + tiempo);
            soluciones.add(new ArrayList<T>(patron));
            patron.remove(actual);
            return;
        }

        //final Set<T> edges  = grafo.ArcosDesde(actual).keySet();
        final Set<Entry<T,PlanVuelo>> df = grafo.ArcosDesde(actual).entrySet();
       
        //System.out.println(edges);
        
        for (Entry<T, PlanVuelo> t : df) {
            if (!patron.contains(t.getKey())) {
                if(veces<3 && tiempo>=0)
                    if(horaActual > t.getValue().getHora_ini()){
                        int espera = 24-(horaActual - t.getValue().getHora_ini()) ;
                        int esperaConVuelo = t.getValue().getDuracion() + espera;
                        recursivo (t.getKey(), destination, soluciones, patron,veces+1,tiempo-esperaConVuelo,t.getValue().getHora_fin());
                    }
                    else{
                        int espera = t.getValue().getHora_ini() - horaActual; 
                        int esperaConVuelo = t.getValue().getDuracion() + espera;
                        recursivo (t.getKey(), destination, soluciones, patron,veces+1,tiempo-espera,t.getValue().getHora_fin());
                    }
            }
        }

        patron.remove(actual);
    }    

}
