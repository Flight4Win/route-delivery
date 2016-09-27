/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 *
 * @author Diego
 */
public class Arista {    
    private ArrayList<Pair<Integer,Integer>> _horas;
    private Pair<Integer,Integer> _ciudades;
    private int _duracion;
    private Boolean _disponible;

    /**
     * @return the _horas
     */
    public ArrayList<Pair<Integer,Integer>> getHoras() {
        return _horas;
    }

    /**
     * @return the _ciudades
     */
    public Pair<Integer,Integer> getCiudades() {
        return _ciudades;
    }

    /**
     * @param _ciudades the _ciudades to set
     */
    public void setCiudades(Pair<Integer,Integer> _ciudades) {
        this._ciudades = _ciudades;
    }

    /**
     * @return the _disponible
     */
    public Boolean getDisponible() {
        return _disponible;
    }

    /**
     * @param _disponible the _disponible to set
     */
    public void setDisponible(Boolean _disponible) {
        this._disponible = _disponible;
    }

    /**
     * @return the _duracion
     */
    public int getDuracion() {
        return _duracion;
    }
    
    public Arista(int ciudadIni, int ciudadFin){
        _ciudades = new Pair<>(ciudadIni,ciudadFin);
        _horas = new ArrayList<>();
        _disponible = true;
    }
    
    public void agregarHora(int horaIni, int horaFin){
        Pair<Integer,Integer> parHora = new Pair<>(horaIni,horaFin);
        if(horaFin>horaIni){
            _duracion = horaFin-horaIni;
        }else{
            _duracion = 24-horaIni+horaFin;
        }
        _horas.add(parHora);
    }
}
