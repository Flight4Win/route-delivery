package grasp;

import java.util.ArrayList;

/**
 *
 * @author XXX
 */
public class Ruta {
    
    int idRuta;
    int totalHoras = 0;
    ArrayList<Vuelo> vuelos = new ArrayList<>();
    
    
    public void mostrarRuta(){
        System.out.println("PLAN DE VUELO :" + totalHoras);
        System.out.println(vuelos.toString());
    }
    
            
}
