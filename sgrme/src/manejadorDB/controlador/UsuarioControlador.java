/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.controlador;

import entidad.Usuario;
import java.util.List;
import manejadorDB.Interfaz.MetodosUsuario;
import manejadorDB.Sesion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author juani
 */
public class UsuarioControlador implements MetodosUsuario{

    @Override
    public void crear(Usuario usuario) {
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //guardar aeropuerto
                session.save(usuario);
                
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
    public Usuario logueo(String usuario, String pass) {
        List<Usuario> usuarios = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                usuarios=session.createNamedQuery("Usuario.logueo").setParameter("usuario", usuario).setParameter("contrasenha", pass).list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        if(usuarios!=null && usuarios.size()>0){
            return usuarios.get(0);
        }else{
            return null;
        }
    }

    @Override
    public Usuario cambioContrasenha(String usuario, String passAnt, String passNvo) {
        Usuario user = logueo(usuario,passAnt);
        if(user!=null){
            try{
                SessionFactory factory = Sesion.init();

                Session session = factory.getCurrentSession();

                user.setContrasenha(passNvo);

                session.getTransaction().commit();
            }catch(Exception e){
                user=null;
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
            return user;
        }else{
            return null;
        }
    }
    
}