/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manejadorDB.controlador;


import entidad.Aeropuerto;
import entidad.Lugar;
import java.util.List;
import manejadorDB.Interfaz.MetodosLugar;
import manejadorDB.Sesion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author juani
 */
public class LugarControlador implements MetodosLugar {

    @Override
    public void crear(Lugar lugar) {
        
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
    public List<Lugar> buscar(String filtro, int opcion) {
        List<Lugar> lugares = null;        
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
                        lugares=session.createNamedQuery("Lugar.findByCiudad").setParameter("ciudad", filtro).list();       
                        break;
//                    case 2:
//                        /*busqueda por Codigo*/
//                        clientes=session.createNamedQuery("Cliente.findByCodigo").setParameter("codigo", filtro).list();   
//                        break;
//                    case 3:
//                        /*busqueda por Apellidos*/
//                        clientes=session.createNamedQuery("Cliente.findByApellidos").setParameter("apellido", filtro).list();   
//                        break;  
//                    case 4:
//                        /*busqueda por Apellidos*/     
//                        clientes=session.createNamedQuery("Cliente.findByFechadereg").setParameter("fechadereg", filtro).list();   
//                        break;     
                    
                }                                
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
    
}
