/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grasp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author carlo
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("UnusedAssignment")
    static int restaHoras(String inicio, String  fin){
        String[] horaInicio = inicio.split(":");
        String[] horaFin = fin.split(":");
        float horaI = Integer.parseInt(horaInicio[0])+(Integer.parseInt(horaInicio[1])/60), 
            horaF = Integer.parseInt(horaFin[0])+(Integer.parseInt(horaFin[1])/60);
        
        if(horaF < horaI){
            horaI = (24-horaI);
            return (int)(horaI+ horaF);
        }//(horaF >horaI)
        else{
            return (int)(horaF-horaI);
        }    
    }
    
    static ArrayList<Vuelo> generarVuelos(){
        ArrayList<Vuelo> vuelos =  new ArrayList<>();
        BufferedReader bf;    
        
        try {
            bf  = new BufferedReader(new FileReader("D:\\GitHub\\route-delivery\\GRASP\\src\\archivos\\plan_vuelo.txt"));
            String cadena;
            while((cadena = bf.readLine())!=null) {
//                System.out.println(cadena);                
                String[] subCadenas = cadena.split("-");
                
                vuelos.add(new Vuelo( subCadenas[0], subCadenas[1],(restaHoras(subCadenas[2], subCadenas[3])) , subCadenas[2], subCadenas[3], 200));
            }
            bf.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo leer el archivo :'(  donde estas! "+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error  .. :$ :$ :   "+ ex.getMessage());
        }           
         
        System.out.println("Lista Vuelos: \n "+vuelos.toString());
        return vuelos;
    }
    
    static ArrayList<Aeropuerto> generarAeropuertos(){
        ArrayList<Aeropuerto> aeropuertos =  new ArrayList<>();
        BufferedReader bf;          
        try {
            bf  = new BufferedReader(new FileReader("D:\\GitHub\\route-delivery\\GRASP\\src\\archivos\\aeropuertos.txt"));
            String cadena;
            while((cadena = bf.readLine())!=null) {
//                System.out.println(cadena);                
                String[] subCadenas = cadena.split("-");
                aeropuertos.add(new Aeropuerto(subCadenas[1], subCadenas[2], subCadenas[3], 300));
            }
            bf.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo leer el archivo :'(  donde estas! "+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error  .. :$ :$ :   "+ ex.getMessage());
        }           
         
        System.out.println("Lista Aeropuertos: \n "+aeropuertos.toString());
        return aeropuertos;
    }
    
    static ArrayList<Paquete> generarPaquetes(){
        ArrayList<Paquete> paquetes =  new ArrayList<>();
        BufferedReader bf;          
        try {
            bf  = new BufferedReader(new FileReader("D:\\GitHub\\route-delivery\\GRASP\\src\\archivos\\paquetes.txt"));
            String cadena;
            while((cadena = bf.readLine())!=null) {
//                System.out.println(cadena);                
                String[] subCadenas = cadena.split("-");
                paquetes.add(new Paquete(subCadenas[0], subCadenas[1]));
            }
            bf.close();
        } catch (FileNotFoundException ex) {
            System.out.println("No se pudo leer el archivo :'(  donde estas! "+ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error  .. :$ :$ :   "+ ex.getMessage());
        }       
        System.out.println("Lista Paquetes: \n "+paquetes.toString());
        return paquetes;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here:
        //Lista de vuelos.
        ArrayList<Vuelo> vuelos =  generarVuelos();
        //Lista de aeropuertos
        ArrayList<Aeropuerto> aeropuertos = generarAeropuertos();
        //Paquetes
        ArrayList<Paquete> paquetes = generarPaquetes();
        //Algoritmo
        Grasp grasp = new Grasp(vuelos,aeropuertos);
        //Recorriendo Lista de Paquetes
//        for (Paquete paquete : paquetes) {
//            grasp.construirSolucion(paquete);
//        }
                    
    }
    
}
