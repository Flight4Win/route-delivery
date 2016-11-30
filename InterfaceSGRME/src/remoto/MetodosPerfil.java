/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import entidad.Perfil;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosPerfil extends Remote{
    public void crear_perf(Perfil perfil ) throws RemoteException;
    public List<Perfil> todos_perf() throws RemoteException;
    public int cantidad_perf () throws RemoteException;
    public Perfil devolverPerfilPorID_perf(Integer idPerfil) throws RemoteException;
    public Perfil devolverPerfilPorNivelAcceso_perf(Integer nivelAcceso) throws RemoteException;
}
