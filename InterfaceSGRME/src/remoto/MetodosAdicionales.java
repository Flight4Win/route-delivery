/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remoto;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author juani
 */
public interface MetodosAdicionales extends Remote{
    
    public String generarCodigo(int opcion) throws RemoteException;
    
}
