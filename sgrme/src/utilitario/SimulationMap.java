/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;

import clases.Aeropuerto;
import clases.Controlador;
import de.fhpotsdam.unfolding.*;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.utils.*;
import de.fhpotsdam.unfolding.providers.*;
import processing.core.*;
import controlP5.*;
import de.fhpotsdam.unfolding.marker.MarkerManager;
import de.fhpotsdam.utils.Integrator;
import de.looksgood.ani.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


import processing.event.MouseEvent;
/**
 *
 * @author carlo
 */
public class SimulationMap extends PApplet{
    
    Timer tempo = new Timer();             
    int num = 20;
    ArrayList<Avion> balls= new ArrayList<>();
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
        //noStroke();

        for(int i = 0; i < num; i++) {

            balls.add(new Avion((int)random(40, 560), (int)(random(0, 900)), 7));
        }
        
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
        
        crearCiudades();
        tempo.schedule(new TimerTaskSimulacion(), 0,200);

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

        ArrayList<SimplePointMarker> listSpm = new ArrayList<>();
        for(Aeropuerto a : Controlador.getAeropuertos().getAeropuertos()){
            Location l = new Location(a.getLongitud(),a.getLatitud());
            SimplePointMarker spm = new SimplePointMarker(l);
            mapDay.addMarker(spm);
            mapNight.addMarker(spm);
            //listSpm.add(spm);
        }               
    }
    
    @Override
    public void draw() {
                blendIntegrator.update();		
		mapDay.draw();                
		tint(255, blendIntegrator.value);
                //mapNight.draw();                
                pasoDeDias();
                //prueba();
                Location mouseLocation = mapDay.getLocationFromScreenPosition(mouseX,mouseY);
                text(mouseLocation.toString(),mouseX,mouseY);
                
                Location bogotaLocation = new Location(4.6983449, -74.1441489);
                ScreenPosition pos1 = mapDay.getScreenPosition(bogotaLocation);
                fill(255, 0, 0);
                ellipse(pos1.x, pos1.y, 6, 6);
                //move((int) pos1.x,10);
                //System.out.println();
                //fill(0);
                for(Avion b : balls){
                    fill(125,0,0);
                    b.draw();
                }                
                
    }
     


//    public void mouseWheel(MouseEvent event) {
//        float e = event.getAmount();
//        //println(e);
//        for(int i = 0; i < num; i++) {
//          int dist = (int) (random(1, 20) * e);
//          balls[i].update(dist);
//        }
//    }
 
class Avion {
    public int x, y, r;
    
    
    Avion (int x_, int y_, int r_){
        x = x_;
        y = y_;
        r = r_;

    }
    
    void draw() {
        ellipse(x, y, r, r);
    } 
    
    void update(int d) {
        Ani.to(this, (float) 1.5, "y", y+d);
        Ani.to(this, (float) 1.5, "x", x+d);
    }
    
}
class TimerTaskSimulacion extends TimerTask{
        
    @Override
    public void run(){
        for(Avion b:balls){
            b.update(1);
        }
        
    }

}

}
