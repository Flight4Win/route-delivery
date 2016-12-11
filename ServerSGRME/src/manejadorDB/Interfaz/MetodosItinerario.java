/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Itinerario;
import entidad.Paquete;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosItinerario {
    public Itinerario crear(Itinerario itinerario);
    public List<Itinerario> buscarporpaquete(Paquete paquete);
    
}
