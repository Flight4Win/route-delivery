/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.controlador;


import entidad.Lugar;
import java.util.ArrayList;
import java.util.List;
import manejadorDB.Interfaz.MetodosLugar;
import manejadorDB.Sesion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utiles.Helper;

/**
 *
 * @author juani
 */
public class LugarControlador implements MetodosLugar {

    @Override
    public Lugar crear(Lugar lugar) {
        
        List<Lugar> lugares = buscarPorCiudad(lugar.getCiudad());  //revisar que se este insertando un nuevo lugar.
        
        if(lugares.isEmpty()){      
            SessionFactory factory = Sesion.init();
            if(factory!=null){

                try{
                    //crear sesion
                    Session session = factory.getCurrentSession();

                    //transaccion
                    session.beginTransaction();

                    //guardar aeropuerto
                    session.save(lugar);

                    //commitear transaccion
                    session.getTransaction().commit();

                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    Sesion.close();
                }
            }
            return lugar;
        }else{
            return lugares.get(0);
        }        
    }

    @Override
    public List<Lugar> todos() {
        
        List<Lugar> lugares = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                lugares=session.createNamedQuery("Lugar.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return lugares;
    }

    @Override
    public int cantidad() {
        List<Lugar> lugares = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                lugares=session.createNamedQuery("Lugar.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        if(lugares==null) return 0;
        else return lugares.size();
    }

    @Override
    public List<Lugar> buscarPorCiudad(String ciudad) {
        List<Lugar> lugares = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();    
                lugares=session.createNamedQuery("Lugar.findByCiudad").setParameter("ciudad", ciudad).list();    
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }        
        return lugares;
    }

    @Override
    public Lugar obtener_lugar(int id) {
        
        Lugar lugar = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lugar 
                lugar=session.get(Lugar.class, id);
                                     
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return lugar;        
    }

    @Override
    public Lugar leer(Lugar lugar) {
        List<Lugar> lugares = buscarPorCiudad(lugar.getCiudad());  //revisar que se este insertando un nuevo lugar.
        
        if(lugares.isEmpty()){      
            SessionFactory factory = Sesion.init();
            if(factory!=null){

                try{
                    //crear sesion
                    Session session = factory.getCurrentSession();

                    //transaccion
                    session.beginTransaction();

                    //guardar aeropuerto
                    session.save(lugar);

                    //commitear transaccion
                    session.getTransaction().commit();

                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    Sesion.close();
                }
            }
            return lugar;
        }else{
            Helper.tablas_leidas=true;
            return lugares.get(0);
        } 
    }
    
    @Override
    public List<String> ciudadesMasEnvios() {
        List<Object[]> lugares_datos = null;        
        List<String> lugares = new ArrayList<>();        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();    
                lugares_datos=session.createNamedQuery("Lugar.masEnvios").setMaxResults(20).list();
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        for (Object[] lugares_dato : lugares_datos) {
            lugares.add(lugares_dato[0]+"#"+lugares_dato[1]);
        }
        
        return lugares;
    }
    
    @Override
    public List<String> ciudadesMasRecepciones() {
        List<Object[]> lugares_datos = null;        
        List<String> lugares = new ArrayList<>();        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();    
                lugares_datos=session.createNamedQuery("Lugar.masRecepciones").setMaxResults(20).list();
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        for (Object[] lugares_dato : lugares_datos) {
            lugares.add(lugares_dato[0]+"#"+lugares_dato[1]);
        }        
        return lugares;
    }
    
}
