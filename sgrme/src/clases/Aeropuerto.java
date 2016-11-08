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
//Clase que representa un aeropuerto
public class Aeropuerto {

    private Lugar _lugar;
    private String _nombre;
    private static int _capacidad = 800;
    private int _id;
    private boolean _europeo;
    private int _capacidadOcupada = 0;
    private ArrayList<Paquete> paquetesPorLlegar = new ArrayList<>();
    private ArrayList<Paquete> paquetesPorSalir = new ArrayList<>();

    /**
     * @return the _capacidadOcupada
     */
    public int getCapacidadOcupada() {
        return _capacidadOcupada;
    }

    /**
     * @param _capacidadOcupada the _capacidadOcupada to set
     */
    public void setCapacidadOcupada(int _capacidadOcupada) {
        this._capacidadOcupada = _capacidadOcupada;
    }

    /**
     * @return the paquetesPorSalir
     */
    public ArrayList<Paquete> getPaquetesPorSalir() {
        return paquetesPorSalir;
    }

    /**
     * @param paquetesPorSalir the paquetesPorSalir to set
     */
    public void setPaquetesPorSalir(ArrayList<Paquete> paquetesPorSalir) {
        this.paquetesPorSalir = paquetesPorSalir;
    }

    /**
     * @return the paquetesPorLlegar
     */
    public ArrayList<Paquete> getPaquetesPorLlegar() {
        return paquetesPorLlegar;
    }

    /**
     * @param paquetesPorLlegar the paquetesPorLlegar to set
     */
    public void setPaquetesPorLlegar(ArrayList<Paquete> paquetesPorLlegar) {
        this.paquetesPorLlegar = paquetesPorLlegar;
    }

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
    public void setCapacidad(int _capacidad) {
        this._capacidad = _capacidad;
    }

    public Aeropuerto(Lugar lugar, String nombre, int capacidad, int id, boolean europeo) {
        _lugar = lugar;
        _nombre = nombre;
        //_capacidad = capacidad;
        _id = id;
        _europeo = europeo;
    }

    public String toString() {
        return _lugar.toString();
    }

    /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @param _id the _id to set
     */
    public void setId(int _id) {
        this._id = _id;
    }

    /**
     * @return the _europeo
     */
    public boolean isEuropeo() {
        return _europeo;
    }
}
