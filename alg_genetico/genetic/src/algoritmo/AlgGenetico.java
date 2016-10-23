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
    
    public AlgGenetico(ArrayList<PlanVuelo> planesVuelo){
        _planesVuelo = planesVuelo;
    }
    
    public ArrayList<Integer> ejecutarAlgGenetico(Paquete paquete, ArrayList<ArrayList<Integer>> solInicial, int horaRegistro){
        if(solInicial.size()==1) {
            //imprimirSolucion(solInicial.get(0),paquete);
            return solInicial.get(0);
        }
        ArrayList<ArrayList<Integer>> cromosomas = (ArrayList<ArrayList<Integer>>)solInicial.clone();
        //System.out.println(cromosomas);
        int tamanho = cromosomas.size();
        HashMap<Integer,ArrayList<Integer>> fitness = new HashMap<>();
        for(int i = 0; i < NUMITERACIONES; i++){
            ArrayList<ArrayList<Integer>> hijos = cruzarCromosomas(cromosomas);
            //System.out.println("hijos: "+hijos);
            hijos.addAll(cromosomas);
            fitness = calcularFitness(hijos,horaRegistro);
            ordenarPorFitness(fitness);
            cromosomas = new ArrayList (hijos.subList(0, tamanho-1));
            //System.out.println("crom: "+cromosomas);
        }
        //System.out.println(cromosomas); 
        //System.out.println(fitness);
        ArrayList<Integer> valores = new ArrayList<>(fitness.keySet());
        Collections.sort(valores);
        ArrayList<Integer> solucion = fitness.get(valores.get(0));
        //imprimirSolucion(solucion,paquete);
        return solucion;
        
    }
    
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
    
    private HashMap<Integer, ArrayList<Integer>> calcularFitness(ArrayList<ArrayList<Integer>> cromosomas,int horaRegistro){

        HashMap<Integer,ArrayList<Integer>> arrFitness = new HashMap();
        
        for( ArrayList<Integer> cromosoma : cromosomas ){
            int fitness = 0;
            fitness+=horasEntreLlegadaPrimeraSalida(horaRegistro,cromosoma.get(0), cromosoma.get(1));
            for(int i=0; i<cromosoma.size()-1; i++){
                int partida, llegada;

                partida = cromosoma.get(i);
                llegada = cromosoma.get(i+1);

                fitness += buscarDuracion(partida, llegada);
                if(i!=0){
                    int partidaAnterior=cromosoma.get(i-1);
                    int llegadaAnterior=cromosoma.get(i);
                    fitness += horasEntreVuelos(partida,llegada,partidaAnterior,llegadaAnterior);
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
    
    private void ordenarPorFitness(HashMap<Integer,ArrayList<Integer>> fitness){
        ArrayList<Integer> valores = new ArrayList<>(fitness.keySet());
        Collections.sort(valores);
        HashMap<Integer,ArrayList<Integer>> nuevoFitness = new HashMap<>();
        for(int llave: valores){
            nuevoFitness.put(llave, fitness.get(llave));
        }
        fitness = nuevoFitness;
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
