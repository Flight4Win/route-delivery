/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.Interfaz;

import java.util.List;
import entidad.Persona;

/**
 *
 * @author juani
 */

/*Interfaces para el acceso a la bd.
 *Cualquier nueva funcionalidad debe ser agregado a las interfaces.*/
public interface MetodosPersona {
    
    public void crear(Persona persona);
    public List<Persona> todos();
    public int cantidad ();
    
}
