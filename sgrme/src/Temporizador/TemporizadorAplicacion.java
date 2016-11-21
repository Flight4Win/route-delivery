/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temporizador;



import clases.Controlador;
import clases.Paquete;
import clases.PlanVuelo;
import data.ColeccionPlanVuelo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */

public class TemporizadorAplicacion implements Dispatcher.PackageListener{
    private Timer _temp;
    private static LocalDateTime _fecha;
    private ColeccionPlanVuelo _planesVuelo;
    private TimerTaskEjm _tarea;
    private ArrayList<VueloListener> _vueloListeners = new ArrayList<>();
    private int _factorTiempo;

    /**
     * @return the _factorTiempo
     */
    public int getFactorTiempo() {
        return _factorTiempo;
    }

    /**
     * @param _factorTiempo the _factorTiempo to set
     */
    public void setFactorTiempo(int _factorTiempo) {
        this._factorTiempo = _factorTiempo;
    }

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
    
    public void ActivarPrimSim(){
        if(_temp!=null)_temp.cancel();
        _temp = new Timer();
        _tarea = new TimerTaskEjm(getTemp(), getFecha(),_planesVuelo, 1);
        for(VueloListener vL : _vueloListeners) _tarea.AgregarListener(vL);
        getTemp().schedule(_tarea, 0,1000);
    }
    
    public void ActivarSegSim(){
        if(_temp!=null)_temp.cancel();
        _temp = new Timer();
        _tarea = new TimerTaskEjm(getTemp(), getFecha(),_planesVuelo, 4);
        for(VueloListener vL : _vueloListeners) _tarea.AgregarListener(vL);
        getTemp().schedule(_tarea, 0,5);
    }
    
    public void ActivarTerSim(){
        if(_temp!=null)_temp.cancel();
        _temp = new Timer();
        _tarea = new TimerTaskEjm(getTemp(), getFecha(),_planesVuelo, 5);
        //System.out.println("tam list "+_vueloListeners.size());
        for(VueloListener vL : _vueloListeners) _tarea.AgregarListener(vL);
        getTemp().schedule(_tarea, 0,1);
    }
    
    public void Cancelar(){
        getTemp().cancel();
    }
    

    @Override
    public void EnvioNuevoPaquete(Paquete p){
        //JOptionPane.showMessageDialog(null, "llego paquete");
        System.out.println(p.getId());
        System.out.println(p.getFechaRegistro());
        int tiempo;  
        boolean sistemaCaido = false;
            if(Controlador.getAeropuertos().EsIntercontinental(p.getPartida(),p.getDestino())){
                tiempo = 24;
            }
            else{
                tiempo = 48;
            }
            p.setMaximaDuracion(tiempo);
            ArrayList<ArrayList<PlanVuelo>> r = Controlador.getPatrones().getPatrones(
                    (Integer)p.getPartida(),(Integer)p.getDestino(),
                    tiempo,p.getHoraEntrega(),Controlador.getPlanVuelos());
            
            p.setRutas(r);
            
            sistemaCaido = !Controlador.getGenetico().ejecutarAlgGenetico(
                    Controlador.getGrafoAeropuerto(),Controlador.getAeropuertos(),
                    Controlador.getPaquetes(),p,r,p.getHoraEntrega());

    }    


}

class TimerTaskEjm extends TimerTask{
    private Timer _temporizador;
    private LocalDateTime _fecha;
    private ColeccionPlanVuelo _planVuelos;
    private ArrayList<VueloListener> _vueloListeners = new ArrayList<>();
    private int _aumento;
    
    public TimerTaskEjm(Timer timer, LocalDateTime fecha, ColeccionPlanVuelo planVuelos, int aumento){
        _temporizador = timer;
        _fecha = fecha;
        _planVuelos = planVuelos;
        _aumento = aumento;
    }
    
    public void AgregarListener (VueloListener vL){
        _vueloListeners.add(vL);
    }
    
    @Override
    public void run(){
        _fecha = _fecha.plusSeconds(_aumento);
        System.out.println(_fecha);
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
                else if(p.getHora_fin()==_fecha.getHour()){
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
//                else if(p.isEnVuelo()){
//                    p.setPosicionX(p.getPosicionX()+p.getDistanciaX()/(p.getDuracion()));
//                    p.setPosicionY(p.getPosicionY()+p.getDistanciaY()/(p.getDuracion()));
//                    //p.setPosicionX(p.getPosicionX()+1);
//                    //p.setPosicionY(p.getPosicionY()+1);
//                }
            }
        }else{
            for(PlanVuelo p : _planVuelos.getEnVuelo()){
                p.setPosicionX(p.getPosicionX()+_aumento*p.getDistanciaX()/3600);
                p.setPosicionY(p.getPosicionY()+_aumento*p.getDistanciaY()/3600);

            }
        }
        
    }
}