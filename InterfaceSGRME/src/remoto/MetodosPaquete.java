/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import entidad.Paquete;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosPaquete extends Remote{
    public Paquete crear(Paquete paquete) throws RemoteException;
    public List<Paquete> todos() throws RemoteException;
    public int cantidad () throws RemoteException;
    public boolean existe(String Codigo) throws RemoteException;
    public List<Paquete> buscarPorCliente(int idCliente) throws RemoteException;
    public List<Paquete> buscarPorCodigo(String codigo) throws RemoteException;
    public List<Paquete> buscarPorDescripcion(String codigo) throws RemoteException;
    public List<Paquete> buscarPorFechaRegistro(Date fecha) throws RemoteException;
    public List<Paquete> buscarPorFechaLlegada(Date fecha) throws RemoteException;
    public List<Paquete> buscarPorFechasRegistro(Date fechaInicio, Date fechaFin) throws RemoteException;
    public List<Paquete> buscarPorCiudadOrigen(int idCiudadOrigen) throws RemoteException;
    public List<Paquete> buscarPorCiudadDestino(int idCiudadDestino) throws RemoteException;
    public Paquete obtener_paquete(int id) throws RemoteException;

}
