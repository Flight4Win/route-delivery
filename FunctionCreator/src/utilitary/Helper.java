/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilitary;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author JuanI
 */
public class Helper {
    
    public static final String sdate_compare = "1977-05-25";
    
    public static Long max_package_code = new Long (-1);
    
    public static LocalDate max_date = LocalDate.MIN;
    
    public static int number_simu_2 = 3;
    public static int number_simu_3 = 50;
    
    
    public static Map<String,Set<String>>  list_airports = new HashMap<String,Set<String>>();
    
    public static void insert(String key, String value){
        
        Set<String> set = list_airports.get(key);
        if(set==null){
            set = new HashSet<String>();
            list_airports.put(key, set);
        }
        set.add(value);
    }
    

    public static String get_path(String route){
        String path = null;
        try{
            path = Helper.class.getResource(route).getPath();    
        }catch(Exception e){
            e.printStackTrace();
        }      
        return path;
    }
    
    public static ArrayList<File> get_files_names(String path){
        
        File folder = new File(path);
        ArrayList<File> files =null;
        if(folder!=null){
            files = new ArrayList<File>(Arrays.asList(folder.listFiles()));
        }
        return files;
    }
    
    public static String get_airport_name(String filename){
        int index_start  = filename.indexOf("_");
        int index_finish = filename.indexOf(".txt", index_start);
        String airport_name = filename.substring(index_start+1, index_finish);
        
        return airport_name;
    }

    public static long convertDate(String sdate) {

        LocalDate date = LocalDate.parse(sdate);
        
        if(max_date.isBefore(date)) max_date=date;
        
        LocalDate date_compare = LocalDate.parse(sdate_compare);
        
        long days = ChronoUnit.DAYS.between(date_compare, date);
        
        LocalDate test = date_compare.plusDays(days); //reconstruction of the date
        //System.out.println("test date: "+test.toString());
        
        return days;
    }
    
    
    public static long convertDate_P(String sdate) {

        LocalDate date = LocalDate.parse(sdate);
                
        LocalDate date_compare = LocalDate.parse(sdate_compare);
        
        long days = ChronoUnit.DAYS.between(date_compare, date);
        
        LocalDate test = date_compare.plusDays(days); //reconstruction of the date
        //System.out.println("test date: "+test.toString());
        
        return days;
    }    
    
    
    
    public static Integer get_prediction(Double _a, Double _b, LocalDate date){
        
        double e = Math.E;
        
        long x = convertDate_P(date.toString());
        
        Double y = _a*(Math.exp(_b*x));
        
        
        
        return y.intValue();
    }
    
    
    public static String file_out(String airport){
        StringBuilder name = new StringBuilder("arch_");
        name.append(airport);
        name.append(".txt");
        
        return name.toString();
    }
    
    
    public static Long codeGenerator(){
        Helper.max_package_code++;
        return Helper.max_package_code;
    }
    
    public static String get_date(String year,String month,String day){
        
        StringBuilder builder = new StringBuilder("");
        builder.append(year);
        
        if(month.length()<2){
            builder.append("0");
        }
        builder.append(month);
        if(day.length()<2){
            builder.append("0");
        }
        builder.append(day);
        
        return builder.toString();
        
    }
    
    
    public static ArrayList<LocalTime> generate_time(int total){
        
        ArrayList<LocalTime> times = new ArrayList<LocalTime>();
        
        for(int i =0 ; i<total ; i++){
            
            LocalTime time = TimeGenerator.generate_time();
            boolean ubicated = false;
            
            for(int j = 0 ; j<times.size();j++){
                if(times.get(j).isAfter(time)){
                    times.add(j, time);
                    ubicated = true;
                    break;
                }
            }
            if(!ubicated){times.add(time);}
            
        }
        
        return times;
      
    }
    
    public static String return_string_time(String hour,String minute){
        
        StringBuilder builder = new StringBuilder("");
        if(hour.length()<2){
            builder.append("0");
        }
        builder.append(hour);
        builder.append(":");
        if(minute.length()<2){
            builder.append("0");
        }
        builder.append(minute);
        
        return builder.toString();
        
        
    }
    
    public static String get_destination(ArrayList<Airport> airports, int index){
        
        Random random = new Random();
        int index_destination = -1;
        do{
            
            index_destination =random.nextInt(airports.size()-1 - 0 + 1) + 0;
        
        }while(index_destination == index);
        
        return airports.get(index_destination).getAirport_name();      
    }
    
    
    public static String get_destination2(String key){
        
        Random random = new Random();
        
        Set<String> airports = list_airports.get(key);        
        String [] airports_temp = airports.toArray(new String[airports.size()]);        
        int index = random.nextInt(airports.size()-1 - 0 + 1) + 0;
        
        return airports_temp[index];
        
    }
    
}
