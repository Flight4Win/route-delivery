/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Temporizador.VueloListener;
import clases.Aeropuerto;
import java.util.ArrayList;

import clases.PlanVuelo;
import java.util.HashMap;

/**
 *
 * @author Diego
 */

/*Clase que representa todos los planes de vuelo, no es lo
    mismo que el itinerario, ya que no tiene la fecha
*/
public class ColeccionPlanVuelo implements VueloListener{
    private ArrayList<PlanVuelo> _planVuelos;
    private ArrayList<PlanVuelo> _enVuelo;

    /**
     * @return the _enVuelo
     */
    public ArrayList<PlanVuelo> getEnVuelo() {
        return _enVuelo;
    }
    
    /**
     * @return the _planVuelos
     */
    public ArrayList<PlanVuelo> getPlanVuelos() {
        return _planVuelos;
    }
    
    public ColeccionPlanVuelo(){
        _planVuelos = new ArrayList<>();
        _enVuelo = new ArrayList<>();
    }

    public void Add(PlanVuelo planVuelo){
        _planVuelos.add(planVuelo);
    }
    
    public HashMap<Integer,Integer> buscarHoras(Aeropuerto inicio, Aeropuerto fin){
        HashMap<Integer,Integer> duracion = new HashMap<>();
        
        for(PlanVuelo plan : _planVuelos){
            if(plan.getDestino()==fin && plan.getPartida()==inicio){
                duracion.put(plan.getHora_ini(),plan.getHora_fin());
                break;
            }
        }
        
        return duracion;
    }
    
    public void ResetearColeccion(){
        _enVuelo.clear();
        for(PlanVuelo pV : _planVuelos){
            pV.setCapacidadOcupada(0);
            pV.getPaquetes().clear();
            pV.getPaquetesDespegados().clear();
            pV.setPosicionX(pV.getPartida().getLongitud());
            pV.setPosicionY(pV.getPartida().getLatitud());
        }
    }
    
    public void imprimir(){
        for(PlanVuelo plan : _planVuelos){
            plan.imprimir();
        }
    }
    
    @Override
    public void DespegoAvion(PlanVuelo pL){
        _enVuelo.add(pL);
        //System.out.println("despego avion");
    }
        
    @Override
    public void AterrizajeAvion(PlanVuelo pL){
        System.out.println(_enVuelo.size());
        _enVuelo.remove(pL);
        //System.out.println("aterrizo avion");
        System.out.println(_enVuelo.size());
    }
}
