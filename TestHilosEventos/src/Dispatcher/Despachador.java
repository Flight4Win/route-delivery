/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package Dispatcher;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.Timer;
//import testhiloseventos.Paquete;
//
///**
// *
// * @author Diego
// */
//public class Despachador {
//    private Timer _tempo = new Timer();
//    private LocalDateTime _fecha;
//    private ArrayList<Paquete> _paqADespachar = new ArrayList<>();
//    private DateTimeFormatter _formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//    private DespachTask _tarea;
//    private ArrayList<PackageListener> _manejadores = new ArrayList<>();
//    
//    /**
//     * @return the _tempo
//     */
//    public Timer getTempo() {
//        return _tempo;
//    }
//    
//    public Despachador(LocalDateTime fecha){
//        _fecha = fecha;
//    }
//    
//    public void ActivarTimer(){
//        _tarea = new DespachTask(_paqADespachar,_fecha);
//        for(PackageListener pL: _manejadores){
//            _tarea.AgregarManejador(pL);
//        }
//        _tempo.schedule(_tarea, 1000,1000);
//    }
//    
//    public void leerPaquetes(){
//        try {
//            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Diego\\Desktop\\alg_genetico\\genetic\\src\\documentos\\paquetes.txt"));
//            String str;
//            while((str = br.readLine())!=null){                
//                String strFecha = str.split(" ")[1]+" "+str.split(" ")[2];
//                int ciudadIni = Integer.parseInt(str.split(" ")[3]);
//                int ciudadFin = Integer.parseInt(str.split(" ")[4]);
//                int id = Integer.parseInt(str.split(" ")[0]);
//                LocalDateTime horaRegistro = LocalDateTime.parse(strFecha, _formateador);
//                //Date fecha = convertirHora(fechaString);                
//                Paquete p = new Paquete(ciudadIni, ciudadFin,horaRegistro.getHour(),id ,horaRegistro);
//                //System.out.println(fecha.getHours());
//                _paqADespachar.add(p);
//            }
//        }catch(Exception e){
//            System.out.println("error al leer paquetes");
//        }
//    }
//    
//    public void AgregarManejador(PackageListener manejador){
//        _manejadores.add(manejador);
//    }
//}
