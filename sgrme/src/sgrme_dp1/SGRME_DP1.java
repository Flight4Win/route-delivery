/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgrme_dp1;

import utilitarios.ConexionMySQL;

/**
 *
 * @author ferna
 */
public class SGRME_DP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ConexionMySQL con=new ConexionMySQL();
        con.conexion();
    }
    
}
