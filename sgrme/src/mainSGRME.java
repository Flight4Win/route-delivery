import utilitario.*;
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
public class mainSGRME {
    public static void main(String [] args){

        
        Helper.cargar_data_entrada();        
        new FSimulacion().setVisible(true);

    }
}
