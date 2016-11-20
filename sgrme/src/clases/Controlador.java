/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import algoritmo.AlgGenetico;
import algoritmo.GrafoAeropuerto;
import algoritmo.Patrones;
import data.ColeccionAeropuerto;
import data.ColeccionPlanVuelo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import Temporizador.TemporizadorAplicacion;
import utilitario.Factory;
import utilitario.Helper;

/**
 *
 * @author Diego
 */
public class Controlador{
    private static ColeccionPlanVuelo _planVuelos = new ColeccionPlanVuelo();
    private final static ColeccionAeropuerto _aeropuertos = new ColeccionAeropuerto();
    private final static GrafoAeropuerto<Integer> _grafoAeropuerto = new GrafoAeropuerto<>();
    private static TemporizadorAplicacion _tempo;
    private static Patrones _patrones;
    private static AlgGenetico _genetico;
    private static ArrayList<Paquete> _paquetes = new ArrayList<>();

    /**
     * @return the _tempo
     */
    public static TemporizadorAplicacion getTempo() {
        return _tempo;
    }

    /**
     * @return the _aeropuertos
     */
    public static ColeccionAeropuerto getAeropuertos() {
        return _aeropuertos;
    }


    /**
     * @return the _planVuelos
     */
    public static ColeccionPlanVuelo getPlanVuelos() {
        return _planVuelos;
    }

    
    public Controlador(){}
    
    public static void IniControlador(){
        leerAeropuertos(_aeropuertos, _grafoAeropuerto);
        leerHusoHorario(_aeropuertos);
        leerVuelos(_aeropuertos, getPlanVuelos(), _grafoAeropuerto);
        _patrones = new Patrones(_grafoAeropuerto);
        _genetico = new AlgGenetico(getPlanVuelos(), _patrones, _grafoAeropuerto);
        
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strFecha = "2016-10-30 01:00:00";
        LocalDateTime horaInicio = LocalDateTime.parse(strFecha,formateador);
        TemporizadorAplicacion tempo = new TemporizadorAplicacion(horaInicio, getPlanVuelos());
        tempo.AgregarListener(getPlanVuelos());
        tempo.ActivarTimer();
    }
    
    public static boolean EjecutarAlgoritmo(Paquete p){
        ArrayList<ArrayList<PlanVuelo>> rutas = _patrones.getPatrones((Integer)p.getPartida(),(Integer)p.getDestino(),p.getMaximaDuracion(),p.getHoraEntrega(), getPlanVuelos());
        p.setRutas(rutas);
        return _genetico.ejecutarAlgGenetico(_grafoAeropuerto, getAeropuertos(),_paquetes, p, rutas, p.getHoraEntrega());   
    }
    
    public static void AgregarPaquete(Paquete p){
        _paquetes.add(p);
    }
    
    public static void EliminarPaquete(Paquete p){
        if(!_paquetes.isEmpty()) _paquetes.remove(p);
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
    
    static void leerPaquetes(ArrayList<Paquete> paquetes){
        try {
            //obteniendo ruta relativa
            String ruta = Controlador.class.getResource("/documentos/paquetes.txt").getPath();

            BufferedReader br = new BufferedReader(new FileReader(ruta));
            String str;
            while((str = br.readLine())!=null){                
                String fechaString = str.split(" ")[1]+" "+str.split(" ")[2];
                int ciudadIni = Integer.parseInt(str.split(" ")[3]);
                int ciudadFin = Integer.parseInt(str.split(" ")[4]);
                int id = Integer.parseInt(str.split(" ")[0]);
                LocalDateTime fecha = convertirHora(fechaString);                
                Paquete p = new Paquete(ciudadIni, ciudadFin,fecha.getHour(),id ,fecha);
                //System.out.println(fecha.getHours());
                paquetes.add(p);
            }
        }catch(Exception e){
            System.out.println("error al leer paquetes");
        }
    }                            
    
    static void leerVuelos(ColeccionAeropuerto aeropuertos, ColeccionPlanVuelo plan_vuelos, GrafoAeropuerto<Integer> grafo) {
        try {
            //obteniendo ruta relativa
            String ruta = Controlador.class.getResource("/documentos/plan_vuelo.txt").getPath();
            
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

//    static void leerAeropuertos(ColeccionAeropuerto aeropuertos, GrafoAeropuerto<Integer> grafo) {
//        try {
//            //obteniendo ruta relativa
//            String ruta = Controlador.class.getResource("/documentos/aeropuertos.txt").getPath(); 
//
//
//            BufferedReader br = new BufferedReader(new FileReader(ruta));
//
//            String str, continente = "";
//            int cont = 1, i = 0, indicador=0;
//            boolean europa = false;            
//            while ((str = br.readLine()) != null) {
//                if (i == 0) {
//                    i++;
//                    continue;
//                }
//                //System.out.println(str);                                
//                String[] strs = str.split("\t");
//    //                System.out.println(strs.length);
//
//                if (strs.length == 2) {
//                    continente = strs[1];
//                    continente = continente.replace(".", "");
//                    continue;
//                }
//
//
//
//                if (strs.length == 0) {
//                    //System.out.println("algoritmo.Genetico.leerAeropuertos()");
//                    europa = true;
//                    continue;
//                }
//                String pais, ciudad, nombre;
//                double longitud, latitud;
//                pais = strs[2];
//                ciudad = strs[3];
//                nombre = strs[1];                
//                indicador = Integer.parseInt(strs[0]);
//                longitud = Double.parseDouble(strs[5]);
//                System.out.println(longitud);
//                latitud = Double.parseDouble(strs[6]);
//                Lugar lugar = new Lugar(continente, pais, ciudad);
//                Aeropuerto aeropuerto = new Aeropuerto(lugar, nombre, 30, indicador,europa,longitud,latitud);
//                aeropuertos.Add(aeropuerto);
//                grafo.AgregarVertice(indicador);
//                //System.out.println(aeropuerto.toString());                
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("error dentro de lectura Aeropuerto\n");
//        }
//    }
    
    static void leerAeropuertos(ColeccionAeropuerto aeropuertos, GrafoAeropuerto<Integer> grafo){
        
        try {
            //obteniendo ruta relativa
            String ruta = Controlador.class.getResource("/documentos/aeropuertos.txt").getPath(); 

            BufferedReader br = new BufferedReader(new FileReader(ruta));

            br.readLine(); // se lee primera linea OACI

            String str;

            boolean leo_continente = true; //leo un continente


            while((str=br.readLine())!=null){

                String[] splited = str.split("\\s+");
                String continente = "";               
                String indicador;
                String nombre;
                String ciudad;
                String pais;
                String temp;
                String longitud;
                String latitud;

                if(leo_continente){
                    StringBuilder strbld = new StringBuilder(splited[0]);
                    for(int i =1 ; i<splited.length;i++){
                        strbld = strbld.append(" ");
                        strbld.append(splited[i]);
                    }
                    continente = strbld.toString();
                    leo_continente = false;
                }else if(splited.length>0){

                    indicador = splited[0];
                    nombre = splited[1];
                    pais = splited[splited.length-4];
                    temp = splited[splited.length-3];
                    longitud = splited[splited.length-2];
                    latitud = splited[splited.length-1];

                    StringBuilder strbld = new StringBuilder(splited[2]);
                    for(int i = 3;i<splited.length-4;i++){
                        strbld=strbld.append(" ");
                        strbld.append(splited[i]);
                    }
                    ciudad = strbld.toString();
                    boolean europa = false;
                    if(continente.equalsIgnoreCase(Helper.europa)) europa = true;

                     /*inicializo objetos*/
                     int id = Integer.parseInt(indicador);
                     double longi = Double.parseDouble(longitud);
                     double lat = Double.parseDouble(latitud);
                     
                    Lugar lugar = new Lugar(continente, pais, ciudad);
                    Aeropuerto aeropuerto = new Aeropuerto(lugar, nombre, 30, id,europa,(float)longi,(float)lat);
                    aeropuertos.Add(aeropuerto);
                    grafo.AgregarVertice(id);
                }else{
                    leo_continente=true;
                }       
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error dentro de lectura Aeropuerto\n");
        } 
    }
    
    static void leerHusoHorario(ColeccionAeropuerto aeropuertos){
        try{            
            //obteniendo ruta relativa
            String ruta = Controlador.class.getResource("/documentos/HusoHorario.txt").getPath();            
            
            BufferedReader br = new BufferedReader(new FileReader(ruta));           
            String str;
            int i=0;
            while((str=br.readLine())!=null){
                String[] splited = str.split("\\s+");
                
                
                String huso = splited[splited.length-1];
                
                StringBuilder strbld = new StringBuilder(splited[0]);
                
                for(int j = 1;j<splited.length-1;j++){
                    strbld.append(" ");
                    strbld.append(splited[j]);
                }
                
                String ciudad = strbld.toString();
                
                /*obteniendo utc*/
                int utc = Integer.parseInt(huso);
                for(Aeropuerto aero: aeropuertos.getAeropuertos()){
                    if(ciudad.equals(aero.getLugar().getCiudad()) ){
                        aero.getLugar().setUtc(utc);
                        //agregarAeropuertoBD(aero); // agrega lugar y aeropuerto a la base de datos
                        break;
                    }
                }                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /*agregar lugar y aeropuerto a la base de datos*/
    static void agregarAeropuertoBD(Aeropuerto aero){
        
        System.out.println("EN AGREGAR AEROPUERTO");
        Factory.to_LugarEntity(aero.getLugar());
        Factory.to_AeropuertoEntity(aero);
               
    }


}
