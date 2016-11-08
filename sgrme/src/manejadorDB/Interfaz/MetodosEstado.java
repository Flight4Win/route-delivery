/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Estado;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosEstado {
    public void crear(Estado estado);
    public List<Estado> todos();
    public int cantidad ();
}
