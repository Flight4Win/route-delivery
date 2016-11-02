/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temporizador;


import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Diego
 */
public class TemporizadorAplicacion {
    private Timer _temp;
    private static LocalDateTime _fecha;

    /**
     * @return the _fecha
     */
    public static LocalDateTime getFecha() {
        return _fecha;
    }
    
    public TemporizadorAplicacion(LocalDateTime fecha){
        _temp = new Timer();
        _fecha = fecha;
    }
    
    public void ActivarTimer(){
        _temp.schedule(new TimerTaskEjm(_temp, getFecha()), 1000,1000);
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