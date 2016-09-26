package grasp;

import java.util.ArrayList;

/**
 *
 * @author XXX
 */
public class Ruta {
    
    int idRuta;
    
    ArrayList<Vuelo> vuelos = new ArrayList<>();
    
    
    public void mostrarRuta(){
        System.out.println("recorrido :");
        for (Vuelo vuelo : vuelos) {            
            System.out.println(vuelo.ciudadOrigen + " - " + vuelo.ciudadDestino);
        }
    }
    
}
