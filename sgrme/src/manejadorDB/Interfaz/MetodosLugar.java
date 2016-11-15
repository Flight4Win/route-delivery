/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Lugar;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosLugar {
    public void crear(Lugar lugar );
    public List<Lugar> todos();
    public int cantidad ();
}
