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
public class PlanVuelo {
    private Aeropuerto _partida;
    private Aeropuerto _destino;
    private int _hora_ini;//ya tiene que estar convertdo a una hora global
    private int _hora_fin;            
    private int _duracion;//en horas
    private static int _capacidad = 250;
    private int _capacidadOcupada = 0;
    private ArrayList<Paquete> _paquetes = new ArrayList<>();
    private ArrayList<Paquete> _paquetesDespegados = new ArrayList<>();
    private double _distanciaX;
    private double _distanciaY;

    /**
     * @return the _distanciaX
     */
    public double getDistanciaX() {
        return _distanciaX;
    }

    /**
     * @return the _distanciaY
     */
    public double getDistanciaY() {
        return _distanciaY;
    }

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
     * @return the _capacidad
     */
    public int getCapacidad() {
        return _capacidad;
    }

    /**
     * @param _capacidad the _capacidad to set
     */
    public void setCapacidad(int _capacidad) {
        this._capacidad = _capacidad;
    }
    
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
    
    /**
     * @return the paquetes
     */
    public ArrayList<Paquete> getPaquetes() {
        return _paquetes;
    }
    
    public void eliminarPaquete(Paquete paquete){
        _paquetes.remove(paquete);
    }
    
    public void agregarPaquete(Paquete paquete){
        _paquetes.add(paquete);
    }
    
    public PlanVuelo(Aeropuerto partida, Aeropuerto destino, int hora_ini, int hora_fin){
        _partida = partida;
        _destino = destino;
        
        //_capacidad = 10;
        
        if(hora_ini>=24)_hora_ini = hora_ini-24;
        else if(hora_ini<0)_hora_ini = 24-hora_ini;
        else _hora_ini = hora_ini;
        
        if(hora_fin>=24)_hora_fin = hora_fin-24;
        else if(hora_fin<0)_hora_fin = 24-hora_fin;
        else _hora_fin = hora_fin;       
//        
        if(_hora_fin>_hora_ini){
            _duracion = _hora_fin-_hora_ini;
        }else{
            _duracion = 24-_hora_ini+_hora_fin;
        }
        
        CalcularDistancias();
        
    }
    /*
    * Calcula el cambio en la distancia del vuelo en una hora
    * Para la simulacion en tiempo real se tiene que cambiar a otro valor
    */
    private void CalcularDistancias(){
        double dX = Math.abs(_partida.getLongitud() - _destino.getLongitud());
        double dY = Math.abs(_partida.getLatitud() - _destino.getLatitud());                
        
        if(_partida.getLongitud()<=_partida.getLongitud()){
            _distanciaX = dX / _duracion;
        }else{
            _distanciaX = -dX / _duracion;
        }
        
        if(_partida.getLatitud()<=_destino.getLatitud()){
            _distanciaY = dY / _duracion;
        }else{
            _distanciaY = -dY / _duracion;
        }
    }
    
    public void imprimir(){
        String cadena = _partida.getId()+" -> "+_destino.getId()+" :"+
                _hora_ini+" -> " +_hora_fin+ " - "+_duracion;
        System.out.println(cadena);
    }
    
    public void EnviarPaquetes(){
        _paquetesDespegados.clear();
        _paquetesDespegados.addAll(_paquetes);
        _paquetes.clear();
    }
    
    public void ActualizarPaquetesAeropuertos(){
        _capacidadOcupada = 0;
        for(Paquete p: _paquetesDespegados){
            if(this==p.getRuta().get(p.getRuta().size()-1)){
                _destino.getPaquetesPorLlegar().remove(p);
            }else{
                _destino.getPaquetesPorLlegar().remove(p);
                _destino.getPaquetesPorSalir().add(p);
                _destino.setCapacidadOcupada(_destino.getCapacidadOcupada()+1);
            }
        }
    }
}
