/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
public class ColeccionPlanVuelo {
    private ArrayList<PlanVuelo> _planVuelos;
    
    /**
     * @return the _planVuelos
     */
    public ArrayList<PlanVuelo> getPlanVuelos() {
        return _planVuelos;
    }
    
    public ColeccionPlanVuelo(){
        _planVuelos = new ArrayList<>();
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
    
    public void imprimir(){
        for(PlanVuelo plan : _planVuelos){
            plan.imprimir();
        }
    }
}
