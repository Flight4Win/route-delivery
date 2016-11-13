/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.controlador;

import entidad.Cliente;
import entidad.Empleado;
import java.util.List;
import manejadorDB.Interfaz.MetodosCliente;
import manejadorDB.Sesion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author juani
 */
public class ClienteControlador implements MetodosCliente {

    @Override
    public void crear(Cliente cliente) {
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //guardar aeropuerto
                session.save(cliente);
                
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
    public List<Cliente> todos() {
        
        List<Cliente> clientes = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                clientes=session.createNamedQuery("Cliente.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return clientes;
    }

    @Override
    public int cantidad() {
        List<Cliente> clientes = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                clientes=session.createNamedQuery("Cliente.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        if(clientes==null) return 0;
        else return clientes.size();
    }

    @Override
    public void eliminar(Integer idCliente) {
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();                
                //eliminar
                session.createNamedQuery("Cliente.delete").setParameter("idCliente", idCliente).getSingleResult();                
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
    public List<Cliente> buscar(int opcion, String filtro) {
        List<Cliente> clientes = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();    
                switch (opcion){
                    case 1:
                        /*busqueda por Documento*/
                        clientes=session.createNamedQuery("Cliente.findByDocumento").setParameter("documento", filtro).list();       
                        break;
                    case 2:
                        /*busqueda por Codigo*/
                        clientes=session.createNamedQuery("Cliente.findByCodigo").setParameter("codigo", filtro).list();   
                        break;
                    case 3:
                        /*busqueda por Apellidos*/
                        clientes=session.createNamedQuery("Cliente.findByApellidos").setParameter("apellidopat", filtro).list();   
                        break;              
                }                                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }        
        return clientes;
    }
    
}
