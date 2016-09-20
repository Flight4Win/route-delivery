/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos_dp1;

import Modelo.Lugar;
import Modelo.Aeropuerto;
import Modelo.Arista;
import Modelo.ColeccionAeropuerto;
import Modelo.ColeccionPlanVuelo;
import Modelo.ConexionCiudades;
import Modelo.Paquete;
import Modelo.PlanVuelo;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

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
        ConexionCiudades grafo = new ConexionCiudades();
        
        leerAeropuertos(aeropuertos,grafo);
        leerHusoHorario(aeropuertos);
        leerVuelos(aeropuertos,plan_vuelos,grafo);
        
        //grafo.imprimirGrafo();
        
        //encontrarCamino(1,2,grafo);
        //encontrarCamino(5,28,grafo);
        //encontrarCamino(10,40,grafo);
        //encontrarCamino(38,7,48,grafo);
    }  
    
    static void encontrarCamino(int a, int b, int tiempo,ConexionCiudades grafo, Paquete paquete){
        Stack pila = new Stack();
        ArrayList<Integer> visitados = new ArrayList<>();
        HashMap<Integer,Integer> padres = new HashMap<>();
        Stack camino = new Stack();
        Calendar fechaInicio = Calendar.getInstance();
        fechaInicio.setTime(paquete.getFechaRegistro());
        //fechaInicio.add(Calendar.HOUR,8);
        //  fechaInicio.
        pila.push(a);
        while(!pila.empty()){
            Integer vertice = (Integer)pila.pop();
            if(vertice == b)break;
            if(!visitados.contains(vertice)){
                visitados.add(vertice);
                System.out.println(vertice);
                for(Arista arista : grafo.getGrafo().get(vertice)){
                    int duracion=0;
                    duracion += arista.getDuracion();
                    
                    Integer hijo = arista.getCiudades().getValue();
                    if(visitados.contains(hijo))continue;
                    pila.push(hijo);
                    padres.put(hijo, vertice);
                    System.out.println(vertice+"-"+hijo);
                }
            }
        }
        System.out.println(padres);
        System.out.println(visitados);
        //System.out.println(padres.get(7));
        System.out.println("termino busqueda");
        Integer ciudadCamino = b;
        while(ciudadCamino != null){
            camino.push(ciudadCamino);
            ciudadCamino = padres.get(ciudadCamino);
            //System.out.println(ciudadCamino);
        }
        System.out.println(camino);
    }
    
    static void leerHusoHorario(ColeccionAeropuerto aeropuertos){
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Diego\\Documents\\NetBeansProjects\\Algoritmos_DP1\\src\\algoritmos_dp1\\husoHorario.txt"));
            String str;
            int i=0;
            while((str = br.readLine())!=null){                
                String ciudad = str.split(" ")[0];
                int utc = Integer.parseInt(str.split(" ")[1]);
                for(Aeropuerto aero: aeropuertos.getAeropuertos()){
                    if(ciudad.equals(aero.getLugar().getCiudad()) ){
                        aero.getLugar().setUtc(utc);
                        break;
                    }
                }
            }
            
        }catch(Exception e){}
    }
    
    static void leerVuelos(ColeccionAeropuerto aeropuertos,ColeccionPlanVuelo plan_vuelos,ConexionCiudades grafo){
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
                grafo.anhadirArista(planVuelo);
                //System.out.println(hora_ini+"-"+hora_fin+"-"+planVuelo.getDuracion());
                plan_vuelos.Add(planVuelo);                                
            }
        }catch(Exception e){}
    }
    
    static void leerAeropuertos(ColeccionAeropuerto aeropuertos,ConexionCiudades grafo){
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
                int codigo;
                codigo = Integer.parseInt(strs[0]);
                pais = strs[2];
                ciudad = strs[3];
                nombre = strs[1];
                Lugar lugar = new Lugar(codigo, continente, pais, ciudad);
                Aeropuerto aeropuerto = new Aeropuerto(lugar, nombre, 30);
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
