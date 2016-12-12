/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author juani
 */
@Embeddable
public class ItinerarioPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "iditinerario")
    private int iditinerario;
    @Basic(optional = false)
    @Column(name = "idpaquete")
    private int idpaquete;
    @Basic(optional = false)
    @Column(name = "idplan")
    private int idplan;

    public ItinerarioPK() {
    }

    public ItinerarioPK(int iditinerario, int idpaquete, int idplan) {
        this.iditinerario = iditinerario;
        this.idpaquete = idpaquete;
        this.idplan = idplan;
    }

    public int getIditinerario() {
        return iditinerario;
    }

    public void setIditinerario(int iditinerario) {
        this.iditinerario = iditinerario;
    }

    public int getIdpaquete() {
        return idpaquete;
    }

    public void setIdpaquete(int idpaquete) {
        this.idpaquete = idpaquete;
    }

    public int getIdplan() {
        return idplan;
    }

    public void setIdplan(int idplan) {
        this.idplan = idplan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iditinerario;
        hash += (int) idpaquete;
        hash += (int) idplan;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItinerarioPK)) {
            return false;
        }
        ItinerarioPK other = (ItinerarioPK) object;
        if (this.iditinerario != other.iditinerario) {
            return false;
        }
        if (this.idpaquete != other.idpaquete) {
            return false;
        }
        if (this.idplan != other.idplan) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.ItinerarioPK[ iditinerario=" + iditinerario + ", idpaquete=" + idpaquete + ", idplan=" + idplan + " ]";
    }
    
}
