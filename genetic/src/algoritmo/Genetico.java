/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmo;

/*
* Version: 1.0
* Última modificación: 17/09/2016
* Descripcion del cambio: Definición de la clase.
* author Joe Huamani
*/

public class Genetico {

    public static void main(String[] args) {
         //////////////////////////////////////////////////////////////////
        /*Datos iniciales del algoritmo genético
        */
        
        final int cantidad_poblacion = 2048;
	final int generaciones_maximas = 16384;
	
        /*Los siguientes valores van entre 0.0 y 1.0*/
        final float Proporcion_cruce = 0.8f; //Proporcion de población que se cruzará con algún miembro de la poblacion
	final float proporcion_elitismo = 0.1f; // proporción de población que no se retendrá
	final float proporcion_mutacion = 0.03f;//proporción de población que mutará
        
        /*Se carga la data*/
        long tiempoInicial = System.currentTimeMillis(); //Para saber cuanto duró la simulación
        ///////////////////////////////////////////////////////
         //////////////////////////////////////////////////////////////////
        /* Crear la población inicial 
        */     
        /*
        int i = 0;
            Chromosome best = pop.getPopulation()[0];
		
            while ((i++ <= maxGenerations) && (best.getFitness() != 0)) {
		System.out.println("Generation " + i + ": " + best.getGene());
		pop.evolve();
		best = pop.getPopulation()[0];
            }
        */
        ///////////////////////////////////////////////////////
         //////////////////////////////////////////////////////////////////
        /* Lugar de evolución de los genes
         * Terminará cuando llegue al óptimo o hasta la última generacion
         */
        
        
        
        ///////////////////////////////////////////////////////
         //////////////////////////////////////////////////////////////////
        /*Datos de la simulación
        */
        
        long tiempoFinal = System.currentTimeMillis();
        
        System.out.println("Generacion " /*+ i*/ + ": " );//+ best.getGene());
	System.out.println("Tiempo total de ejecucion: " + 
                           (tiempoFinal - tiempoInicial) +
                           "ms");
        ///////////////////////////////////////////////////////
    }
    
}
