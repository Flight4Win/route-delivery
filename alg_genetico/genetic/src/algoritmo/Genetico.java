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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
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
        ColeccionPlanVuelo planVuelos = new ColeccionPlanVuelo();
        ColeccionAeropuerto aeropuertos = new ColeccionAeropuerto();

        GrafoAeropuerto<Integer> grafoAeropuerto = new GrafoAeropuerto<>();

        leerAeropuertos(aeropuertos, grafoAeropuerto);
        leerHusoHorario(aeropuertos);
        
        // Inicializar arreglos de vuelo     
        leerVuelos(aeropuertos, planVuelos, grafoAeropuerto);
        
        ArrayList<Paquete> paquetes = new ArrayList<>();
        
        leerPaquetes(paquetes);
        
        Patrones patrones = new Patrones(grafoAeropuerto);
        
        AlgGenetico algoritmo = new AlgGenetico(planVuelos.getPlanVuelos(), patrones);
        long tiempoInicio = System.currentTimeMillis();
        //esto tiene que estar dentro de un for por cada paquete
        //Paquete paquete = new Paquete(aeropuertos.BuscarId("SKBO"),aeropuertos.BuscarId("SEQM"), 1, , 1);
        //Paquete paquete = new Paquete(1,30, 0, 1);
        for(Paquete paquete: paquetes){
            double tiempo;            
            if(aeropuertos.EsIntercontinental(paquete.getPartida(),paquete.getDestino())){
                tiempo = 48.0;
            }
            else{
                tiempo = 24.0;
            }
            ArrayList<ArrayList<PlanVuelo>> r = patrones.getPatrones((Integer)paquete.getPartida(),(Integer)paquete.getDestino(),tiempo,paquete.getHoraEntrega(),planVuelos);
            //System.out.println(r);
            boolean haySol = algoritmo.ejecutarAlgGenetico(paquete,r,paquete.getHoraEntrega());
            //System.out.println(sol);
        }
        long tiempoFin = System.currentTimeMillis();
        System.out.println(tiempoFin - tiempoInicio);

    }
    
    static Date convertirHora(String fechaString){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try{
            Date fecha = formatter.parse(fechaString);
            return fecha;
        }catch(Exception e){
            return null;
        }
        
    }
    
    static void leerPaquetes(ArrayList<Paquete> paquetes){
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Diego\\Desktop\\alg_genetico\\genetic\\src\\documentos\\paquetes.txt"));
            String str;
            while((str = br.readLine())!=null){                
                String fechaString = str.split(" ")[1]+" "+str.split(" ")[2];
                int ciudadIni = Integer.parseInt(str.split(" ")[3]);
                int ciudadFin = Integer.parseInt(str.split(" ")[4]);
                int id = Integer.parseInt(str.split(" ")[0]);
                Date fecha = convertirHora(fechaString);                
                Paquete p = new Paquete(ciudadIni, ciudadFin,fecha.getHours(),id ,fecha);
                //System.out.println(fecha.getHours());
                paquetes.add(p);
            }
        }catch(Exception e){
            System.out.println("error al leer paquetes");
        }
    }
    
    static int horasEntreLlegadaPrimeraSalida(ColeccionPlanVuelo p, int horaRegistro, int ciudadPartida, int ciudadDestino){
        for(PlanVuelo planVuelo : p.getPlanVuelos()){
            if((planVuelo.getPartida().getId() == ciudadPartida)&&
                (planVuelo.getDestino().getId() == ciudadDestino) &&
                 (planVuelo.getHora_ini()>=horaRegistro)){
                return planVuelo.getHora_ini() - horaRegistro;			
            }
        }
        return 1000;
    }
    static int buscarDuracion(ColeccionPlanVuelo p ,int ciudadPartida, int ciudadDestino){
        
        for(PlanVuelo planVuelo : p.getPlanVuelos()){
            if((planVuelo.getPartida().getId() == ciudadPartida)&&
                (planVuelo.getDestino().getId() == ciudadDestino)){
                return planVuelo.getDuracion();			
            }
        }
        return 100;
    }
    static int horasEntreVuelos(ColeccionPlanVuelo p,int ciudadPartida, int ciudadDestino,int ciudadPartidaAnt, int ciudadDestinoAnt){
        int horaSalida = 0;
        int horaLlegada = 0;
        for(PlanVuelo planVuelo : p.getPlanVuelos()){
            if((planVuelo.getPartida().getId() == ciudadPartida)&&
                    (planVuelo.getDestino().getId() == ciudadDestino)){
                    horaSalida = planVuelo.getHora_ini();		
            }
            if((planVuelo.getPartida().getId() == ciudadPartidaAnt)&&
                    (planVuelo.getDestino().getId() == ciudadDestinoAnt)){
                    horaLlegada = planVuelo.getHora_fin();		
            }

        }
        return horaSalida - horaLlegada;
    }
    
    
    
    
    static void leerVuelos(ColeccionAeropuerto aeropuertos, ColeccionPlanVuelo plan_vuelos, GrafoAeropuerto<Integer> grafo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Diego\\Documents\\NetBeansProjects\\Algoritmos_DP1\\src\\algoritmos_dp1\\plan_vuelo.txt"));

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
                int utcPartida = partida.getLugar().getUtc();
                int utcDestino = destino.getLugar().getUtc();
                PlanVuelo planVuelo = new PlanVuelo(partida, destino, hora_ini+utcPartida, hora_fin+utcDestino);

            //    if(!grafo.ExisteRuta(partida.getId(), destino.getId())){ 
                    grafo.agregarArco(partida.getId(),destino.getId(), planVuelo);
              //  }
  
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
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Diego\\Documents\\NetBeansProjects\\Algoritmos_DP1\\src\\algoritmos_dp1\\aeropuertos.txt"));

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
}
