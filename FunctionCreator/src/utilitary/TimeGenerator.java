/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitary;

import java.util.Random;
import org.joda.time.LocalTime;

/**
 *
 * @author juani
 */
public class TimeGenerator {
    
    private static Random random = new Random();
    
    public static java.time.LocalTime generate_time(){

        LocalTime time = new LocalTime(random.nextLong());
       
        java.time.LocalTime time_retorno = java.time.LocalTime.of(time.getHourOfDay(), time.getMinuteOfHour());
        
        return time_retorno;
       
    }
    
    
    
    
}
