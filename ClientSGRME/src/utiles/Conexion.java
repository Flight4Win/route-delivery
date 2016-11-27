/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import prueba_prueba.conexion;
import remoto.MetodosAeropuerto;
import remoto.MetodosAvion;
import remoto.MetodosCargo;
import remoto.MetodosCliente;
import remoto.MetodosEmpleado;
import remoto.MetodosEstado;
import remoto.MetodosLugar;
import remoto.MetodosPaquete;
import remoto.MetodosPerfil;
import remoto.MetodosPersona;
import remoto.MetodosPlandevuelo;
import remoto.MetodosUsuario;
import remoto.MetodosVuelo;

/**
 *
 * @author juani
 */
public class Conexion {
    public static Registry registro = null;
    public static MetodosAeropuerto mr_aeropuerto = null;
    public static MetodosAvion mr_avion = null;
    public static MetodosCargo mr_cargo = null;
    public static MetodosCliente mr_cliente = null;
    public static MetodosEmpleado mr_empleado = null;
    public static MetodosEstado mr_estado = null;
    public static MetodosLugar mr_lugar = null;
    public static MetodosPaquete mr_paquete = null;
    public static MetodosPerfil mr_perfil = null;
    public static MetodosPersona mr_persona = null;
    public static MetodosPlandevuelo mr_plandevuelo = null;
    public static MetodosUsuario mr_usuario = null;
    public static MetodosVuelo mr_vuelo = null;

    
    
    
    public static void init(){
       
       try{
            registro = LocateRegistry.getRegistry("127.0.0.1",1099);
            
            mr_aeropuerto = (MetodosAeropuerto) registro.lookup("rmi://localhost:1099/InterfaceSGRME");
            mr_avion = (MetodosAvion) registro.lookup("rmi://localhost:1099/InterfaceSGRME"); 
            mr_cargo = (MetodosCargo) registro.lookup("rmi://localhost:1099/InterfaceSGRME"); 
            mr_cliente = (MetodosCliente) registro.lookup("rmi://localhost:1099/InterfaceSGRME"); 
            mr_empleado = (MetodosEmpleado) registro.lookup("rmi://localhost:1099/InterfaceSGRME"); 
            mr_estado = (MetodosEstado) registro.lookup("rmi://localhost:1099/InterfaceSGRME"); 
            mr_lugar = (MetodosLugar) registro.lookup("rmi://localhost:1099/InterfaceSGRME"); 
            mr_paquete = (MetodosPaquete) registro.lookup("rmi://localhost:1099/InterfaceSGRME"); 
            mr_perfil = (MetodosPerfil) registro.lookup("rmi://localhost:1099/InterfaceSGRME"); 
            mr_persona = (MetodosPersona) registro.lookup("rmi://localhost:1099/InterfaceSGRME"); 
            mr_plandevuelo = (MetodosPlandevuelo) registro.lookup("rmi://localhost:1099/InterfaceSGRME"); 
            mr_usuario = (MetodosUsuario) registro.lookup("rmi://localhost:1099/InterfaceSGRME"); 
            mr_vuelo = (MetodosVuelo) registro.lookup("rmi://localhost:1099/InterfaceSGRME"); 
            
       }catch(RemoteException e){
           e.printStackTrace();
       } catch (NotBoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
