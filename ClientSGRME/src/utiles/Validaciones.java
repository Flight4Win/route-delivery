/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ferna
 */
public abstract class Validaciones {
//    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
//            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
 
    private static final String PATTERN_EMAIL = "[a-z]+([0-9]+)?([a-z]+)?(\\_|\\.)?(([0-9]+)|([a-z]+))+";
    private static final String PATTERN_DNI = "[0-9]{8}";
    private static final String PATTERN_TELEFONO = "\\+([0-9]{3}|[0-9]{2})[0-9]{9}";
//    private static final String PATTERN_LAT_LONG = "(\\+|\\-)[0-9]{2} [0-9]{9}";
    /**
     * Validate given email with regular expression.
     * 
     * @param email
     *            email for validation
     * @return true valid email, otherwise false
     */
    public static boolean validateEmail(String email) {
 
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches(); 
    }
    
    public static  boolean validateTelefono(String telefono){
       // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_TELEFONO);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(telefono);
        return matcher.matches();  
    }
    
    public static boolean validateDNI(String dni){
        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_DNI);
 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(dni);
        return matcher.matches(); 
    }
    
//    public static boolean validateLatLong(String latLong) {
// 
//        // Compiles the given regular expression into a pattern.
//        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
// 
//        // Match the given input against this pattern
//        Matcher matcher = pattern.matcher(latLong);
//        return matcher.matches(); 
//    }
}
