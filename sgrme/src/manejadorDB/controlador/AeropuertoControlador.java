/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.controlador;

import entidad.Aeropuerto;
import entidad.Lugar;
import java.util.List;
import manejadorDB.Interfaz.MetodosAeropuerto;
import manejadorDB.Sesion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author juani
 */
public class AeropuertoControlador implements MetodosAeropuerto{

    @Override
    public Aeropuerto crear(Aeropuerto aeropuerto) {
        
        Aeropuerto a =obtener_Aeropuerto(aeropuerto.getIdaeropuerto()); //se revisa si se está insertando un nuevo aeropuerto o ya existe.
        if (a==null){
            SessionFactory factory = Sesion.init();
            if(factory!=null){

                try{
                    //crear sesion
                    Session session = factory.getCurrentSession();

                    //transaccion
                    session.beginTransaction();

                    //guardar aeropuerto
                    session.save(aeropuerto);

                    //commitear transaccion
                    session.getTransaction().commit();

                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    Sesion.close();
                }
            }

            return aeropuerto;
        }else{
            return a;
        }
        
    }

    @Override
    public List<Aeropuerto> todos() {
        
        List<Aeropuerto> aeropuertos = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                aeropuertos=session.createNamedQuery("Aeropuerto.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        return aeropuertos;
    }

    @Override
    public int cantidad() {
        List<Aeropuerto> aeropuertos = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                
                //obtener lista 
                aeropuertos=session.createNamedQuery("Aeropuerto.findAll").list();
                
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        
        if(aeropuertos==null) return 0;
        else return aeropuertos.size();
    }

    @Override
    public List<Aeropuerto> buscarByLugar(Lugar filtro) {
        List<Aeropuerto> aeropuertos = null;        
        SessionFactory factory = Sesion.init();
        if(factory!=null){            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();                
                //transaccion
                session.beginTransaction();    
                System.out.println("filtro :   "+filtro.toString());     
                aeropuertos=session.createNamedQuery("Aeropuerto.findByLugar").setParameter("idlugar", filtro).list();                    
                //commitear transaccion
                session.getTransaction().commit();    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }        
        return aeropuertos;
    }

    @Override
    public Aeropuerto obtener_Aeropuerto(int id) {
        Aeropuerto aeropuerto = null;
        
        SessionFactory factory = Sesion.init();
        if(factory!=null){
            
            try{
                //crear sesion
                Session session = factory.getCurrentSession();
                
                //transaccion
                session.beginTransaction();
                //obtener aeropuerto
                aeropuerto = session.get(Aeropuerto.class, id);
                //commitear transaccion
                session.getTransaction().commit();
    
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                Sesion.close();
            }
        }
        return aeropuerto; 
    }
    
}
