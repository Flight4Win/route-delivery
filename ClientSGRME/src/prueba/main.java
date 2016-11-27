/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import entidad_prueba.Persona;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juani
 */
public class main {
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        conexion.init();
        
        //registrar_personas();
        //buscar_persona();
        //todos();
        //modificar_personas();
        //eliminar_persona();
        
        
        
    }

    private static void registrar_personas() {
        System.out.println("EN REGISTRAR PERSONAS");
        for(int i = 0 ; i < 10 ; i++){
            try {
                conexion.interfaz.agregar("12345", "ferraro", "ticona", "juani");
            } catch (RemoteException ex) {
                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("FIN REGISTRAR PERSONAS");
    }

    private static void buscar_persona() {
        System.out.println("EN BUSCAR PERSONAS");
        try {
            ArrayList<Persona> personas = conexion.interfaz.buscar_persona("12345");
            for ( Persona p : personas){
                System.out.println("codigo :"+p.getCodigo());
            }
        } catch (RemoteException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("FIN BUSCAR PERSONAS");
    }

    private static void todos() {
        System.out.println("TODOS");
        ArrayList<Persona> personas = new ArrayList<>();
        try {
            personas = conexion.interfaz.mostrar();
        } catch (RemoteException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        for ( Persona p : personas){
            System.out.println("codigo :"+p.getCodigo());
        }       
        System.out.println("FIN TODOS");
    }

    private static void modificar_personas() {
        System.out.println("MODIFICAR");
        try {
            conexion.interfaz.modificar("12345", "ferrarox", "ticonax", "juanix");
        } catch (RemoteException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        buscar_persona();
        System.out.println("FIN MODIFICAR");
    }

    private static void eliminar_persona() {
        System.out.println("ELIMINAR");
        try {
            conexion.interfaz.eliminar("12345");
        } catch (RemoteException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
        buscar_persona();
        System.out.println("FIN ELIMINAR");
    }
    
}
