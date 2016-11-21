/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitary;

/**
 *
 * @author juani
 */
public class Airport {

    /**
     * @return the _airport_name
     */
    public String getAirport_name() {
        return _airport_name;
    }

    /**
     * @return the _a
     */
    public Double getA() {
        return _a;
    }

    /**
     * @return the _b
     */
    public Double getB() {
        return _b;
    }
    
    private String _airport_name;
    private Double _a;
    private Double _b;
    
    public Airport(String line){
        
        //get commas position
        int index_comma  = line.indexOf(",");
        int index_comma2 = line.indexOf(",", index_comma+1);
        
        
        //airport name
        _airport_name = line.substring(0,index_comma);
        //_a
        String _sa = line.substring(index_comma+1,index_comma2);
        _a = Double.parseDouble(_sa);
        //b
        String _sb = line.substring(index_comma2+1,line.length());
        _b = Double.parseDouble(_sb);
        
        
        
    }
    
    
    
}
