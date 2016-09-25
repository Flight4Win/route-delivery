package grasp;
/**
 *
 * @author 
 */
public class Vuelo {
 
    int idVuelo;
    
    String ciudadOrigen;
    String ciudadDestino;
    
    int tiempoVuelo;
    String horaSalida;
    String horaLlegada;
    
    int capacidad;
    
    int capacidadActual=0;
    
    int estado;//0 estacionado    1 volando

    public Vuelo(int idVuelo, String ciudadOrigen, String ciudadDestino, int tiempoVuelo, String horaSalida, String horaLlegada, int capacidad, int estado) {
        this.idVuelo = idVuelo;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.tiempoVuelo = tiempoVuelo;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.capacidad = capacidad;
        this.estado = estado;
    }

      
    public void asignarPaquete(){
        capacidadActual++;
    }
    
    public void dejarPaquete(){
        capacidadActual--;
    }


    
    
    
    
    
    
    
}
