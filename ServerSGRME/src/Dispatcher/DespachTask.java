/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dispatcher;

import utiles.Controlador;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TimerTask;
import clases.Paquete;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class DespachTask extends TimerTask{
    private PriorityQueue<Paquete> _paqADesp;
    private LocalDateTime _fecha;
    private ArrayList<PackageListener> _manejadores = new ArrayList<>();
    private int _aumento;
    private boolean _enPausa;
    
    public DespachTask(PriorityQueue<Paquete> paqADesp, LocalDateTime fecha, int aumento){
        _paqADesp = paqADesp;
        _fecha = fecha;
        _aumento = aumento;
    }
    
    public void Pausar(){
        _enPausa = true;
    }
    
    public void Reanudar(){
        _enPausa=false;
    }
    
    public void AgregarManejador(PackageListener manejador){
        _manejadores.add(manejador);
    }
    
    @Override
    public void run(){
        //System.out.println("run");
        if(!_enPausa){
            _fecha = _fecha.plusSeconds(_aumento);
            if(_paqADesp.isEmpty()){
                System.out.println("termino");
                cancel();
                return;
            }

            if(_fecha.equals(_paqADesp.peek().getFechaRegistro()) ){
                System.out.println("encontre paquete");            
                Paquete p = _paqADesp.poll();

                //mandar evento
                //System.out.println("Se encontro paquete");
                for(PackageListener pL: _manejadores){
                    pL.EnvioNuevoPaquete(p);
                }
                boolean sigue = true;
                while(sigue){
                    if(_fecha.equals(_paqADesp.peek().getFechaRegistro())){
                        Paquete p2 = _paqADesp.poll();
                        for(PackageListener pL: _manejadores){
                            System.out.println("se envio paq");
                            pL.EnvioNuevoPaquete(p2);
                        }
                    }else{
                        sigue=false;
                    }
                }  
            }
        }
    }        
}
