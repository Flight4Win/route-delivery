/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Aeropuerto;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosAeropuerto {
    public void crear(Aeropuerto aeropuerto );
    public List<Aeropuerto> todos();
    public int cantidad ();
}
