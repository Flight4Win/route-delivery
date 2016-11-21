/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptación;

/**
 *
 * @author carlo
 */
public class Encriptación {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        StringEncrypt encriptador = new StringEncrypt();
        String key = "92AE31A79FEEB2A3"; //llave
        String iv = "0123456789ABCDEF"; // vector de inicialización
 String cleartext = "hola";
 String encriptado = encriptador.encrypt(key, iv,cleartext);
 System.out.println("Texto encriptado: "+encriptado);
 System.out.println("Texto desencriptado: "+encriptador.decrypt(key, iv,encriptado));
 

        key = "92AE31A79FEEB2A3"; //llave
        iv = "0123456789ABCDEF"; // vector de inicialización
        cleartext = "hola";
        encriptado = encriptador.encrypt(key, iv,cleartext);
 System.out.println("Texto encriptado: "+encriptado);
 System.out.println("Texto desencriptado: "+encriptador.decrypt(key, iv,encriptado));
 
    }
    
}
