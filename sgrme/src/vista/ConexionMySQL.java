/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import sgrme_dp1.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class ConexionMySQL {
    Connection con=null;
    Statement stm;
    public Connection conexion(){

        try{
            //cargar el drive 
            Class.forName("com.mysql.jdbc.Driver");
            //con=DriverManager.getConnection("jdbc:mysql://localhost:3307/sgrme","root","123456");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sgrme","root","root");
            System.out.println("Conexion establecida");
//            JOptionPane.showMessageDialog(null, "conexion establecida");
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error de conexion"+e);
//            JOptionPane.showMessageDialog(null,"Error de conexion"+e);
        }  
        
        return con;
    
    }
}
