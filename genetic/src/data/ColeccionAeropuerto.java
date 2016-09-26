/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import clases.Aeropuerto;
/**
 *
 * @author Diego
 */

//Clase que representa todos los aeropuertos
public class ColeccionAeropuerto {
    private  ArrayList<Aeropuerto> aeropuertos;

    /**
     * @return the aeropuertos
     */
    public ArrayList<Aeropuerto> getAeropuertos() {
        return aeropuertos;
    }
    
    public ColeccionAeropuerto(){
        aeropuertos = new ArrayList<>();
    }
    
    public void Add(Aeropuerto aeropuerto){
        aeropuertos.add(aeropuerto);
    }
    
    public Aeropuerto Buscar(String nombre){
        for(Aeropuerto a:aeropuertos){
            if(a.getNombre().equals(nombre)) return a;
        }
        return null;
    }
    
    public int BuscarId(String nombre){
        for(Aeropuerto a:aeropuertos){
            if(a.getNombre().equals(nombre)) return a.getId();
        }
        return -1;
    }
}
