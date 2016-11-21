
import airporthandler.ReadFile;
import regressionhandler.Read;
import utilitary.Helper;

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
        String regresion = "/function";
        Read r = new Read(routeIN,routeOUT,regresion);
        r.Process_Files();        
        
        
        System.out.println("\n\n\n\nLAST PACKAGE CODE: "+Helper.max_package_code.toString());
        System.out.println("\n\n\n\nLAST DATE: "+Helper.max_date.toString() );
        
        
        /*generate date*/
        routeIN  = "/function";
        String routeOutSimu2 ="/simu2";
        String routeOutSimu3 = "/simu3";
        
        generatorhandler.ReadFile read = new generatorhandler.ReadFile(routeIN, routeOutSimu2, routeOutSimu3);
        read.process_file();
        
        
    }
    
}
