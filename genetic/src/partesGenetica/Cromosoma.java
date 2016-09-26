package partesGenetica;

import clases.Paquete;
import clases.PlanVuelo;
import clases.Ruta;
import data.ColeccionAeropuerto;
import data.ColeccionPlanVuelo;

import java.util.ArrayList;
import java.util.Random;

/*
* Version: 1.0
* Última modificación: 17/09/2016
* Descripcion del cambio: Definición de la clase.
* author Joe Huamani
*/

public class Cromosoma{


    ///////////////////////////////////////////////////////////
    /*Estructura de cromosoma
    */ 
    private ArrayList<Integer> _gen;
    private /*final*/ int aptitud;
    private int _horaAcumulada;
    
	
    
	/** The target gene, converted to an array for convenience. */
    private static final char[] TARGET_GENE = "Hello, world!".toCharArray();

	/** Convenience randomizer. */
    private static final Random rand = new Random(System.currentTimeMillis());
     //////////////////////////////////////
    /*Constructor del cromosoma
    */
	public Cromosoma(ArrayList<Integer> itinerario,int horaAcumulada) {
		this._gen    = itinerario;
                this._horaAcumulada = horaAcumulada;
		this.aptitud = calcularAptitud(itinerario,horaAcumulada);
        }
     ///////////////////////////////////////////////////////////
    /* Devolver el valor de gen
    */ 
    public ArrayList<Integer> getGen() {
	return _gen;
    }

     ///////////////////////////////////////////////////////////
    /* Devolver el valor de la aptitud
    */ 
    public int getAptitud() {
	return aptitud;
    }
    
/*package */ static Cromosoma generarItinerario(Ruta rutas,Paquete paquete, ColeccionAeropuerto aeropuerto) {
        ArrayList<Integer> camino = new ArrayList<Integer>();
        ArrayList<Integer> fallido = new ArrayList<Integer>();
        int horaAcumulada = 0;
        camino.contains(1);
        
        int idPartida = paquete.getPartida();
        int idDestino = paquete.getPartida();
        
        camino.add(idPartida);
        
        int horaActual = paquete.getHoraEntrega();
        int horaAnterior = paquete.getHoraEntrega();
        int horaTope = 48;
        int dia = 0;
	int aero=0;
      
        
        for (int i = 0; i < 6; i++) {
            while(aero < aeropuerto.getAeropuertos().size()) {
                if((rutas.getExisteRutaPrime(idPartida,aero)==1 || rutas.getExisteRutaSegun(idPartida,aero)==1)
                        && !fallido.contains(i)){
                    if(rutas.getExisteRutaPrime(idPartida,aero)==1){
                        if(rutas.getRutaPrime(idPartida,aero).getHora_ini()>horaActual){
                            if(horaAcumulada+rutas.getRutaPrime(idPartida, aero).getDuracion() < horaTope){
                                horaActual = horaActual + rutas.getRutaPrime(idPartida, aero).getDuracion();
                                camino.add(aero);
                                break;
                            }
                        }
                    }
                   // if(rutas.getExisteRutaSegun(idPartida,aero)==1){
                     //   camino.add(aero);
                       // break;
                    //}
                }
                aero++;
                if(aero==aeropuerto.getAeropuertos().size()){
                    fallido.add(idPartida);
                    horaActual = horaAnterior;
                }
            }
            if(aero==idDestino) break;
	}
	return new Cromosoma(camino,horaAcumulada);
    }
 
    ///////////////////////////////////////////////////////////
    /* método que ayuda a calcular la aptitud para un gen dado.
        **
        * explicación del gen
        *
        * The fitness is defined as being the sum of the absolute value of the 
	* difference between the current gene and the target gene.
        **
    */ 
    private static int calcularAptitud(ArrayList<Integer> itinerario,int horaAcumulada) {
	int fitness = 0;
	//char[] arr  = gene.toCharArray();
	//for (int i = 0; i < arr.length; i++) {
        //    fitness += Math.abs(((int) arr[i]) - ((int) TARGET_GENE[i]));
	//}
	return fitness;
    }

	/**
	 * Method to generate a new <code>Chromosome</code> that is a random
	 * mutation of this <code>Chromosome</code>.  This method randomly
	 * selects one character in the <code>Chromosome</code>s gene, then
	 * replaces it with another random (but valid) character.  Note that
	 * this method returns a new <code>Chromosome</code>, it does not
	 * modify the existing <code>Chromosome</code>.
	 * 
	 * @return A mutated version of this <code>Chromosome</code>.
	 */
        /*
	public Chromosome mutate() {
		char[] arr  = gene.toCharArray();
		int idx     = rand.nextInt(arr.length);
		int delta   = (rand.nextInt() % 90) + 32;
		arr[idx]    = (char) ((arr[idx] + delta) % 122);

		return new Chromosome(String.valueOf(arr));
	}
        */
	/**
	 * Method used to mate this <code>Chromosome</code> with another.  The
	 * resulting child <code>Chromosome</code>s are returned.
	 * 
	 * @param mate The <code>Chromosome</code> to mate with.
	 * 
	 * @return The resulting <code>Chromosome</code> children.
	 */
        /*
	public Chromosome[] mate(Chromosome mate) {
		// Convert the genes to arrays to make thing easier.
		char[] arr1  = gene.toCharArray();
		char[] arr2  = mate.gene.toCharArray();
		
		// Select a random pivot point for the mating
		int pivot    = rand.nextInt(arr1.length);
		
		// Provide a container for the child gene data
		char[] child1 = new char[gene.length()];
		char[] child2 = new char[gene.length()];
		
		// Copy the data from each gene to the first child.
		System.arraycopy(arr1, 0, child1, 0, pivot);
		System.arraycopy(arr2, pivot, child1, pivot, (child1.length - pivot));
		
		// Repeat for the second child, but in reverse order.
		System.arraycopy(arr2, 0, child2, 0, pivot);
		System.arraycopy(arr1, pivot, child2, pivot, (child2.length - pivot));

		return new Chromosome[] { new Chromosome(String.valueOf(child1)), 
				new Chromosome(String.valueOf(child2))}; 
	}
	*/
        

       
	/**
	 * Method to allow for comparing <code>Chromosome</code> objects with
	 * one another based on fitness.  <code>Chromosome</code> ordering is 
	 * based on the natural ordering of the fitnesses of the
	 * <code>Chromosome</code>s.  
	 */
        /*
	@Override
	public int compareTo(Chromosome c) {
		if (fitness < c.fitness) {
			return -1;
		} else if (fitness > c.fitness) {
			return 1;
		}
		
		return 0;
	}
	*/
	/**
	 * @see Object#equals(Object)
	 */
	/*@Override
	public boolean equals(Object o) {
		if (!(o instanceof Chromosome)) {
			return false;
		}
		
		Chromosome c = (Chromosome) o;
		return (gene.equals(c.gene) && fitness == c.fitness);
	}
	*/
	/**
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode() {		
		return new StringBuilder().append(_gen).append(aptitud)
				.toString().hashCode();
	}   
    
    
}
