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
import remoto.MetodosAdicionales;
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
    public static MetodosAdicionales mr_adicionales = null;
    
    

    
    
    
    public static void init(String ip, String port){
        
        int port_n = Integer.parseInt(port);
        String structure = ip+":"+port;
       
       try{
            registro = LocateRegistry.getRegistry(ip,port_n);
            
            mr_aeropuerto = (MetodosAeropuerto) registro.lookup("sgrme");
            mr_avion = (MetodosAvion) registro.lookup("sgrme"); 
            mr_cargo = (MetodosCargo) registro.lookup("sgrme"); 
            mr_cliente = (MetodosCliente) registro.lookup("sgrme"); 
            mr_empleado = (MetodosEmpleado) registro.lookup("sgrme"); 
            mr_estado = (MetodosEstado) registro.lookup("sgrme"); 
            mr_lugar = (MetodosLugar) registro.lookup("sgrme"); 
            mr_paquete = (MetodosPaquete) registro.lookup("sgrme"); 
            mr_perfil = (MetodosPerfil) registro.lookup("sgrme"); 
            mr_persona = (MetodosPersona) registro.lookup("sgrme"); 
            mr_plandevuelo = (MetodosPlandevuelo) registro.lookup("sgrme"); 
            mr_usuario = (MetodosUsuario) registro.lookup("sgrme"); 
            mr_vuelo = (MetodosVuelo) registro.lookup("sgrme"); 
            mr_adicionales = (MetodosAdicionales) registro.lookup("sgrme"); 
       }catch(RemoteException e){
           e.printStackTrace();
       } catch (NotBoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
