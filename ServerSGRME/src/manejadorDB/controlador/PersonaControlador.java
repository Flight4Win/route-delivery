/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.controlador;


import entidad.Persona;
import java.util.List;
import manejadorDB.Interfaz.MetodosPersona;
import manejadorDB.Sesion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author juani
 */
public class PersonaControlador implements MetodosPersona{

    @Override
    public Persona crear(Persona persona) {
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //guardar aeropuerto
                session.save(persona);
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        return persona;        
    }

    @Override
    public List<Persona> todos() {
        
        List<Persona> personas = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                personas=session.createNamedQuery("Persona.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return personas;
    }

    @Override
    public int cantidad() {
        List<Persona> personas = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                personas=session.createNamedQuery("Persona.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        if(personas==null) return 0;
        else return personas.size();
    }

    @Override
    public void eliminar(Persona persona) {
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();                
                //eliminar
                session.delete(persona);               
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
    public void modificar(Persona persona) {
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();                
                //eliminar                
                session.update(persona);
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
    public List<Persona>  buscarPorId(int idPersona) {
        List<Persona> personas = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();
                        /*busqueda por Documento*/
                personas=session.createNamedQuery("Persona.findByIdpersona").setParameter("idpersona", idPersona).list();  
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return personas;
    }
                
                
                
    @Override
    public Persona obtener_Persona(int id) {
        Persona persona = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener persona 
                persona=session.get(Persona.class, id);
                                     
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }        
        return persona;
    }
    
    @Override
    public boolean existeDocumento(String documento){
        List<Persona> personas = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                personas=session.createNamedQuery("Persona.existeDocuemnto").setParameter("documento", documento).list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        if(personas!=null && personas.size()>0){
            return true;
        }else{
            return false;
        }
    }
    
}
