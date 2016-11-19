/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;

import java.security.SecureRandom;
import java.math.BigInteger;
import java.util.Random;
import manejadorDB.controlador.ClienteControlador;
import manejadorDB.controlador.EmpleadoControlador;
import manejadorDB.controlador.PaqueteControlador;


/**
 *
 * @author juani
 */
public abstract class Helper {
    
    //generacion de codigo
    /*empleado y cliente*/
    private static final SecureRandom random = new SecureRandom();
    
    /*paquete*/
    private static final Random generator = new Random();
    
    
    public final static String europa = "EUROPA";
    public final static String america_sur = "AMERICA DEL SUR.";
    /*otros continentes*/
    

    public abstract String get_RutaRelativa(String file);
    
    
    
    
    
    //tipo = 0 (cliente)
    //tipo = 1 (empleado)
    //tipo = 2 (paquete )
    public static String generarCodigo(int tipo){
        String code = null;
        
        switch (tipo) {
            case 0:
                code = generarCodigoC();
                break;
            case 1:
                code = generarCodigoE();
                break;
            default:
                code = generarCodigoP();
                break;
        }
        return code;
    }
    
    
    /*definiendo funciones generadoras de código*/
    
    private static String generarCodigoC() {
        
               
       boolean existe = true;
       ClienteControlador cc = new ClienteControlador();
       String finalcode=null;
        
        do{
            String code = null;
            do{
                code= new BigInteger(140,random).toString(32); /*BigInteger(n,random).toString(32); devuelve una secuencia de caracteres igual a n/5, es decir, si es 150 devuelve 30 caracteres.*/ 
            } while(code.length()<28); //hasta que no contenga esta longitud.        
            
            StringBuilder newCode = new StringBuilder(code);
            newCode.setCharAt(0, 'C'); //agregar C al inicio.
            
            finalcode = newCode.toString();
            
            existe = cc.existe(finalcode); //comprobar si ya hay registrado un cliente con este codigo.
            
        }while(existe);
        
        String code =null;
        
        return finalcode;
    }

    private static String generarCodigoE() {
               
       boolean existe = true;
       EmpleadoControlador ec = new EmpleadoControlador();
       String finalcode=null;
        
        do{
            String code = null;
            do{
                code= new BigInteger(140,random).toString(32); /*BigInteger(n,random).toString(32); devuelve una secuencia de caracteres igual a n/5, es decir, si es 150 devuelve 30 caracteres.*/ 
            } while(code.length()<28); //hasta que no contenga esta longitud.        
            
            StringBuilder newCode = new StringBuilder(code);
            newCode.setCharAt(0, 'E'); //agregar E al inicio.
            
            finalcode = newCode.toString();
            
            existe = ec.existe(finalcode); //comprobar si ya hay registrado un cliente con este codigo.
            
        }while(existe);
        
        String code =null;
        
        return finalcode;
    }
    
    /*se genera el codigo para el paquete*/
    private static String generarCodigoP() {
        
        boolean existe = true;
        int longitud = 10;
        PaqueteControlador pc = new PaqueteControlador();
        String codigo = null;
        
        do{
            char cadena[] = new char[longitud];
            for(int i=0;i<longitud;i++){
                int numero = random.nextInt(8)+1;
                char caracter = (char) (numero +'0');
                cadena[i]=caracter;
            }            
            
            codigo = new String(cadena);
            
            existe = pc.existe(codigo);
            
        }while(existe);
        
        return codigo;
        
    }
    
    



    
}
