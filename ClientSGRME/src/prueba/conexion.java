/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import interfaces.RISGRME;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juani
 */
public class conexion {
    
    public static Registry registro = null;
    public static RISGRME interfaz = null;
    
    public static void init(){
       
       try{
            registro = LocateRegistry.getRegistry("127.0.0.1",1099);
            interfaz = (RISGRME) registro.lookup("rmi://localhost:1099/InterfaceSGRME");          
       }catch(RemoteException e){
           e.printStackTrace();
       } catch (NotBoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }
    
    
    
}
