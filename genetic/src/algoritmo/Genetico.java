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
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import partesGenetica.Poblacion;

public class Genetico {

    public String[] cargarDatosAeropuerto;

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        //////////////////////////////////////////////////////////////////
        /* Fechas formato Gregoriano
         */
        Calendar fechaAct = Calendar.getInstance();
        Calendar fechaBase = Calendar.getInstance();

        fechaAct.setTime(new Date());
        fechaBase.setTime(new Date());

        fechaBase.set(1950, 1, 1, 0, 0, 0);
        Date tempDateAct = fechaAct.getTime();
        Date tempDateBase = fechaBase.getTime();

        /* impresión de fechas
         System.out.println(tempDateAct);
         System.out.println(tempDateBase);
         */
        //////////////////////////////////////////////////////////////////
        /*Datos iniciales del algoritmo genético
         */
        final int cantidad_poblacion = 100;
        final int generaciones_maximas = 16384;

        /*Los siguientes valores van entre 0.0 y 1.0*/
        final float Proporcion_cruce = 0.8f; //Proporcion de población que se cruzará con algún miembro de la poblacion
        final float proporcion_elitismo = 0.1f; // proporción de población que no se retendrá
        final float proporcion_mutacion = 0.03f;//proporción de población que mutará

        long tiempoCargaIni = System.currentTimeMillis(); //Para saber cuanto duró la carga de datos

        //////////////////////////////////////////////////////////////////
        /*Se carga la data
         */
        ColeccionPlanVuelo planVuelo = new ColeccionPlanVuelo();
        ColeccionAeropuerto aeropuerto = new ColeccionAeropuerto();

        GrafoAeropuerto<Integer> grafoAeropuerto = new GrafoAeropuerto<Integer>();

        leerAeropuertos(aeropuerto, grafoAeropuerto);

        // Inicializar arreglos de vuelo     
        leerVuelos(aeropuerto, planVuelo, grafoAeropuerto);

        Paquete paquete = new Paquete(aeropuerto.BuscarId("SKBO"),aeropuerto.BuscarId("LPPT"), 1, 5, 1);
        
//        grafoAeropuerto.imprimirGrafo();
        //////////////////////////////////////////////////////////////////


        //////////////////////////////////////////////////////////////////
        /* Crear la población inicial 
         */
        Poblacion poblacion = new Poblacion(cantidad_poblacion, Proporcion_cruce,
                proporcion_elitismo, proporcion_mutacion, grafoAeropuerto, paquete, aeropuerto,planVuelo);

        long tiempoCargaFin = System.currentTimeMillis();
        System.out.println("Tiempo total de carga de datos: "
                + (tiempoCargaFin - tiempoCargaIni)
                + "ms");

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
        //////////////////////////////////////////////////////////////////
        /*Resultados "interesantes" de la simulación
         */
//	System.out.printf("Dato:\t %s\n", aeropuerto.getAeropuertos().get(1).getLugar().getPais());			
        long tiempoEvolFin = System.currentTimeMillis();

        System.out.println("Generacion " /*+ i*/ + ": ");//+ best.getGene());
        System.out.println("Tiempo total de ejecucion: "
                + (tiempoEvolFin - tiempoEvolIni)
                + "ms");
        ///////////////////////////////////////////////////////

    }

    static void leerVuelos(ColeccionAeropuerto aeropuertos, ColeccionPlanVuelo plan_vuelos, GrafoAeropuerto<Integer> grafo) {
        try {
            File homeDir = new File(System.getProperty("user.home"));
            File fileToRead = new File(homeDir, "/Descargas/route-delivery-joe/genetic/src/documentos/planVuelo.txt");
            BufferedReader br = new BufferedReader(new FileReader(fileToRead));

            String str;
            int duracion;

            while ((str = br.readLine()) != null) {

                String[] strs = str.split("-");
                String s_partida = strs[0];
                String s_destino = strs[1];
                String h_ini = strs[2];
                String h_fin = strs[3];
                int hora_ini = Integer.parseInt(h_ini.split(":")[0]);
                int hora_fin = Integer.parseInt(h_fin.split(":")[0]);

                Aeropuerto partida = aeropuertos.Buscar(s_partida);
                if (partida == null) {
                    System.out.println("partida NULL");
                }
                Aeropuerto destino = aeropuertos.Buscar(s_destino);
                if (destino == null) {
                    System.out.println("destino NULL");
                }

                PlanVuelo planVuelo = new PlanVuelo(partida, destino, hora_ini, hora_fin);

                if(!grafo.ExisteRuta(partida.getId(), destino.getId())){ 
                    grafo.agregarArco(partida.getId(),destino.getId(), planVuelo.getDuracion());
                }
  
                //System.out.println(planVuelo.getPartida().getNombre()+"-"+planVuelo.getDestino().getNombre()+"-"+planVuelo.getHora_ini()+"-"+planVuelo.getHora_fin());
                if (planVuelo == null)  System.out.println("vuelos NULL");
                
                plan_vuelos.Add(planVuelo);

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error dentro de lectura Plan de vuelo\n");
        }
    }

    static void leerAeropuertos(ColeccionAeropuerto aeropuertos, GrafoAeropuerto<Integer> grafo) {
        try {
            File homeDir = new File(System.getProperty("user.home"));
            File fileToRead = new File(homeDir, "Descargas/route-delivery-joe/genetic/src/documentos/aeropuertos.txt");
            BufferedReader br = new BufferedReader(new FileReader(fileToRead));

            String str, continente = "";
            int cont = 1, i = 0, indicador=0;
            boolean europa = false;
            while ((str = br.readLine()) != null) {
                if (i == 0) {
                    i++;
                    continue;
                }
                //System.out.println(str);                                
                String[] strs = str.split("\t");
//                System.out.println(strs.length);

                if (strs.length == 2) {
                    continente = strs[1];
                    continente = continente.replace(".", "");
                    continue;
                }
                if (strs.length == 0) {
                    System.out.println("algoritmo.Genetico.leerAeropuertos()");
                    europa = true;
                    continue;
                }
                String pais, ciudad, nombre;
                pais = strs[2];
                ciudad = strs[3];
                nombre = strs[1];
                indicador = Integer.parseInt(strs[0]);
                Lugar lugar = new Lugar(continente, pais, ciudad);
                Aeropuerto aeropuerto = new Aeropuerto(lugar, nombre, 30, indicador,europa);
                aeropuertos.Add(aeropuerto);
                grafo.AgregarVertice(indicador);
                //System.out.println(aeropuerto.toString());                
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error dentro de lectura Aeropuerto\n");
        }
    }

}
