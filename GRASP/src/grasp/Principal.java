/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grasp;

import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here:
        
        //Vuelos
        
        
        @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
        ArrayList<Vuelo> vuelos =  new ArrayList<>();//Lista de vuelos.
        
        Vuelo v1 = new Vuelo(1, "Peru", "Brasil", 5, "08:30", "13:30", 200, 0);        
        Vuelo v2 = new Vuelo(1, "Peru", "Brasil", 5, "08:30", "13:30", 200, 0);
        Vuelo v3 = new Vuelo(1, "Peru", "Brasil", 5, "08:30", "13:30", 200, 0);
        Vuelo v4 = new Vuelo(1, "Peru", "Brasil", 5, "08:30", "13:30", 200, 0);
        Vuelo v5 = new Vuelo(1, "Peru", "Brasil", 5, "08:30", "13:30", 200, 0);
        Vuelo v6 = new Vuelo(1, "Peru", "Brasil", 5, "08:30", "13:30", 200, 0);
        Vuelo v7 = new Vuelo(1, "Peru", "Brasil", 5, "08:30", "13:30", 200, 0);
        Vuelo v8 = new Vuelo(1, "Peru", "Brasil", 5, "08:30", "13:30", 200, 0);
        Vuelo v9 = new Vuelo(1, "Peru", "Brasil", 5, "08:30", "13:30", 200, 0);
        Vuelo v10 = new Vuelo(1, "Peru", "Brasil", 5, "08:30", "13:30", 200, 0);
        
        vuelos.add(v1);
        vuelos.add(v2);
        vuelos.add(v3);
        vuelos.add(v4);
        vuelos.add(v5);
        vuelos.add(v6);
        vuelos.add(v7);
        vuelos.add(v8);
        vuelos.add(v9);
        vuelos.add(v10);
        
        //Paquetes
        
        
        //Aeropuertos
          ArrayList<Aeropuerto> aeropuertos = null;     
        
        //Algoritmo
        Grasp grasp = new Grasp(vuelos,aeropuertos);
       //Recorriendo Lista de Paquetes
       
       //
       
       
        
        
    }
    
}
