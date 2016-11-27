/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utiles;

import Dispatcher.Despachador;
import Dispatcher.PackageListener;
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
import clases.Aeropuerto;
import clases.Lugar;
import clases.Paquete;
import clases.PlanVuelo;
import utiles.Factory;
import utiles.Helper;

/**
 *
 * @author Diego
 */
public class Controlador{
    private static ColeccionPlanVuelo _planVuelos = new ColeccionPlanVuelo();
    private final static ColeccionAeropuerto _aeropuertos = new ColeccionAeropuerto();
    private final static GrafoAeropuerto<Integer> _grafoAeropuerto = new GrafoAeropuerto<>();
    private static TemporizadorAplicacion _tempo;
    private static Despachador _despacher;
    private static Patrones _patrones;
    private static AlgGenetico _genetico;
    private static ArrayList<Paquete> _paquetes = new ArrayList<>();
    private static LocalDateTime _horaInicio;

    /**
     * @return the _despacher
     */
    public static Despachador getDespacher() {
        return _despacher;
    }

    /**
     * @param aDespacher the _despacher to set
     */
    public static void setDespacher(Despachador aDespacher) {
        _despacher = aDespacher;
    }

    /**
     * @return the _grafoAeropuerto
     */
    public static GrafoAeropuerto<Integer> getGrafoAeropuerto() {
        return _grafoAeropuerto;
    }

    /**
     * @return the _paquetes
     */
    public static ArrayList<Paquete> getPaquetes() {
        return _paquetes;
    }

    /**
     * @return the _patrones
     */
    public static Patrones getPatrones() {
        return _patrones;
    }

    /**
     * @return the _genetico
     */
    public static AlgGenetico getGenetico() {
        return _genetico;
    }

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
        leerAeropuertos(_aeropuertos, getGrafoAeropuerto());
        leerHusoHorario(_aeropuertos);
        leerVuelos(_aeropuertos, _planVuelos, getGrafoAeropuerto());
        _patrones = new Patrones(getGrafoAeropuerto());
        _genetico = new AlgGenetico(_planVuelos, getPatrones(), getGrafoAeropuerto());
        
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strFecha = "2016-01-01 15:00:00";
        _horaInicio = LocalDateTime.parse(strFecha,formateador);
        _tempo = new TemporizadorAplicacion(_horaInicio, getPlanVuelos());
        _tempo.AgregarListener(_planVuelos);
        //tempo.ActivarTimer();        
        _despacher = new Despachador(LocalDateTime.parse(strFecha,formateador));
        _despacher.AgregarManejador(_tempo);
        /*se encarga de poblar la tabla en segundo plano*/
        LecturaThread hilo_lectura = new LecturaThread();
        hilo_lectura.start();
        
        System.out.println("termino iniControlador");
    }
    
    public static boolean EjecutarAlgoritmo(Paquete p){
        ArrayList<ArrayList<PlanVuelo>> rutas = getPatrones().getPatrones((Integer)p.getPartida(),(Integer)p.getDestino(),p.getMaximaDuracion(),p.getHoraEntrega(), getPlanVuelos());
        p.setRutas(rutas);
        return getGenetico().ejecutarAlgGenetico(getGrafoAeropuerto(), getAeropuertos(), getPaquetes(), p, rutas, p.getHoraEntrega());   
    }
    
    public static void AgregarPaquete(Paquete p){
        getPaquetes().add(p);
    }
    
    public static void EliminarPaquete(Paquete p){
        if(!_paquetes.isEmpty()) getPaquetes().remove(p);
    }                                           
    
    static void leerVuelos(ColeccionAeropuerto aeropuertos, ColeccionPlanVuelo plan_vuelos, GrafoAeropuerto<Integer> grafo) {
        try {
            //obteniendo ruta relativa
            String ruta = Controlador.class.getResource("/documentos/plan_vuelo.txt").getPath();
            
            BufferedReader br = new BufferedReader(new FileReader(ruta));

            String str;
            int duracion;
            int i = 1;

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
                i++; //id secuencial

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
            String continente = "";  

            while((str=br.readLine())!=null){

                String[] splited = str.split("\\s+");
                             
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
                    boolean europa = false;
                    if(continente.trim().equalsIgnoreCase(Helper.europa)){
                        europa = true;
                        ciudad = splited[2];
                        StringBuilder strbld = new StringBuilder(splited[3]);
                        for(int i = 4;i<splited.length-3;i++){
                            strbld=strbld.append(" ");
                            strbld.append(splited[i]);
                        }
                        pais = strbld.toString();        
                        
                    }else{
                        europa = false;
                        
                        pais = splited[splited.length-4];
                        
                        StringBuilder strbld = new StringBuilder(splited[2]);
                        for(int i = 3;i<splited.length-4;i++){
                            strbld=strbld.append(" ");
                            strbld.append(splited[i]);
                        }
                        ciudad = strbld.toString();                                                                        
                    }
                    System.out.println("pais: "+pais+"\t"+"ciudad: "+ciudad+"\t"+"continente: "+continente);
                    indicador = splited[0];
                    nombre = splited[1];
                    temp = splited[splited.length-3];
                    longitud = splited[splited.length-2];
                    latitud = splited[splited.length-1];                    

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
                        break;
                    }
                }                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /*agregar lugar y aeropuerto a la base de datos*/
    static void agregarAeropuertoBD(){
        System.out.println("EN AGREGAR AEROPUERTO"); 
        
        ArrayList<Aeropuerto> aeropuertos = _aeropuertos.getAeropuertos();
        
        for(Aeropuerto aero: aeropuertos){
            Factory.to_LugarEntity(aero.getLugar());
            Factory.to_AeropuertoEntity(aero);            
        }            
    }
    
    /*agregar plan de vuelo a la bd*/
    static void agregarPlanVueloBD(){
        System.out.println("EN AGREGAR PLAN DE VUELO");
        
        ArrayList<PlanVuelo> planVuelos = _planVuelos.getPlanVuelos();
        
        int id = 1;
        
        for(PlanVuelo planvuelo : planVuelos){
            Factory.to_PlanVueloEntity(planvuelo,id);
            id++;
        }
       
    }
    
    
    /*Hilo encargado de poblar las tablas lugar, aeropuerto, planes.*/
    private static class LecturaThread extends Thread {

    public void run(){
        while(!Helper.tablas_leidas){    //si se coloca en true, las tablas ya han sido leidas saltandose todas las demas lecturas.
            //agregarAeropuertoBD();
            //agregarPlanVueloBD();  
        }
        Helper.tablas_leidas=true; // al finalizar se coloca en true.
    }
  }


}
