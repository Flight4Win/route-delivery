/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import entidad.Lugar;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosLugar extends Remote{
    
    public Lugar leer_lug (Lugar lugar) throws RemoteException;
    public Lugar crear_lug(Lugar lugar) throws RemoteException;
    public List<Lugar> todos_lug() throws RemoteException;
    public int cantidad_lug () throws RemoteException;
    public List<Lugar> buscarPorCiudad_lug(String ciudad) throws RemoteException;
    public Lugar obtener_lugar_lug(int id) throws RemoteException;
}
