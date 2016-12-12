/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import clases.Aeropuerto;
import clases.PlanVuelo;
import de.fhpotsdam.unfolding.*;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.utils.*;
import de.fhpotsdam.unfolding.providers.*;
import processing.core.*;
import de.fhpotsdam.utils.Integrator;
import de.looksgood.ani.*;
import java.awt.Component;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.DMonitoreoPaquetes;


/**
 *
 * @author carlo
 */

public class SimulationMap extends PApplet {          
    int refresh = 0;
    int num = 20;
    boolean seguir_sim = true;
    boolean mensaje_mostrado = false;
    ArrayList<Avion> vuelos= new ArrayList<>();
    ArrayList<PlanVuelo> _planes = new ArrayList<>();
    ArrayList<SimplePointMarker> listSpm = new ArrayList<>();
    

    PImage mapImage = null;
    UnfoldingMap mapDay;
    UnfoldingMap mapNight;
    Integrator blendIntegrator = new Integrator(255);
    UnfoldingMap map;
    DMonitoreoPaquetes monitPaquetes;
    int contador = 99;

    public SimulationMap(DMonitoreoPaquetes monitor) {
        monitPaquetes = monitor;
    }
    
    
    @Override
    public void setup() {
        size(800, 600);        
        seguir_sim=true;
        smooth();
        
        System.out.println(vuelos.size());        
        //noStroke();
        
        // you have to call always Ani.init() first!
        Ani.init(this);
        Ani.autostart();
        Ani.overwrite();
 
        Ani.setDefaultEasing(Ani.EXPO_OUT);
        Ani.setDefaultTimeMode(Ani.FRAMES);               
        
        mapDay = new UnfoldingMap(this,new OpenStreetMap.OpenStreetMapProvider());
        mapNight = new UnfoldingMap(this, new OpenStreetMap.OpenStreetMapProvider());
        
        mapDay.setZoomRange(3, 3);
        mapDay.zoomTo(3);
        mapNight.setZoomRange(3, 3);
        mapNight.zoomTo(3);
        mapDay.zoomAndPanTo(new Location(6.9f, -33.7f), 6);
        
        MapUtils.createDefaultEventDispatcher(this, mapDay, mapNight);
        
//        SimplePointMarker berlinMark=new SimplePointMarker(berlinLocation);
//        SimplePointMarker dublinMark=new SimplePointMarker(dublinLocation);
        

        //crearCiudades();
        crearVuelos();
        System.out.println(vuelos.size());
        //tempo.schedule(new TimerTaskSimulacion(), 0,200);

    }
    
    @Override
    public void mouseMoved() {
    Marker hitMarker = mapDay.getFirstHitMarker(mouseX, mouseY);
        if (hitMarker != null) {
            // Select current marker 
            hitMarker.setSelected(true);
        } else {
            // Deselect all other markers
            for (Marker marker : mapDay.getMarkers()) {
                marker.setSelected(false);
            }
        }
    }
    
    public void pasoDeDias() {
        contador++;
        //System.out.println(contador);
        if(contador%100 == 0){
            blendIntegrator.target(255);
        }
        if(contador%200 == 0){
            blendIntegrator.target(120);
        }
       
    }
    
    public void crearVuelos(){
        try {
            _planes = Conexion.mr_adicionales.obtener_planes();
            System.out.println(_planes.size());
            for(PlanVuelo pl : _planes){                
                Aeropuerto a = pl.getPartida();
                Location l = new Location(a.getLongitud(),a.getLatitud());
                SimplePointMarker spm = new SimplePointMarker(l);
                listSpm.add(spm);
                Avion avion = new Avion(PI, PI, 7, pl, spm);
                vuelos.add(avion);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(SimulationMap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearCiudades(){

        try {
            ArrayList<Aeropuerto> aeropuertos = Conexion.mr_adicionales.obtener_aeropuertos();
            System.out.println(aeropuertos.size());
            for(Aeropuerto a : aeropuertos){
                Location l = new Location(a.getLongitud(),a.getLatitud());
                SimplePointMarker spm = new SimplePointMarker(l);
                mapDay.addMarker(spm);
                mapNight.addMarker(spm);
                listSpm.add(spm);               
            }
        } catch (RemoteException ex) {
            Logger.getLogger(SimulationMap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void draw() {
        try{
            if(!seguir_sim) {
                if(!mensaje_mostrado){
                    JOptionPane.showMessageDialog(null, "Terminó la simulación","Fin Simulación",
                            JOptionPane.INFORMATION_MESSAGE);
                    mensaje_mostrado=true;
                }
                return;
            }
            blendIntegrator.update();       
            mapDay.draw();                
            tint(255, blendIntegrator.value);
            //mapNight.draw();                
            //pasoDeDias();
            blendIntegrator.target(255);
            //prueba();
            Location mouseLocation = mapDay.getLocationFromScreenPosition(mouseX,mouseY);
            text(mouseLocation.toString(),mouseX,mouseY);                                   

            if(refresh < 60){
                refresh++;

            }else if(refresh>=60 && refresh<80){
                mapDay.getMarkers().clear();
                mapNight.getMarkers().clear();
                if(refresh==70){
                    monitPaquetes.getDtmCiudad();
                }                    
                refresh++;
            }else{
                if(Conexion.mr_adicionales.termino_sistema()){
                    //System.out.println("se cae el sistema");
                    seguir_sim=false;
                    clases.Paquete paqFallo = Conexion.mr_adicionales.paquete_fallo();
                    //System.out.println("antes de hacer mensaje");
                    String mensaje = "El siguiente paquete falló: "+paqFallo.getId()+
                            "\nEn la fecha: "+paqFallo.getFechaRegistro()+
                            "\nEl sistema duró: "+Conexion.mr_adicionales.cantDias()+" días";
                    JOptionPane.showMessageDialog(null, mensaje,"Fin Simulación",
                            JOptionPane.ERROR_MESSAGE);   
                    //System.out.println("despues del dialog");
                } 
                //JOptionPane.showMessageDialog(null, "funciona plz"); 
                refresh=0;
                //System.out.println("antes de obtener planes");
                //ArrayList<PlanVuelo> planes = Conexion.mr_adicionales.obtener_planes();
                //System.out.println("despues de obtener planes");
                for(PlanVuelo pl : _planes){
                    Avion a = BuscarAvion(pl);
                    if(a==null)continue;
                    //else System.out.println("no es nulo");
                    //System.out.println("antes de obtener valor");
                    boolean valor = Conexion.mr_adicionales.contiene_plan(pl);
                    //System.out.println("despues de obtener valor");
                    if(!valor){
                        a._mostrar=false;
                        //System.out.println("falso");
                        //if(mapDay.getMarkers().contains(a._spm)) mapDay.getMarkers().remove(a._spm);
                        //if(mapNight.getMarkers().contains(a._spm)) mapNight.getMarkers().remove(a._spm);
                    }else{
                        a._mostrar=true;
                    }
                    if(a._mostrar){
                        float pX,pY;
                        pX=Conexion.mr_adicionales.posX(pl);
                        pY=Conexion.mr_adicionales.posY(pl);
                        float porc = (float)Conexion.mr_adicionales.porcLleno(pl);
                        //float porc = (float)0.80;
                        if(porc<=0.15){
                            a._spm.setColor(color(0,0,255));
                        }else if(porc>0.15 && porc<=0.35){
                            a._spm.setColor(color(0,255,0));
                        }else if(porc>0.35 && porc<=0.55){
                            a._spm.setColor(color(255,153,0));
                        }else{
                            a._spm.setColor(color(255,0,0));
                        }
                        
                        a._spm.setLocation(pX,pY);
                        mapDay.addMarker(a._spm);
                        mapNight.addMarker(a._spm);
                        fill(125,0,0);
                    }
//                    Location l = new Location(b._pl.getPartida().getLongitud(),b._pl.getPartida().getLatitud());
//                    ScreenPosition pos1 = mapDay.getScreenPosition(l);
//                    fill(125,0,0);
//                    ellipse(pos1.x,pos1.y,7,7);
//                        fill(125,0,0);
//                        b.draw();
                }
                
            }
        }catch(Exception e){
            return;
        }
                                                        
    }
    
    private Avion BuscarAvion(PlanVuelo pl){
        for(Avion a : vuelos){
            if((a._pl.getPartida().getId()==pl.getPartida().getId()&&
                    (a._pl.getDestino().getId()==pl.getDestino().getId())&&
                    a._pl.getHora_ini()==pl.getHora_ini()))return a;
            //if(a._pl.equals(pl)) return a;
        }
        return null;
    }    
    
    private void EliminarVuelo(PlanVuelo pL){
        for(Avion a : vuelos){
            if(pL.equals(a._pl)){
                vuelos.remove(a);
                break;
            }
        }
    }
    
 
class Avion {
    public float x, y, r;
    private PlanVuelo _pl;
    private SimplePointMarker _spm;
    public boolean _mostrar;
    
    Avion(float x_, float y_, float r_){
        x = x_;
        y = y_;
        r = r_;
    }
    
    Avion(float x_, float y_, float r_, PlanVuelo pl, SimplePointMarker spm){
        x = x_;
        y = y_;
        r = r_;
        _pl = pl;
        _spm = spm;
        //_mostrar = true;
    }    
    
}

}
