
package grasp;

/**
 *
 * @author carlo
 */
public class Paquete {
     
    static int id=0;
    int idPaquete;
    String ciudadOrigen;
    String ciudadDestino;
    String horaLlegada;
    int tiempoMaxEntrega;
    int estado; //0 es espera  1 entregado 2 en transito.

    public Paquete(String ciudadOrigen, String ciudadDestino) {
        id ++;
        idPaquete = id;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.estado = 0;
    }

public Paquete(String ciudadOrigen, String ciudadDestino, String horaLlegada) {
        id ++;
        idPaquete = id;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.horaLlegada = horaLlegada;
        this.estado = 0;
    }     

    public void setTiempoMaxEntrega(int tiempoMaxEntrega) {
        this.tiempoMaxEntrega = tiempoMaxEntrega;
    }

    public int getTiempoMaxEntrega() {
        return tiempoMaxEntrega;
    }
   
    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
       
    @Override
    public String toString(){
        return("\n"+ idPaquete+"   "+ciudadOrigen+ "   "+ciudadDestino);
    }
    
    
    
}
