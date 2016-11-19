/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import clases.PlanVuelo;
import data.ColeccionPlanVuelo;
import java.util.ArrayList;

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
        DFS(partida, destino, partida, patrones, new ArrayList<PlanVuelo>(),new ArrayList<PlanVuelo>(),1,tiempo,horaActual,grafo.CopiaDelGrafo(),true);
        //System.out.println("termino DFS");
        return patrones;
        
    }


    void DFS(T actual, T destination,T anterior, ArrayList<ArrayList<PlanVuelo>> soluciones,
                     ArrayList<PlanVuelo> patron,ArrayList<PlanVuelo> patronSolucion,
                     int veces,double tiempo,int horaActual,
                     GrafoAeropuerto<T> grafito,boolean inicio){
        
        
        if(inicio){
            for(PlanVuelo planes: grafito.ArcosDesde(destination)){ //lista negra
                patron.add(planes);
            }
        }
        
        if (actual.equals(destination) && tiempo>=0){// Si se llego al destino o no se cumplió con el tiempo
            soluciones.add(new ArrayList<>(patronSolucion));
            patronSolucion.remove(grafo.BuscarPlanVuelo(actual, anterior));
            return;
        }

        final ArrayList<PlanVuelo> df = grafito.ArcosDesde(actual);

        for (PlanVuelo t : df){ //Para sacar cada vuelo desde un vértice
             
            if((Integer)t.getDestino().getId()!= anterior){ //Para que no retorne a su anterior posicion 
                if (!patron.contains(t)){ //si no lo encuentra en la lista negra
                    if(!patronSolucion.contains(t)){// si no está considera en la solución
                        
                        patronSolucion.add(t);
                        
                        if(veces<3 && tiempo>=0){ //Si el tamaño de caminos es 3 [o si el tiempo se terminó]

                            if(horaActual > t.getHora_ini()){ //Para manejar correctamente los tiempos de salida de las ciudades

                                int espera = 24-(horaActual - t.getHora_ini()); //Lo que se espera en el aeropuerto intermedio
                                int esperaConVuelo = t.getDuracion() + espera; //la espera sumado con el viaje
                                DFS ((T)(Integer)(Object)t.getDestino().getId(), destination, actual, soluciones, patron,patronSolucion,veces+1,tiempo-esperaConVuelo,t.getHora_fin(),grafito,false);
                            }
                            else{
                                int espera = t.getHora_ini() - horaActual; //Lo que se espera en el aeropuerto intermedio
                                int esperaConVuelo = t.getDuracion() + espera; //la espera sumado con el viaje
                                DFS ((T)(Integer)(Object)t.getDestino().getId(), destination, actual, soluciones, patron,patronSolucion,veces+1,tiempo-esperaConVuelo,t.getHora_fin(),grafito,false);
                            }
                        }
                    }
                }
            }
            
            patronSolucion.remove(t);
            
        }
        
    }       

}
