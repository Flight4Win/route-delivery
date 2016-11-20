/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.controlador;

import entidad.Vuelo;
import java.util.List;
import manejadorDB.Interfaz.MetodosVuelo;
import manejadorDB.Sesion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author juani
 */
public class VueloControlador implements MetodosVuelo{

    @Override
    public void crear(Vuelo vuelo) {
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //guardar aeropuerto
                session.save(vuelo);
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        
    }

    @Override
    public List<Vuelo> todos() {
        
        List<Vuelo> vuelos = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                vuelos=session.createNamedQuery("Vuelo.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return vuelos;
    }

    @Override
    public int cantidad() {
        List<Vuelo> vuelos = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                vuelos=session.createNamedQuery("Vuelo.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        if(vuelos==null) return 0;
        else return vuelos.size();
    }
    
}
