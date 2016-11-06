
import entidad.Aeropuerto;
import entidad.Lugar;
import entidad.Paquete;
import entidad.Almacenavion;
import entidad.Avion;
import entidad.Cargo;
import entidad.Cliente;
import entidad.Empleado;
import entidad.Estado;
import entidad.Itinerario;
import entidad.ItinerarioPK;
import entidad.Movimientoalmacen;
import entidad.Movimientoavion;
import entidad.Perfil;
import entidad.Persona;
import entidad.Plandevuelo;
import entidad.Usuario;
import entidad.Vuelo;
import java.util.List;
import manejadorDB.Sesion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
            factory.close();
        }
    }
    
}
