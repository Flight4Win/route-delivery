/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Itinerario {
    private ArrayList<Paquete> paquetePorLlegar;
    private ArrayList<Paquete> paquetePorSalir;//la cantidad de estos paquetes es capacidad real
    private int Capacidad;
    private int CapacidadReal;
    private PlanVuelo planVuelo;
    
    public Itinerario(){
        
    }
}
