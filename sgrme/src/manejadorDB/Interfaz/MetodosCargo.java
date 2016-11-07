/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Cargo;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosCargo {
    public void crear(Cargo cargo);
    public List<Cargo> todos();
    public int cantidad ();
}
