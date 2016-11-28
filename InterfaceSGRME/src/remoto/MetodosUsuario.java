/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import entidad.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author juani
 */
public interface MetodosUsuario extends Remote{
    public Usuario crear_usu(Usuario usuario) throws RemoteException;
    public Usuario logueo_usu(String usuario,String pass) throws RemoteException;
    public Usuario cambioContrasenha_usu(Usuario user) throws RemoteException;
    public void eliminar_usu(Usuario usuario) throws RemoteException;
    
}
