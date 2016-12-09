/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import entidad.Aeropuerto;
import entidad.Lugar;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosAeropuerto extends Remote{
    
    public Aeropuerto crear_aero(Aeropuerto aeropuerto ) throws RemoteException;
    public List<Aeropuerto> todos_aero() throws RemoteException;
    public int cantidad_aero () throws RemoteException;
    public List<Aeropuerto> buscarByLugar_aero(Lugar filtro) throws RemoteException;
    public Aeropuerto obtener_Aeropuerto_aero(int id) throws RemoteException;
    public entidad.Aeropuerto to_Aeropuerto_Entity(clases.Aeropuerto a) throws RemoteException;
}
