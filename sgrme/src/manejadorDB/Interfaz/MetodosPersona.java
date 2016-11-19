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
    
    public Persona crear(Persona persona);
    public List<Persona> todos();
    public int cantidad ();
    public void eliminar(Integer idPersona);
    public void modificar(Persona persona);
    public Persona obtener_Persona(int id);
    
}
