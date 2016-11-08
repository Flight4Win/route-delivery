/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgrme_dp1;

import de.fhpotsdam.unfolding.*;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.utils.*;
import de.fhpotsdam.unfolding.providers.*;
import processing.core.*;
import controlP5.*;
import de.fhpotsdam.utils.Integrator;
import de.looksgood.ani.*;
import java.util.List;
/**
 *
 * @author carlo
 */
public class SimulationMap extends PApplet{
    
    UnfoldingMap mapDay;
    UnfoldingMap mapNight;
    Integrator blendIntegrator = new Integrator(255);
    
    UnfoldingMap map;
    Location berlinLocation = new Location(52.5, 13.4);
    Location dublinLocation = new Location(53.35, -6.26);
    Location casa = new Location(-12.11493,-77.01182);
    
    int contador = 99;
    
    float x = (float) 52.5;
    float y = (float) 13.4;
    
    public void setup() {
        size(800, 600);        
        
        smooth();
        //noStroke();

        // you have to call always Ani.init() first!
        Ani.init(this);
        
        mapDay = new UnfoldingMap(this,new OpenStreetMap.OpenStreetMapProvider());
        mapNight = new UnfoldingMap(this, new OpenStreetMap.OpenStreetMapProvider());
        
        mapDay.setZoomRange(3, 3);
        mapDay.zoomTo(3);
        mapNight.setZoomRange(3, 3);
        mapNight.zoomTo(3);
        
        
        
        MapUtils.createDefaultEventDispatcher(this, mapDay, mapNight);
        
        SimplePointMarker berlinMark=new SimplePointMarker(berlinLocation);
        SimplePointMarker dublinMark=new SimplePointMarker(dublinLocation);
        
        crearCiudades();
        
        /*map = new UnfoldingMap(this, new OpenStreetMap.OpenStreetMapProvider());
        MapUtils.createDefaultEventDispatcher(this, map);
        map.setZoomRange(2, 2);
        map.zoomTo(2);
        

        SimpleLinesMarker connectionMarker = new SimpleLinesMarker(berlinLocation, dublinLocation);
        
        SimplePointMarker casaLocation=new SimplePointMarker(casa);
        
        
        connectionMarker.setColor(color(255, 0, 0, 100));
        connectionMarker.setStrokeColor(color(255, 0, 0));
        connectionMarker.setStrokeWeight(3);
        connectionMarker.setSelected(true);
        casaLocation.setColor(color(255, 0, 0, 100));
        casaLocation.setStrokeColor(color(255, 0, 0));
        casaLocation.setStrokeWeight(1);

	map.addMarkers(casaLocation,connectionMarker,berlinMark,dublinMark);*/
        
    }
    
    /*@Override
    public void mouseMoved() {
    Marker hitMarker = map.getFirstHitMarker(mouseX, mouseY);
    if (hitMarker != null) {
        // Select current marker 
        hitMarker.setSelected(true);
    } else {
        // Deselect all other markers
        for (Marker marker : map.getMarkers()) {
            marker.setSelected(false);
        }
    }
    }*/
    
    public void pasoDeDias() {
        contador++;
        System.out.println(contador);
        if(contador%100 == 0){
            blendIntegrator.target(255);
        }
        if(contador%200 == 0){
            blendIntegrator.target(120);
        }
       
}
    public void crearCiudades(){
        
        Location bogotaLocation = new Location(4.6983449, -74.1441489);
        Location quitoLocation = new Location(-0.121211, -78.3608112);
        
        
        SimplePointMarker bogotaMark=new SimplePointMarker(bogotaLocation);
        SimplePointMarker quitoMark=new SimplePointMarker(quitoLocation);
        
        
        mapDay.addMarkers(bogotaMark,quitoMark);
        mapNight.addMarkers(bogotaMark,quitoMark);
         

    }
    
    public void draw() {
        
        /*map.draw();
        fill(0);
        ellipse(x,y,30,30);*/
        
                blendIntegrator.update();		
		mapDay.draw();                
		tint(255, blendIntegrator.value);
                mapNight.draw();
                pasoDeDias();
                
    }
    
    public void mouseReleased() {
  // animate the variables x and y in 1.5 sec from mouse click position to the initial values
  Ani.from(this, (float) 1.5, "x", mouseX, Ani.QUINT_IN_OUT);
  Ani.from(this, (float) 1.5, "y", mouseY, Ani.QUINT_IN_OUT);
}
}
