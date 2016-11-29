/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dispatcher;

import clases.Aeropuerto;
import utiles.Controlador;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import clases.Paquete;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Diego
 */
public class Despachador {
    private Timer _tempo;
    private LocalDateTime _fecha;    
    private PriorityQueue<Paquete> _paqADesp12Sim = new PriorityQueue<>(new PaqueteComp());
    private PriorityQueue<Paquete> _paqADesp3Sim = new PriorityQueue<>(new PaqueteComp());
    private final DateTimeFormatter _formateador = DateTimeFormatter.ofPattern("yyyyMMddHH:mm");
    private DespachTask _tarea;
    private ArrayList<PackageListener> _manejadores = new ArrayList<>();
    private int _simActual = 0;

    /**
     * @return the _simActual
     */
    public int getSimActual() {
        return _simActual;
    }

    /**
     * @param _simActual the _simActual to set
     */
    public void setSimActual(int _simActual) {
        this._simActual = _simActual;
    }

    /**
     * @return the _tempo
     */
    public Timer getTempo() {
        return _tempo;
    }
    
    public Despachador(LocalDateTime fecha){
        _fecha = fecha;
        leerPaq12Sim();
        leerPaq3Sim();
        //leerPaquetes();
    }
    
    public void Pausar(){
        _tarea.Pausar();
    }
    
    public void Reanudar(){
        _tarea.Reanudar();
    }
    
    public void ActivarPrimSim(){
        if(_tempo!=null)_tempo.cancel();
        //_tempo = new Timer();
        //_tarea = new DespachTask(_paqADesp12Sim,_fecha,1);
        //for(PackageListener pL : _manejadores) _tarea.AgregarManejador(pL);
        //_tempo.schedule(_tarea, 0,1000);                
    }
    
    public void ActivarSegSim(){
        if(_simActual!=0)return;
        if(_tempo!=null)_tempo.cancel();
        _tempo = new Timer();
        _tarea = new DespachTask(_paqADesp12Sim,_fecha,4);
        //System.out.println("tam listener: "+_manejadores.size());
        for(PackageListener pL : _manejadores) _tarea.AgregarManejador(pL);
        _tempo.schedule(_tarea, 0,5);
        //System.out.println("se activo");
    }
    
    public void ActivarTerSim(){
        if(_simActual!=0)return;
        if(_tempo!=null)_tempo.cancel();
        _tempo = new Timer();
        _tarea = new DespachTask(_paqADesp3Sim,_fecha,10);
        for(PackageListener pL : _manejadores) _tarea.AgregarManejador(pL);
        System.out.println("tam listener: "+_manejadores.size());
        _tempo.schedule(_tarea, 0,10);
    }        
    
    public void CancelarTimer(){
        _tempo.cancel();
    }
    
    private void leerPaq12Sim(){
        try{
            for(Aeropuerto a : Controlador.getAeropuertos().getAeropuertos()){                
                //String ruta = Controlador.class.getResource("/dataSimulacion1_2/arch_"+a.getNombre()+".txt").getPath();
                //BufferedReader br = new BufferedReader(new FileReader(ruta));
                
                InputStream im = Controlador.class.getResourceAsStream("/dataSimulacion1_2/arch_"+a.getNombre()+".txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(im));
                
                String str;
                while((str = br.readLine())!=null){                
                    String strFecha = str.substring(9,22);
                    int ciudadIni = a.getId();
                    int ciudadFin = Controlador.getAeropuertos().BuscarId(str.substring(22,26));
                    int id = Integer.parseInt(str.substring(0, 9));
                    LocalDateTime horaRegistro = LocalDateTime.parse(strFecha, _formateador);
                    horaRegistro = horaRegistro.withSecond(0);
                    horaRegistro = horaRegistro.plusHours(a.getLugar().getUtc());
                    //Date fecha = convertirHora(fechaString);                
                    Paquete p = new Paquete(ciudadIni, ciudadFin,horaRegistro.getHour(),id ,horaRegistro);
                    //System.out.println(fecha.getHours());
                    _paqADesp12Sim.add(p);
                }
            }
            System.out.println("tamanho de paqADesp12Sim: "+_paqADesp12Sim.size());
        }
        catch(Exception e){
            System.out.println("error al leer paquetes simulacion 1,2");
        }
    }
    
    private void leerPaq3Sim(){
        try{
            for(Aeropuerto a : Controlador.getAeropuertos().getAeropuertos()){                
                //String ruta = Controlador.class.getResource("/dataSimulacion3/arch_"+a.getNombre()+".txt").getPath();               
               // BufferedReader br = new BufferedReader(new FileReader(ruta));
                
                InputStream im = Controlador.class.getResourceAsStream("/dataSimulacion3/arch_"+a.getNombre()+".txt");
                BufferedReader br = new BufferedReader(new InputStreamReader(im));
                
                
                String str;
                while((str = br.readLine())!=null){
                    
                    String strFecha = str.substring(9,22);
                    int ciudadIni = a.getId();
                    int ciudadFin = Controlador.getAeropuertos().BuscarId(str.substring(22,26));
                    int id = Integer.parseInt(str.substring(0, 9));
                    LocalDateTime horaRegistro = LocalDateTime.parse(strFecha, _formateador);
                    horaRegistro = horaRegistro.withSecond(0);
                    horaRegistro = horaRegistro.plusHours(a.getLugar().getUtc());
                    //Date fecha = convertirHora(fechaString);                
                    Paquete p = new Paquete(ciudadIni, ciudadFin,horaRegistro.getHour(),id ,horaRegistro);
                    //System.out.println(fecha.getHours());
                    _paqADesp3Sim.add(p);
                }
            }
            System.out.println("tamanho de paqADesp3Sim: "+_paqADesp3Sim.size());
        }
        catch(Exception e){
            System.out.println("error al leer paquetes simulacion 3");
        }
    }    
    
    public void AgregarManejador(PackageListener manejador){
        _manejadores.add(manejador);
    }
}

class PaqueteComp implements Comparator<Paquete>{
    
    @Override
    public int compare(Paquete p1, Paquete p2){
        return p1.getFechaRegistro().compareTo(p2.getFechaRegistro());
    }    
}
