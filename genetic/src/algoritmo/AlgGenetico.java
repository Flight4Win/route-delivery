/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

import clases.Paquete;
import clases.PlanVuelo;
import data.ColeccionPlanVuelo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Diego
 */
public class AlgGenetico {
    private static final int NUMITERACIONES = 2;
    private static final int SINDURACION = 1000;
    private ColeccionPlanVuelo _planesVuelo;
    private Patrones _patrones;
    private GrafoAeropuerto _grafo;
    
    public AlgGenetico(ColeccionPlanVuelo planesVuelo, Patrones patrones, GrafoAeropuerto grafo){
        _planesVuelo = planesVuelo;
        _patrones = patrones;
        _grafo=grafo;
    }
    
    /*
    Ejecuta el algoritmo genético para un paquete.
    */
    public boolean ejecutarAlgGenetico(Paquete paquete, 
            ArrayList<ArrayList<PlanVuelo>> solInicial, int horaRegistro){
                
        ArrayList<ArrayList<PlanVuelo>> cromosomas = new ArrayList<>();
        cromosomas.addAll(solInicial);
        Set<ArrayList<PlanVuelo>> hs = new HashSet<>();
        hs.addAll(cromosomas);
        cromosomas.clear();
        cromosomas.addAll(hs);
        
        for(ArrayList<PlanVuelo> p: cromosomas) imp(p);
        //System.out.println(cromosomas);
        int tamanho = cromosomas.size();
        HashMap<Integer,ArrayList<PlanVuelo>> fitness = new HashMap<>();
        for(int i = 0; i < NUMITERACIONES; i++){
            //ArrayList<ArrayList<Integer>> hijos = cruzarCromosomas(cromosomas);
            ArrayList<ArrayList<PlanVuelo>> hijos = new ArrayList<>();
            hijos = Mutacion(cromosomas);
            /*for(ArrayList<PlanVuelo> p: cromosomas) imp(p);
            System.out.println("-----------");
            for(ArrayList<PlanVuelo> p: hijos) imp(p);
            System.out.println("-----------");*/
            hijos.addAll(cromosomas);                    
            
            //hijos.addAll(cromosomas);
            fitness = calcularFitness(hijos,horaRegistro);
            ordenarPorFitness(fitness);            
            cromosomas = new ArrayList (hijos.subList(0, tamanho));
            //System.out.println("crom: "+cromosomas);
        }
        //System.out.println(cromosomas); 
        //System.out.println(fitness);
        ArrayList<Integer> valores = new ArrayList<>(fitness.keySet());
        Collections.sort(valores);
        
        //se revisa si hay un vuelo con capacidad suficiente
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
                    planI.getPartida().setCapacidadOcupada(
                            planI.getPartida().getCapacidadOcupada()+1);
                    planI.getDestino().getPaquetesPorLlegar().add(paquete);  
                    planI.getDestino().setCapacidadOcupada(
                            planI.getDestino().getCapacidadOcupada()+1);
                }
                paquete.setRuta(solucion);
                paquete.setDuracionViaje(valores.get(j));
                //haySolucion = true;
                System.out.println("Se encontro solucion");
                return true;
            }
        }
        
        //no se encontro vuelo con capacidad suficiente
        //se revisa que paquete se puede rerutear
        for(int i=0; i<valores.size();i++){
            ArrayList<PlanVuelo> solucion = fitness.get(valores.get(i));
            ArrayList<Paquete> paquetesARerutear = new ArrayList<>();      
            
            //contiene los planes de vuelo que tienen capacidad                        
            ArrayList<PlanVuelo> planesConCapacidad = new ArrayList<>();
            
            for(PlanVuelo planVuelo: solucion){
                //planVuelo.getPaquetes();                
                if(planVuelo.getCapacidadOcupada() == planVuelo.getCapacidad()){
                    ArrayList<Paquete> paquetes = planVuelo.getPaquetes();
                    //CAMBIAR POR COLA DE PRIORIDAD!!!!!!!!!
                    Paquete paqueteARerutear = ObtenerPaqueteReruteo(paquetes);
                    paqueteARerutear.setDuracionViaje(-1);
                    for(PlanVuelo plan: paqueteARerutear.getRuta()){
                        plan.getPaquetes().remove(paqueteARerutear);
                    }
                    paqueteARerutear.setRuta(null);                    
                    paquetesARerutear.add(paqueteARerutear);
                    
                }else{
                    planesConCapacidad.add(planVuelo);      
                }
            }
            for(Paquete paqReruteo: paquetesARerutear){                
                _patrones.getPatrones((Integer)paqReruteo.getPartida(),
                        (Integer)paqReruteo.getDestino(),
                        paqReruteo.getMaximaDuracion(),paquete.getHoraEntrega(),
                        _planesVuelo);
            }
            for(PlanVuelo plan: planesConCapacidad){
                plan.getPaquetes().add(paquete);
                plan.setCapacidadOcupada(plan.getCapacidadOcupada()+1);
            }
            paquete.setRuta(solucion);
            paquete.setDuracionViaje(valores.get(i));
        }
        System.out.println("No se pudo encontrar ruta, el sistema se ha caido");
        return false;
                
        //imp(solucion);
        //  return solucion;
        //return new ArrayList<>();
        
    }
    
    private ArrayList<ArrayList<PlanVuelo>> Mutacion(ArrayList<ArrayList<PlanVuelo>> cromosomas){
        ArrayList<ArrayList<PlanVuelo>> hijos = new ArrayList<>();
        for(ArrayList<PlanVuelo> cromosoma : cromosomas){
            if(cromosoma.size() > 1) {
                int posMutacion = ThreadLocalRandom.current().nextInt(0,cromosoma.size());
                PlanVuelo p = cromosoma.get(posMutacion);
                //int ciudad = p.getDestino().getId();
                int ciudad;
                boolean muto = false;
                ArrayList<PlanVuelo> hijo = new ArrayList<>(cromosoma);
                if((posMutacion+1) == cromosoma.size()){
                    ciudad = p.getPartida().getId();
                    ArrayList<PlanVuelo> a = _grafo.VerticesA(p.getDestino().getId());
                    ArrayList<PlanVuelo> b = _grafo.ArcosDesde(cromosoma.get(posMutacion-1).getPartida().getId());                    
                    for(PlanVuelo p1 : b){
                        for(PlanVuelo p2 : a){
                            if((p2.getDestino().getId()==p1.getPartida().getId())
                                    &&(p2.getDestino().getId()!=ciudad)){
                                hijo.set(posMutacion, p1);
                                hijo.set(posMutacion-1,p2);
                                muto = true;
                                break;
                            }
                        }
                        if(muto) break;
                    }
                }else{
                    ciudad = p.getDestino().getId();
                    ArrayList<PlanVuelo> a = _grafo.VerticesA(cromosoma.get(posMutacion+1).getDestino().getId());
                    ArrayList<PlanVuelo> b = _grafo.ArcosDesde(p.getPartida().getId());
                    
                    for(PlanVuelo p1 : b){
                        for(PlanVuelo p2 : a){
                            if((p2.getDestino().getId()==p1.getPartida().getId())
                                    &&(ciudad!=p2.getDestino().getId())){
                                hijo.set(posMutacion, p2);
                                hijo.set(posMutacion+1,p1);
                                muto = true;
                                break;
                            }
                        }
                        if(muto) break;
                    }
                }
                hijos.add(hijo);
                //_grafo.VerticesA(ciudad);
            }
        }
        return hijos;
    }
    
    private Paquete ObtenerPaqueteReruteo(ArrayList<Paquete> paquetes){
        Paquete paqARerutear = paquetes.get(0);
        int duracionMinima = 50; //ningun vuelo puede durar 50h
        for(Paquete paquete: paquetes){
            if(paquete.getDuracionViaje() < duracionMinima){
                paqARerutear = paquete;
                duracionMinima = paquete.getDuracionViaje();
            }
        }
        return paqARerutear;
    }
    
    private void imp(ArrayList<PlanVuelo> solucion){
        String camino = "";
        camino += solucion.get(0).getPartida().getId() +" ("+solucion.get(0).getHora_ini()+")"+" -> "+
                solucion.get(0).getDestino().getId() ;
        if(solucion.size()>1){
            for(int i=1; i<solucion.size();i++){
                camino += " ("+solucion.get(i).getHora_ini()+")"+" -> " + solucion.get(i).getDestino().getId() +" ("+solucion.get(i).getHora_fin()+")";
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
            for(PlanVuelo p: _planesVuelo.getPlanVuelos()){
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
        for(PlanVuelo planVuelo : _planesVuelo.getPlanVuelos()){
            if((planVuelo.getPartida().getId() == ciudadPartida)&&
                (planVuelo.getDestino().getId() == ciudadDestino) &&
                 (planVuelo.getHora_ini()>=horaRegistro)){
                return planVuelo.getHora_ini() - horaRegistro;			
            }
        }
        return 1000;
    }
    
    public int buscarDuracion(int ciudadPartida, int ciudadDestino){
        for(PlanVuelo planVuelo : _planesVuelo.getPlanVuelos()){
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
        
        for(PlanVuelo planVuelo : _planesVuelo.getPlanVuelos()){
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
