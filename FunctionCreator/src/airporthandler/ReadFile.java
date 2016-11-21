/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package airporthandler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.System.exit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utilitary.Helper;

/**
 *
 * @author JuanI
 */
public class ReadFile {
    
    private String _directoryPathIN;
    private String _directoryPathOut;
    private ArrayList<File> _filesInDirectory;
    
    public ReadFile(String routeIn, String routeOut){        
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
        for(File file : _filesInDirectory){
            ArrayList<String> buffer_csv = new ArrayList<>();
            ArrayList<String> output = Process_File(file,buffer_csv);
            if(file.isFile() && output!=null){
                WriteFile wf = new WriteFile(_directoryPathOut, file.getName());
                //wf.write(output);
                wf.write_csv(buffer_csv);
            }
        }
    }

    private ArrayList<String> Process_File(File file,ArrayList<String> buffer_csv) {
        try {
            if(file.isFile()){
                System.out.println("File: "+file.getName());
                String airport_origin=Helper.get_airport_name(file.getName());
                System.out.println("Airport: "+airport_origin);
                
                BufferedReader bufferReader = new BufferedReader(new FileReader(file));
                String str;
                LocalDate date_before = LocalDate.MAX;
                int package_count = 0;
                boolean first_time = true;
                ArrayList<String> buffer = new ArrayList<String>();
                
                //save the airport name
                String airport_string = "The airport is: "+airport_origin;
                StringBuilder csv = new StringBuilder("Airport");
                csv.append(',');
                csv.append(airport_origin);
                csv.append('\n');
                buffer.add(airport_string);
                buffer_csv.add(csv.toString());
                
                csv = new StringBuilder("Date");
                csv.append(',');
                csv.append("Count");
                csv.append('\n');
                buffer_csv.add(csv.toString());
                
                while((str=bufferReader.readLine())!=null){
                    int index_point = str.indexOf(":");
                    //two chars to the right of the point are the minutes.
                    int offset = 2;
                    int start =index_point+1;
                    int end = start+offset;
                    String minutes = str.substring(start, end);
                    //the remainder are the code of the destination airport
                    start=start+offset;
                    end = str.length();
                    String airport_destination = str.substring(start, end);
                    //two chars to the left of the point are the hours
                    offset = -2;
                    end=index_point;
                    start = end+offset;
                    String hours = str.substring(start,end);
                    //two chars to the left of the hours is the day
                    end = start;
                    start = end + offset;
                    String day = str.substring(start,end);
                    //two chars to the left of the day is the month
                    end = start;
                    start=end+offset;
                    String month = str.substring(start,end);
                    //four chars to the left of the month is the year
                    offset-=2;
                    end = start;
                    start = end+offset;
                    String year = str.substring(start,end);
                    //the remainder to the right are the code of the package
                    end = start ;
                    start = 0;
                    String package_code =  str.substring(start,end);
                    Long code = Long.parseLong(package_code);
                    if(Helper.max_package_code<code){
                        Helper.max_package_code=code;
                    }
                    
                    //System.out.println("package code: "+package_code);
                   //System.out.println("date: "+year+"/"+month+"/"+day);
                    //System.out.println("time: "+hours+":"+minutes);
                    //System.out.println("airport destination: "+airport_destination);
                    
                    LocalDate new_date = LocalDate.parse(year+"-"+month+"-"+day);
                    if(new_date.isEqual(date_before)){
                        package_count++;
                    }else{
                        if(first_time){
                            first_time=false;
                            package_count++;
                        }else{
                            String output = "Date: "+date_before.toString()+" There are :"+package_count+" packages.";
                            csv = new StringBuilder(date_before.toString());
                            csv.append(',');
                            csv.append(package_count);
                            csv.append('\n');
                            buffer.add(output);
                            buffer_csv.add(csv.toString());
                            System.out.println(output);
                            package_count=1;
                        }
                    }
                    date_before = new_date;                    
                }
                
                /*last date*/
                String output = "Date: "+date_before.toString()+" There are :"+package_count+" packages.";
                csv = new StringBuilder(date_before.toString());
                csv.append(',');
                csv.append(package_count);
                csv.append('\n');
                buffer.add(output);
                buffer_csv.add(csv.toString());
                System.out.println(output);                

                return buffer;
            }          
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    
    
    
    
    
}
