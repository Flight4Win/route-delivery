/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.controlador;

import entidad.Avion;
import java.util.List;
import manejadorDB.Interfaz.MetodosAvion;
import manejadorDB.Sesion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author juani
 */
public class AvionControlador implements MetodosAvion {

    @Override
    public void crear(Avion avion) {
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //guardar aeropuerto
                session.save(avion);
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                factory.close();
            }
        }
        
        
    }

    @Override
    public List<Avion> todos() {
        
        List<Avion> aviones = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                aviones=session.createNamedQuery("Avion.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                factory.close();
            }
        }
        
        return aviones;
    }

    @Override
    public int cantidad() {
        List<Avion> aviones = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                aviones=session.createNamedQuery("Avion.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                factory.close();
            }
        }
        
        if(aviones==null) return 0;
        else return aviones.size();
    }
    
}
