/*
* Version: 1.1
* Última modificación: 18/09/2016
* Descripcion del cambio: Definición de la clase.
* author Joe Huamani
*/

package partesGenetica;

import algoritmo.GrafoAeropuerto;
import algoritmo.Patrones;
import clases.Paquete;
import clases.Ruta;
import data.ColeccionAeropuerto;
import data.ColeccionPlanVuelo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Poblacion {
     ///////////////////////////////////////////////////////////////////////
    /*Estructura de población
    */    
    private static final int TOURNAMENT_SIZE = 3;
    private float _elitismo;
    private float _mutacion;
    private float _cruce;
    private ArrayList<Cromosoma> _poblacion;
    
    /* variable random por tiempo del sistema */
    private static final Random _rand = new Random(System.currentTimeMillis());
    
     /////////////////////////////////////////////////////////////////////////
    /*Iniciador de la estructura genética
    */
    public Poblacion(int cantidad_poblacion, float Proporcion_cruce, float proporcion_elitismo, 
			float proporcion_mutacion,GrafoAeropuerto<Integer> grafoRutas,Paquete paquete,ColeccionAeropuerto aeropuertos, ColeccionPlanVuelo vuelos) {
		
        this._cruce = Proporcion_cruce;
	this._elitismo = proporcion_elitismo;
	this._mutacion = proporcion_mutacion;
	
//        double tiempo;
//	/* Generar la población inicial */
//        Patrones patrones = new Patrones(grafoRutas);
//        
//        if(aeropuertos.EsIntercontinental(paquete.getPartida(),paquete.getDestino())){
//            tiempo = 48.0;
//        }
//        else{
//            tiempo = 24.0;
//        }
//        List r = patrones.getPatrones(paquete.getPartida(),paquete.getDestino(),tiempo,paquete.getHoraEntrega());
//        //aqui ya tengo las soluciones iniciales
//        
//        System.out.println(r.toArray().length);
	//for (int i = 0; i < cantidad_poblacion; i++) {
           // this._poblacion.add(Cromosoma.generarItinerario(paquete,rutas,aeropuertos));
	//}
        //System.out.println(r);
		//Arrays.sort(this.popArr);   
    }

     ///////////////////////////////////////////////////////////
    /* Evolución de la población
    */    
    public void evolve() {
	// Create a buffer for the new generation
	//Chromosome[] buffer = new Chromosome[popArr.length];
		
	// Copy over a portion of the population unchanged, based on 
	// the elitism ratio.
	//int idx = Math.round(popArr.length * elitism);
	//System.arraycopy(popArr, 0, buffer, 0, idx);

	// Iterate over the remainder of the population and evolve as 
	// appropriate.
	//while (idx < buffer.length) {
            // Check to see if we should perform a crossover. 
            if (_rand.nextFloat() <= _cruce) {
				
		// Select the parents and mate to get their children
		//Chromosome[] parents = selectParents();
		//Chromosome[] children = parents[0].mate(parents[1]);
				
		// Check to see if the first child should be mutated.
		if (_rand.nextFloat() <= _mutacion) {
                    //buffer[idx++] = children[0].mutate();
		}
                else {
                    //buffer[idx++] = children[0];
		}
				
		// Repeat for the second child, if there is room.
		//if (idx < buffer.length) {
                    if (_rand.nextFloat() <= _mutacion) {
			//buffer[idx] = children[1].mutate();
                    }
                    else{
			//buffer[idx] = children[1];
                    }
		//}
            }
            else{ // No crossover, so copy verbatium.
                // Determine if mutation should occur.
		if (_rand.nextFloat() <= _mutacion) {
                    //buffer[idx] = popArr[idx].mutate();
		}
                else{
                    //buffer[idx] = popArr[idx];
                }
            }
        //}
        // Increase our counter
	//++idx;
       
    // Sort the buffer based on fitness.
    //Arrays.sort(buffer);
		
    // Reset the population
    //popArr = buffer;
    }
	
    /**
     * Method used to retrieve a copy of the current population.  This
     * method returns a copy of the population at the time the method was
     * called.
     * 
     * @return A copy of the population.
     */
    /*public Chromosome[] getPopulation() {
        Chromosome[] arr = new Chromosome[popArr.length];
        System.arraycopy(popArr, 0, arr, 0, popArr.length);
		
	return arr;
    }*/
    
    
     //////////////////////////////////////////////////////////////////
    /* Devolver el calor de la proporción de elitismo
    */
    public float getElitismo() {
        return _elitismo;
    }
    
     //////////////////////////////////////////////////////////////////
    /* Devolver el calor de la proporción de cruce
    */
    public float getCruce() {
        return _cruce;
    }
    
     //////////////////////////////////////////////////////////////////
    /* Devolver el calor de la proporción de mutacion
    */
    public float getMutacion() {
        return _mutacion;
    }

	/**
	 * A helper method that can be used to select two random parents from
	 * the population to use in crossover during evolution. 
	 * 
	 * @return Two randomly selected <code>Chromsomes</code> for crossover.
	 */
	/*private Chromosome[] selectParents() {
		Chromosome[] parents = new Chromosome[2];

		// Randomly select two parents via tournament selection.
		for (int i = 0; i < 2; i++) {
			parents[i] = popArr[rand.nextInt(popArr.length)];
			for (int j = 0; j < TOURNAMENT_SIZE; j++) {
				int idx = rand.nextInt(popArr.length);
				if (popArr[idx].compareTo(parents[i]) < 0) {
					parents[i] = popArr[idx];
				}
			}
		}
		
		return parents;
	}
        */
}
