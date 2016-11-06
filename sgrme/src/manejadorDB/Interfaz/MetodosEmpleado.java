/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import entidad.Empleado;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosEmpleado {
    public void crear(Empleado empleado);
    public List<Empleado> todos();
    public int cantidad ();
}
