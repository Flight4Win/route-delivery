/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juani
 */
@Entity
@Table(name = "almacenavion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Almacenavion.findAll", query = "SELECT a FROM Almacenavion a")
    , @NamedQuery(name = "Almacenavion.findByIdalmacenavion", query = "SELECT a FROM Almacenavion a WHERE a.idalmacenavion = :idalmacenavion")
    , @NamedQuery(name = "Almacenavion.findByFecha", query = "SELECT a FROM Almacenavion a WHERE a.fecha = :fecha")})
public class Almacenavion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idalmacenavion")
    private Integer idalmacenavion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "idavion", referencedColumnName = "idavion")
    @ManyToOne(optional = false)
    private Avion idavion;
    @JoinColumn(name = "idpaquete", referencedColumnName = "idpaquete")
    @ManyToOne(optional = false)
    private Paquete idpaquete;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estado idestado;

    public Almacenavion() {
    }

    public Almacenavion(Integer idalmacenavion) {
        this.idalmacenavion = idalmacenavion;
    }

    public Almacenavion(Integer idalmacenavion, Date fecha) {
        this.idalmacenavion = idalmacenavion;
        this.fecha = fecha;
    }

    public Integer getIdalmacenavion() {
        return idalmacenavion;
    }

    public void setIdalmacenavion(Integer idalmacenavion) {
        this.idalmacenavion = idalmacenavion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Avion getIdavion() {
        return idavion;
    }

    public void setIdavion(Avion idavion) {
        this.idavion = idavion;
    }

    public Paquete getIdpaquete() {
        return idpaquete;
    }

    public void setIdpaquete(Paquete idpaquete) {
        this.idpaquete = idpaquete;
    }

    public Estado getIdestado() {
        return idestado;
    }

    public void setIdestado(Estado idestado) {
        this.idestado = idestado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idalmacenavion != null ? idalmacenavion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almacenavion)) {
            return false;
        }
        Almacenavion other = (Almacenavion) object;
        if ((this.idalmacenavion == null && other.idalmacenavion != null) || (this.idalmacenavion != null && !this.idalmacenavion.equals(other.idalmacenavion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Almacenavion[ idalmacenavion=" + idalmacenavion + " ]";
    }
    
}
