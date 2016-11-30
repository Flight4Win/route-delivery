/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorhandler;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import utilitary.Airport;
import utilitary.Helper;

/**
 *
 * @author juani
 */
public class WriteFile {

    private ArrayList<Airport> _airports;
    private int _cycles;
    private String _directoryPathOut;
    
    
    public WriteFile(String directoryPathOut, ArrayList<Airport> airports, int cycles) {
        
        _airports = airports;
        _cycles=cycles;
        _directoryPathOut=directoryPathOut;
        
        
    }

    public void write() {
        
        int m = 0;
        ArrayList<String> buffer;
        
        for(Airport airport : _airports){
            
            buffer = new ArrayList<String>();
            
            String _filename = Helper.file_out(airport.getAirport_name());
            LocalDate dateStart = Helper.max_date;
            for(int i = 0;i<_cycles;i++){
                
                dateStart=dateStart.plusDays(1);

                String date = Helper.get_date(dateStart.getYear()+"", dateStart.getMonthValue()+"", dateStart.getDayOfMonth()+"");
                
                int num_packages = Helper.get_prediction(airport.getA(), airport.getB(), dateStart);
                
                ArrayList<LocalTime> times = Helper.generate_time(num_packages);
                
                for(int j = 0 ; j<num_packages;j++){
                    
                    //generate code
                    String code =Helper.codeGenerator().toString();
                    
                    //time
                    String time = Helper.return_string_time(times.get(j).getHour()+"", times.get(j).getMinute()+"");
                    
                    
                    //destination
                    String destination = Helper.get_destination2(airport.getAirport_name());
                    
                    
                    //uniquestring
                    String uniquestring = code+date+time+destination;
                    
                    buffer.add(uniquestring);
                }

            }
            
            //print
            print_buffer(buffer,_filename);
           
          m++;  
        }             
    }

    private void print_buffer(ArrayList<String> buffer, String _filename) {

        String file_route = _directoryPathOut+"/"+_filename;
        Writer writer = null;
        try{
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file_route),"utf-8"));
            for(String line: buffer){
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
    
}
