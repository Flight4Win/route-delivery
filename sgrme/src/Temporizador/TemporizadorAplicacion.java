/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temporizador;



import clases.Paquete;
import clases.PlanVuelo;
import data.ColeccionPlanVuelo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Diego
 */
public class TemporizadorAplicacion {
    private Timer _temp;
    private static LocalDateTime _fecha;
    private ColeccionPlanVuelo _planesVuelo;
    private TimerTaskEjm _tarea;
    private ArrayList<VueloListener> _vueloListeners = new ArrayList<>();

    /**
     * @return the _temp
     */
    public Timer getTemp() {
        return _temp;
    }
    
    /**
     * @return the _fecha
     */
    public static LocalDateTime getFecha() {
        return _fecha;
    }
    
    public TemporizadorAplicacion(LocalDateTime fecha, ColeccionPlanVuelo planesVuelo){
        //_temp = new Timer();
        _fecha = fecha;
        _planesVuelo = planesVuelo;
    }
    
    public void AgregarListener (VueloListener vL){
        _vueloListeners.add(vL);
    }
    
    public void ActivarTimer(){
        _temp = new Timer();
        _tarea = new TimerTaskEjm(getTemp(), getFecha(),_planesVuelo);
        for(VueloListener vL : _vueloListeners) _tarea.AgregarListener(vL);
        getTemp().schedule(_tarea, 0,50);
    }
    
    public void Cancelar(){
        getTemp().cancel();
    }
    
    /*@Override
    public void EnvioNuevoPaquete(Paquete p){
        System.out.println(p.getId());
    }*/    
}

class TimerTaskEjm extends TimerTask{
    private Timer _temporizador;
    private LocalDateTime _fecha;
    private ColeccionPlanVuelo _planVuelos;
    private ArrayList<VueloListener> _vueloListeners = new ArrayList<>();
    
    public TimerTaskEjm(Timer timer, LocalDateTime fecha, ColeccionPlanVuelo planVuelos){
        _temporizador = timer;
        _fecha = fecha;
        _planVuelos = planVuelos;
    }
    
    public void AgregarListener (VueloListener vL){
        _vueloListeners.add(vL);
    }
    
    @Override
    public void run(){
        _fecha = _fecha.plusSeconds(4);
        //System.out.println(_fecha);
        if(_fecha.getHour()!= _fecha.minusSeconds(1).getHour()){
            //significa que ha cambiado la hora, de 6 a 7 por ejemplo
            for(PlanVuelo p : _planVuelos.getPlanVuelos()){                
                if(p.getHora_ini()==_fecha.getHour()){
                    //despega un vuelo
                    
                    //System.out.println("inicio vuelo ");
                    //p.imprimir();
                    //_planVuelos.getEnVuelo().add(p);
                    p.EnviarPaquetes();
                    for(VueloListener vL : _vueloListeners){
                        vL.DespegoAvion(p);
                    }
                }
                if(p.getHora_fin()==_fecha.getHour()){
                    //aterriza un vuelo
                    if(_planVuelos.getEnVuelo().contains(p)){
                        //System.out.println("fin vuelo");
                        //p.imprimir();
                        //_planVuelos.getEnVuelo().remove(p);
                        p.ActualizarPaquetesAeropuertos();
                        for(VueloListener vL : _vueloListeners){
                            vL.AterrizajeAvion(p);
                        }
                    }
                    
                }
            }
        }
        
    }
}