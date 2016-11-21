/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilitary;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author JuanI
 */
public class Helper {
    
    public static final String sdate_compare = "1977-05-25";
    
    
    
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
        
        LocalDate date_compare = LocalDate.parse(sdate_compare);
        
        long days = ChronoUnit.DAYS.between(date_compare, date);
        
        LocalDate test = date_compare.plusDays(days); //reconstruction of the date
        System.out.println("test date: "+test.toString());
        
        return days;
    }
    
}
