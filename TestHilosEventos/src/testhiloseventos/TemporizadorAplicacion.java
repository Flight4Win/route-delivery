/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testhiloseventos;

import Dispatcher.PackageListener;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Diego
 */
public class TemporizadorAplicacion implements PackageListener{
    private Timer _temp;
    private LocalDateTime _fecha;
    
    public TemporizadorAplicacion(LocalDateTime fecha){
        _temp = new Timer();
        _fecha = fecha;
    }
    
    public void ActivarTimer(){
        _temp.schedule(new TimerTaskEjm(_temp,_fecha), 1000,1000);
    }
    
    @Override
    public void EnvioNuevoPaquete(Paquete p){
        System.out.println(p.getId());
    }
}

class TimerTaskEjm extends TimerTask{
    private Timer _temporizador;
    private LocalDateTime _fecha;
    
    public TimerTaskEjm(Timer timer, LocalDateTime fecha){
        _temporizador = timer;
        _fecha = fecha;
    }
    
    @Override
    public void run(){
        _fecha = _fecha.plusSeconds(1);
        System.out.println(_fecha);
    }
}