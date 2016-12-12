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
@Table(name = "almacenplan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Almacenplan.findAll", query = "SELECT a FROM Almacenplan a")
    , @NamedQuery(name = "Almacenplan.findByIdalmacenavion", query = "SELECT a FROM Almacenplan a WHERE a.idalmacenavion = :idalmacenavion")
    , @NamedQuery(name = "Almacenplan.findByFecha", query = "SELECT a FROM Almacenplan a WHERE a.fecha = :fecha")})
public class Almacenplan implements Serializable {

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
    @JoinColumn(name = "idplan", referencedColumnName = "idplan")
    @ManyToOne(optional = false)
    private Plandevuelo idplan;
    @JoinColumn(name = "idpaquete", referencedColumnName = "idpaquete")
    @ManyToOne(optional = false)
    private Paquete idpaquete;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estado idestado;

    public Almacenplan() {
    }

    public Almacenplan(Integer idalmacenavion) {
        this.idalmacenavion = idalmacenavion;
    }

    public Almacenplan(Integer idalmacenavion, Date fecha) {
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

    public Plandevuelo getIdplan() {
        return idplan;
    }

    public void setIdplan(Plandevuelo idplan) {
        this.idplan = idplan;
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
        if (!(object instanceof Almacenplan)) {
            return false;
        }
        Almacenplan other = (Almacenplan) object;
        if ((this.idalmacenavion == null && other.idalmacenavion != null) || (this.idalmacenavion != null && !this.idalmacenavion.equals(other.idalmacenavion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Almacenplan[ idalmacenavion=" + idalmacenavion + " ]";
    }
    
}
