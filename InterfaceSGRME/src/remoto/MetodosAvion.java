/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import entidad.Avion;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosAvion extends Remote{
    public void crear_avio(Avion avion ) throws RemoteException;
    public List<Avion> todos_avio() throws RemoteException;
    public int cantidad_avio () throws RemoteException;
}
