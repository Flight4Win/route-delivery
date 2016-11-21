/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grasp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author carlo
 */
public class Grasp { 
    ArrayList<Vuelo> vuelos;
    ArrayList<Aeropuerto> aeropuertos;
//    int indiceDeLaVida = 1;
    ArrayList<Vuelo> tempVuelos;

    public Grasp(ArrayList<Vuelo> vuelos, ArrayList<Aeropuerto> aeropuertos) {
        this.vuelos = vuelos;
        this.aeropuertos = aeropuertos;
    } 
    ArrayList<Ruta> listaRutas = new ArrayList<>();
    static final int MAX = 2;
    
    public void algoritmo(Paquete paquete){
        Ruta rutaNueva = new Ruta();
        Ruta rutaMejorada = new Ruta() ;
        int indice = 0;
        //Mientras (No Condicion de parada)
        while(indice < MAX){          
            System.out.println("\n generando ruta : " + indice);
            //Fase de contruccion
                //Seleccionar lista de candidatos
                //Considerar listra restringida (mejores)
                //Seleccionar elemento de lista restringida
                //rutaPosible = construirSolucion(paquete);
                rutaNueva = construirSolucion(paquete);
                if(rutaNueva != null ){ 
                rutaNueva.mostrarRuta();                
                listaRutas.add(rutaNueva);
                }
            // Fase de mejora (búsqueda local)
                //Solución de búsqueda local hasta no mejorarse
//            rutaMejorada = mejora(rutaPosible, paquete.getTiempoMaxEntrega());
            //Actualización
            //Si la solución > solución almacenada
            //SolAlmacenada = SolMejorada
//            if(indice == 0){
//                rutaMejorada = rutaNueva;
//            }else{
//                if(rutaNueva.totalHoras > rutaMejorada.totalHoras){
//                    rutaNueva = rutaMejorada;
//                }else{
//                    
//                }
//            }
//            if(rutaMejorada.totalHoras < 48 && rutaPosible.totalHoras < 48){
//                if(rutaPosible.totalHoras > rutaMejorada.totalHoras){
//                    rutaPosible = rutaMejorada;
//                }  
//            }
            indice++;
        }
//        rutaMejorada = rutaPosible;
//            for (Ruta ruta : listaRutas) {
//                if(calcularTiempo(rutaPosible) > calcularTiempo(ruta)){
//                rutaMejorada = ruta;
//            }
//            }
        //Fin Mientras
        listaRutas.get(0).mostrarRuta();
        //Devolver SolAlmacenada        
    }
    
    public int calcularTiempo(Ruta ruta){
        int totalHoras = 0;        
        for (Vuelo vuelo : ruta.vuelos) {
            totalHoras = totalHoras + vuelo.tiempoVuelo;
        }        
        return totalHoras;
    }
    
    public Ruta construirSolucion(Paquete paquete){
        //Ruta = vacio | Lista de adyacencia (de aviones que tomará)
        Ruta rutaPaquete = new Ruta(); 
        //Cargar lista de aviones que puede tomar
        tempVuelos = vuelos;
        String destinoUltimo;        
        if (buscarContienente(paquete.ciudadOrigen).compareTo(buscarContienente(paquete.ciudadDestino)) == 0 ){
                
            System.out.println("co:  "+buscarContienente(paquete.ciudadOrigen));
            System.out.println("cd:  "+buscarContienente(paquete.ciudadDestino));
            paquete.setTiempoMaxEntrega(24);
        }else{
                paquete.setTiempoMaxEntrega(48);
        } 
        //Como al inicio ruta no tiene destinoActual
        if(rutaPaquete.vuelos.isEmpty()){
            destinoUltimo=paquete.ciudadOrigen;
        }else{ //La última ubicación del paquete
            destinoUltimo=rutaPaquete.vuelos.get(rutaPaquete.vuelos.size()-1).ciudadDestino;
        }
        ArrayList<Vuelo> listaRestringida = new ArrayList<>();
        //Mientras (Ruta no llegue a destino) hacer
        boolean sobrepasaHoraEntrega= false;        
        int contadorAuxiliar=0;
        
        while((destinoUltimo.compareTo(paquete.ciudadDestino) != 0) && tempVuelos.size()>0 ){            
            System.out.println("Tiempo max:   "+paquete.tiempoMaxEntrega);
            ArrayList<Vuelo> listaVuelosOrigen = new ArrayList<>();            
            
            if(sobrepasaHoraEntrega){
                System.out.println("                      DE NUEVOO!!!");
//                System.out.println("Pqr:   "+paquete.toString());
                tempVuelos = vuelos;
                rutaPaquete.vuelos.clear();
                rutaPaquete.totalHoras = 0;
                destinoUltimo=paquete.ciudadOrigen;//                
                sobrepasaHoraEntrega = false;
                contadorAuxiliar++;
            }           
            System.out.println("destinoUltimo:  "+destinoUltimo);
            listaRestringida.clear();
            //seleccionar Vuelos que cumplan que el origen es el destinoUltimo            
            //Eliminar vuelos que tengan ciudadDestino la ubicación del paquete            
                for (Iterator<Vuelo> iterator = tempVuelos.iterator(); iterator.hasNext();) {
                    Vuelo vuelo = iterator.next();
                    if (vuelo.ciudadDestino.compareToIgnoreCase(destinoUltimo) == 0) {
                        // Remove the current element from the iterator and the list.
                        iterator.remove();
                    }
                }
            int auxiliar = 0 ;
            for (Vuelo tempVuelo : tempVuelos) {
                if (tempVuelo.ciudadOrigen.compareToIgnoreCase(destinoUltimo) == 0 && 
                    tempVuelo.capacidadActual < tempVuelo.capacidad && 
                    buscarAeropuerto(tempVuelo.ciudadDestino).capacidadActual <= buscarAeropuerto(tempVuelo.ciudadDestino).capacidadMaxima) {
                    //corregir !!!!!
                    String[] subCadenas = paquete.horaLlegada.split(":"); 
                    int horaLlegadaPaquete = Integer.parseInt(subCadenas[0]);
                    subCadenas = tempVuelo.horaLlegada.split(":");
                    int horaLLegadaVuelo = Integer.parseInt(subCadenas[0]);
                    subCadenas = tempVuelo.horaSalida.split(":");
                    int horaSalidaVuelo = Integer.parseInt(subCadenas[0]);                    
                    //verificar si están disponibles por la hora y por el estado del vuelo
                    if (horaLlegadaPaquete >= horaLLegadaVuelo && horaLlegadaPaquete <= horaSalidaVuelo) {
//                        System.out.println(horaLLegadaVuelo + " - " + paquete.tiempoMaxEntrega + " - " + horaSalidaVuelo);
//                        System.out.println("Timepo de vuelo:  " + tempVuelo.tiempoVuelo);
                        auxiliar = tempVuelo.tiempoVuelo;
//                        System.out.println("Horas hasta el momemnto:  "+rutaPaquete.totalHoras);
                        listaVuelosOrigen.add(tempVuelo);
                    }
                }                
            }            
            //función voraz???? fx = 48 - h > 0            
            //a = obtener mínimo de función voraz de elementos restantes
            //b = obtener máximo de función voraz de elementos restantes            
            //agregar a lista de candidatos restringidos(LCR)
            //los que cumplan que f(c) <= a + 0.7(b-a)
            funcionVoraz(listaRestringida,listaVuelosOrigen, paquete.getTiempoMaxEntrega() );                
            //y = selecionar aleatoriamente un elemento de LCR 
            //agregar "y" a Ruta
            Random rand = new Random();
            if(listaRestringida.size() > 0){
                int indice = rand.nextInt(listaRestringida.size());
                rutaPaquete.vuelos.add(listaRestringida.get(indice));
                rutaPaquete.totalHoras += listaRestringida.get(indice).tiempoVuelo;
//                System.out.println("tV.:  " + auxiliar);
//                System.out.println("Horas hasta el momemnto:  "+rutaPaquete.totalHoras);
                //Se actualiza la ciudad actual( o último destino en el que está)
                destinoUltimo=rutaPaquete.vuelos.get(rutaPaquete.vuelos.size()-1).ciudadDestino;
               //disminuir la lista de candidatos
               //Borrar de tempVuelos el vuelo que se seleccionó de la lista restringida
                for(int i =0; i < tempVuelos.size()-1 ; i++){
                    if(tempVuelos.get(i).idVuelo == listaRestringida.get(indice).idVuelo){
                        tempVuelos.remove(i);
                        break;
                    } 
                }
            }
            if (rutaPaquete.totalHoras > paquete.tiempoMaxEntrega){
                System.out.println("volver, ya sobrepase.  !!");
                sobrepasaHoraEntrega = true; 
                System.out.println("in   :   "+contadorAuxiliar);
                if(contadorAuxiliar > 5){
                    
                    return null;
                }
            } 
            System.out.println("hora:  "+rutaPaquete.totalHoras);
            System.out.println("sobre:  "+sobrepasaHoraEntrega);
        }        
        System.out.println("xk que xrjs sali!!:  " +rutaPaquete.vuelos.get(rutaPaquete.vuelos.size()-1).ciudadDestino);
        System.out.println("tem vuelos:   "+tempVuelos.size());
        System.out.println("");
        rutaPaquete.mostrarRuta();
        return rutaPaquete;
    }
    
    private void funcionVoraz(ArrayList<Vuelo> listaRestringida,ArrayList<Vuelo> tempVuelos, int horas ){        
        @SuppressWarnings("MismatchedReadAndWriteOfArray")
        Integer[] valores = new Integer[tempVuelos.size()];
        float funcion;
        int max=-1,min = 99999;        
        for(int i =0; i < tempVuelos.size() ; i++){
            valores[i]=(horas - tempVuelos.get(i).tiempoVuelo);
            if(min > valores[i]){
                min = valores[i];
            }
            if(max < valores[i]){
                max = valores[i];
            }
        }
        funcion = (float) (min+0.6*max);
        //Se crea la lista restringida
        for(int i=0; i< valores.length ;i++){ 
//            System.out.println(valores[i]);
            if(valores[i]<funcion){
                listaRestringida.add(tempVuelos.get(i));
            }
        }       
    }    
    
    //implmentar la funcion que devueklva los vuelos que esen disponibles
    // que los vuelos que tiene como origen nuestra posicion actual.
    
    public Ruta mejora(Ruta rutaPosible,int horas){
        Ruta rutaMejorada = new Ruta();
        //nodoActual: ciudad origen
        //nodoSiguiente: ciudad siguiente
        //nodoActual = rutaPosible.vuelos.get(0);
        int indicePRuta = 0;
        Vuelo vueloActual = rutaPosible.vuelos.get(indicePRuta++);
        rutaMejorada.vuelos.add(vueloActual);
        rutaMejorada.totalHoras = rutaMejorada.totalHoras + vueloActual.tiempoVuelo;
        //Vuelo vueloSiguiente = rutaPosible.vuelos.get(1);
        //int acumuladoHoras = 0;
        int acumuladoHoras = vueloActual.tiempoVuelo;
        //ArrayList<Vuelo> vecinos = encontrarVecinos(vueloActual.ciudadOrigen);
        ArrayList<Vuelo> vecinos = encontrarVecinos(vueloActual.ciudadDestino);
        //while (rutaMejorada.totalHoras < horas 
            //&& rutaMejorada.get(último).ciudadDestino == rutaPosible.get(último).ciudadDestino)
        //valorInicial = horas - vueloActual.tiempoVuelo;
        System.out.println("xD ");
        while (rutaMejorada.totalHoras < horas && rutaMejorada.vuelos.get(rutaMejorada.vuelos.size()-1).ciudadDestino.equals(rutaPosible.vuelos.get(rutaPosible.vuelos.size()-1).ciudadDestino)) {
            System.out.println("xD x"+indicePRuta);
            //encontrar vecinos del nodo actual            
            //int valorInicial = horas - vueloActual.tiempoVuelo;
            int valorInicial = horas-(vecinos.get(0).tiempoVuelo+acumuladoHoras);
            int indice = -1;
            
            for(int i = 0; i < vecinos.size();i++){
                int nuevoValor = horas-(vecinos.get(i).tiempoVuelo+acumuladoHoras);
                if( valorInicial < nuevoValor){
                    indice = i;
                    valorInicial = nuevoValor;
                }
            }
            if( indice != -1){
                acumuladoHoras = acumuladoHoras + vecinos.get(indice).tiempoVuelo;
                rutaMejorada.vuelos.add(vecinos.get(indice));
                rutaMejorada.totalHoras = rutaMejorada.totalHoras + vecinos.get(indice).tiempoVuelo;
                //actualizar el vueloACtual
                vueloActual = vecinos.get(indice);
                vecinos = encontrarVecinos(vueloActual.ciudadDestino);                
            }else{
                vueloActual = rutaPosible.vuelos.get(indicePRuta++);
                rutaMejorada.vuelos.add(vueloActual);
                rutaMejorada.totalHoras = rutaMejorada.totalHoras + vueloActual.tiempoVuelo;
                vecinos = encontrarVecinos(vueloActual.ciudadDestino);
                
                if(indicePRuta == rutaPosible.vuelos.size()){
                    break;
                }
            }
            
        }
        if(vueloActual.ciudadDestino.compareTo(rutaPosible.vuelos.get(rutaPosible.vuelos.size()-1).ciudadDestino)== 0){
            return rutaMejorada;
        }else{
            return rutaPosible;
        }        
    }
    
    private ArrayList<Vuelo> encontrarVecinos(String ciudadOrigen){
        ArrayList<Vuelo> vecinos = new ArrayList<>();
        vuelos.stream().filter((vuelo) -> (vuelo.ciudadOrigen.compareTo(ciudadOrigen) == 0)).forEach((vuelo) -> {
            vecinos.add(vuelo);
        });
        return vecinos;
    }
    
     private String buscarContienente(String ciudad){
        boolean encontrado = false;
        int i=0;
        while (!encontrado && i < aeropuertos.size() ){
            if(aeropuertos.get(i).ciudad.equals(ciudad)){
                encontrado = true;                
            }
            i++;
        }
        return aeropuertos.get(i-1).continente;        
    }
     
     private Aeropuerto buscarAeropuerto(String ciudad){
        boolean encontrado = false;
        int i=0;
        while (!encontrado && i < aeropuertos.size() ){
            if(aeropuertos.get(i).ciudad.equals(ciudad)){
                encontrado = true;                
            }
            i++;
        }
        return aeropuertos.get(i-1);        
    }

}
