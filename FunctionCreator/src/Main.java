
import airporthandler.ReadFile;
import regressionhandler.Read;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JuanI
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String routeIN  = "/document";
        String routeOUT = "/input";
        ReadFile rf = new ReadFile(routeIN,routeOUT);
        rf.Process_Files();
        
        
        /*regresion*/
        
        routeIN  = "/input";
        routeOUT = "/output";        
        Read r = new Read(routeIN,routeOUT);
        r.Process_Files();        
        
        
    }
    
}
