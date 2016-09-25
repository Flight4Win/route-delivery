
package grasp;

/**
 *
 * @author carlo
 */
public class Paquete {
     
    int idPaquete;
    
    String ciudadOrigen;
    String ciudadDestino;
    
    int estado; //0 es espera  1 entregado 2 en transito.
    
    Ruta ruta = new Ruta();

    public Paquete(int idPaquete, String ciudadOrigen, String ciudadDestino, int estado) {
        this.idPaquete = idPaquete;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.estado = estado;
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
    
    
    
    
}
