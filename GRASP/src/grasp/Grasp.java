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
public class Grasp { 
    ArrayList<Vuelo> vuelos;
    ArrayList<Aeropuerto> aeropuertos;
    
    ArrayList<Vuelo> tempVuelos;

    public Grasp(ArrayList<Vuelo> vuelos, ArrayList<Aeropuerto> aeropuertos) {
        this.vuelos = vuelos;
        this.aeropuertos = aeropuertos;
    } 
    
    
    
    public void algoritmo(/*Paquete, PlanVuelo, Aeropuertos */){
        
        //Mientras (No Condicion de parada)
            //Fase de contruccion
                //Seleccionar lista de candidatos
                //Considerar listra restringida (mejores)
                //Seleccionar elemento de lista restringida
            // Fase de mejora (búsqueda local)
                //Solución de búsqueda local hasta no mejorarse
            //Actualización
                //Si la solución > solución almacenada
                    //SolAlmacenada = SolMejorada
        //Fin Mientras
        //Devolver SolAlmacenada
    }
    
    public void construirSolucion(Paquete paquete){
        //Ruta = vacio | Lista de adyacencia (de aviones que tomará)
        Ruta rutaPaquete = new Ruta(); 
        //Cargar lista de aviones que puede tomar
        tempVuelos = vuelos;
        String destinoUltimo ;
        
        
        //Como al inicio ruta no tiene destinoActual
        if(rutaPaquete.vuelos.isEmpty()){
            destinoUltimo=paquete.ciudadOrigen;
        }else{ //La última ubicación del paquete
            destinoUltimo=rutaPaquete.vuelos.get(rutaPaquete.vuelos.size()-1).ciudadDestino;
        }         
        //Mientras (Ruta no llegue a destino) hacer
        while(destinoUltimo.compareTo(paquete.ciudadDestino) != 0){
            //función voraz????
            
             //a = obtener mínimo de función voraz de elementos restantes
            //b = obtener máximo de función voraz de elementos restantes            
            //agregar a lista de candidatos restringidos(LCR)
                //los que cumplan que f(c) <= a + 0.7(b-a)
            
            //y = selecionar aleatoriamente un elemento de LCR 
           //agregar "y" a Ruta
           //disminuir la lista de candidatos
        }
           
    }
    
    
    //ArrayList<Vuel
    
}
