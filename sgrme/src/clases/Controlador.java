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

/**
 *
 * @author Diego
 */
public class Controlador{
    private static ColeccionPlanVuelo _planVuelos = new ColeccionPlanVuelo();
    private static ColeccionAeropuerto _aeropuertos = new ColeccionAeropuerto();
    private static GrafoAeropuerto<Integer> _grafoAeropuerto = new GrafoAeropuerto<>();
    private static TemporizadorAplicacion _tempo;
    private static Patrones _patrones;
    private static AlgGenetico _genetico;
    private static ArrayList<Paquete> _paquetes = new ArrayList<>();
    
    public Controlador(){}
    
    public static void IniControlador(){
        leerAeropuertos(_aeropuertos, _grafoAeropuerto);
        leerHusoHorario(_aeropuertos);
        leerVuelos(_aeropuertos, _planVuelos, _grafoAeropuerto);
        _patrones = new Patrones(_grafoAeropuerto);
        AlgGenetico _genetico = new AlgGenetico(_planVuelos, _patrones, _grafoAeropuerto);
        
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String strFecha = "2016-10-30 01:00:00";
        LocalDateTime horaInicio = LocalDateTime.parse(strFecha,formateador);
        TemporizadorAplicacion tempo = new TemporizadorAplicacion(horaInicio, _planVuelos);
        tempo.ActivarTimer();
    }
    
    public static boolean EjecutarAlgoritmo(Paquete p){
        ArrayList<ArrayList<PlanVuelo>> rutas = _patrones.getPatrones((Integer)p.getPartida(),(Integer)p.getDestino(),p.getMaximaDuracion(),p.getHoraEntrega(),_planVuelos);
        p.setRutas(rutas);
        return _genetico.ejecutarAlgGenetico(_grafoAeropuerto,_aeropuertos,_paquetes, p, rutas, p.getHoraEntrega());   
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
            String ruta = Controlador.class.getResource("/documentos/planVuelo.txt").getPath();
            
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
            //obteniendo ruta relativa
            String ruta = Controlador.class.getResource("/documentos/aeropuertos.txt").getPath(); 

            
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
                    //System.out.println("algoritmo.Genetico.leerAeropuertos()");
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
            //obteniendo ruta relativa
            String ruta = Controlador.class.getResource("/documentos/HusoHorario.txt").getPath();             
            
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
