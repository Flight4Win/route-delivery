/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.Date;

/**
 *
 * @author Diego
 */
public class Paquete {
    private int _destino ;
    private int _partida;
    private int _tipo;
    private int _HoraEntrega;
    private int _id;
    private Date _fechaRegistro;

    public Paquete(int id_partida, int id_destino, int tipo, int HoraEntrega, int id){
        _destino = id_destino;
        _partida = id_partida;
        _tipo = tipo;
        _HoraEntrega = HoraEntrega;
        _id = id;
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
     * @return the _tipo
     */
    public int getTipo() {
        return _tipo;
    }

    /**
     * @param _tipo the _tipo to set
     */
    public void setTipo(int _tipo) {
        this._tipo = _tipo;
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
    public Date getFechaRegistro() {
        return _fechaRegistro;
    }

    /**
     * @param _fechaRegistro the _fechaRegistro to set
     */
    public void setFechaRegistro(Date _fechaRegistro) {
        this._fechaRegistro = _fechaRegistro;
    }
}
