/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import entidad.Plandevuelo;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosPlandevuelo extends Remote{
    public Plandevuelo crear_plan(Plandevuelo plandeVuelo) throws RemoteException;
    public List<Plandevuelo> todos_plan() throws RemoteException;
    public int cantidad_plan () throws RemoteException;
    public Plandevuelo obtener_plan_plan(int id) throws RemoteException;
}
