/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorhandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitary.Airport;
import utilitary.Helper;

/**
 *
 * @author juani
 */
public class ReadFile {
    
    
    private String _directoryPathIN;
    private String _directoryPathOut_Simu2;
    private String _directoryPathOut_Simu3;
    private File _file;
    
    private ArrayList<Airport> airports;
    
    public ReadFile(String routeIn, String routeOutSimu2,String routeOutSimu3){        
        _directoryPathIN = Helper.get_path(routeIn);
        if(_directoryPathIN==null){
            System.out.println("The route for input is invalid.");
            exit(1);
        }else{
            ArrayList<File> files = Helper.get_files_names(_directoryPathIN);
            if(files==null){

                System.out.println("There was a problem when trying to get files in directory: "+_directoryPathIN);
                exit(1);
            }else{
                _file=files.get(0);
            }
        }
        _directoryPathOut_Simu2 = Helper.get_path(routeOutSimu2);
        if(_directoryPathOut_Simu2==null){
            System.out.println("The route for simu2 is invalid.");
            exit(1);
        }
        _directoryPathOut_Simu3 = Helper.get_path(routeOutSimu3);
        if(_directoryPathOut_Simu3==null){
            System.out.println("The route for simu3 is invalid.");
            exit(1);
        }

    }


    public void process_file(){
        read();
        WriteFile wf_simu2 = new WriteFile(_directoryPathOut_Simu2,airports,Helper.number_simu_2);
        wf_simu2.write();
        WriteFile wf_simu3 = new WriteFile(_directoryPathOut_Simu3,airports,Helper.number_simu_3);
        wf_simu3.write();
        
        
    }

    private void read() {
        airports = new ArrayList<Airport>();
        try{
            
            BufferedReader bufferReader = new BufferedReader(new FileReader(_file));
            String str;
            while((str=bufferReader.readLine())!=null){
                airports.add(new Airport(str));
            }            
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
}
