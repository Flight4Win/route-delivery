/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.controlador;

import entidad.Cliente;
import entidad.Estado;
import entidad.Paquete;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import manejadorDB.Interfaz.MetodosPaquete;
import manejadorDB.Sesion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author juani
 */
public class PaqueteControlador implements MetodosPaquete{

    @Override
    public Paquete crear(Paquete paquete) {
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //guardar aeropuerto
                session.save(paquete);
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        return paquete;
        
        
    }

    @Override
    public List<Paquete> todos() {        
        List<Paquete> paquetes = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.findAll").list();                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }        
        return paquetes;
    }

    @Override
    public int cantidad() {
        List<Paquete> paquetes = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        if(paquetes==null) return 0;
        else return paquetes.size();
    }

    @Override
    public boolean existe(String codigo) {
        List<Paquete> paquetes = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.unique").setParameter("codigounico", codigo).list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return !paquetes.isEmpty(); //FALSO es que no existe y por tanto es apropiado utilizar ese codigo.
    }

    @Override
    public List<Paquete> buscarPorCodigo(String codigo) {
        List<Paquete> paquetes = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.findByCodigounico").setParameter("codigounico", codigo).list();                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }        
        return paquetes;
    }

    @Override
    public List<Paquete> buscarPorDescripcion(String descripcion) {
        List<Paquete> paquetes = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.findByDescripcion").setParameter("descripcion", descripcion).list();                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }        
        return paquetes;
    }

    @Override
    public List<Paquete> buscarPorFechaLlegada(Date fecha) {
        List<Paquete> paquetes = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.findByFechafin").setParameter("fechafin", fecha).list();                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }        
        return paquetes;
    }
    
    @Override
    public List<Paquete> buscarPorFechaRegistro(Date fecha) {
        List<Paquete> paquetes = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.findByFechainicio").setParameter("fechainicio", fecha).list();                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }        
        return paquetes;
    }

    @Override
    public List<Paquete> buscarPorCiudadOrigen(int idCiudadOrigen) {
        List<Paquete> paquetes = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.findByOrigen").setParameter("idorigen", idCiudadOrigen).list();                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }        
        return paquetes;
    }

    @Override
    public List<Paquete> buscarPorCiudadDestino(int idCiudadDestino) {
        List<Paquete> paquetes = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.findByDestino").setParameter("iddestino", idCiudadDestino).list();                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }        
        return paquetes;
    }
                
    @Override
    public List<Paquete> buscarPorCliente(int idcliente) {
        List<Paquete> paquetes = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.findByCliente").setParameter("idcliente",idcliente).list();
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }        
        return paquetes;
    }
    
    
    @Override
    public List<Paquete> buscarPorFechasRegistro(Date fechaInicio, Date fechaFin){
        List<Paquete> paquetes = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.findByFechasRegistro").setParameter("fechainicio", fechaInicio).setParameter("fechafin", fechaFin).list();
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }        
        return paquetes;
    }
    
                
    @Override
    public Paquete obtener_paquete(int id) {
        Paquete paquete = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener paquete 
                paquete=session.get(Paquete.class, id);
                                     
                //commitear transaccion
                session.getTransaction().commit();
    

            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }    
        return paquete;  
   }

    @Override
    public List<Paquete> reportePorRangoFechas(Date fechaInicio, Date fechaFin) {
        List<Paquete> paquetes = null;   
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.reportFechasEnvio").setParameter("fechainicio", fechaInicio).setParameter("fechafin", fechaFin).list();                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        } 
        return paquetes;
    }
    
    @Override
    public List<Paquete> reportePorEstado(Estado idEstado){
        List<Paquete> paquetes = null;   
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.reportEstado").setParameter("idestado", idEstado).list();                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        } 
        return paquetes;
    }
    
    @Override
    public List<Paquete> reporteClienteEstado(Cliente idCliente, Estado idEstado){
        List<Paquete> paquetes = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.reportClienteEstado").setParameter("idcliente", idCliente).setParameter("idestado", idEstado).list();
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }        
        return paquetes;
    }
    
    @Override
    public List<Paquete> reporteClienteFecha(Cliente idCliente, Date fechaInicio, Date fechaFin) {
        List<Paquete> paquetes = null;   
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.reportClienteFecha").setParameter("idcliente", idCliente).setParameter("fechainicio", fechaInicio).setParameter("fechafin", fechaFin).list();                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        } 
        return paquetes;
    }

    @Override
    public List<Paquete> reporteEstadoFecha(Estado idEstado, Date fechaInicio, Date fechaFin) {
        List<Paquete> paquetes = null;   
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.reportEstadoFecha").setParameter("idestado", idEstado).setParameter("fechainicio", fechaInicio).setParameter("fechafin", fechaFin).list();                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        } 
        return paquetes;
    }

    @Override
    public List<Paquete> reportePorCliente(Cliente idCliente) {
        List<Paquete> paquetes = null;   
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.reportCliente").setParameter("idcliente", idCliente).list();                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        } 
        return paquetes;
    }

    @Override
    public List<Paquete> reporteClienteEstadoFecha(Cliente idCliente, Estado idEstado, Date fechaInicio, Date fechaFin) {
        List<Paquete> paquetes = null;   
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                 //transaccion
                session.beginTransaction();                
                //obtener lista 
                paquetes=session.createNamedQuery("Paquete.reportClienteEstadoFecha").setParameter("idcliente", idCliente).setParameter("idestado", idEstado).setParameter("fechainicio", fechaInicio).setParameter("fechafin", fechaFin).list();                
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        } 
        return paquetes;
    }
    
    @Override
    public void actualizarFechaFin(Date fecha, String codigo){
        
        entidad.Paquete paquete = new PaqueteControlador().buscarPorCodigo(codigo).get(0);
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();                
                //guardar aeropuerto
                paquete.setFechafin(fecha);
                session.update(paquete);                
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
    public Paquete actualizar(Paquete paquete) {
        if(paquete!=null){
            try{
                SessionFactory factory = Sesion.init();

                Session session = factory.getCurrentSession();
                
                session.beginTransaction();
                
                session.update(paquete);

                session.getTransaction().commit();
            }catch(Exception e){
                paquete=null;
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
            return paquete;
        }else{
            return null;
        }
    }
}
