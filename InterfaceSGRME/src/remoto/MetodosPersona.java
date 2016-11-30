/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import java.util.List;
import entidad.Persona;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author juani
 */

/*Interfaces para el acceso a la bd.
 *Cualquier nueva funcionalidad debe ser agregado a las interfaces.*/
public interface MetodosPersona extends Remote{
    
    public Persona crear_per(Persona persona) throws RemoteException;
    public List<Persona> todos_per() throws RemoteException;
    public int cantidad_per () throws RemoteException;
    public void eliminar_per(Persona persona) throws RemoteException;
    public void modificar_per(Persona persona) throws RemoteException;
    public List<Persona>  buscarPorId_per(int idPersona) throws RemoteException;
    public Persona obtener_Persona_per(int id) throws RemoteException;   
    public boolean existeDocumento(String documento) throws RemoteException;   
}

