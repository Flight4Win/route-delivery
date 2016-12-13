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
import entidad.Estado;
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
import utiles.GestorSMS;

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
    private final GestorCorreo gc = new GestorCorreo();
    private final GestorSMS gs = new GestorSMS();
    /**
     * @param _simActual the _simActual to set
     */
    public void setSimActual(int _simActual) {
        this._simActual = _simActual;
    }
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
     * @return the _tarea
     */
    public static TimerTaskEjm getTarea() {
        return _tarea;
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
        return TimerTaskEjm.getFecha();
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
        setSimActual(1);
        if(_temp!=null)_temp.cancel();
        _temp = new Timer();
        _tarea = new TimerTaskEjm(_temp, _fecha.plusSeconds(0),_planesVuelo, 10,_simActual);
        for(VueloListener vL : _vueloListeners) _tarea.AgregarListener(vL);
        getTemp().schedule(_tarea, 0,50);
    }
    
    public void ActivarSegSim(){
        if(_simActual!=0)return;        
        setSimActual(2);
        if(_temp!=null)_temp.cancel();
        _temp = new Timer();
        _tarea = new TimerTaskEjm(_temp, _fecha.plusSeconds(0),_planesVuelo, 10,_simActual);
        for(VueloListener vL : _vueloListeners) _tarea.AgregarListener(vL);
        getTemp().schedule(_tarea, 0,10);
    }
    
    public void ActivarTerSim(){
        if(_simActual!=0)return;
        setSimActual(3);
        if(_temp!=null)_temp.cancel();
        _temp = new Timer();
        _tarea = new TimerTaskEjm(_temp, _fecha.plusSeconds(0),_planesVuelo, 10,_simActual);
        //System.out.println("tam list "+_vueloListeners.size());
        for(VueloListener vL : _vueloListeners) _tarea.AgregarListener(vL);
        getTemp().schedule(_tarea, 0,5);
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
    
    public void Terminar(){
        _tarea.setTermino(true);
    }
    
    @Override
    public synchronized void EnvioNuevoPaquete(Paquete p){
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
            ArrayList<ArrayList<PlanVuelo>> r;
            if(p.getRutas().isEmpty()){
                r = Controlador.getPatrones().getPatrones(
                    (Integer)p.getPartida(),(Integer)p.getDestino(),
                    tiempo,p.getHoraEntrega(),Controlador.getPlanVuelos());
            
                p.setRutas(r);
            }else{
                r=p.getRutas();
            }            
            
            sistemaCaido = !Controlador.getGenetico().ejecutarAlgGenetico(
                    Controlador.getGrafoAeropuerto(),Controlador.getAeropuertos(),
                    Controlador.getPaquetes(),p,r,p.getHoraEntrega(),_simActual);
            if(sistemaCaido){
                //System.out.println(p.getId() + " - "+p.getFechaRegistro()+" - "+p.getPartida()+" - "+p.getDestino());
                //System.exit(0);
                if((_simActual==3) && (_tarea.getDias()>=11)){
                    //System.out.println(_tarea.getDias());
                    Controlador.getTempo().Cancelar();
                    Controlador.getDespacher().CancelarTimer(); 
                    Controlador.setPaquete_fallo(p);
                    Controlador.setFallo_sistema(true);                       
                }
                
            }
            if(_simActual == 1){
                AeropuertoControlador ac= new AeropuertoControlador();
                PersonaControlador pc = new PersonaControlador();
                ClienteControlador cc = new ClienteControlador();
                System.out.println("tamanho de a ruta oficial:  "+p.getRutaOficial().size());
                System.out.println("Paquete ruta:   "+ p.getRutaOficial().size());            
        
                System.out.println("Duracion:  "+p.getDuracionViaje());
                System.out.println("Origen:   "+ ac.obtener_Aeropuerto(p.getPartida()).getIdlugar().getCiudad());
                System.out.println("Destino:   "+ac.obtener_Aeropuerto(p.getDestino()).getIdlugar().getCiudad());
                String mensajeParaEmisor = "Su paquete estara llegando a su destino en  "+
                        p.getDuracionViaje()+" horas. La ruta que tomara sera la siguiente, sale de : \n"
                        ;
                mensajeParaEmisor+= " "+ac.obtener_Aeropuerto(p.getPartida()).getIdlugar().getCiudad();
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
                gc.enviarCorreo(emisor.getIdpersona().getCorreo(), "Paquete "+p.getId()+"  -> ENVIO PAQUETE - TraslaPack", mensajeParaEmisor);// emisor
                gc.enviarCorreo(destinatario.getCorreo(),"Paquete "+p.getId()+"  -> PAQUETE A RECIBIR - TraslaPack", "Su paquete estara llegando en "+p.getDuracionViaje()+"horas");// emisor
//                gs.enviarSMS(emisor.getIdpersona().getCelular(), mensajeParaEmisor);
//                gs.enviarSMS(destinatario.getCelular(), "Su paquete estara llegando en "+p.getDuracionViaje()+"horas");
                /*CArlo aqui suma horas y haz lo siguiente:
                PaqueteControlador pqt = new PaqueteControlador();
                pqt.actualizarFechaFin("aqui la fecha inico + la suma de horas", p.getId()"creo que es este ");
                */                
            }            
        }    
    
    public static int getDias(){
        return _tarea.getDias();
    }
}

class TimerTaskEjm extends TimerTask{
    private Timer _temporizador;
    private static LocalDateTime _fecha;
    private ColeccionPlanVuelo _planVuelos;
    private ArrayList<VueloListener> _vueloListeners = new ArrayList<>();
    private int _aumento;
    private boolean _enPausa;
    private ArrayList<Paquete> _listaPaquetesEnDestino = new ArrayList<>();
    private ArrayList<Paquete> _listaPaquetesNoDestino = new ArrayList<>();
    private GestorCorreo gc = new GestorCorreo();
    private GestorSMS gs = new GestorSMS();
    private int _simulacion;
    private boolean _termino = false;
    private static int _dias = 0;

    /**
     * @param _termino the _termino to set
     */
    public void setTermino(boolean _termino) {
        this._termino = _termino;
    }

    AeropuertoControlador ac= new AeropuertoControlador();
    PersonaControlador pc = new PersonaControlador();
    ClienteControlador cc = new ClienteControlador();
    
    /**
     * @param _simulacion the _simulacion to set
     */
    public void setSimulacion(int _simulacion) {
        this._simulacion = _simulacion;
    }

    /**
     * @return the _fecha
     */
    public static LocalDateTime getFecha() {
        return _fecha;
    }
    
    public TimerTaskEjm(Timer timer, LocalDateTime fecha, ColeccionPlanVuelo planVuelos, int aumento, int simulacion){
        _temporizador = timer;
        _fecha = fecha;
        _planVuelos = planVuelos;
        _aumento = aumento;
        _enPausa=false;
        _simulacion = simulacion;
        _dias = 0;
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
        if(_termino)return;
        if(!_enPausa){
            _fecha = _fecha.plusSeconds(_aumento);
            System.out.println(getFecha());
            if((_fecha.getHour()==0) &&(_fecha.getMinute()==0) &&(_fecha.getSecond()==0))_dias++;
            if(getFecha().getHour()!= getFecha().minusSeconds(1).getHour()){
                //significa que ha cambiado la hora, de 6 a 7 por ejemplo
                for(PlanVuelo p : _planVuelos.getPlanVuelos()){                
                    if(p.getHora_ini()==getFecha().getHour()){
                        //despega un vuelo

                        //System.out.println("inicio vuelo ");
                        //p.imprimir();
                        //_planVuelos.getEnVuelo().add(p);
                        
                        p.EnviarPaquetes();
                        if(_simulacion==1)enviarNotificacionesAPaquetesEnTransito(p);
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
                            //System.out.println("D");
                            _listaPaquetesEnDestino = p.ActualizarPaquetesAeropuertos(_listaPaquetesNoDestino);                            
                            if(_simulacion==1){                                
                                System.out.println("Paquetes a enviar correos:   _listaPaquetesEnDestino"+_listaPaquetesEnDestino.size());
                                System.out.println("Paquetes a enviar correos:   _listaPaquetesNoDestino"+_listaPaquetesNoDestino.size());
                                PaqueteControlador pqtc = new PaqueteControlador();
                                    if(!_listaPaquetesEnDestino.isEmpty()){                                    
                                        entidad.Paquete paquete;
                                        for (Paquete pqt : _listaPaquetesEnDestino) {
                                            paquete =  (entidad.Paquete) pqtc.buscarPorCodigo(Integer.toString(p.getId_base()));
                                            paquete.setIdestado(new Estado(5));
                                            pqtc.actualizar(paquete);
                                            entidad.Cliente emisor = cc.obtener_cliente(pqt.getIdcliente());
                                            entidad.Persona destinatario = pc.obtener_Persona(pqt.getIdpersona());
                                            gc.enviarCorreo(emisor.getIdpersona().getCorreo(), "Paquete "+pqt.getId()+"  -> SEGUIMIENTO PAQUETE  - TraslaPack", "Su paquete ya llego a su destino");// emisor
                                            gc.enviarCorreo(destinatario.getCorreo(),"Paquete "+pqt.getId()+"  -> SEGUIMIENTO PAQUETE  - TraslaPack", "Su paquete ya llego a su destino");// emisor
    //                                        gs.enviarSMS(emisor.getIdpersona().getCelular(), "SEGUIMIENTO PAQUETE \nSu paquete ya llego a su destino");
    //                                        gs.enviarSMS(destinatario.getCelular(),"SEGUIMIENTO PAQUETE \nSu paquete ya llego a su destino");
                                        }
                                    }
                                    if(!_listaPaquetesNoDestino.isEmpty()){
                                       entidad.Paquete paquete;
                                        for (Paquete pqt : _listaPaquetesNoDestino) {
                                            paquete =  (entidad.Paquete) pqtc.obtener_paquete(pqt.getId_base());
                                            paquete.setIdestado(new Estado(3));
                                            pqtc.actualizar(paquete);
                                            entidad.Cliente emisor = cc.obtener_cliente(pqt.getIdcliente());
                                            entidad.Persona destinatario = pc.obtener_Persona(pqt.getIdpersona());
                                            gc.enviarCorreo(emisor.getIdpersona().getCorreo(), "Paquete "+pqt.getId()+"  -> SEGUIMIENTO PAQUETE  - TraslaPack", "Su paquete esta haciendo una escala");// emisor
                                            gc.enviarCorreo(destinatario.getCorreo(),"Paquete "+pqt.getId()+"  -> SEGUIMIENTO PAQUETE  - TraslaPack", "Su paquete esta haciendo una escala");// emisor
    //                                        gs.enviarSMS(emisor.getIdpersona().getCelular(), "SEGUIMIENTO PAQUETE \nSu paquete esta haciendo una escala");
    //                                        gs.enviarSMS(destinatario.getCelular(),"SEGUIMIENTO PAQUETE \nSu paquete esta haciendo una escala");
                                        } 
                                    }
                            }
                            //p.ActualizarPaquetesAeropuertos();
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
    
    public void enviarNotificacionesAPaquetesEnTransito(PlanVuelo plan){
        PaqueteControlador pq = new PaqueteControlador();
        entidad.Paquete paquete;
//        String mensajeParaEmisor = "Su paquete acaba de salir del Aeropuerto de ";
        for (Paquete p : plan.getPaquetesDespegados()) {
            //modificar BD estado del paquete
            paquete =  pq.obtener_paquete(p.getId_base());
            paquete.setIdestado(new Estado(4));
            pq.actualizar(paquete);
            System.out.println("Modificar data: "+p.getId_base()+"  estado:   En transito");
            //
//            mensajeParaEmisor += ac.obtener_Aeropuerto(p.getPartida()).getIdlugar().getCiudad()+" con direccion "+
//                    ac.obtener_Aeropuerto(p.getDestino() ).getIdlugar().getCiudad();
//            entidad.Cliente emisor = cc.obtener_cliente(p.getIdcliente());
//            entidad.Persona destinatario = pc.obtener_Persona(p.getIdpersona());
//            gc.enviarCorreo(emisor.getIdpersona().getCorreo(), "Paquete "+p.getId()+"  -> SEGUIMIENTO PAQUETE - TraslaPack", mensajeParaEmisor + " "+p.getFechaRegistro().toString());// emisor
//            gc.enviarCorreo(destinatario.getCorreo(),"Paquete "+p.getId()+"  -> SEGUIMIENTO PAQUETE - TraslaPack", "Su paquete estarÃ¡ llegando en "+p.getDuracionViaje()+"horas");// emisor                
//            gs.enviarSMS(emisor.getIdpersona().getCelular(), "SEGUIMIENTO PAQUETE \n"+mensajeParaEmisor + " "+p.getFechaRegistro().toString());
//            gs.enviarSMS(destinatario.getCelular(),"SEGUIMIENTO PAQUETE \nSu paquete estara llegando en "+p.getDuracionViaje()+"horas");
                
        }
        
        //modificar estado de paquetes en el aeropuerto
        for (Paquete p : plan.getPaquetes()) {
            //modificar BD estado del paquete
            paquete =  (entidad.Paquete) pq.buscarPorCodigo(Integer.toString(p.getId_base()));
            paquete.setIdestado(new Estado(3));
            pq.actualizar(paquete);
        }
    }
    
    public void enviarNotificacionesAPaquetesLlegados(PlanVuelo plan){
        PaqueteControlador pq = new PaqueteControlador();
        entidad.Paquete paquete;
        for (Paquete pqt : plan.getPaquetesDespegados()) {
            //modificar BD estado del paquete
            
            if(pqt.getDestino() == plan.getDestino().getId()){
                paquete =  (entidad.Paquete) pq.buscarPorCodigo(Integer.toString(pqt.getId_base()));
                paquete.setIdestado(new Estado(5));
                pq.actualizar(paquete);
                entidad.Cliente emisor = cc.obtener_cliente(pqt.getIdcliente());
                entidad.Persona destinatario = pc.obtener_Persona(pqt.getIdpersona());
                gc.enviarCorreo(emisor.getIdpersona().getCorreo(), "Paquete "+pqt.getId()+"  -> SEGUIMIENTO PAQUETE  - TraslaPack", "Su paquete ya llego a su destino");// emisor
                gc.enviarCorreo(destinatario.getCorreo(),"Paquete "+pqt.getId()+"  -> SEGUIMIENTO PAQUETE  - TraslaPack", "Su paquete ya llego a su destino");// emisor
//                gs.enviarSMS(emisor.getIdpersona().getCelular(), "SEGUIMIENTO PAQUETE \nSu paquete ya llego a su destino");
//                gs.enviarSMS(destinatario.getCelular(),"SEGUIMIENTO PAQUETE \nSu paquete ya llego a su destino");
            }else{
                paquete =  (entidad.Paquete) pq.buscarPorCodigo(Integer.toString(pqt.getId_base()));
                paquete.setIdestado(new Estado(3));
                pq.actualizar(paquete);
                entidad.Cliente emisor = cc.obtener_cliente(pqt.getIdcliente());
                entidad.Persona destinatario = pc.obtener_Persona(pqt.getIdpersona());
                gc.enviarCorreo(emisor.getIdpersona().getCorreo(), "Paquete "+pqt.getId()+"  -> SEGUIMIENTO PAQUETE  - TraslaPack", "Su paquete esta haciendo una escala");// emisor
                gc.enviarCorreo(destinatario.getCorreo(),"Paquete "+pqt.getId()+"  -> SEGUIMIENTO PAQUETE  - TraslaPack", "Su paquete esta haciendo una escala");// emisor
//                gs.enviarSMS(emisor.getIdpersona().getCelular(), "SEGUIMIENTO PAQUETE \nSu paquete esta haciendo una escala");
//                gs.enviarSMS(destinatario.getCelular(),"SEGUIMIENTO PAQUETE \nSu paquete esta haciendo una escala");
            }
            
                 
        }
    }
    

    /**
     * @return the _dias
     */
    public static int getDias() {
        return _dias;
    }
}