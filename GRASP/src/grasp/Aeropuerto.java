/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grasp;

/**
 *
 * @author carlo
 */
public class Aeropuerto {
    String idAeropuerto;
    
    String ciudad;    
    String pais;
    String continente;
    
    int capacidadMaxima;
    int capacidadActual;

    public Aeropuerto(String idAeropuerto, String ciudad, String pais, int capacidad) {
        this.idAeropuerto = idAeropuerto;
        this.ciudad = ciudad;
        this.pais = pais;
        this.capacidadMaxima = capacidad;
        
        if(idAeropuerto.charAt(0)!='S') {
            continente="E";
        }else {
            continente="AL";
        }
    }
    
     public String toString(){
        return ("\n "+idAeropuerto+"   "+ciudad+"   "+capacidadMaxima);//+"   "+pais);
    }
       
    
}

