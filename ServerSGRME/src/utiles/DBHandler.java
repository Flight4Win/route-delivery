/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import entidad.Estado;
import entidad.Itinerario;
import entidad.ItinerarioPK;
import entidad.Paquete;
import entidad.Plandevuelo;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import manejadorDB.controlador.EstadoControlador;
import manejadorDB.controlador.ItinerarioControlador;
import manejadorDB.controlador.PaqueteControlador;
import manejadorDB.controlador.PlandevueloControlador;

/**
 *
 * @author juani
 */
public class DBHandler {
    
    public static boolean es_simu1 = true;
    
    
    
    public static void InsertarItinerarioTable(clases.Paquete p){
      
        EstadoControlador ec = new EstadoControlador();
        PaqueteControlador pc = new PaqueteControlador();
        PlandevueloControlador pdv = new PlandevueloControlador();
        ItinerarioControlador ic = new ItinerarioControlador();
        
        Paquete paquete = Factory.to_PaqueteEntity(p);
        
        Date fecha = paquete.getFechainicio();
        
       /*PAQUETE:
        actualizar tiempo estimado
        actualizar idestado*/
        paquete.setTiempoestimado(p.getDuracionViaje());
        Estado estado_transito = ec.devolverEstado(4); //retorna en transito.
        paquete.setIdestado(estado_transito);
        
        /*actualizar estado*/
        paquete = pc.actualizar(paquete);
        /*fin actualizar paquete*/
              

       ArrayList<clases.PlanVuelo> planes = p.getRutaOficial();
       
       for(clases.PlanVuelo plan : planes){
        /*PLANVUELO:
         actualizar nropaquetes++
         */
        
           Plandevuelo pland = Factory.to_PlanVueloEntity(plan,0);
           int num = pland.getNropaquetes();
           num = num ++;
           
           /*actualizar plan*/
           pland = pdv.actualizar(pland);
           /*fin actualizar plan*/
           
           
            /*ITINERARIO:
             idpaquete
             idplan
             fecha y hora actual
             nrocalculo=1
             estado*/                     
           ItinerarioPK ipk = new ItinerarioPK();
           ipk.setIdpaquete(paquete.getIdpaquete());
           ipk.setIdplan(pland.getIdplan());
           
           Itinerario itinerario = new Itinerario(ipk);           
           itinerario.setFecha(fecha);
           itinerario.setNrocalculo(1); /*primera vez que se ha calculado*/
           Estado est = ec.devolverEstado(1);
           itinerario.setIdestado(est);
           ic.crear(itinerario);
           
       }
       /*fin registrar itinerarios*/
    
    }
    
    
    
}
