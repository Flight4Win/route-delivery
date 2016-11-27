/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.Serializable;

/**
 *
 * @author Joe Natan
 */
public class Ruta implements Serializable{
    private PlanVuelo[][][] _ruta;
    private int [][][] _ExisteRuta;
    
    public Ruta(int cantidadAeropuerto){
        
        _ruta = new PlanVuelo[cantidadAeropuerto+1][cantidadAeropuerto+1][2];
        _ExisteRuta = new int[cantidadAeropuerto+1][cantidadAeropuerto+1][2];
        
       /* for (int i = 0; i < _ruta.length; i++) {
            for (int j = 0; j < _ruta.length; j++) {
                _ExisteRuta[i][j][1]= 0;
                _ExisteRuta[i][j][2]= 0;
            }
        }*/
        
    }
    
    
    public PlanVuelo getRutaPrime(int fil,int col){
        return _ruta[fil][col][0];
    }
    public PlanVuelo getRutaSegun(int fil,int col){
        return _ruta[fil][col][1];
    }
    public PlanVuelo getRuta(int fil,int col, int pos){
        return _ruta[fil][col][pos];
    }
    
    public void setRutaPrime(PlanVuelo vuelo,int fil,int col){
        _ruta[fil][col][0] = vuelo;
    }
    public void setRutaSegun(PlanVuelo vuelo,int fil,int col){
        _ruta[fil][col][1] = vuelo;
    }
    public void setRuta(PlanVuelo vuelo,int fil,int col, int pos){
        _ruta[fil][col][pos] = vuelo;
    }
    
    
    
    
    public int getExisteRutaPrime(int fil,int col){
        return _ExisteRuta[fil][col][0];
    }
    public int getExisteRutaSegun(int fil,int col){
        return _ExisteRuta[fil][col][1];
    }
    public int getExisteRuta(int fil,int col, int pos){
        return _ExisteRuta[fil][col][pos];
    }
    
    public void setExisteRutaPrime(int fil,int col){
        _ExisteRuta[fil][col][0]=1;
    }
    public void setExisteRutaSegun(int fil,int col){
        _ExisteRuta[fil][col][1]=1;
    }
    public void setExisteRuta(int fil,int col, int pos){
        _ExisteRuta[fil][col][pos]=1;
    }
}
