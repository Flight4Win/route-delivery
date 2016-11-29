/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Aeropuerto;
import entidad.Lugar;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosAeropuerto {
    public Aeropuerto crear(Aeropuerto aeropuerto );
    public List<Aeropuerto> todos();
    public int cantidad ();
    public List<Aeropuerto> buscarByLugar(Lugar filtro);
    public Aeropuerto obtener_Aeropuerto(int id);
    
    
}
