/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.controlador;

import entidad.Itinerario;
import entidad.Paquete;
import java.util.List;
import manejadorDB.Interfaz.MetodosItinerario;
import manejadorDB.Sesion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author juani
 */
public class ItinerarioControlador implements MetodosItinerario {

    @Override
    public Itinerario crear(Itinerario itinerario) {
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //guardar itinerario
                session.save(itinerario);
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }

        }
         return itinerario;        
    }

    @Override
    public List<Itinerario> buscarporpaquete(Paquete paquete) {
        List<Itinerario> itinerarios = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                itinerarios=session.createNamedQuery("Itinerario.findByIdpaquete").setParameter("idpaquete", paquete.getIdpaquete()).list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return itinerarios;
    }
    
}
