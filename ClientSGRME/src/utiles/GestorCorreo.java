/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author carlo
 */
public class GestorCorreo {
    
        final String username = "dp1.sgrme@gmail.com";
        final String password = "dp1.sgrme19";

        Properties props = new Properties();        
    
    public GestorCorreo(){
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
    }
    
    public void enviarCorreo(String correoReceptor, String asunto, String mensaje){
        
        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dp1.sgrme@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(correoReceptor));
            message.setSubject(asunto);
            message.setText(mensaje
                + "\n\n TraslaPack  - SGRME");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        
    }
}
