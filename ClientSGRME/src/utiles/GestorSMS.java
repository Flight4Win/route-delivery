/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
/**
 *
 * @author carlo
 */
public class GestorSMS {
    // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACb467bf13ebcf916e45943920f0d7306c";
  public static final String AUTH_TOKEN = "61bf35d429b504fcd35621ed0b0e43d9";
  PhoneNumber numeroPrincipal = new PhoneNumber("+19546271870");
  public GestorSMS(){
    
}
  
  public void enviarSMS(String numero, String mensaje){
    System.out.println("Telefono receptor:   "+numero);
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new PhoneNumber(numero),//Este es el que recibe :D
        new PhoneNumber("+19546271870"), //El que envía
        mensaje).create(); //El mensaje :D

    System.out.println(message.getSid());
    System.out.println("Done - Telefono");
  }
}
