/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package regressionhandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.exit;
import java.util.ArrayList;
import utilitary.Helper;
import regressionhandler.Write;

/**
 *
 * @author JuanI
 */
public class Read {
    private String _directoryPathIN;
    private String _directoryPathOut;
    private ArrayList<File> _filesInDirectory;
    
    public Read(String routeIn, String routeOut){
        _directoryPathIN = Helper.get_path(routeIn);
        if(_directoryPathIN==null){
            System.out.println("The route for input is invalid.");
            exit(1);
        }else{
            _filesInDirectory = Helper.get_files_names(_directoryPathIN);
            if(_filesInDirectory==null){
                System.out.println("There was a problem when trying to get files in directory: "+_directoryPathIN);
                exit(1);
            }
        }
        _directoryPathOut = Helper.get_path(routeOut);
        if(_directoryPathOut==null){
            System.out.println("The route for output is invalid.");
            exit(1);
        }
        System.out.println("In directory: "+_directoryPathIN+" There are "+_filesInDirectory.size()+" files.");  
    }
    
    
    public void Process_Files(){
        ArrayList<String> buffer = new ArrayList<>();
        for(File file : _filesInDirectory){
            Process_File(file,buffer);   
            
        }
        Write write = new Write(_directoryPathOut);
        write.write(buffer);
        //print
    }    

    private void Process_File(File file, ArrayList<String> buffer) {
        try{
            if (file.isFile()){
                BufferedReader bufferReader = new BufferedReader(new FileReader(file));
                String str;
                /*read the first three lines*/
                bufferReader.readLine();
                /*get the airport*/
                str = bufferReader.readLine();
                int index_comma = str.indexOf(",");
                String airport_name = str.substring(index_comma+1,str.length());
                /*ignore*/
                bufferReader.readLine();
                
                String line = "Airport: "+airport_name;
                buffer.add(line);
                
                ArrayList<String> scounts = new ArrayList<String>();
                ArrayList<Long> days = new ArrayList<Long>();
                /*read the remainder of the file*/
                while((str=bufferReader.readLine())!=null){
                    index_comma = str.indexOf(",");
                    String date = str.substring(0,index_comma);
                    long represent_date = Helper.convertDate(date);
                    days.add(represent_date);
                    String scount= str.substring(index_comma+1,str.length());
                    scounts.add(scount);
                }
                
                /*calculate the regression*/
                Regresion reg = new Regresion(scounts,days);
                //linear
                reg.linearRegresion();
                buffer.add(reg.getSize(0));
                buffer.add(reg.getEquation(0));
                buffer.add(reg.getR());
                buffer.add(reg.getP());
                buffer.add(reg.getStd_err());
                
                buffer.add("line");
                
                //exponential
                reg.exponentialRegresion();
                buffer.add(reg.getSize(1));
                buffer.add(reg.getEquation(1));
                buffer.add(reg.getR());
                buffer.add(reg.getP());
                buffer.add(reg.getStd_err());
                
                buffer.add("line");
                buffer.add("line");
                
            }
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
}
