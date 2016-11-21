/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package regressionhandler;

import java.util.ArrayList;

/**
 *
 * @author JuanI
 */
public class Regresion {
    
    private ArrayList<Double> _xAxis = new ArrayList<Double>();
    private ArrayList<Double> _yAxis = new ArrayList<Double>();
    private int _size;
    private Double _e = Math.E;    //constant
    
    
    private Double _a;
    private Double _b;
    private Double _r;
    private Double _p;
    private Double _std_err;
    
    public Regresion(ArrayList<String> scounts,ArrayList<Long> days){
        
        for(String scount : scounts){
            _yAxis.add(Double.parseDouble(scount));
        }
        for(Long day: days){
            _xAxis.add(day.doubleValue());
        }
        _size=_xAxis.size();
        //System.out.println("size: "+_size);
    }
    
    public void linearRegresion(){
        
        /* Find sum of squares:
         * Calculate sum(X) & sum(X^2) & sum(Y) & sum(Y^2) & sum(X*Y)
         * NOTE: Y denotes log(Y) for each case when calculating exponential regression
         */
        Double sumX = new Double(0.00);
        Double sumX2 = new Double(0.00);
        Double sumYlin = new Double(0.00);
        Double sumY2lin = new Double(0.00);
        Double sumXYlin = new Double(0.00);

        for(int i=0;i<_size;i++)
        {
            sumX = sumX + _xAxis.get(i);
            sumX2 = sumX2 + Math.pow(_xAxis.get(i), 2);

            // linear
            sumYlin = sumYlin + _yAxis.get(i);
            sumY2lin = sumY2lin + Math.pow(_yAxis.get(i),2);
            sumXYlin = sumXYlin + _xAxis.get(i)*_yAxis.get(i);
        }

        /* Calculate regression coefficient 'b' */		
        // linear
        _b = new Double(0.00);
        _b = ((_size*sumXYlin) - (sumX*sumYlin))/(_size*sumX2 - (sumX*sumX));

        /* Calculate regression coefficient 'a' */

        // linear
        _a = new Double(0.00);
        _a = (sumYlin*sumX2 - sumX*sumXYlin)/(_size*sumX2 - sumX*sumX);

        /* Calculate coefficient of determination (R^2) */

        // linear
        Double c = new Double(0.00);	// numerator
        Double d = new Double(0.00);	// denominator
        _r = new Double(0.00);              // coefficient of determination
        c = (_b)*(sumXYlin - sumX*sumYlin/_size);
        d = sumY2lin - (sumYlin*sumYlin)/_size;
        _r = c/d;

        // Calculate coefficient of correlation

        // linear
        _p = new Double(0.00);
        if(_r > 0){
                _p = Math.sqrt(_r);
        } else {
                _p = 0.00;
        }

        /* Calculate standard error
         * equals (total variance - y variance)/(n-2)
         */

        // linear
        _std_err = new Double(0.00);
        _std_err = Math.sqrt((d-c)/(_size-2));
        
    }
    
    public void exponentialRegresion(){
        /* Find sum of squares:
         * Calculate sum(X) & sum(X^2) & sum(Y) & sum(Y^2) & sum(X*Y)
         * NOTE: Y denotes log(Y) for each case when calculating exponential regression
         */
        Double sumX = 0.00;
        Double sumX2 = 0.00;
        Double sumY = 0.00;
        Double sumY2 = 0.00;
        Double sumXY = 0.00;

        for(int i=0;i<_size;i++)
        {
            sumX = sumX + _xAxis.get(i);
            sumX2 = sumX2 + Math.pow(_xAxis.get(i), 2);

            // exponential
            sumY = sumY + Math.log(_yAxis.get(i));
            sumY2 = sumY2 + Math.pow(Math.log(_yAxis.get(i)), 2);
            sumXY = sumXY + (_xAxis.get(i)*(Math.log(_yAxis.get(i)))); 
            
        }

        /* Calculate regression coefficient 'b' */
        // exponential
        _b = 0.00;
        _b = ((_size*sumXY) - (sumX*sumY))/(_size*sumX2 - (sumX*sumX));

        /* Calculate regression coefficient 'a' */
        // exponential
        _a = 0.00;
        _a = Math.pow(_e, (sumY - (_b*sumX))/_size);

        /* Calculate coefficient of determination (R^2) */
        // exponential
        Double c = 0.00;	// numerator
        Double d = 0.00;	// denominator
        _r = 0.00;              // coefficient of determination
        c = (_b)*(sumXY - sumX*sumY/_size);
        d = sumY2 - (sumY*sumY)/_size;
        _r = c/d;

        // Calculate coefficient of correlation
        // exponential
        _p = 0.00;
        if(_r > 0){
                _p = Math.sqrt(_r);
        } else {
                _p = 0.00;
        }

        /* Calculate standard error
         * equals (total variance - y variance)/(n-2)
         */
        // exponential
        _std_err = 0.00;
        _std_err = Math.sqrt((d-c)/(_size-2));       
    }

    /**
     * @return the _size
     */
    public String getSize(int option) {
        String response=null;
        if(option==0){
            response = "Linear regression model for n equals "+_size+":";  
        }else{
            response = "Exponential regression model for n equals "+_size+":";            
        }
        return response;
    }

    /**
     * @return the _a
     */
    public String getEquation(int option) {
        String response=null;
        if(option==0){
            response = "Y = "+_b.toString()+"x + "+_a.toString();
        }else{
            response = "y = "+_a+"*"+"(e^("+_b.toString()+"*x))";            
        }
        return response;
    }

    /**
     * @return the _r
     */
    public String getR() {
        String response = "R-square value equals "+_r.toString();
        return response;
    }

    /**
     * @return the _p
     */
    public String getP() {
        String response = "Correlation equals " + _p.toString();
        return response;
    }

    /**
     * @return the _std_err
     */
    public String getStd_err() {
       String response = "Standard Error equals " + _std_err.toString();
       return response;
    }
    
    
    
    
}
