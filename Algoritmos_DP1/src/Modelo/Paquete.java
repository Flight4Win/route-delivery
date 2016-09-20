/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Diego
 */
public class Paquete {
    private int _ciudadIni;
    private int _ciudadFin;
    private Date _fechaRegistro;

    /**
     * @return the ciudadIni
     */
    public int getCiudadIni() {
        return _ciudadIni;
    }

    /**
     * @param ciudadIni the ciudadIni to set
     */
    public void setCiudadIni(int ciudadIni) {
        this._ciudadIni = ciudadIni;
    }

    /**
     * @return the ciudadFin
     */
    public int getCiudadFin() {
        return _ciudadFin;
    }

    /**
     * @param ciudadFin the ciudadFin to set
     */
    public void setCiudadFin(int ciudadFin) {
        this._ciudadFin = ciudadFin;
    }

    /**
     * @return the fechaSalida
     */
    public Date getFechaRegistro() {
        return _fechaRegistro;
    }

    /**
     * @param fechaSalida the fechaSalida to set
     */
    public void setFechaRegistro(Date fechaSalida) {
        this._fechaRegistro = fechaSalida;
    }
    
    public Paquete(int ciudadIni, int ciudadFin, Date fechaRegistro){
        _ciudadIni = ciudadIni;
        _ciudadFin = ciudadFin;
        _fechaRegistro = fechaRegistro;
    }
}
