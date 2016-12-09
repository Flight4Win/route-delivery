/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temporizador;



import clases.Aeropuerto;
import utiles.Controlador;
import clases.Paquete;
import clases.PlanVuelo;
import data.ColeccionPlanVuelo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import manejadorDB.controlador.AeropuertoControlador;
import manejadorDB.controlador.ClienteControlador;
import manejadorDB.controlador.PaqueteControlador;
import manejadorDB.controlador.PersonaControlador;
import utiles.Factory;
import utiles.GestorCorreo;
import utilitario.gestorSMS;

/**
 *
 * @author Diego
 */

public class TemporizadorAplicacion implements Dispatcher.PackageListener{
    private Timer _temp;
    private static LocalDateTime _fecha;
    private ColeccionPlanVuelo _planesVuelo;
    private static TimerTaskEjm _tarea;
    private ArrayList<VueloListener> _vueloListeners = new ArrayList<>();
    private int _factorTiempo;
    private int _simActual=0;
    private GestorCorreo gc = new GestorCorreo();
    /**
     * @return the _simActual
     */
    public int getSimActual() {
        return _simActual;
    }

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
        return _tarea.getFecha();
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
        if(_simActual!=0)return;
        if(_temp!=null)_temp.cancel();
//        _temp = new Timer();
//        _tarea = new TimerTaskEjm(getTemp(), getFecha(),_planesVuelo, 1);
//        for(VueloListener vL : _vueloListeners) _tarea.AgregarListener(vL);
//        getTemp().schedule(_tarea, 0,1000);
    }
    
    public void ActivarSegSim(){
        if(_simActual!=0)return;        
        if(_temp!=null)_temp.cancel();
        _temp = new Timer();
        _tarea = new TimerTaskEjm(getTemp(), getFecha(),_planesVuelo, 4);
        for(VueloListener vL : _vueloListeners) _tarea.AgregarListener(vL);
        getTemp().schedule(_tarea, 0,5);
    }
    
    public void ActivarTerSim(){
        if(_simActual!=0)return;
        if(_temp!=null)_temp.cancel();
        _temp = new Timer();
        _tarea = new TimerTaskEjm(getTemp(), getFecha(),_planesVuelo, 10);
        //System.out.println("tam list "+_vueloListeners.size());
        for(VueloListener vL : _vueloListeners) _tarea.AgregarListener(vL);
        getTemp().schedule(_tarea, 0,10);
    }
    
    public void Cancelar(){
        getTemp().cancel();
    }
    
    public void Pausar(){
        _tarea.Pausar();
    }
    
    public void Reanudar(){
        _tarea.Reanudar();
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
            if(sistemaCaido){
                System.out.println(p.getId() + " - "+p.getFechaRegistro()+" - "+p.getPartida()+" - "+p.getDestino());
                //System.exit(0);
                if(_simActual!=1){
                    Controlador.setPaquete_fallo(p);
                    Controlador.setFallo_sistema(true);
                    Controlador.getTempo().Cancelar();
                    Controlador.getDespacher().CancelarTimer();    
                }
                
            }
            if(_simActual == 0){
                AeropuertoControlador ac= new AeropuertoControlador();
                PersonaControlador pc = new PersonaControlador();
                ClienteControlador cc = new ClienteControlador();
                System.out.println("tamaño de a ruta oficial:  "+p.getRutaOficial().size());
                System.out.println("Paquete ruta:   "+ p.getRutaOficial().size());            
        
                System.out.println("Duracion:  "+p.getDuracionViaje());
                System.out.println("Origen:   "+ ac.obtener_Aeropuerto(p.getPartida()).getIdlugar().getCiudad());
                System.out.println("Destino:   "+ac.obtener_Aeropuerto(p.getDestino()).getIdlugar().getCiudad());
                String mensajeParaEmisor = "Su paquete estará llegando a su destino en  "+
                        p.getDuracionViaje()+" horas. La ruta que tomará será la siguiente, sále de : \n"
                        ;
                if(p.getRutaOficial() != null){
                    for (int i = 0; i < p.getRutaOficial().size(); i++) {
                        entidad.Aeropuerto aux;
                        PlanVuelo ruta = p.getRutaOficial().get(i);
                        aux = ac.to_Aeropuerto_Entity(ruta.getDestino());
                        mensajeParaEmisor+= "  -> "+aux.getIdlugar().getCiudad();
                        System.out.println("-->   "+aux.getIdlugar().getCiudad()); 
                    } 
                }                                
                entidad.Cliente emisor = cc.obtener_cliente(p.getIdcliente());
                entidad.Persona destinatario = pc.obtener_Persona(p.getIdpersona());
                gc.enviarCorreo(emisor.getIdpersona().getCorreo(), "Paquete "+p.getId()+"  -> ENVÍO PAQUETE - TraslaPack", mensajeParaEmisor);// emisor
                gc.enviarCorreo(destinatario.getCorreo(),"Paquete "+p.getId()+"  -> PAQUETE A RECIBIR - TraslaPack", "Su paquete estará llegando en "+p.getDuracionViaje()+"horas");// emisor
                /*CArlo aqui suma horas y haz lo siguiente:
                PaqueteControlador pqt = new PaqueteControlador();
                pqt.actualizarFechaFin("aqui la fecha inico + la suma de horas", p.getId()"creo que es este ");
                */                
            }            
        }    
}

class TimerTaskEjm extends TimerTask{
    private Timer _temporizador;
    private static LocalDateTime _fecha;
    private ColeccionPlanVuelo _planVuelos;
    private ArrayList<VueloListener> _vueloListeners = new ArrayList<>();
    private int _aumento;
    private boolean _enPausa;
    private ArrayList<Paquete> _listaPaquetes = new ArrayList<>();
    private GestorCorreo gesCorreo = new GestorCorreo();
    private gestorSMS gesSMS = new gestorSMS();

    /**
     * @return the _fecha
     */
    public static LocalDateTime getFecha() {
        return _fecha;
    }
    
    public TimerTaskEjm(Timer timer, LocalDateTime fecha, ColeccionPlanVuelo planVuelos, int aumento){
        _temporizador = timer;
        _fecha = fecha;
        _planVuelos = planVuelos;
        _aumento = aumento;
        _enPausa=false;
    }
    
    public void AgregarListener (VueloListener vL){
        _vueloListeners.add(vL);
    }
    
    public void Pausar(){
        _enPausa = true;
    }
    
    public void Reanudar(){
        _enPausa=false;
    }
    
    @Override
    public void run(){
        if(!_enPausa){
            _fecha = getFecha().plusSeconds(_aumento);
            System.out.println(getFecha());
            if(getFecha().getHour()!= getFecha().minusSeconds(1).getHour()){
                //significa que ha cambiado la hora, de 6 a 7 por ejemplo
                for(PlanVuelo p : _planVuelos.getPlanVuelos()){                
                    if(p.getHora_ini()==getFecha().getHour()){
                        //despega un vuelo

                        //System.out.println("inicio vuelo ");
                        //p.imprimir();
                        //_planVuelos.getEnVuelo().add(p);
                        p.EnviarPaquetes();
                        for(VueloListener vL : _vueloListeners){
                            vL.DespegoAvion(p);                        
                        }
                    }
                    else if(p.getHora_fin()==getFecha().getHour()){
                        //aterriza un vuelo
                        if(_planVuelos.getEnVuelo().contains(p)){
                            //System.out.println("fin vuelo");
                            //p.imprimir();
                            //_planVuelos.getEnVuelo().remove(p);
                            System.out.println("D");
                            _listaPaquetes = p.ActualizarPaquetesAeropuertos();
                            System.out.println("Paquetes a enviar correos: "+_listaPaquetes.size());
                            if(!_listaPaquetes.isEmpty()){
                                PaqueteControlador paqControl = new PaqueteControlador();
                                for (Paquete paq : _listaPaquetes){
                                    System.out.println("Paquete con código: "+paq.getId());
                                    entidad.Paquete paqNotify = paqControl.obtener_paquete(paq.getId());
                                    if(paqNotify==null)break;
                                    System.out.println("paqNotify: "+paqNotify.getCodigounico());
                                    gesCorreo.enviarCorreo(paqNotify.getIdcliente().getIdpersona().getCorreo(), "Info de Paquete",
                                            "Su paquete: " + paqNotify.getCodigounico() + " está en camino a "+p.getDestino().getNombre()); 
                                    gesSMS.enviarSMS(paqNotify.getIdcliente().getIdpersona().getCelular(), "Su paquete: " + paqNotify.getCodigounico() + " está en camino a "+p.getDestino().getNombre());
                                }
                                
                            }
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
}