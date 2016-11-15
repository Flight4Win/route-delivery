/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;

import java.security.SecureRandom;
import java.math.BigInteger;
import java.util.Random;


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
        
        /*BigInteger(n,random).toString(32); devuelve una secuencia de caracteres igual a n/5, es decir, si es 150 devuelve 30 caracteres.*/        
        String code =null;
        
        do{
           code= new BigInteger(140,random).toString(32);
        } while(code.length()<28);

        
        StringBuilder newCode = new StringBuilder(code);
        newCode.setCharAt(0, 'C');
        
        return newCode.toString();
    }

    private static String generarCodigoE() {
        
        /*BigInteger(n,random).toString(32); devuelve una secuencia de caracteres igual a n/5, es decir, si es 150 devuelve 30 caracteres.*/        
        String code =null;
        
        do{
           code= new BigInteger(140,random).toString(32);
        } while(code.length()<28);

        
        StringBuilder newCode = new StringBuilder(code);
        newCode.setCharAt(0, 'E');
        
        return newCode.toString();
    }

    private static String generarCodigoP() {
        
        /*se genera el codigo para el paquete*/
        
        int longitud = 10;
        //StringBuilder constructor = new StringBuilder();
        char cadena[] = new char[longitud];

        
        for(int i=0;i<longitud;i++){
            int numero = random.nextInt(8)+1;
            char caracter = (char) (numero +'0');
            cadena[i]=caracter;
        }
        
        String codigo = new String(cadena);
        
        return codigo;
        
    }
    
    



    
}
