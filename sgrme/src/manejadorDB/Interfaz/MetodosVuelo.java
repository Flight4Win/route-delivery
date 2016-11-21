/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Vuelo;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosVuelo {
    public void crear(Vuelo vuelo);
    public List<Vuelo> todos();
    public int cantidad ();
    
}
