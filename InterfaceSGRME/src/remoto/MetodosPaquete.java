/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import entidad.Cliente;
import entidad.Estado;
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
    public List<Paquete> reportePorRangoFechas(Date fechaInicio, Date fechaFin) throws RemoteException;
    public List<Paquete> reportePorEstado(Estado idEstado) throws RemoteException;
    public List<Paquete> reportePorCliente(Cliente idCliente) throws RemoteException;
    public List<Paquete> reporteClienteEstado(Cliente idCliente, Estado idEstado) throws RemoteException;
    public List<Paquete> reporteClienteFecha(Cliente idCliente, Date fechaInicio, Date fechaFin) throws RemoteException;
    public List<Paquete> reporteEstadoFecha(Estado idEstado, Date fechaInicio, Date fechaFin) throws RemoteException;
    public List<Paquete> reporteClienteEstadoFecha(Cliente idCliente, Estado idEstado, Date fechaInicio, Date fechaFin) throws RemoteException;
    public void actualizarFechaFin(Date fecha, String codigo) throws RemoteException;
    public void actualizarEstado(Paquete paquete) throws RemoteException;
}
