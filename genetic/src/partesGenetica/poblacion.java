/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partesGenetica;

import java.util.Random;

/*
* Version: 1.0
* Última modificación: 17/09/2016
* Descripcion del cambio: Definición de la clase.
* author Joe Huamani
*/

public class poblacion {
     ///////////////////////////////////////////////////////////
    /*Estructura de población
    */    
    private static final int TOURNAMENT_SIZE = 3;
    private float elitismo;
    private float mutacion;
    private float cruce;
    //private Chromosome[] popArr;
    
    /* variable random por tiempo del sistema */
    private static final Random rand = new Random(System.currentTimeMillis());
    /////////////////////////////////////////////////
     ///////////////////////////////////////////////////////////
    /*Iniciador de la estructura genética
    */
    public poblacion(int cantidad_poblacion, float Proporcion_cruce, float proporcion_elitismo, 
			float proporcion_mutacion) {
		
		this.cruce = Proporcion_cruce;
		this.elitismo = proporcion_elitismo;
		this.mutacion = proporcion_mutacion;
		
		/* Generar la población inicial */
		//this.popArr = new Chromosome[size];
		for (int i = 0; i < cantidad_poblacion; i++) {
			//this.popArr[i] = Chromosome.generateRandom();
		}

		//Arrays.sort(this.popArr);   
    }
    /////////////////////////////////////////////////
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
            if (rand.nextFloat() <= cruce) {
				
		// Select the parents and mate to get their children
		//Chromosome[] parents = selectParents();
		//Chromosome[] children = parents[0].mate(parents[1]);
				
		// Check to see if the first child should be mutated.
		if (rand.nextFloat() <= mutacion) {
                    //buffer[idx++] = children[0].mutate();
		}
                else {
                    //buffer[idx++] = children[0];
		}
				
		// Repeat for the second child, if there is room.
		//if (idx < buffer.length) {
                    if (rand.nextFloat() <= mutacion) {
			//buffer[idx] = children[1].mutate();
                    }
                    else{
			//buffer[idx] = children[1];
                    }
		//}
            }
            else{ // No crossover, so copy verbatium.
                // Determine if mutation should occur.
		if (rand.nextFloat() <= mutacion) {
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
        return elitismo;
    }
    ////////////////////////////////////////
     //////////////////////////////////////////////////////////////////
    /* Devolver el calor de la proporción de cruce
    */
    public float getCruce() {
        return cruce;
    }
    ////////////////////////////////////////
     //////////////////////////////////////////////////////////////////
    /* Devolver el calor de la proporción de mutacion
    */
    public float getMutacion() {
        return mutacion;
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
