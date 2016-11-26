/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Avion;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosAvion {
    public void crear(Avion avion );
    public List<Avion> todos();
    public int cantidad ();
}
