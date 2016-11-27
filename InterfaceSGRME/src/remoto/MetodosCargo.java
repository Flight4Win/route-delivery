/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import entidad.Cargo;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosCargo extends Remote{
    public void crear_carg(Cargo cargo) throws RemoteException;
    public List<Cargo> todos_carg() throws RemoteException;
    public int cantidad_carg () throws RemoteException;
    public Cargo devolverCargo_carg(Integer idCodigo) throws RemoteException;
}
