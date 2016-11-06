/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

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
            if(nombre.equals(a.getNombre())) return a;
        }
        return null;
    }
    
    public Aeropuerto Buscar(int codigo){
        for(Aeropuerto a:aeropuertos){
            if(a.getLugar().getCodigo() == codigo) return a;
        }
        return null;
    }
}
