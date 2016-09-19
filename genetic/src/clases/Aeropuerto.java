/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author Diego
 */

//Clase que representa un aeropuerto
public class Aeropuerto {
    private Lugar _lugar;
    private String _nombre;
    private double _capacidad;    

    /**
     * @return the _lugar
     */
    public Lugar getLugar() {
        return _lugar;
    }

    /**
     * @param _lugar the _lugar to set
     */
    public void setLugar(Lugar _lugar) {
        this._lugar = _lugar;
    }

    /**
     * @return the _nombre
     */
    public String getNombre() {
        return _nombre;
    }

    /**
     * @param _nombre the _nombre to set
     */
    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    /**
     * @return the _capacidad
     */
    public double getCapacidad() {
        return _capacidad;
    }

    /**
     * @param _capacidad the _capacidad to set
     */
    public void setCapacidad(double _capacidad) {
        this._capacidad = _capacidad;
    }
    
    public Aeropuerto(Lugar lugar, String nombre, double capacidad){
        _lugar = lugar;
        _nombre = nombre;
        _capacidad = capacidad;
    }
    
    public String toString(){
        return _lugar.toString();
    }
}
