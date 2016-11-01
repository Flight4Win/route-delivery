/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dispatcher;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TimerTask;
import testhiloseventos.Paquete;

/**
 *
 * @author Diego
 */
public class DespachTask extends TimerTask{
    private ArrayList<Paquete> _paqADesp;
    private LocalDateTime _fecha;
    private ArrayList<PackageListener> _manejadores = new ArrayList<>();
    
    public DespachTask(ArrayList<Paquete> paqADesp, LocalDateTime fecha){
        _paqADesp = paqADesp;
        _fecha = fecha;
    }
    
    public void AgregarManejador(PackageListener manejador){
        _manejadores.add(manejador);
    }
    
    @Override
    public void run(){
        _fecha = _fecha.plusSeconds(1);
        if(_paqADesp.isEmpty()) return;
        if(_fecha.equals(_paqADesp.get(0).getFechaRegistro()) ){
            Paquete p = _paqADesp.get(0);
            _paqADesp.remove(0);
            //mandar evento
            //System.out.println("Se encontro paquete");
            for(PackageListener pL: _manejadores){
                pL.EnvioNuevoPaquete(p);
            }
            
            for(Paquete paq : _paqADesp){
                if(_fecha.equals(paq.getFechaRegistro())){
                    //mandar evento
                    //System.out.println("Se encontro otro paquete a la misma hora");
                    for(PackageListener pL: _manejadores){
                        pL.EnvioNuevoPaquete(paq);
                    }
                }else{
                    break;
                }
            }
        }
    }
}
