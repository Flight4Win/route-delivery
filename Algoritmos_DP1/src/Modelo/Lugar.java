/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Diego
 */
public class Lugar {
    private int _codigo;
    private String _continente;
    private String _pais;
    private String _ciudad;
    private int _utc;

    /**
     * @return the _codigo
     */
    public int getCodigo() {
        return _codigo;
    }

    /**
     * @param _codigo the _codigo to set
     */
    public void setCodigo(int _codigo) {
        this._codigo = _codigo;
    }

    /**
     * @return the _continente
     */
    public String getContinente() {
        return _continente;
    }

    /**
     * @param _continente the _continente to set
     */
    public void setContinente(String _continente) {
        this._continente = _continente;
    }

    /**
     * @return the _pais
     */
    public String getPais() {
        return _pais;
    }

    /**
     * @param _pais the _pais to set
     */
    public void setPais(String _pais) {
        this._pais = _pais;
    }

    /**
     * @return the _ciudad
     */
    public String getCiudad() {
        return _ciudad;
    }

    /**
     * @param _ciudad the _ciudad to set
     */
    public void setCiudad(String _ciudad) {
        this._ciudad = _ciudad;
    }

    /**
     * @return the _utc
     */
    public int getUtc() {
        return _utc;
    }

    /**
     * @param _utc the _utc to set
     */
    public void setUtc(int utc) {
        this._utc = utc;
    }
    
    public Lugar(int codigo, String continente, String pais, String ciudad){
        _codigo = codigo;
        _continente = continente;
        _pais = pais;
        _ciudad = ciudad;
    }
    
    public String toString(){
        return _continente+"-"+_pais+"-"+_ciudad;
    }
}
