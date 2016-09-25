
package grasp;

/**
 *
 * @author carlo
 */
public class Paquete {
     
    int idPaquete;
    
    String ciudadOrigen;
    String continenteOrigen;
    String ciudadDestino;
    String continenteDestino;;
    
    int estado; //0 es espera  1 entregado 2 en transito.

    public Paquete(int idPaquete, String ciudadOrigen, String continenteOrigen, String ciudadDestino, String continenteDestino, int estado) {
        this.idPaquete = idPaquete;
        this.ciudadOrigen = ciudadOrigen;
        this.continenteOrigen = continenteOrigen;
        this.ciudadDestino = ciudadDestino;
        this.continenteDestino = continenteDestino;
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
