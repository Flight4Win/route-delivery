/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.controlador;

import entidad.Empleado;
import java.util.List;
import manejadorDB.Interfaz.MetodosEmpleado;
import manejadorDB.Sesion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author juani
 */
public class EmpleadoControlador implements MetodosEmpleado {

    @Override
    public void crear(Empleado empleado) {        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();                
                //guardar aeropuerto
                session.save(empleado);                
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
    public List<Empleado> todos() {        
        List<Empleado> empleados = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();                
                //obtener lista 
                empleados=session.createNamedQuery("Empleado.findAll").list();                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return empleados;
    }

    @Override
    public int cantidad() {
        List<Empleado> empleados = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();                
                //obtener lista 
                empleados=session.createNamedQuery("Empleado.findAll").list();                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        if(empleados==null) return 0;
        else return empleados.size();
    }
    
    @Override
    public void eliminar(Integer idEmpleado) {
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();                
                //eliminar
                session.createNamedQuery("Empleado.delete").setParameter("idEmpleado", idEmpleado).getSingleResult();                
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
    public List<Empleado> buscar(int opcion, String filtro) {
        List<Empleado> empleados = null;        
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
                        empleados=session.createNamedQuery("Empleado.findByDocumento").setParameter("documento", filtro).list();       
                        break;
                    case 2:
                        /*busqueda por Codigo*/
                        empleados=session.createNamedQuery("Empleado.findByCodigo").setParameter("codigo", filtro).list();   
                        break;
                    case 3:
                        /*busqueda por Apellidos*/
                        empleados=session.createNamedQuery("Empleado.findByApellidos").setParameter("apellidopat", filtro).list();   
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
        return empleados;
    }

    @Override //util para determinar si existe registrado un empleado con dicho codigo
    public boolean existe(String codigo) {
        List<Empleado> empleados = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();                
                //obtener lista 
                empleados=session.createNamedQuery("Empleado.unique").setParameter("codigo", codigo).list();
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return !empleados.isEmpty(); //FALSO es que no existe y por tanto es apropiado utilizar ese codigo.
    }
    
    
}
