/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.controlador;

import entidad.Cliente;
import entidad.Empleado;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import manejadorDB.Interfaz.MetodosCliente;
import manejadorDB.Sesion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utilitario.DateD;

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
                System.out.println("filtro :   "+filtro);     
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
                        clientes=session.createNamedQuery("Cliente.findByApellidos").setParameter("apellido", filtro).list();   
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

    @Override //Util para determinar si con ese codigo ya existe un cliente registrado.
    public boolean existe(String codigo) {
        List<Cliente> clientes = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                clientes=session.createNamedQuery("Cliente.unique").setParameter("codigo", codigo).list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return !clientes.isEmpty();  //FALSO es que no existe y por tanto es apropiado utilizar ese codigo.
    }

    @Override
    public List<Cliente> buscarByFecha(Date fechaReg) {
        List<Cliente> clientes = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();    
                System.out.println("FEchar : "+fechaReg.toString());
                clientes=session.createNamedQuery("Cliente.findByFechadereg").setParameter("fechadereg", fechaReg).list();   
                                       
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
    public Cliente obtener_cliente(int id) {
        Cliente cliente = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener cliente 
                cliente=session.get(Cliente.class, id);
                                     
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return cliente;
    }
    
}
