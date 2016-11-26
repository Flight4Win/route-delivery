/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import entidad.Persona;
import interfaces.RISGRME;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import controller.Controlador;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author juani
 */

public class ServerRMI  extends UnicastRemoteObject implements RISGRME{
    
    public ServerRMI() throws RemoteException{
        super();
    }

    @Override
    public ArrayList<Persona> buscar_persona(String codigo) throws RemoteException {
        
       ArrayList<Persona> p_encontradas = new ArrayList<Persona>();
       for(Persona persona: Controlador.personas){
           if(persona.getCodigo().equalsIgnoreCase(codigo)){
               p_encontradas.add(persona);
           }
       }
       return p_encontradas;     
    }

    @Override
    public ArrayList<Persona> mostrar() throws RemoteException {
        return Controlador.personas;
    }

    @Override
    public boolean eliminar(String codigo) throws RemoteException {
        boolean eliminado = false;
        int c = -1 ; 
        for(int i = 0 ; i< Controlador.personas.size();i++){
            if(Controlador.personas.get(i).getCodigo().equalsIgnoreCase(codigo)){
                c = i;
                eliminado = true;
                break;
            }
        }
        
        if(c!=-1){
            Controlador.personas.remove(c);
        }
        return eliminado;


    }

    @Override
    public boolean modificar(String codigo, String appaterno, String apmaterno, String nombres) throws RemoteException {
        boolean modificado = false;
        ArrayList<Persona> p_resultado = buscar_persona(codigo);
        if(!p_resultado.isEmpty()){
            for (Persona p : p_resultado){
                p.setNombres(nombres);
                p.setAppaterno(appaterno);
                p.setApmaterno(apmaterno);
            }
            modificado=true;
        }
        return modificado;
        
    }

    @Override
    public boolean agregar(String codigo, String appaterno, String apmaterno, String nombres) throws RemoteException {
        boolean agregado = false;
        Persona p = new Persona(codigo,appaterno,apmaterno,nombres);
        Controlador.personas.add(p);
        agregado = true;
        return agregado;
    }
    
    public static void main(String args[]){
        try{
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("rmi://localhost:1099/InterfaceSGRME", new ServerRMI());
            System.out.println("Servidor creado y escuchando puerto 1099....");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    
}
