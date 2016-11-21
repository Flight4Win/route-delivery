/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package regressionhandler;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

/**
 *
 * @author JuanI
 */
public class Write {
    
    private String _directoryPathOut;
    private String _filename;
    
    public Write(String _directoryPathOut){
        this._directoryPathOut = _directoryPathOut;
        this._filename = "regresion_result.txt";
    }
    
    
    
    public void write(ArrayList<String> buffer){
        
      String file=_filename.substring(0, _filename.indexOf(".txt"));
      String file_route = _directoryPathOut+"/"+_filename;
        System.out.println("output: "+file_route);
      Writer writer = null;
      try{
          writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_route),"utf-8"));
          for(String line : buffer){
              if(line.equals("line")){
                 writer.write(System.lineSeparator());                  
              }else{
                writer.write(line);                  
              }
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
    
}
