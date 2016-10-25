/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import clases.Paquete;
import clases.PlanVuelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 *
 * @author Diego
 */
public class AlgGenetico {
    private static final int NUMITERACIONES = 50;
    private static final int SINDURACION = 1000;
    private ArrayList<PlanVuelo> _planesVuelo;
    private Patrones _patrones;
    
    public AlgGenetico(ArrayList<PlanVuelo> planesVuelo, Patrones patrones){
        _planesVuelo = planesVuelo;
        _patrones = patrones;
    }
    
    public boolean ejecutarAlgGenetico(Paquete paquete, ArrayList<ArrayList<PlanVuelo>> solInicial, int horaRegistro){
        
        
        ArrayList<ArrayList<PlanVuelo>> cromosomas = (ArrayList<ArrayList<PlanVuelo>>)solInicial.clone();
        //System.out.println(cromosomas);
        int tamanho = cromosomas.size();
        HashMap<Integer,ArrayList<PlanVuelo>> fitness = new HashMap<>();
        for(int i = 0; i < NUMITERACIONES; i++){
            //ArrayList<ArrayList<Integer>> hijos = cruzarCromosomas(cromosomas);
            ArrayList<ArrayList<PlanVuelo>> hijos = (ArrayList<ArrayList<PlanVuelo>>)cromosomas.clone();
            
            //hijos.addAll(cromosomas);
            fitness = calcularFitness(hijos,horaRegistro);
            ordenarPorFitness(fitness);
            cromosomas = new ArrayList (hijos.subList(0, tamanho-1));
            //System.out.println("crom: "+cromosomas);
        }
        //System.out.println(cromosomas); 
        //System.out.println(fitness);
        ArrayList<Integer> valores = new ArrayList<>(fitness.keySet());
        Collections.sort(valores);
        
        //boolean haySolucion = false;
        for(int j=0; j<valores.size();j++){
            ArrayList<PlanVuelo> solucion = fitness.get(valores.get(j));
            boolean solAceptable = true;
            for (PlanVuelo solucion1 : solucion) {
                if (solucion1.getCapacidadOcupada() == solucion1.getCapacidad()) {
                    solAceptable = false;
                    break;
                }
            }
            if(solAceptable){
                for (PlanVuelo planI : solucion) {
                    planI.getPaquetes().add(paquete);
                    planI.setCapacidadOcupada(planI.getCapacidadOcupada() + 1);
                    planI.getPartida().getPaquetesPorSalir().add(paquete);
                    planI.getPartida().setCapacidadOcupada(planI.getPartida().getCapacidadOcupada()+1);
                    planI.getDestino().getPaquetesPorLlegar().add(paquete);  
                    planI.getDestino().setCapacidadOcupada(planI.getDestino().getCapacidadOcupada()+1);
                }
                paquete.setRuta(solucion);                
                //haySolucion = true;
                return true;
            }
        }
        return false;
        
        
        /*
        en lugar de devolver el primer valor se debería revisar si es que hay capacidad
        si no hay, revisar la sgte posible solución, así hasta llenar todos los posibles
        soluciones. Si es que ninguna tiene, revisar cuál paquete se puede sacar
        */
        //imp(solucion);
        //  return solucion;
        //return new ArrayList<>();
        
    }
    
    private void imp(ArrayList<PlanVuelo> solucion){
        String camino = "";
        camino += solucion.get(0).getPartida().getId() +" -> "+solucion.get(0).getDestino().getId();
        if(solucion.size()>1){
            for(int i=1; i<solucion.size();i++){
                camino += " -> " + solucion.get(i).getDestino().getId();
            }
        }
        System.out.println(camino);
    }
    
    //antiguo
    //aqui va ejecutarAlgoritmo2
    
    private void imprimirSolucion(ArrayList<Integer> solucion, Paquete paquete){        
        int tamanho = solucion.size();
        for(int i=0; i<tamanho-1;i++){
            int ciudadIni = solucion.get(i);
            int ciudadFin = solucion.get(i+1);
            for(PlanVuelo p: _planesVuelo){
                if((p.getPartida().getId()==ciudadIni)&&
                    (p.getDestino().getId()==ciudadFin)){
                    System.out.println();
                }
            }
        }
    }
    
    private ArrayList<ArrayList<Integer>> cruzarCromosomas(ArrayList<ArrayList<Integer>> cromosomas){
        /*
        Version preliminar, falta que se verifique que los cromosomas
        son válidos para hacer el cruce
        */
        int tamanho = cromosomas.size();
        ArrayList<ArrayList<Integer>> hijos = new ArrayList<>();
        for(int i=0; i<tamanho/2; i++){
                ArrayList<Integer> cromosoma1 = cromosomas.get(i);
                ArrayList<Integer> cromosoma2 = cromosomas.get(tamanho/2 + i);
                int tamCrom1 = cromosoma1.size();
                int tamCrom2 = cromosoma2.size();
                ArrayList<Integer> hijo1 = new ArrayList<>(cromosoma1.subList(0,tamCrom1/2)) ;
                hijo1.addAll(cromosoma2.subList(tamCrom2/2,tamCrom2));
                ArrayList<Integer> hijo2 = new ArrayList<>(cromosoma2.subList(0,tamCrom2/2));
                hijo2.addAll(cromosoma1.subList(tamCrom1/2,tamCrom1));
                hijos.add(hijo1);
                hijos.add(hijo2);
        }
        return hijos;
    }
    
    private int horasEntreLlegadaPrimeraSalida2(int horaRegistro, PlanVuelo planVuelo){
        int horas=0;        
        int horaPartida = planVuelo.getHora_ini();
        if(horaRegistro > horaPartida ){
            horas += 24 - horaRegistro + horaPartida;
        }else{
            horas += horaPartida - horaRegistro;
        }                       
        return horas;
    }
    
    private HashMap<Integer, ArrayList<PlanVuelo>> calcularFitness(ArrayList<ArrayList<PlanVuelo>> cromosomas,int horaRegistro){

        HashMap<Integer,ArrayList<PlanVuelo>> arrFitness = new HashMap();
        
        for( ArrayList<PlanVuelo> cromosoma : cromosomas ){
            int fitness = 0;
            
            fitness += horasEntreLlegadaPrimeraSalida2(horaRegistro, cromosoma.get(0));
            //fitness += horasEntreLlegadaPrimeraSalida(horaRegistro,cromosoma.get(0), cromosoma.get(1));
            
            for(int i=0; i<cromosoma.size()-1; i++){
                PlanVuelo partida, llegada;

                partida = cromosoma.get(i);
                llegada = cromosoma.get(i+1);
                
                fitness += partida.getDuracion();                
                //fitness += buscarDuracion(partida, llegada);
                if(i!=0){
                    PlanVuelo partidaAnterior=cromosoma.get(i-1);
                    PlanVuelo llegadaAnterior=cromosoma.get(i);
                    fitness += horasEntreVuelos2(partidaAnterior, llegadaAnterior);
                    //fitness += horasEntreVuelos(partida,llegada,partidaAnterior,llegadaAnterior);
                }
            }
            //ya se tiene el fitness del cromosoma
            arrFitness.put(fitness,cromosoma );

        }
        return arrFitness;
    }
    
    public int horasEntreLlegadaPrimeraSalida(int horaRegistro, int ciudadPartida, int ciudadDestino){
        for(PlanVuelo planVuelo : _planesVuelo){
            if((planVuelo.getPartida().getId() == ciudadPartida)&&
                (planVuelo.getDestino().getId() == ciudadDestino) &&
                 (planVuelo.getHora_ini()>=horaRegistro)){
                return planVuelo.getHora_ini() - horaRegistro;			
            }
        }
        return 1000;
    }
    
    public int buscarDuracion(int ciudadPartida, int ciudadDestino){
        for(PlanVuelo planVuelo : _planesVuelo){
            if((planVuelo.getPartida().getId() == ciudadPartida)&&
                (planVuelo.getDestino().getId() == ciudadDestino)){
                return planVuelo.getDuracion();			
            }
        }
        return SINDURACION;
    }
    
    private void ordenarPorFitness(HashMap<Integer,ArrayList<PlanVuelo>> fitness){
        ArrayList<Integer> valores = new ArrayList<>(fitness.keySet());
        Collections.sort(valores);
        HashMap<Integer,ArrayList<PlanVuelo>> nuevoFitness = new HashMap<>();
        for(int llave: valores){
            nuevoFitness.put(llave, fitness.get(llave));
        }
        fitness = nuevoFitness;
    }
    
    private int horasEntreVuelos2(PlanVuelo inicio, PlanVuelo destino){
        int diferenciaVuelo = 0;
        
        int horaFin = inicio.getHora_fin();
        int horaInicio = destino.getHora_ini();
        
        if(horaFin > horaInicio){
            diferenciaVuelo += 24 - horaFin + horaInicio;
        }else{
            diferenciaVuelo += horaFin - horaInicio;
        }
        
        return diferenciaVuelo;
    }
    
    private int horasEntreVuelos(int ciudadPartida, int ciudadDestino,int ciudadPartidaAnt, int ciudadDestinoAnt){
        int horaSalida = 0;
        int horaLlegada = 0;        
        
        for(PlanVuelo planVuelo : _planesVuelo){
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
}
