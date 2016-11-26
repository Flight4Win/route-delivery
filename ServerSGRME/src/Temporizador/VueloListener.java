/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temporizador;

import clases.PlanVuelo;

/**
 *
 * @author Diego
 */
public interface VueloListener {
    void DespegoAvion(PlanVuelo pL);
    void AterrizajeAvion(PlanVuelo pL);
}
