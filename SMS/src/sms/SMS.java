/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sms;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


/**
 *
 * @author carlo
 */
public class SMS {

     // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "AC0fa76fdc6ccad0d9245f1d3259c3faa9";
  public static final String AUTH_TOKEN = "dcb55f0f53b79ec4b90fa56d73396428";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new PhoneNumber("+51987199629"),
        new PhoneNumber("+15128616728"), 
        "This is the ship that made the Kessel Run in fourteen parsecs?").create();

    System.out.println(message.getSid());
    
    
    
    }
    
}
