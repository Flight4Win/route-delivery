/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import clases.PlanVuelo;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 *
 * @author joe
 * @param <T>
 */
public class GrafoAeropuerto<T> implements Iterable<T>{
    
    public Map<T, ArrayList<PlanVuelo>> grafo = new HashMap<T, ArrayList<PlanVuelo>>();

    /**
     *  Adds a new node to the graph. If the node already exists then its a
     *  no-op.
     * 
     * @param vertice
     * @return      true if node is added, false otherwise.
     */
    public GrafoAeropuerto<T> CopiaDelGrafo(){
        
        Map<T, ArrayList<PlanVuelo>> grafoMap = new HashMap<T, ArrayList<PlanVuelo>>(grafo);
        
        GrafoAeropuerto<T> grafoReturn = new GrafoAeropuerto<T>();
        grafoReturn.grafo = grafoMap;
        
        return grafoReturn;
    }
    
    
    public boolean AgregarVertice(T vertice) {
        if (vertice == null) {
            throw new NullPointerException("El valor ingresado no debe ser null");
        }
        if (grafo.containsKey(vertice)) return false;

        grafo.put(vertice, new ArrayList<PlanVuelo>());
        
        Map<T, ArrayList<PlanVuelo>> grafot = new HashMap<T, ArrayList<PlanVuelo>>(grafo);
        
        return true;
    }

    /**
     * Given the source and destination node it would add an arc from source 
     * to destination node. If an arc already exists then the value would be 
     * updated the new value.
     *  
     * @param partida                    the source node.
     * @param Destino               the destination node. 
     * @throws NullPointerException     if source or destination is null.
     * @throws NoSuchElementException   if either source of destination does not exists. 
     */
    public void agregarArco (T partida, T Destino, PlanVuelo vuelo){
        if (partida == null || Destino == null) {
            throw new NullPointerException("Source and Destination, both should be non-null.");
        }
        if (!grafo.containsKey(partida) || !grafo.containsKey(Destino)) {
            throw new NoSuchElementException("Source and Destination, both should be part of graph");
        }
        // A node would always be added so no point returning true or false 
        grafo.get(partida).add(vuelo);
    }

    /**
     * Removes an edge from the graph.
     * 
     * @param partida        If the source node.
     * @param destino   If the destination node.
     * @throws NullPointerException     if either source or destination specified is null
     * @throws NoSuchElementException   if graph does not contain either source or destination
     */
    public void removerArco (T partida, T destino) {
        if (partida == null || destino == null) {
            throw new NullPointerException("Source and Destination, both should be non-null.");
        }
        if (!grafo.containsKey(partida) || !grafo.containsKey(destino)) {
            throw new NoSuchElementException("Source and Destination, both should be part of graph");
        }
        grafo.get(partida).remove(destino);
    }

    /**
     * Given a node, returns the edges going outward that node,
     * as an immutable map.
     * 
     * @param nodo The node whose edges should be queried.
     * @return An immutable view of the edges leaving that node.
     * @throws NullPointerException   If input node is null.
     * @throws NoSuchElementException If node is not in graph.
     */
    public ArrayList<PlanVuelo> ArcosDesde(T nodo) {
        if (nodo == null) {
            throw new NullPointerException("The node should not be null.");
        }
        ArrayList<PlanVuelo> arcos = grafo.get(nodo);
        if (arcos == null) {
            throw new NoSuchElementException("Source node does not exist.");
        }
        return arcos;
    }

    public boolean ExisteRuta(T partida,T destino){
        try{
            ArrayList<PlanVuelo> df = grafo.get(partida);
            for(PlanVuelo t: df){
                if(t.getDestino().getId()== (Integer)destino)
                    return true;
            }
            return false;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    public PlanVuelo BuscarPlanVuelo(T destino,T partida){
        ArrayList<PlanVuelo> df = grafo.get(partida);
            for(PlanVuelo t: df){
                if(t.getDestino().getId()== (Integer)destino)
                    return t;
            }
            return null;
    }   
    
    public ArrayList<PlanVuelo> BuscarListaPlanVuelo(T destino,T partida){
        ArrayList<PlanVuelo> df = grafo.get(partida);
        ArrayList<PlanVuelo> encontrado = new ArrayList<>();
            for(PlanVuelo t: df){
                if(t.getDestino().getId()== (Integer)destino){
                   encontrado.add(t);
                }
            }
            if(!encontrado.isEmpty())
                return encontrado;
            else
                return null;
    }  
    
    public ArrayList<PlanVuelo> VerticesA(T nodo){
        ArrayList<PlanVuelo> verticesA = new ArrayList<>();
        
        for(T vertice:grafo.keySet()){
            ArrayList<PlanVuelo> arcos = grafo.get(vertice);
            for(PlanVuelo p : arcos){
                if(p.getDestino().getId() == (Integer)nodo){
                    verticesA.add(p);
                }
            }
        }
        return verticesA;
    }
    
    /**
     * Returns the iterator that travels the nodes of a graph.
     * 
     * @return an iterator that travels the nodes of a graph.
     */
    @Override public Iterator<T> iterator() {
        return grafo.keySet().iterator();
    }
}

