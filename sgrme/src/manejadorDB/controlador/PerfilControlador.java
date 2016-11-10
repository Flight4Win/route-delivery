/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.controlador;


import entidad.Perfil;
import java.util.List;
import manejadorDB.Interfaz.MetodosPerfil;
import manejadorDB.Sesion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

//
/**
 *
 * @author juani
 */
public class PerfilControlador implements MetodosPerfil{

    @Override
    public void crear(Perfil perfil) {
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //guardar aeropuerto
                session.save(perfil);
                
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
    public List<Perfil> todos() {
        
        List<Perfil> perfiles = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                perfiles=session.createNamedQuery("Perfil.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return perfiles;
    }

    @Override
    public int cantidad() {
        List<Perfil> perfiles = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                perfiles=session.createNamedQuery("Perfil.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        if(perfiles==null) return 0;
        else return perfiles.size();
    }

    @Override
    public Perfil devolverPerfilPorID(Integer idPerfil) {
        List<Perfil> perfiles = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                perfiles=session.createNamedQuery("Perfil.findByIdperfil").setParameter("idperfil", idPerfil).list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        if(perfiles!=null && perfiles.size()>0){
            return perfiles.get(0);
        }else{
            return null;
        }
        
    }

    @Override
    public Perfil devolverPerfilPorNivelAcceso(Integer nivelAcceso) {
        List<Perfil> perfiles = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                perfiles=session.createNamedQuery("Perfil.findByNivelacceso").setParameter("nivelacceso", nivelAcceso).list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        if(perfiles!=null && perfiles.size()>0){
            return perfiles.get(0);
        }else{
            return null;
        }
    }

    
    
    
    
}
