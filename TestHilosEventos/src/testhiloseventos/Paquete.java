/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testhiloseventos;

import java.time.LocalDateTime;

/**
 *
 * @author Diego
 */
public class Paquete {
    private int _destino ;
    private int _partida;
    private int _horaEntrega;
    private int _id;
    private LocalDateTime _fechaRegistro;

    /**
     * @return the _destino
     */
    public int getDestino() {
        return _destino;
    }

    /**
     * @return the _partida
     */
    public int getPartida() {
        return _partida;
    }

    /**
     * @return the _horaEntrega
     */
    public int getHoraEntrega() {
        return _horaEntrega;
    }

    /**
     * @return the _id
     */
    public int getId() {
        return _id;
    }

    /**
     * @return the _fechaRegistro
     */
    public LocalDateTime getFechaRegistro() {
        return _fechaRegistro;
    }
    
    public Paquete(int id_partida, int id_destino, int horaEntrega, int id, LocalDateTime fechaRegistro){
        _destino = id_destino;
        _partida = id_partida;        
        _horaEntrega = horaEntrega;
        _fechaRegistro = fechaRegistro;
        _id = id;
    }
}
