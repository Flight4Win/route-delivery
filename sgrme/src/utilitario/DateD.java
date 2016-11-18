/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitario;

import java.util.Date;

/**
 *
 * @author ferna
 */
public class DateD extends java.util.Date{

    
    int y;
    int m;
    int d;
    int h;
    int mi;
    int s;
    
    public DateD(int year, int month, int date, int hrs, int min, int sec) {
        super(year, month, date, hrs, min, sec);
        this.y =year;
        this.m = month;
        this.d = date;
        this.h = hrs;
        this.mi = min;
        this.s = sec;
    }
    
    public Date generarDate(){
        Date da = new Date(y,m,d,h,mi,s);
        System.out.println("Sout :  "+da.toString());
        return da;
    }
    
}
