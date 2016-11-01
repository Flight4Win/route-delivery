/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import clases.Paquete;
import clases.PlanVuelo;
import data.ColeccionPlanVuelo;
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
    public ArrayList<ArrayList<PlanVuelo>> getPatrones(T partida, T destino,double tiempo,int horaActual,ColeccionPlanVuelo vuelos) {
        validar(partida, destino);
        
        ArrayList<ArrayList<PlanVuelo>> patrones = new ArrayList<ArrayList<PlanVuelo>>();
        DFS(partida, destino, partida/*anterior*/, patrones, new ArrayList<T>(),new ArrayList<PlanVuelo>(),1,tiempo,horaActual);
        //System.out.println("termino DFS");
        return patrones;
    }


    private void DFS(T actual, T destination,T anterior, ArrayList<ArrayList<PlanVuelo>> soluciones, ArrayList<T> patron,ArrayList<PlanVuelo> patronSolucion,int veces,double tiempo,int horaActual) {
        patron.add(actual);
        PlanVuelo vuelo = grafo.BuscarPlanVuelo(actual, anterior);
        if(vuelo != null){
            patronSolucion.add(grafo.BuscarPlanVuelo(actual,anterior));
        }
        
        if (actual.equals(destination) && tiempo>=0){// Si se llego al destino o no se cumplió con el tiempo
            //System.out.println(patron.toString()+ " -> " + tiempo);
            soluciones.add(new ArrayList<PlanVuelo>(patronSolucion));
            patronSolucion.remove(grafo.BuscarPlanVuelo(actual, anterior));
            patron.remove(actual);
            return;
        }

        final ArrayList<PlanVuelo> df = grafo.ArcosDesde(actual);

        for (PlanVuelo t : df){
            if (!patron.contains(t.getDestino().getId())){ //si no lo enecuntra en la lista patrón
                if(veces<3 && tiempo>=0) //Si el tamaño de caminos es 3 [o si el tiempo se terminó]
                    if(horaActual > t.getHora_ini()){ //Para manejar correctamente los tiempos de salida de las ciudades
                        int espera = 24-(horaActual - t.getHora_ini()); //Lo que se espera en el aeropuerto intermedio
                        int esperaConVuelo = t.getDuracion() + espera; //la espera sumado con el viaje
                        DFS ((T)(Integer)(Object)t.getDestino().getId(), destination, actual, soluciones, patron,patronSolucion,veces+1,tiempo-esperaConVuelo,t.getHora_fin());
                    }
                    else{
                        int espera = t.getHora_ini() - horaActual; //Lo que se espera en el aeropuerto intermedio
                        int esperaConVuelo = t.getDuracion() + espera; //la espera sumado con el viaje
                        DFS ((T)(Integer)(Object)t.getDestino().getId(), destination, actual, soluciones, patron,patronSolucion,veces+1,tiempo-esperaConVuelo,t.getHora_fin());
                    }
            }
        }
        patronSolucion.remove(grafo.BuscarPlanVuelo(actual, anterior));
        patron.remove(actual);
    }    

}
