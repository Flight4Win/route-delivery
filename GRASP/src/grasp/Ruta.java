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
        System.out.println("PLAN DE VUELO :");
        System.out.println(vuelos.toString());
    }
    
}
