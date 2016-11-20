/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB;


import entidad.Aeropuerto;
import entidad.Almacenavion;
import entidad.Avion;
import entidad.Cargo;
import entidad.Cliente;
import entidad.Empleado;
import entidad.Estado;
import entidad.Itinerario;
import entidad.ItinerarioPK;
import entidad.Lugar;
import entidad.Movimientoalmacen;
import entidad.Movimientoavion;
import entidad.Paquete;
import entidad.Perfil;
import entidad.Persona;
import entidad.Plandevuelo;
import entidad.Usuario;
import entidad.Vuelo;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author juani
 */
public class Sesion {
    
    private static SessionFactory factory = null;
    
    public static SessionFactory init(){
        if(factory ==null){
            try{
                factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Persona.class)
                                .addAnnotatedClass(Aeropuerto.class)                
                                .addAnnotatedClass(Paquete.class)
                                .addAnnotatedClass(Avion.class)
                                .addAnnotatedClass(Cargo.class)
                                .addAnnotatedClass(Cliente.class)
                                .addAnnotatedClass(Empleado.class)
                                .addAnnotatedClass(Estado.class)
                                .addAnnotatedClass(Itinerario.class)
                                .addAnnotatedClass(ItinerarioPK.class)
                                .addAnnotatedClass(Lugar.class)
                                .addAnnotatedClass(Movimientoalmacen.class) 
                                .addAnnotatedClass(Movimientoavion.class) 
                                .addAnnotatedClass(Almacenavion.class) 
                                .addAnnotatedClass(Plandevuelo.class)  
                                .addAnnotatedClass(Usuario.class)      
                                .addAnnotatedClass(Vuelo.class)
                                .addAnnotatedClass(Perfil.class)
                                .buildSessionFactory();
            }catch(Exception e){
                factory = null;
            }
        }
        return factory;
    }

    public static void close(){
        if(factory!=null){
            factory.close();
            factory=null;
        }
    }


}
