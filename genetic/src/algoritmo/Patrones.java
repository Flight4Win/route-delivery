/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
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

    private void validar (T partida, T destino) {

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
     * Returns the list of paths, where path itself is a list of nodes.
     * 
     * @param partida            the source node
     * @param destino       the destination node
     * @return                  List of all paths
     */
    public List<List<T>> getPatrones(T partida, T destino) {
        validar(partida, destino);

        List<List<T>> patrones = new ArrayList<List<T>>();
        recursivo(partida, destino, patrones, new LinkedHashSet<T>());
        return patrones;
    }

    // so far this dude ignore's cycles.
    private void recursivo (T actual, T destination, List<List<T>> patrones, LinkedHashSet<T> patron) {
        patron.add(actual);

        if (actual.equals(destination)){
            System.out.println(patron.toString());
            patrones.add(new ArrayList<T>(patron));
            patron.remove(actual);
            return;
        }

        final Set<T> edges  = grafo.ArcosDesde(actual).keySet();

        for (T t : edges) {
            if (!patron.contains(t)) {
                recursivo (t, destination, patrones, patron);
            }
        }

        patron.remove(actual);
    }    

  /*  public static void main(String[] args) {
        GraphFindAllPaths<String> graphFindAllPaths = new GraphFindAllPaths<String>();
        graphFindAllPaths.addNode("A");
        graphFindAllPaths.addNode("B");
        graphFindAllPaths.addNode("C");
        graphFindAllPaths.addNode("D");

        graphFindAllPaths.addEdge("A", "B", 10);
        graphFindAllPaths.addEdge("A", "C", 10);
        graphFindAllPaths.addEdge("B", "D", 10);
        graphFindAllPaths.addEdge("C", "D", 10);

        graphFindAllPaths.addEdge("B", "C", 10);
        graphFindAllPaths.addEdge("C", "B", 10);

            FindAllPaths<String> findAllPaths = new FindAllPaths<String>(graphFindAllPaths);

        findAllPaths.getAllPaths("A", "D");

        
    }*/
}
