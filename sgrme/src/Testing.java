

import entidad.Persona;
import entidad.Usuario;
import java.util.List;
import manejadorDB.Sesion;
import manejadorDB.controlador.PersonaControlador;
import manejadorDB.controlador.UsuarioControlador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/*Esta clase es con fines de prueba.
*/

/**
 *
 * @author juani
 */
public class Testing {
    
    public static void main(String [] args){
        
        test_juani_connection();
        //test_juani_connection_2();
        //test_juani_connection_3();
    }

    private static void test_juani_connection() {
        SessionFactory factory = Sesion.init();
        
        Session session = factory.getCurrentSession();
        
        try
        {
            session.beginTransaction();

            List<Persona> personas = session.createQuery("from Persona").list();

            for(Persona p : personas){
                System.out.println(p);
            }

            session.getTransaction().commit();            
        }catch(Exception e)
        {
            e.printStackTrace();
        }finally{
            Sesion.close();
        }
    }

    private static void test_juani_connection_2() {
        PersonaControlador pc = new PersonaControlador();
        List<Persona> personas = pc.todos();
        if(personas!=null){
            for(Persona p : personas){
                System.out.println(p);
            }       
        }
    }

    private static void test_juani_connection_3() {
        UsuarioControlador uc = new UsuarioControlador();
        Usuario usuario = uc.logueo("pamplina", "empleado123");
        System.out.println(usuario.getIdperfil().getIdperfil());
    }
    
}
