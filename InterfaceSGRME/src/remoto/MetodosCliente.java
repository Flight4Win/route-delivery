/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import entidad.Cliente;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosCliente extends Remote{
    public void crear_client(Cliente cliente) throws RemoteException;
    public List<Cliente> todos_client() throws RemoteException;
    public int cantidad_client () throws RemoteException;
    public void eliminar_client(Cliente cliente) throws RemoteException;
    public List<Cliente> buscar_client(int opcion, String filtro) throws RemoteException;
    public List<Cliente> buscarByFecha_client(Date fechaReg) throws RemoteException;
    public List<Cliente> buscarPorId_client(int idCliente) throws RemoteException;
    public boolean existe_client(String codigo) throws RemoteException;
    public Cliente obtener_cliente_client(int id) throws RemoteException;
    public void actualizar_client(Cliente cliente) throws RemoteException;
}
