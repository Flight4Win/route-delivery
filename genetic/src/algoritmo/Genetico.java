/*
* Version: 1.1
* Última modificación: 18/09/2016
* Descripcion del cambio: Definición de la clase.
* author Joe Huamani
*/
package algoritmo;

import java.io.BufferedReader;
import java.io.FileReader;

import data.ColeccionAeropuerto;
import data.ColeccionPlanVuelo;
import clases.*;
import partesGenetica.Poblacion;

public class Genetico {
    
    public String[] cargarDatosAeropuerto;
    
    public static void main(String[] args) {
         //////////////////////////////////////////////////////////////////
        /*Datos iniciales del algoritmo genético
        */  
        
        final int cantidad_poblacion = 2048;
	final int generaciones_maximas = 16384;
	
        /*Los siguientes valores van entre 0.0 y 1.0*/
        final float Proporcion_cruce = 0.8f; //Proporcion de población que se cruzará con algún miembro de la poblacion
	final float proporcion_elitismo = 0.1f; // proporción de población que no se retendrá
	final float proporcion_mutacion = 0.03f;//proporción de población que mutará
        //////////////////////////////////////////////
        
        
        long tiempoCargaIni = System.currentTimeMillis(); //Para saber cuanto duró la carga de datos
        
        
         //////////////////////////////////////////////////////////////////
        /*Se carga la data
        */
        ColeccionPlanVuelo planVuelo = new ColeccionPlanVuelo();
        ColeccionAeropuerto aeropuerto = new ColeccionAeropuerto();
        
        leerAeropuertos(aeropuerto);
        leerVuelos(aeropuerto,planVuelo);
        ///////////////////////////////////////////////////////
        
         //////////////////////////////////////////////////////////////////
        /* Crear la población inicial 
        */ 
        Poblacion poblacion = new Poblacion(cantidad_poblacion, Proporcion_cruce, 
				proporcion_elitismo, proporcion_mutacion);
        
        ///////////////////////////////////////////
        
        
        long tiempoCargaFin = System.currentTimeMillis();
        System.out.println("Tiempo total de carga de datos: " + 
                           (tiempoCargaFin - tiempoCargaIni) +
                           "ms");
        
        long tiempoEvolIni = System.currentTimeMillis();
        
         //////////////////////////////////////////////////////////////////
        /* Lugar de evolución de los genes
         * Terminará cuando llegue al óptimo o hasta la última generacion
         */
        
                /*
        int i = 0;
            Chromosome best = pop.getPopulation()[0];
		
            while ((i++ <= maxGenerations) && (best.getFitness() != 0)) {
		System.out.println("Generation " + i + ": " + best.getGene());
		pop.evolve();
		best = pop.getPopulation()[0];
            }
        */
        ////////////
        
         //////////////////////////////////////////////////////////////////
        /*Resultados "interesantes" de la simulación
        */
        
        long tiempoEvolFin = System.currentTimeMillis();
        
        System.out.println("Generacion " /*+ i*/ + ": " );//+ best.getGene());
	System.out.println("Tiempo total de ejecucion: " + 
                           (tiempoEvolFin - tiempoEvolIni) +
                           "ms");
        ///////////////////////////////////////////////////////
    }
    
    static String[] cargarDatosAeropuerto(){
        String[] rar = new String[20];
        
        return rar;
    }
    static void leerVuelos(ColeccionAeropuerto aeropuertos,ColeccionPlanVuelo plan_vuelos){
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Joe Natan\\OneDrive\\Documentos\\Desarrollo de programas 1\\route-delivery\\genetic\\src\\documentos\\planVuelo.txt"));
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
                //System.out.println(hora_ini+"-"+hora_fin+"-"+planVuelo.getDuracion());
                plan_vuelos.Add(planVuelo);                                
            }
        }catch(Exception e){}
    }
    
    static void leerAeropuertos(ColeccionAeropuerto aeropuertos){
        try{
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Joe Natan\\OneDrive\\Documentos\\Desarrollo de programas 1\\route-delivery\\genetic\\src\\documentos\\aeropuertos.txt"));
                
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
            System.out.println("error dentro de lectura Aeropuerto\n");
        }
    }
    
}
