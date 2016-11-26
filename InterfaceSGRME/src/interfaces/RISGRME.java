/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
import entidad_prueba.Persona;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author juani
 */
public interface RISGRME extends Remote{
    public ArrayList<Persona> buscar_persona(String codigo) throws  RemoteException;
    public ArrayList<Persona> mostrar() throws RemoteException;
    public boolean eliminar(String codigo) throws RemoteException;
    public boolean modificar(String codigo, String appaterno, String apmaterno, String nombres) throws  RemoteException;
    public boolean agregar(String codigo, String appaterno,String apmaterno,String nombres) throws RemoteException;
}
