
import utiles.Conexion;
import vista.FSimulacion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author juani
 */
public class MainSGRME {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion.init();
        new FSimulacion().setVisible(true);
    }
    
}
