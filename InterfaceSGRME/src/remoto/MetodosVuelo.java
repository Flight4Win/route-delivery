/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import entidad.Vuelo;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosVuelo extends Remote{
    public void crear_vue(Vuelo vuelo) throws RemoteException;
    public List<Vuelo> todos_vue() throws RemoteException;
    public int cantidad_vue () throws RemoteException;
    
}
