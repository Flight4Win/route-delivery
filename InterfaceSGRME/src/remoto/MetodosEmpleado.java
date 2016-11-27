/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import entidad.Empleado;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosEmpleado extends Remote{
    public void crear_emp(Empleado empleado) throws RemoteException;
    public List<Empleado> todos_emp() throws RemoteException;
    public int cantidad_emp () throws RemoteException;
    public void eliminar_emp(Integer idPersona) throws RemoteException;
    public List<Empleado> buscar_emp(int opcion, String filtro) throws RemoteException;
    public boolean existe_emp(String codigo) throws RemoteException;
    public void actualizar_emp(Empleado empleado) throws RemoteException;
}

