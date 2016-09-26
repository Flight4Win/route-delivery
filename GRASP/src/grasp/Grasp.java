/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grasp;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author carlo
 */
public class Grasp { 
    ArrayList<Vuelo> vuelos;
    ArrayList<Aeropuerto> aeropuertos;
    
    ArrayList<Vuelo> tempVuelos;

    public Grasp(ArrayList<Vuelo> vuelos, ArrayList<Aeropuerto> aeropuertos) {
        this.vuelos = vuelos;
        this.aeropuertos = aeropuertos;
    } 
    
    
    
    public void algoritmo(/*Paquete paquete, PlanVuelo, Aeropuertos */){
        Ruta rutaPosible = new Ruta();
        //Mientras (No Condicion de parada)
            //Fase de contruccion
                //Seleccionar lista de candidatos
                //Considerar listra restringida (mejores)
                //Seleccionar elemento de lista restringida
                
                //rutaPosible = construirSolucion(paquete);
                
            // Fase de mejora (búsqueda local)
                //Solución de búsqueda local hasta no mejorarse
            //Actualización
                //Si la solución > solución almacenada
                    //SolAlmacenada = SolMejorada
        //Fin Mientras
        //Devolver SolAlmacenada
    }
    
    public Ruta construirSolucion(Paquete paquete){
        //Ruta = vacio | Lista de adyacencia (de aviones que tomará)
        Ruta rutaPaquete = new Ruta(); 
        //Cargar lista de aviones que puede tomar
        tempVuelos = vuelos;
        String destinoUltimo;        
        
        //Como al inicio ruta no tiene destinoActual
        if(rutaPaquete.vuelos.isEmpty()){
            destinoUltimo=paquete.ciudadOrigen;
        }else{ //La última ubicación del paquete
            destinoUltimo=rutaPaquete.vuelos.get(rutaPaquete.vuelos.size()-1).ciudadDestino;
        }         
        //Mientras (Ruta no llegue a destino) hacer
        while((destinoUltimo.compareTo(paquete.ciudadDestino) != 0) && tempVuelos.size()>0){
            ArrayList<Vuelo> listaRestringida = new ArrayList<>();
            
            //seleccionar Vuelos que cumplan que el origen es el destinoUltimo
            ArrayList<Vuelo> listaVuelosOrigen = new ArrayList<>();
            for(int i =0; i < tempVuelos.size()-1 ; i++){
                if((tempVuelos.get(i).ciudadOrigen.compareTo(destinoUltimo) == 0) && (tempVuelos.get(i).capacidadActual<tempVuelos.get(i).capacidad)){
                    //verificar si están disponibles por la hora y por el estado del vuelo
                    listaVuelosOrigen.add(tempVuelos.get(i));
                } 
            }
            //función voraz???? fx = 48 - h > 0            
             //a = obtener mínimo de función voraz de elementos restantes
            //b = obtener máximo de función voraz de elementos restantes            
            //agregar a lista de candidatos restringidos(LCR)
                //los que cumplan que f(c) <= a + 0.7(b-a)
            funcionVoraz(listaRestringida,listaVuelosOrigen, buscarContienente(paquete.ciudadOrigen), buscarContienente(paquete.ciudadDestino) );
                
            //y = selecionar aleatoriamente un elemento de LCR 
           //agregar "y" a Ruta
            Random rand = new Random();
            int indice = rand.nextInt(listaRestringida.size());
            rutaPaquete.vuelos.add(listaRestringida.get(indice));
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
        
        return rutaPaquete;
           
    }
    
    private void funcionVoraz(ArrayList<Vuelo> listaRestringida,ArrayList<Vuelo> tempVuelos, String continenteOrigen, String continenteDestino ){
        int horas;
        @SuppressWarnings("MismatchedReadAndWriteOfArray")
        Integer[] valores = new Integer[tempVuelos.size()];
        float funcion;
        int max=-1,min = 99999;
        if(continenteOrigen.equals(continenteDestino)){
            horas = 24;
        }else{
            horas = 48;
        }
        for(int i =0; i < tempVuelos.size()-1 ; i++){
            valores[i]=(horas - tempVuelos.get(i).tiempoVuelo);
            if(min > valores[i]){
                min = valores[i];
            }
            if(max < valores[i]){
                max = valores[i];
            }
        }
        funcion = (float) (min+0.7*max);
        //Se crea la lista restringida
        for(int i=0; i< valores.length ;i++){
            if(valores[i]<funcion){
                listaRestringida.add(tempVuelos.get(i));
            }
        }       
//     
    }
    
    //iimplmentar la funcion que devueklva los vuelos que esen disponibles
    // que los vuelos que tiene como origen nuestra posicion actual.
    
    public Ruta mejora(Ruta rutaPosible,String continenteOrigen, String continenteDestino){
        int horas;
        if(continenteOrigen.equals(continenteDestino)){
            horas = 24;
        }else{
            horas = 48;
        }
        Ruta rutaMejorada = new Ruta();
        //nodoActual: ciudad origen
        //nodoSiguiente: ciudad siguiente
        //nodoActual = rutaPosible.vuelos.get(0);
        int indicePRuta = 0;
        Vuelo vueloActual = rutaPosible.vuelos.get(indicePRuta++);        
        //Vuelo vueloSiguiente = rutaPosible.vuelos.get(1);
        int acumuladoHoras = 0;
        ArrayList<Vuelo> vecinos = encontrarVecinos(vueloActual.ciudadOrigen);
        while (true) {
            //encontrar vecinos del nodo actual            
            int valorInicial = horas - vueloActual.tiempoVuelo;            
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
                //actualizar el vueloACtual
                vueloActual = vecinos.get(indice);
                vecinos = encontrarVecinos(vueloActual.ciudadDestino);                
            }else{
                vueloActual = rutaPosible.vuelos.get(indicePRuta++);
            }
                //retorna el nodoActual o break
            if(indicePRuta == rutaPosible.vuelos.size()){
                break;
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
        for(int i = 0; i < vuelos.size(); i++){
            if( vuelos.get(i).ciudadOrigen.compareTo(ciudadOrigen) == 0){
                vecinos.add(vuelos.get(i));
            }
        }
        return vecinos;
    }
    
     private String buscarContienente(String ciudad){
        boolean encontrado = false;
        int i=0;
        while (!encontrado){
            if(aeropuertos.get(i).ciudad.equals(ciudad)){
                encontrado = true;                
            }
            i++;
        }
        return aeropuertos.get(i-1).continente;        
    }

}
