/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */

/*Clase que representa todos los planes de vuelo, no es lo
    mismo que el itinerario, ya que no tiene la fecha de salida
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
}
