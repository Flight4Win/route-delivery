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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import utiles.Controlador;

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
        
        Controlador.IniControlador();
        //////////////////////////////////////////////////////////////////
        /*Datos iniciales del algoritmo genético
         */
        
        
        final int cantidad_poblacion = 100;
        final int generaciones_maximas = 16384;   

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
        
        leerPaquetes(paquetes,aeropuertos);
        
        Patrones patrones = new Patrones(grafoAeropuerto);
        
        AlgGenetico algoritmo = new AlgGenetico(planVuelos, patrones, grafoAeropuerto);
        long tiempoInicio = System.currentTimeMillis();
        //esto tiene que estar dentro de un for por cada paquete
        //Paquete paquete = new Paquete(aeropuertos.BuscarId("SKBO"),aeropuertos.BuscarId("SEQM"), 1, , 1);
        //Paquete paquete = new Paquete(1,30, 0, 1);
        
        boolean sistemaCaido = false;
        
        for(Paquete paquete: paquetes){
            int tiempo;            
            if(aeropuertos.EsIntercontinental(paquete.getPartida(),paquete.getDestino())){
                tiempo = 48;
            }
            else{
                tiempo = 50;
            }
            paquete.setMaximaDuracion(tiempo);
            ArrayList<ArrayList<PlanVuelo>> r = patrones.getPatrones((Integer)paquete.getPartida(),(Integer)paquete.getDestino(),tiempo,paquete.getHoraEntrega(),planVuelos);
            
            paquete.setRutas(r);
            
            sistemaCaido = !algoritmo.ejecutarAlgGenetico(grafoAeropuerto,aeropuertos,paquetes,paquete,r,paquete.getHoraEntrega(),1);
            
            if(sistemaCaido){
                break;   
            }
                
        }
        long tiempoFin = System.currentTimeMillis();
        System.out.println(tiempoFin - tiempoInicio);
        if(sistemaCaido) System.out.println("Se cayó el sistema general");
    }
    
    static LocalDateTime convertirHora(String fechaString){
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        try{
            LocalDateTime fecha = LocalDateTime.parse(fechaString,formateador);
            return fecha;
        }catch(Exception e){
            return null;
        }
        
    }
    
    static void leerPaquetes(ArrayList<Paquete> paquetes, ColeccionAeropuerto aeropuerto){
        try {
            
            for(Aeropuerto a : Controlador.getAeropuertos().getAeropuertos()){ 
                
                      
                String ruta = Controlador.class.getResource("/dataSimulacion1_2/1arch_"+a.getNombre()+".txt").getPath();
                BufferedReader br = new BufferedReader(new FileReader(ruta));
               
                String str;
               

                while((str = br.readLine())!=null){

                    String primerString = str.split(":")[0];
                    String segundoString = str.split(":")[1];

                    String destino = segundoString.substring(2);
                    String partida = a.getNombre();

                    int id = (int) ((Long.parseLong(primerString) /100000) /100000);

                    int anio = (int) ((Long.parseLong(primerString)/1000000)%10000);
                    int mes = (int) ((Long.parseLong(primerString)/10000) % 100);
                    int dia = (int) ((Long.parseLong(primerString)/100) % 100);
                    int hora = (int) (Long.parseLong(primerString) % 100);
                    int minut =  Integer.parseInt(segundoString.replace(destino,""));

                    String fechaString = anio + "-" + (mes<10?("0"+mes):mes) + "-" + (dia<10?("0"+dia):dia) + " " + 
                                         (hora<10?("0"+hora):hora) + ":" + (minut<10?("0"+minut):minut) + ":" + "00";

                    LocalDateTime fecha = convertirHora(fechaString); 

                    int ciudadIni = aeropuerto.BuscarId(partida);
                    int ciudadFin = aeropuerto.BuscarId(destino);

                    //System.out.println(fechaString);    
                    
                    Paquete p = new Paquete(ciudadIni, ciudadFin,fecha.getHour(),id ,fecha);
                    //System.out.println(fecha.getHours());
                    paquetes.add(p);
                }
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
            String ruta = Controlador.class.getResource("/documentos/planVuelo.txt").getPath();
           // File homeDir = new File(System.getProperty("user.home"));
           // File fileToRead = new File(homeDir, "/Documentos/route-delivery/genetic/src/documentos/planVuelo.txt");
            BufferedReader br = new BufferedReader(new FileReader(ruta)); 
            
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
            String ruta = Controlador.class.getResource("/documentos/aeropuertos.txt").getPath();
           // File homeDir = new File(System.getProperty("user.home"));
           // File fileToRead = new File(homeDir, "/Documentos/route-delivery/genetic/src/documentos/aeropuertos.txt");
            BufferedReader br = new BufferedReader(new FileReader(ruta));
            
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
                float longitud, latitud;
                pais = strs[2];
                ciudad = strs[3];
                nombre = strs[1];                
                indicador = Integer.parseInt(strs[0]);
                longitud = Float.parseFloat(strs[5]);
                latitud = Float.parseFloat(strs[6]);
                Lugar lugar = new Lugar(continente, pais, ciudad);
                Aeropuerto aeropuerto = new Aeropuerto(lugar, nombre, 30, indicador,europa,longitud,latitud);
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
            String ruta = Controlador.class.getResource("/documentos/HusoHorario.txt").getPath();
            //BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Diego\\Documents\\NetBeansProjects\\Algoritmos_DP1\\src\\algoritmos_dp1\\husoHorario.txt"));
            BufferedReader br = new BufferedReader(new FileReader(ruta));

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
