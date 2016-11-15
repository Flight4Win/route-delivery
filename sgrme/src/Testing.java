

import entidad.Cliente;
import entidad.Estado;
import entidad.Perfil;
import entidad.Persona;
import entidad.Usuario;
import java.util.Date;
import java.util.List;
import manejadorDB.Sesion;
import manejadorDB.controlador.ClienteControlador;
import manejadorDB.controlador.EstadoControlador;
import manejadorDB.controlador.PaqueteControlador;
import manejadorDB.controlador.PerfilControlador;
import manejadorDB.controlador.PersonaControlador;
import manejadorDB.controlador.UsuarioControlador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utilitario.Helper;

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
        
        //test_juani_connection();
        //test_juani_connection_2();
        //test_juani_connection_3();
        
        //test_juani_code_generator_1();
        //test_juani_code_generator_2();
        
        test_juani_cliente_add();
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

    private static void test_juani_code_generator_1() {
        
        for(int i=0;i<100;i++){
            String code = Helper.generarCodigo(0);
            System.out.println("longitud codigo: "+code.length()+ "\tcodigo: "+code);
            //ClienteControlador cc = new ClienteControlador();
            //boolean existe = cc.existe(code);
            //System.out.println("EXISTE? :"+ existe);
        
        }

    }

    private static void test_juani_code_generator_2() {
        for(int i=0 ;i<100;i++){
            String code = Helper.generarCodigo(2);
            System.out.println("longitud codigo: "+code.length()+ "\tcodigo: "+code);
            //PaqueteControlador pc = new PaqueteControlador();
            //boolean existe = pc.existe(code);
            //System.out.println("EXISTE? :"+ existe);
        }
    }

    private static void test_juani_cliente_add() {
        String documento ="48288722";
        String apellidopat ="Ferraro";
        String apellidomat ="Ticona";
        String nombres = "nombres";
        String celular = "7";
        String correo ="juani@mail.com";
        Persona persona = new Persona(documento, apellidopat, apellidomat, nombres, celular, correo);
        PersonaControlador pc = new PersonaControlador();
        
        persona = pc.crear(persona);
        
       
        
        
        
        String usuario = "juani2";
        String corre  ="juani@mail.com";
        String contrasenha ="admin123";
        
        PerfilControlador pcc = new PerfilControlador();
        Perfil idperfil = pcc.devolverPerfilPorNivelAcceso(1);
        
        
        Usuario user = new Usuario(usuario, corre, contrasenha, idperfil);
        
        UsuarioControlador uc = new UsuarioControlador();
        user=uc.crear(user);
        
        EstadoControlador ec = new EstadoControlador();
        Estado idestado = ec.devolverEstado(1);
        
        
        Cliente cliente = new Cliente("gdfhfghfghhh", persona, user, idestado);
        
        Date fechadereg = new Date(1994, 4, 25,12,12,12 );
        
        //cliente.setFechadereg(fechadereg);
        
        ClienteControlador cc = new ClienteControlador();
        cc.crear(cliente);
        
        
        
        
        
    }
    
}
