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
import de.looksgood.ani.*;
import java.util.List;
/**
 *
 * @author carlo
 */
public class SimulationMap extends PApplet{
    UnfoldingMap map;
    Location berlinLocation = new Location(52.5, 13.4);
    Location dublinLocation = new Location(53.35, -6.26);
    Location casa = new Location(-12.11493,-77.01182);

    public void setup() {
        size(800, 600);        
        smooth();      
        map = new UnfoldingMap(this, new OpenStreetMap.OpenStreetMapProvider());
        MapUtils.createDefaultEventDispatcher(this, map);
        map.setZoomRange(2, 2);
        map.zoomTo(2);
        

        SimpleLinesMarker connectionMarker = new SimpleLinesMarker(berlinLocation, dublinLocation);
        
        SimplePointMarker casaLocation=new SimplePointMarker(casa);
        SimplePointMarker berlinMark=new SimplePointMarker(berlinLocation);
        SimplePointMarker dublinMark=new SimplePointMarker(dublinLocation);
        
        connectionMarker.setColor(color(255, 0, 0, 100));
        connectionMarker.setStrokeColor(color(255, 0, 0));
        connectionMarker.setStrokeWeight(3);
        connectionMarker.setSelected(true);
        casaLocation.setColor(color(255, 0, 0, 100));
        casaLocation.setStrokeColor(color(255, 0, 0));
        casaLocation.setStrokeWeight(1);

	map.addMarkers(casaLocation,connectionMarker,berlinMark,dublinMark);
        
    }
    
    @Override
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
}
    public void draw() {
        
        map.draw();
        
    }
}
