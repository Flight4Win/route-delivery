/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos_dp1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Diego
 */
public class Algoritmos_DP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        //ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();
        ColeccionAeropuerto aeropuertos = new ColeccionAeropuerto();
        ColeccionPlanVuelo plan_vuelos = new ColeccionPlanVuelo();        
        
        leerAeropuertos(aeropuertos);
        leerVuelos(aeropuertos,plan_vuelos);
        
    }  
    
    static void leerVuelos(ColeccionAeropuerto aeropuertos,ColeccionPlanVuelo plan_vuelos){
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Diego\\Documents\\NetBeansProjects\\Algoritmos_DP1\\src\\algoritmos_dp1\\plan_vuelo.txt"));
            String str;
            int i=0;
            while((str = br.readLine())!=null){
                
                String[] strs = str.split("-");
                String s_partida = strs[0];
                String s_destino = strs[1];
                String h_ini = strs[2];
                String h_fin = strs[3];
                int hora_ini = Integer.parseInt(h_ini.split(":")[0]);
                int hora_fin = Integer.parseInt(h_fin.split(":")[0]);
                
                Aeropuerto partida = aeropuertos.Buscar(s_partida);
                Aeropuerto destino = aeropuertos.Buscar(s_destino);
                
                PlanVuelo planVuelo = new PlanVuelo(partida, destino, hora_ini, hora_fin);
                System.out.println(hora_ini+"-"+hora_fin+"-"+planVuelo.getDuracion());
                plan_vuelos.Add(planVuelo);                                
            }
        }catch(Exception e){}
    }
    
    static void leerAeropuertos(ColeccionAeropuerto aeropuertos){
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Diego\\Documents\\NetBeansProjects\\Algoritmos_DP1\\src\\algoritmos_dp1\\aeropuertos.txt"));
                
            String str,continente="";
            int cont=1,i=0;
            while((str = br.readLine())!=null){
                if(i==0){
                    i++;
                    continue;
                }
                //System.out.println(str);                                
                String[] strs = str.split("\t");
//                System.out.println(strs.length);
                
                if(strs.length==2){
                    continente=strs[1];
                    continente = continente.replace(".", "");
                    continue;
                }
                if(strs.length==0)continue;
                String pais,ciudad,nombre;
                pais = strs[2];
                ciudad = strs[3];
                nombre = strs[1];
                Lugar lugar = new Lugar(continente,pais,ciudad);
                Aeropuerto aeropuerto = new Aeropuerto(lugar,nombre,30);
                aeropuertos.Add(aeropuerto);
                //System.out.println(aeropuerto.toString());                
            }
        }catch(Exception e){
            System.out.println("error");
        }
    }
    
    static boolean isNumeric(String s) {  
        return s.matches("[-+]?\\d*\\.?\\d+");  
    } 
}
