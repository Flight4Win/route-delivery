/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;
import algoritmo.Patrones;
import clases.Aeropuerto;
import clases.Paquete;
import clases.PlanVuelo;
import data.ColeccionAeropuerto;
import data.ColeccionPlanVuelo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;



/**
 *
 * @author Diego
 */
public class AlgGenetico {
    static final int TOTAL_RERUTEAR = 3;
    static final double PORCENTAJE = 0.8;
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
    public boolean ejecutarAlgGenetico(GrafoAeropuerto<Integer> grafo, 
                                     ColeccionAeropuerto aeropuertos,
                                     ArrayList<Paquete> coleccionPaquetes,
                                     Paquete paquete,
                                     ArrayList<ArrayList<PlanVuelo>> solInicial, 
                                     int horaRegistro){
        
        ArrayList<ArrayList<PlanVuelo>> cromosomas = new ArrayList<>();
        cromosomas.addAll(solInicial);
        Set<ArrayList<PlanVuelo>> hs = new HashSet<>();
        hs.addAll(cromosomas);
        cromosomas.clear();
        cromosomas.addAll(hs);

        //for(ArrayList<PlanVuelo> p: cromosomas) imp(p);
        //System.out.println(cromosomas);

        int tamanho = cromosomas.size();
        
        HashMap<Integer,ArrayList<PlanVuelo>> fitness = new HashMap<>();
        
        for(int i = 0; i < NUMITERACIONES; i++){
  
            ArrayList<ArrayList<PlanVuelo>> hijos = new ArrayList<>();
            hijos = Mutacion(cromosomas);
           
            hijos.addAll(cromosomas);                    
        
            fitness = calcularFitness(hijos,horaRegistro);
            ordenarPorFitness(fitness);
            cromosomas = new ArrayList (hijos.subList(0, tamanho));

        }
        
        ArrayList<Integer> valores = new ArrayList<>(fitness.keySet());
        Collections.sort(valores);
        if(valores.size()==0){
            System.out.println("fitness de tamaño = " + fitness.size());
        }
       
        
        //se revisa si hay un vuelo con capacidad suficiente
        if(insertarVueloConFitness(valores,fitness,paquete)) return true;

        //RE-RUTEO
        return reruteoPorCategoria(grafo,aeropuertos,coleccionPaquetes,paquete,fitness,valores,paquete.getFechaRegistro());
        
        
    }
    
    private boolean insertarVuelo(ArrayList<PlanVuelo> solucion, Paquete paquete) {
       
        boolean solAceptable = true;
        
        for (PlanVuelo vuelo : solucion) {
                
            //Busca problemas en plan de vuelo
            if (vuelo.getCapacidadOcupada() == vuelo.getCapacidad()) {
                solAceptable = false;
                break;
            }

            //Busca problemas en aeropuerto
            if(vuelo.getDestino().CapacidadHoraX(vuelo.getHora_fin())>=vuelo.getDestino().getCapacidad()) {
                solAceptable=false;
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
            paquete.setRutaOficial(solucion);
         //   paquete.setDuracionViaje(valores.get(j));
            //haySolucion = true
            imp(solucion);
            //System.out.println("Se encontro solucion");

            return true;
        }
        
        return false;
    }
    
    private boolean insertarVueloConFitness(ArrayList<Integer> valores, HashMap<Integer, ArrayList<PlanVuelo>> fitness, Paquete paquete) {
        for(int j=0; j<valores.size();j++){
            ArrayList<PlanVuelo> solucion = fitness.get(valores.get(j));
            boolean solAceptable = true;
            for (PlanVuelo solucion1 : solucion) {
                
                //Busca problemas en plan de vuelo
                if (solucion1.getCapacidadOcupada() == solucion1.getCapacidad()) {
                    solAceptable = false;
                    break;
                }
                
                //Busca problemas en aeropuerto
                if(solucion1.getDestino().CapacidadHoraX(solucion1.getHora_fin())>=solucion1.getDestino().getCapacidad()) {
                    solAceptable=false;
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
                paquete.setRutaOficial(solucion);
                paquete.setDuracionViaje(valores.get(j));
                //haySolucion = true
                imp(solucion);
                //System.out.println("Se encontro solucion");
                
                return true;
            }
        }
        return false;
    }


    private boolean reruteoPorCategoria(GrafoAeropuerto<Integer> grafo, ColeccionAeropuerto aeropuertos, 
                    ArrayList<Paquete> coleccionPaquetes, Paquete paquete,
                    HashMap<Integer, ArrayList<PlanVuelo>> fitness, 
                    ArrayList<Integer> valores, LocalDateTime horaRegistro) {
        boolean solucion;
        
        for(int i=0; i<valores.size(); i++){ //por cada una de sus soluciones optimizadas
        
            solucion = false;
            
            ArrayList<PlanVuelo> vuelosConflictivos = new ArrayList<>();
            ArrayList<PlanVuelo> vuelosDeAeropuertosConflic = new ArrayList<>();
            
            buscarConflictosRuta(grafo,aeropuertos,fitness.get(valores.get(i)),
                                                paquete,vuelosConflictivos,vuelosDeAeropuertosConflic);
            
            solucion = SolucionarProblemaDeCapacidad(grafo,vuelosConflictivos,
                                                    vuelosDeAeropuertosConflic,
                                                    coleccionPaquetes,
                                                    fitness.get(valores.get(i)),
                                                    paquete);
            
            if(solucion){
                if(!insertarVuelo(fitness.get(valores.get(i)), paquete))
                    continue;
                
                return true;
            }
        }
        
        System.out.println("No logró rerutear");
        return false;
                
        //imp(solucion);
        //  return solucion;
        //return new ArrayList<>();
    }
    
    private boolean SolucionarProblemaDeCapacidad(GrafoAeropuerto<Integer> grafo,
                                                  ArrayList<PlanVuelo> vuelosConflictivos,
                                                  ArrayList<PlanVuelo> vuelosDeAeroConflic,
                                                  ArrayList<Paquete> coleccionPaquetes,
                                                  ArrayList<PlanVuelo> PosibleRutaOficial,
                                                  Paquete paquete) {
        
        ArrayList<Paquete> paquetesDelVuelo = new ArrayList<>();
        boolean contieneVuelo = false;
        int contador = 0;
        /*
        Set<Paquete> hs = new HashSet<>();
        
        
        for(PlanVuelo vuelo: vuelosConflictivos){                                             
            hs.addAll(vuelo.getPaquetes());            
        }
        paquetesDelVuelo.addAll(hs);
        */
        for(PlanVuelo vuelo: vuelosConflictivos){ //Por cada vuelo conflictivo de la ruta

            boolean encontroSolucion = false;
            
            int partida = vuelo.getPartida().getId();
            
            ArrayList<Paquete> conjuntoDePaquetes = new ArrayList<>(vuelo.getPaquetes());
            
            
            for(Paquete paqueteVuelo: conjuntoDePaquetes){//Tomar paquetes del vuelo conflictivo

                int inicio = paqueteVuelo.getPartida();     
                int tiempo = paqueteVuelo.getMaximaDuracion();
                int horaSegunPosicion = paquete.getHoraEntrega();

                //calcular el tiempo y la hora la ubicación de partida deseada
                for(PlanVuelo planPaquete: paqueteVuelo.getRutaOficial()){

                    if(planPaquete.getPartida().getId()==partida) break; //salida

                    //del aeropuerto
                    int espera = 24-(tiempo - planPaquete.getHora_ini());
                    int esperaConVuelo = planPaquete.getDuracion() + espera;
                    tiempo = tiempo - esperaConVuelo;

                    //del vuelo
                    horaSegunPosicion = planPaquete.getHora_fin();
                }

                //realizar DFS de ese aeropuerto a su destino final
                ArrayList<ArrayList<PlanVuelo>> patrones = new ArrayList<ArrayList<PlanVuelo>>();
                this._patrones.DFS(inicio, paqueteVuelo.getDestino(), inicio, patrones,new ArrayList<PlanVuelo>(),new ArrayList<PlanVuelo>(), 1 ,tiempo,horaSegunPosicion, grafo, true);

                //liberar espacio de vuelos 
                int destinoN;
                int partidaN;
                boolean encontroInicio = false;
                for(PlanVuelo viaje: PosibleRutaOficial){//eliminar paquete del camino parcial

                    if(encontroInicio || viaje.getPartida().getId()== partida){
                        encontroInicio = true;
                        destinoN = viaje.getDestino().getId();
                        partidaN = viaje.getPartida().getId();

                        //Eliminar paquete del vuelo
                        viaje.eliminarPaquete(paqueteVuelo);
                        viaje.setCapacidadOcupada(viaje.getCapacidadOcupada()-1);

                        //Eliminar paquete de los aeropuertos (en paquetes por llegar)
                        viaje.getDestino().getPaquetesPorLlegar().remove(paqueteVuelo);
                    }
                }

                // Probar soluciones del DFS
                 encontroSolucion = false;
                for(ArrayList<PlanVuelo> ruta: patrones){//solucion parcial del paquete
                    boolean contieneConflicto = false;

                    for(PlanVuelo vueloPatron:ruta){
                        if(vuelosConflictivos.contains(vueloPatron)){//si tiene conflicto de ruta
                            contieneConflicto = true;
                            break;
                        }
                        if(vuelosDeAeroConflic.contains(vueloPatron)){//si tiene conflicto de capacidad indirecta
                            contieneConflicto = true;
                            break;
                        }
                    }
                    if(!contieneConflicto){
                        //ListaDeNuevaRuta.add(ruta);
                        if(ReruteoPorCapacidadAvion(paqueteVuelo,ruta)){
                            encontroSolucion = true;     

                            //Modificar ruta oficial
                            ArrayList<PlanVuelo> nuevaRuta = new ArrayList<>();
                            for(PlanVuelo viaje: PosibleRutaOficial){
                                if(viaje.getPartida().getId()== partida)
                                    break;
                                else
                                    nuevaRuta.add(viaje);
                            }
                            for(PlanVuelo viaje:ruta){
                                nuevaRuta.add(viaje);
                            }
                            //System.out.println("______________________________");
                            System.out.println("Paquete reruteado :: " + paquete.getId());
                            imp(nuevaRuta);
                            System.out.println("##############################");
                            paquete.setRutaOficial(nuevaRuta);

                            break;
                        }                            
                    }
                }

                if(encontroSolucion){
                    break;
                }
                else{ //Restaurar los espacios quitados de la ruta original del paquete
                    int destinoA;
                    int partidaA;
                    encontroInicio = false;
                    for(PlanVuelo viaje: PosibleRutaOficial){

                        if(encontroInicio || viaje.getPartida().getId()== partida){
                            encontroInicio = true;
                            destinoA = viaje.getDestino().getId();
                            partidaA = viaje.getPartida().getId();

                            //agregar paquete al vuelo
                            viaje.agregarPaquete(paqueteVuelo);
                            viaje.setCapacidadOcupada(viaje.getCapacidadOcupada()+1);

                            //agregar paquete de los aeropuertos (en paquetes por llegar)
                            viaje.getDestino().getPaquetesPorLlegar().add(paqueteVuelo);
                        }
                    }
                }
            }

            if(!encontroSolucion)return false;
        }
        /*
        for(Paquete paqueteVuelo: paquetesDelVuelo){//conjunto de paquetes de dicho vuelo
            
            contieneVuelo = false; //por si acaso
            
            
                        
            for(ArrayList<PlanVuelo> ruta: patrones){//soluciones del paquete
                
                for(PlanVuelo vueloPaquete: ruta){ //vuelos de la ruta
                    
                    contieneVuelo = false;
                    
                    for(PlanVuelo planVueloConflicto: vuelosConflictivos){//para comparar vuelos con los conflictivos
                        if(vueloPaquete.equals(planVueloConflicto)){
                            contieneVuelo=true;
                            break;
                        }
                    }
                    
                    //Lugar donde se realiza reruteo
                    if(!contieneVuelo){
                        if(ReruteoPorCapacidadAvion(paqueteVuelo,ruta)){
                            contador++;
                            break;
                        }
                    }
                }
                
                if(!contieneVuelo) break;
            }
            
            if(contador==3){ //reruteó 3 paquetes
                    return true;
            }  
        }
        */
        return true; //Si hay reruteo devuelve true;
      
    }
    
    public boolean ReruteoPorCapacidadAvion(Paquete paqueteVuelo,
                                            ArrayList<PlanVuelo> nuevaRuta){
        
        for(PlanVuelo vuelo: nuevaRuta){
            if(vuelo.getCapacidadOcupada()==vuelo.getCapacidad()){
                return false;
            }
            //si es que hay problema con aeropuerto
            if(vuelo.getDestino().CapacidadHoraX(vuelo.getHora_fin())>=vuelo.getDestino().getCapacidad()) {
                return false;
            }
        }
        
        int destino,partida;
        
        for(PlanVuelo vuelo: nuevaRuta){
            
            destino = vuelo.getDestino().getId();
            partida = vuelo.getPartida().getId();
            
            //agregar paquete al vuelo
            vuelo.agregarPaquete(paqueteVuelo);
            vuelo.setCapacidadOcupada(vuelo.getCapacidadOcupada()+1);
            
            //agregar paquete de los aeropuertos (en paquetes por llegar)
            vuelo.getDestino().getPaquetesPorLlegar().add(paqueteVuelo);
        }

        return true;
    }  
    
    private void buscarConflictosRuta(GrafoAeropuerto<Integer> grafo,
                                     ColeccionAeropuerto aeropuertos, 
                                     ArrayList<PlanVuelo> solucion,
                                     Paquete paquete,
                                     ArrayList<PlanVuelo> vuelosConflictivos,
                                     ArrayList<PlanVuelo> vuelosAeroConflic) {
        
        for(PlanVuelo vuelo: solucion){ //para ver exceso de capacidad de almacén
            
            if(vuelo.getDestino().CapacidadHoraX(vuelo.getHora_fin())>=vuelo.getDestino().getCapacidad()) {
               
                for(PlanVuelo vueloProblematico : grafo.grafoInvertido.get(vuelo.getDestino().getId())){
                    vuelosAeroConflic.add(vueloProblematico);
                }
            }
            if(vuelo.getCapacidadOcupada() == vuelo.getCapacidad()){
                vuelosConflictivos.add(vuelo);
            }
            
        }

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
