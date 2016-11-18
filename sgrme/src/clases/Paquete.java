/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Paquete {

    private int _destino;
    private int _partida;
    private int _HoraEntrega;
    private int _id;
    private LocalDateTime _fechaRegistro;
    private ArrayList<PlanVuelo> rutaOficial;
    private ArrayList<ArrayList<PlanVuelo>> rutas;
    private int _duracionViaje;
    private int _maximaDuracion;

    /**
     * @return the ruta
     */
    public ArrayList<PlanVuelo> getRuta() {
        return rutaOficial;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(ArrayList<PlanVuelo> ruta) {
        this.rutaOficial = ruta;
    }
    
    /**
     * @return the _maximaDuracion
     */
    public int getMaximaDuracion() {
        return _maximaDuracion;
    }

    /**
     * @param _maximaDuracion the _maximaDuracion to set
     */
    public void setMaximaDuracion(int _maximaDuracion) {
        this._maximaDuracion = _maximaDuracion;
    }

    /**
     * @return the _duracionViaje
     */
    public int getDuracionViaje() {
        return _duracionViaje;
    }

    /**
     * @param _duracionViaje the _duracionViaje to set
     */
    public void setDuracionViaje(int _duracionViaje) {
        this._duracionViaje = _duracionViaje;
    }

    /**
     * @return the ruta
     */
    public ArrayList<PlanVuelo> getRutaOficial() {
        return rutaOficial;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRutaOficial(ArrayList<PlanVuelo> ruta) {
        this.rutaOficial = ruta;
    }

    /**
     * @return the _destino
     */
    public int getDestino() {
        return _destino;
    }

    /**
     * @param _destino the _destino to set
     */
    public void setDestino(int _destino) {
        this._destino = _destino;
    }

    /**
     * @return the _partida
     */
    public int getPartida() {
        return _partida;
    }

    /**
     * @param _partida the _partida to set
     */
    public void setPartida(int _partida) {
        this._partida = _partida;
    }

    /**
     * @return the _tiempo
     */
    public int getHoraEntrega() {
        return _HoraEntrega;
    }

    /**
     * @param _HoraEntrega the _tiempo to set
     */
    public void setHoraEntrega(int _HoraEntrega) {
        this._HoraEntrega = _HoraEntrega;
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
     * @return the _fechaRegistro
     */
    public LocalDateTime getFechaRegistro() {
        return _fechaRegistro;
    }

    /**
     * @param _fechaRegistro the _fechaRegistro to set
     */
    public void setFechaRegistro(LocalDateTime _fechaRegistro) {
        this._fechaRegistro = _fechaRegistro;
    }

    public Paquete(int id_partida, int id_destino, int HoraEntrega, int id, LocalDateTime fechaRegistro) {
        _destino = id_destino;
        _partida = id_partida;
        //_tipo = tipo;
        _HoraEntrega = HoraEntrega;
        _fechaRegistro = fechaRegistro;
        _id = id;
    }

    /**
     * @return the rutas
     */
    public ArrayList<ArrayList<PlanVuelo>> getRutas() {
        return rutas;
    }

    /**
     * @param rutas the rutas to set
     */
    public void setRutas(ArrayList<ArrayList<PlanVuelo>> rutas) {
        this.rutas = rutas;
    }

}
