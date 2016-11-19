/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.controlador;

import entidad.Plandevuelo;
import java.util.List;
import manejadorDB.Interfaz.MetodosPlandevuelo;
import manejadorDB.Sesion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author juani
 */
public class PlandevueloControlador implements MetodosPlandevuelo {

@Override
    public Plandevuelo crear(Plandevuelo plandevuelo) {
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //guardar aeropuerto
                session.save(plandevuelo);
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        return plandevuelo;
        
    }

    @Override
    public List<Plandevuelo> todos() {
        
        List<Plandevuelo> plandevuelos = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                plandevuelos=session.createNamedQuery("Plandevuelo.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return plandevuelos;
    }

    @Override
    public int cantidad() {
        List<Plandevuelo> plandevuelos = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                plandevuelos=session.createNamedQuery("Plandevuelo.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        if(plandevuelos==null) return 0;
        else return plandevuelos.size();
    }

    @Override
    public Plandevuelo obtener_plan(int id) {
        Plandevuelo plandevuelo = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener plandevuelo 
                plandevuelo=session.get(Plandevuelo.class, id);
                                     
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return plandevuelo;
    }
    
}
