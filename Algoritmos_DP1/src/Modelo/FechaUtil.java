/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 *
 * @author Diego
 */
public class FechaUtil {
    public static Date convertirUTC(Date fuente){
        String patron = "MM-dd-yyy hh:mm:ss a";
        ZonedDateTime zdt = ZonedDateTime.ofInstant(fuente.toInstant(), ZoneId.of("UTC"));
        return Date.from(zdt.toInstant());
    }
}
