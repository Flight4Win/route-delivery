/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad_prueba;

import java.io.Serializable;

/**
 *
 * @author juani
 */
public class Persona implements Serializable {

    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the appaterno
     */
    public String getAppaterno() {
        return appaterno;
    }

    /**
     * @param appaterno the appaterno to set
     */
    public void setAppaterno(String appaterno) {
        this.appaterno = appaterno;
    }

    /**
     * @return the apmaterno
     */
    public String getApmaterno() {
        return apmaterno;
    }

    /**
     * @param apmaterno the apmaterno to set
     */
    public void setApmaterno(String apmaterno) {
        this.apmaterno = apmaterno;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    private String codigo;
    private String appaterno;
    private String apmaterno;
    private String nombres;

    public Persona(String codigo, String appaterno, String apmaterno, String nombres) {
        this.codigo = codigo;
        this.appaterno = appaterno;
        this.apmaterno = apmaterno;
        this.nombres = nombres;
    }


    
    
}
