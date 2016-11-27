/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import entidad.Estado;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosEstado extends Remote{
    public void crear_est(Estado estado) throws RemoteException;
    public List<Estado> todos_est() throws RemoteException;
    public int cantidad_est () throws RemoteException;
    public Estado devolverEstado_est(Integer idEstado) throws RemoteException;
}
