/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static java.lang.Math.pow;
import java.time.LocalDateTime;
import java.util.Random;

/**
 *
 * @author Diego
 */
public class CreadorPaquete {
    private final ColeccionAeropuerto _aeropuertos;
    private final Random rnd = new Random();
    
    public CreadorPaquete(ColeccionAeropuerto aeropuertos){
        _aeropuertos = aeropuertos;
    }
    
    public void crearPaquetes(String ciudad, float coef1, float coef2, int x, int ultCodigo, LocalDateTime fechaIni){
        String nombArch = ciudad+".txt";
        fechaIni = fechaIni.withHour(0);
        fechaIni = fechaIni.minusHours(1);
        fechaIni = fechaIni.withMinute(0);
        fechaIni = fechaIni.withSecond(0);
        int cantDias = 4;
        int factor = x;
        int cantAeropuertos = _aeropuertos.getAeropuertos().size();
        for(int i=0;i<cantDias;i++){
            fechaIni = fechaIni.plusHours(1);
            factor++;
            int cantPaq = (int) (coef1 * pow(coef2,factor));
            System.out.println(cantPaq);
            int paqXHora = cantPaq/24;
            int residuo = cantPaq%24;
            System.out.println(String.valueOf(paqXHora)+"-"+residuo);
            int paqEnHora = 0;
            int max = cantPaq-residuo;
            for(int j=0;j<max;j++){
                if(paqEnHora <paqXHora){
                    paqEnHora++;                
                }else{
                    paqEnHora=1;
                    fechaIni = fechaIni.plusHours(1);
                }
                ultCodigo++;
                String codigo = String.valueOf(ultCodigo);
                String fecha = String.valueOf(fechaIni.getYear())+conv(fechaIni.getMonthValue())+conv(fechaIni.getDayOfMonth());
                String destino = _aeropuertos.getAeropuertos().get(rnd.nextInt(cantAeropuertos)).getNombre();
                String paquete = codigo+fecha+conv(fechaIni.getHour())+":"+conv(fechaIni.getMinute())+destino;
                System.out.println(paquete);
                if(rnd.nextBoolean() && residuo!=0){
                    ultCodigo++;
                    codigo = String.valueOf(ultCodigo);
                    destino = _aeropuertos.getAeropuertos().get(rnd.nextInt(cantAeropuertos)).getNombre();
                    paquete = codigo+fecha+conv(fechaIni.getHour())+":"+conv(fechaIni.getMinute())+destino;
                    System.out.println(paquete);
                    residuo--;
                }                
            }
            System.out.println(residuo);
        }
    }
    private String conv(int n){
        if(n<10) return "0"+String.valueOf(n);
        else return String.valueOf(n);
    }
    
}
