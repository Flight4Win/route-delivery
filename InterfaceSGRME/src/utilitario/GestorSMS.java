/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
/**
 *
 * @author carlo
 */
public class GestorSMS {
    // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC0fa76fdc6ccad0d9245f1d3259c3faa9";
  public static final String AUTH_TOKEN = "dcb55f0f53b79ec4b90fa56d73396428";
  PhoneNumber numeroPrincipal = new PhoneNumber("+51987199629");
  public GestorSMS(){
    
}
  
  public void enviarSMS(String numero, String mensaje){
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(numeroPrincipal,new PhoneNumber(numero),mensaje).create();
    System.out.println(message.getSid());
  }
}
