package grasp;
/**
 *
 * @author 
 */
public class Vuelo {
 
    static int id=0;
    
    int idVuelo;
    String ciudadOrigen;
    String ciudadDestino;
    
    int tiempoVuelo;
    String horaSalida;
    String horaLlegada;
    
    int capacidad;
    
    int capacidadActual=0;
    
    int estado;//0 estacionado    1 volando

    public Vuelo( String ciudadOrigen, String ciudadDestino, int tiempoVuelo, String horaSalida, String horaLlegada, int capacidad) {
        id ++;
        idVuelo = id;
        this.ciudadOrigen = asignarNombrePais(ciudadOrigen);
        this.ciudadDestino = asignarNombrePais(ciudadDestino);
        this.tiempoVuelo = tiempoVuelo;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.capacidad = capacidad;
        this.estado = 0;
    }

    private String asignarNombrePais(String ciudad){
        String nombreCiudad;
        switch(ciudad){
            case "SKBO": nombreCiudad = "Bogota"; break;
            case "SEQM": nombreCiudad = "Quito"; break;
            case "SVMI": nombreCiudad = "Caracas"; break;
            case "SBBR": nombreCiudad = "Brasilia"; break;
            case "SPIM": nombreCiudad = "Lima"; break;
            case "SLLP": nombreCiudad = "La Paz"; break;
            case "SCEL": nombreCiudad = "Santiago de Chile"; break;
            case "SABE": nombreCiudad = "Buenos Aires"; break;
            case "SGAS": nombreCiudad = "Asuncion"; break;
            case "SUAA": nombreCiudad = "Monte Video"; break;
            case "LATI": nombreCiudad = "Albania"; break;
            case "EDDI": nombreCiudad = "Berlin"; break;
            case "LOWW": nombreCiudad = "Viena"; break;
            case "EBCI": nombreCiudad = "Bruselas"; break;
            case "UMMS": nombreCiudad = "Minsk"; break;
            case "LBSF": nombreCiudad = "Sofia"; break;
            case "LKPR": nombreCiudad = "Praga"; break;
            case "LDZA": nombreCiudad = "Zagreb"; break;
            case "EKCH": nombreCiudad = "Copenhague"; break;
            case "LZIB": nombreCiudad = "Bratislava"; break;
            case "LJLJ": nombreCiudad = "Liubliana"; break;
            case "LEMD": nombreCiudad = "Madrid"; break;
            case "EETN": nombreCiudad = "Tallin"; break;
            case "EFHK": nombreCiudad = "Helsinki"; break;
            case "LFPG": nombreCiudad = "Paris"; break;
            case "LGAV": nombreCiudad = "Atenas"; break;
            case "EHAM": nombreCiudad = "Budapest"; break;    
            case "LHBP": nombreCiudad = "Budapest"; break;
            case "EIDW": nombreCiudad = "Dublin"; break;
            case "BIKF": nombreCiudad = "Reykjavik"; break;
            case "LIRA": nombreCiudad = "Roma"; break;
            case "EVRA": nombreCiudad = "Riga"; break;
            case "ELLX": nombreCiudad = "Luxembrugo"; break;
            case "LMML": nombreCiudad = "La Valleta"; break;
            case "ENGM": nombreCiudad = "Oslo"; break;
            case "EPMO": nombreCiudad = "Varsovia"; break;
            case "LPPT": nombreCiudad = "Lisboa"; break;
            case "EGLL": nombreCiudad = "Londres"; break;
            case "ESKN": nombreCiudad = "Estocolmo"; break;
            case "LSZB": nombreCiudad = "Berna"; break;
            default: 
                nombreCiudad = "holi";
        }
        return nombreCiudad;
    }
      
    public void asignarPaquete(){
        capacidadActual++;
    }
    
    public void dejarPaquete(){
        capacidadActual--;
    }
    
    public String toString(){
        return ("\n "+ciudadOrigen+" - "+ciudadDestino);
    }
    
    
}
