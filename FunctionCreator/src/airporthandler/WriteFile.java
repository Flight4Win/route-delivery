/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package airporthandler;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author JuanI
 */
public class WriteFile {
    private String _directoryPathOut;
    private String _filename;
    
    public WriteFile(String _directoryPathOut, String _filename){
        this._directoryPathOut = _directoryPathOut;
        this._filename=_filename;
    }
    
    public void write(ArrayList<String> buffer){
        
      String file=_filename.substring(0, _filename.indexOf(".txt"));
      String file_csv = file+".csv";
      String file_route = _directoryPathOut+"/"+_filename;
        System.out.println("output: "+file_route);
      Writer writer = null;
      try{
          writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_route),"utf-8"));
          for(String line : buffer){
              writer.write(line);
              writer.write(System.lineSeparator());
          }
      }catch(IOException ex){
          ex.printStackTrace();
      }finally{
          try{
              writer.close();
          }catch(Exception ex){}
      }
    }
      
    public void write_csv(ArrayList<String> buffer){

        FileWriter fileWriter = null;
        String file=_filename.substring(0, _filename.indexOf(".txt"));
        String file_csv = file+".csv";
        String file_route = _directoryPathOut+"/"+file_csv;
        
        try{
           fileWriter = new FileWriter(file_route);
           fileWriter.append("sep=,"); //to permit open in excel.
           fileWriter.append("\n");
           for (String line : buffer){
               fileWriter.append(line);
           }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }   
        }
        
    }
}
