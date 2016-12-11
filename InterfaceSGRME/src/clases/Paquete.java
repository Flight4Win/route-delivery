/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Paquete implements Serializable{

    public Paquete(Paquete p) {
        _destino = p.getDestino();
        _partida = p.getPartida();
        _HoraEntrega = p.getHoraEntrega();
        _fechaRegistro = p.getFechaRegistro();
        _id = p.getId();
        idcliente = p.getIdcliente();
        idpersona = p.getIdpersona();
        id_base = p.getId_base();
    }

    
    
    /**
     * @return the idcliente
     */
    public int getIdcliente() {
        return idcliente;
    }

    /**
     * @param idcliente the idcliente to set
     */
    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    /**
     * @return the idpersona
     */
    public int getIdpersona() {
        return idpersona;
    }

    /**
     * @param idpersona the idpersona to set
     */
    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    /**
     * @return the tiempo_estimado
     */
    public int getTiempo_estimado() {
        return tiempo_estimado;
    }

    /**
     * @param tiempo_estimado the tiempo_estimado to set
     */
    public void setTiempo_estimado(int tiempo_estimado) {
        this.tiempo_estimado = tiempo_estimado;
    }

    /**
     * @return the id_estado
     */
    public int getId_estado() {
        return id_estado;
    }

    /**
     * @param id_estado the id_estado to set
     */
    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    /**
     * @return the id_base
     */
    public int getId_base() {
        return id_base;
    }

    /**
     * @param id_base the id_base to set
     */
    public void setId_base(int id_base) {
        this.id_base = id_base;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private int _destino;
    private int _partida;
    private int _HoraEntrega;
    private int _id;
    private LocalDateTime _fechaRegistro;
    private ArrayList<PlanVuelo> rutaOficial = new ArrayList<>();
    private ArrayList<ArrayList<PlanVuelo>> rutas = new ArrayList<>();
    private int _duracionViaje;
    private int _maximaDuracion;
    
    private int id_base = -1;
    private String descripcion = null;
    private int id_estado = 1;
    private int tiempo_estimado = -1;
    private LocalDateTime fecha_fin = null;
    
    //necesario
    private int idcliente = 1;
    private int idpersona = 2;

    public Paquete() {

    }
    

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
        _id  = id;
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

    /**
     * @return the fecha_fin
     */
    public LocalDateTime getFecha_fin() {
        return fecha_fin;
    }

    /**
     * @param fecha_fin the fecha_fin to set
     */
    public void setFecha_fin(LocalDateTime fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

}
