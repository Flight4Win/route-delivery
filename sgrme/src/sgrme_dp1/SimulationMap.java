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
    
    PImage mapImage = null;
    UnfoldingMap mapDay;
    UnfoldingMap mapNight;
    Integrator blendIntegrator = new Integrator(255);
    
    UnfoldingMap map;
    Location berlinLocation = new Location(52.5, 13.4);
    Location dublinLocation = new Location(53.35, -6.26);
    Location casa = new Location(-12.11493,-77.01182);
    
    int contador = 99;
    
    //float x = (float) 52.5;
    //float y = (float) 13.4;
    
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
        
        Location bogotaLocation = new Location(4.6983449, -74.1441489);
        Location quitoLocation = new Location(-0.121211, -78.3608112);
        Location caracasLocation = new Location(10.5977114, -67.0080677);
        Location brasiliaLocation = new Location(-23.434548, -46.4803147);
        Location limaLocation = new Location(-12.0240527,-77.1142247);
         
        SimplePointMarker bogotaMark=new SimplePointMarker(bogotaLocation);
        SimplePointMarker quitoMark=new SimplePointMarker(quitoLocation);
        SimplePointMarker caracasMark=new SimplePointMarker(caracasLocation);
        SimplePointMarker brasiliaMark=new SimplePointMarker(brasiliaLocation);
        SimplePointMarker limaMark=new SimplePointMarker(limaLocation);
        SimpleLinesMarker connectionMarker = new SimpleLinesMarker(brasiliaLocation, caracasLocation);
        
        mapDay.addMarkers(bogotaMark,quitoMark,caracasMark,brasiliaMark,connectionMarker,limaMark);
        mapNight.addMarkers(bogotaMark,quitoMark,caracasMark,brasiliaMark,connectionMarker,limaMark);
        
        //System.out.println(caracasMark.getScreenPosition(mapDay));
    }
    
    public void draw() {
        /*
        if (mapDay.allTilesLoaded()) {
			if (mapImage == null) {
				mapImage = mapDay.mapDisplay.getInnerPG().get();
			}
			image(mapImage, 0, 0);
		} else {
			mapDay.draw();
		}
        */
        
        
        
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
                
    }
    
    public void prueba(){
        //System.out.println(caracasMark.getScreenPosition(mapDay));
        Location caracasLocation = new Location(10.5977114, -67.0080677);
        Location brasiliaLocation = new Location(-23.434548, -46.4803147);
        
        SimplePointMarker caracasMark=new SimplePointMarker(caracasLocation);
        SimplePointMarker brasiliaMark=new SimplePointMarker(brasiliaLocation);
        SimpleLinesMarker connectionMarker = new SimpleLinesMarker(brasiliaLocation, caracasLocation);
        double distance = caracasMark.getDistanceTo(brasiliaLocation);
        
        ScreenPosition sp = caracasMark.getScreenPosition(mapDay);
        float x = sp.x;
        float y = sp.y;
        
        ScreenPosition spD = brasiliaMark.getScreenPosition(mapDay);
        float xD = spD.x;
        float yD = spD.y;
        System.out.println(x + "-" + y);
        System.out.println(xD + "-" + yD);
        Ani.from(caracasMark, (float) 1.5, "x", xD, Ani.LINEAR);
        Ani.from(caracasMark, (float) 1.5, "y", yD, Ani.LINEAR);
        
        ellipse(x,y,45,45);
    }
    

}
