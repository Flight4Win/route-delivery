/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 *
 * @author joe
 * @param <T>
 */
public class GrafoAeropuerto<T> implements Iterable<T>{
    
    private final Map<T, Map<T, Double>> grafo = new HashMap<T, Map<T, Double>>();

    /**
     *  Adds a new node to the graph. If the node already exists then its a
     *  no-op.
     * 
     * @param node  Adds to a graph. If node is null then this is a no-op.
     * @return      true if node is added, false otherwise.
     */
    public boolean AgregarVertice(T vertice) {
        if (vertice == null) {
            throw new NullPointerException("El valor ingresado no debe ser null");
        }
        if (grafo.containsKey(vertice)) return false;

        grafo.put(vertice, new HashMap<T, Double>());
        return true;
    }

    /**
     * Given the source and destination node it would add an arc from source 
     * to destination node. If an arc already exists then the value would be 
     * updated the new value.
     *  
     * @param partida                    the source node.
     * @param Destino               the destination node.
     * @param duracion                    if length if 
     * @throws NullPointerException     if source or destination is null.
     * @throws NoSuchElementException   if either source of destination does not exists. 
     */
    public void agregarArco (T partida, T Destino, double duracion) {
        if (partida == null || Destino == null) {
            throw new NullPointerException("Source and Destination, both should be non-null.");
        }
        if (!grafo.containsKey(partida) || !grafo.containsKey(Destino)) {
            throw new NoSuchElementException("Source and Destination, both should be part of graph");
        }
        /* A node would always be added so no point returning true or false */
        grafo.get(partida).put(Destino, duracion);
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
    public Map<T, Double> ArcosDesde(T nodo) {
        if (nodo == null) {
            throw new NullPointerException("The node should not be null.");
        }
        Map<T, Double> arcos = grafo.get(nodo);
        if (arcos == null) {
            throw new NoSuchElementException("Source node does not exist.");
        }
        return Collections.unmodifiableMap(arcos);
    }

    public boolean ExisteRuta(T partida,T destino){
        if(grafo.get(partida).get(destino)!=null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void imprimirGrafo(){
        for (int i = 1; i <= grafo.size(); i++) {
            System.out.print(i+") ");
            for (int j = 1;j< grafo.get(i).size(); j++) {
                if(grafo.get(i).get(j)!=null){
                    System.out.print(grafo.get(i).keySet().toArray()[j] + " -> ");
                }
            }
            System.out.println("null");
        }
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

