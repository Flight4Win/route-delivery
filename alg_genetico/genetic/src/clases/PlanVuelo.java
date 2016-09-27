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
public class PlanVuelo {
    private Aeropuerto _partida;
    private Aeropuerto _destino;
    private int _hora_ini;//ya tiene que estar convertdo a una hora global
    private int _hora_fin;            
    private int _duracion;//en horas
    
    /**
     * @return the _partida
     */
    public Aeropuerto getPartida() {
        return _partida;
    }

    /**
     * @param _partida the _partida to set
     */
    public void setPartida(Aeropuerto _partida) {
        this._partida = _partida;
    }

    /**
     * @return the _destino
     */
    public Aeropuerto getDestino() {
        return _destino;
    }

    /**
     * @param _destino the _destino to set
     */
    public void setDestino(Aeropuerto _destino) {
        this._destino = _destino;
    }

    /**
     * @return the _hora_ini
     */
    public int getHora_ini() {
        return _hora_ini;
    }

    /**
     * @param _hora_ini the _hora_ini to set
     */
    public void setHora_ini(int _hora_ini) {
        this._hora_ini = _hora_ini;
    }

    /**
     * @return the _hora_fin
     */
    public int getHora_fin() {
        return _hora_fin;
    }

    /**
     * @param _hora_fin the _hora_fin to set
     */
    public void setHora_fin(int _hora_fin) {
        this._hora_fin = _hora_fin;
    }
    
    /**
     * @return the _duracion
     */
    public int getDuracion() {
        return _duracion;
    }
    
    public PlanVuelo(Aeropuerto partida, Aeropuerto destino, int hora_ini, int hora_fin){
        _partida = partida;
        _destino = destino;
        
        if(hora_ini>=24)_hora_ini = hora_ini-24;
        else if(hora_ini<0)_hora_ini = 24-hora_ini;
        else _hora_ini = hora_ini;
        
        if(hora_fin>=24)_hora_fin = hora_fin-24;
        else if(hora_fin<0)_hora_fin = 24-hora_fin;
        else _hora_fin = hora_fin;
//        _hora_ini = hora_ini;
//        _hora_fin = hora_fin;
        
//        
        if(_hora_fin>_hora_ini){
            _duracion = _hora_fin-_hora_ini;
        }else{
            _duracion = 24-_hora_ini+_hora_fin;
        }
        
    }

    public void imprimir(){
        String cadena = _partida.getId()+" -> "+_destino.getId()+" :"+
                _hora_ini+" -> " +_hora_fin+ " - "+_duracion;
        System.out.println(cadena);
    }
}
