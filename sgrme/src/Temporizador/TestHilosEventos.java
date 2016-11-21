/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Temporizador;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.TimerTask;
import java.util.Timer;
//import javafx.util.converter.LocalDateTimeStringConverter;

/**
 *
 * @author Diego
 */
public class TestHilosEventos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strFecha = "2016-10-30 19:00:30";
        LocalDateTime horaInicio = LocalDateTime.parse(strFecha,formateador);
        //System.out.println(horaInicio.getSecond());
       // TemporizadorAplicacion temporizador = new TemporizadorAplicacion(LocalDateTime.parse(strFecha,formateador));                                       
        
        //temporizador.ActivarTimer();        
    }
    
}

