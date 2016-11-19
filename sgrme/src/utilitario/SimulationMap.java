/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;

import clases.Aeropuerto;
import clases.Controlador;
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
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author carlo
 */

public class SimulationMap extends PApplet {
    Timer tempo = new Timer();           
    
    ArrayList<Avion> vuelos= new ArrayList<>();


    PImage mapImage = null;
    UnfoldingMap mapDay;
    UnfoldingMap mapNight;
    Integrator blendIntegrator = new Integrator(255);
    UnfoldingMap map;
    Location berlinLocation = new Location(52.5, 13.4);
    Location dublinLocation = new Location(53.35, -6.26);
    Location casa = new Location(-12.11493,-77.01182);

    
    int contador = 99;
    
    
    @Override
    public void setup() {
        size(800, 600);        
        
        smooth();

        
        for(PlanVuelo pl : Controlador.getPlanVuelos().getPlanVuelos()){
            //Location l = new Location(pl.getPartida().getLongitud(),pl.getPartida().getLatitud());
            //ScreenPosition pos1 = mapDay.getScreenPosition(l);
            Avion vuelo = new Avion(pl.getPartida().getLongitud(),pl.getPartida().getLatitud(), (float)25.0,pl);
            //Avion vuelo = new Avion((int)random(40, 560), (int)(random(0, 550)),7,pl);
//            fill(125,0,0);
//            ellipse(pos1.x,pos1.y,7,7);
            vuelos.add(vuelo);

        }
        System.out.println(vuelos.size());
        //noStroke();
//
//        for(int i = 0; i < num; i++) {
//            vuelos.add(new Avion((int)random(40, 560), (int)(random(0, 900)), 7));
//        }
        
        // you have to call always Ani.init() first!
        Ani.init(this);
        Ani.autostart();
        Ani.overwrite();
        //frameRate(10);
        Ani.setDefaultEasing(Ani.EXPO_OUT);
        //Ani.setDefaultTimeMode(Ani.FRAMES);               
        
        mapDay = new UnfoldingMap(this,new OpenStreetMap.OpenStreetMapProvider());
        mapNight = new UnfoldingMap(this, new OpenStreetMap.OpenStreetMapProvider());
        
        //mapDay.setZoomRange(3, 3);
        mapDay.zoomTo(3);
        //mapNight.setZoomRange(3, 3);
        mapNight.zoomTo(3);
        mapDay.zoomAndPanTo(new Location(6.9f, -33.7f), 6);
        
        MapUtils.createDefaultEventDispatcher(this, mapDay, mapNight);
        
//        SimplePointMarker berlinMark=new SimplePointMarker(berlinLocation);
//        SimplePointMarker dublinMark=new SimplePointMarker(dublinLocation);
        
        crearCiudades();
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
    public void crearCiudades(){

        for(Aeropuerto a : Controlador.getAeropuertos().getAeropuertos()){
            Location l = new Location(a.getLongitud(),a.getLatitud());
            SimplePointMarker spm = new SimplePointMarker(l);
            mapDay.addMarker(spm);
            mapNight.addMarker(spm);
            //listSpm.add(spm);
        }               
    }
    
    public void draw() {
                blendIntegrator.update();		
		mapDay.draw();                
		tint(255, blendIntegrator.value);
                //mapNight.draw();                
                //pasoDeDias();
                blendIntegrator.target(255);
                //prueba();
                Location mouseLocation = mapDay.getLocationFromScreenPosition(mouseX,mouseY);
                text(mouseLocation.toString(),mouseX,mouseY);
                
//                System.out.println(Controlador.getPlanVuelos().getEnVuelo().size());
//                for(PlanVuelo pl : Controlador.getPlanVuelos().getEnVuelo()){
//                    Avion vuelo = BuscarAvion(pl);
//                    if(vuelo!=null){
//                        //vuelo.update(pl.getDistanciaX()/5, pl.getPosicionY()/5);
//                        fill(125,0,0);
//                        //vuelo.draw();
//                        vuelo.update(1, 1);
//                    }else{
//                        vuelo = new Avion(pl.getPartida().getLongitud(),
//                                pl.getPartida().getLatitud() , 
//                                (float)25.0,
//                                pl);
//                        vuelos.add(vuelo);
//                        //fill
//                        fill(125,0,0);
//                        vuelo.draw();
//                    }
//                }
//                Location bogotaLocation = new Location(4.6983449, -74.1441489);
//                 ScreenPosition pos1 = mapDay.getScreenPosition(bogotaLocation);
//                 fill(255, 0, 0);
//                 ellipse(pos1.x, pos1.y, 6, 6);
//                vuelos.get(0).x = pos1.x;
//                vuelos.get(0).y=pos1.y;
                
                for(Avion b : vuelos){
//                    Location l = new Location(b._pl.getPartida().getLongitud(),b._pl.getPartida().getLatitud());
//                    ScreenPosition pos1 = mapDay.getScreenPosition(l);
//                    fill(125,0,0);
//                    ellipse(pos1.x,pos1.y,7,7);
                    fill(125,0,0);
                    b.draw();
                }                
                
    }
    
    private Avion BuscarAvion(PlanVuelo pl){
        for(Avion a : vuelos){
            if(a._pl.equals(pl)) return a;
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
    public boolean _mostrar;
    
    Avion(float x_, float y_, float r_){
        x = x_;
        y = y_;
        r = r_;
    }
    
    Avion(float x_, float y_, float r_, PlanVuelo pl){
        x = x_;
        y = y_;
        r = r_;
        _pl = pl;
        _mostrar = true;
    }
    
    void draw() {      
        
        ellipse(x, y, r, r);        
    } 
    
    void update(float dX, float dY) {
        Ani.to(this, (float) 1.5, "y", dY);
        Ani.to(this, (float) 1.5, "x", dX);
        
    }
    
}
class TimerTaskSimulacion extends TimerTask{
        
    @Override
    public void run(){
        for(Avion b:vuelos){
            System.out.println("asdfasdf");
            b.update(1,1);
        }
        
    }

}

}
