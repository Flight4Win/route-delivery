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
@Table(name = "movimientoavion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimientoavion.findAll", query = "SELECT m FROM Movimientoavion m")
    , @NamedQuery(name = "Movimientoavion.findByIdmovimientoavion", query = "SELECT m FROM Movimientoavion m WHERE m.idmovimientoavion = :idmovimientoavion")
    , @NamedQuery(name = "Movimientoavion.findByFecha", query = "SELECT m FROM Movimientoavion m WHERE m.fecha = :fecha")})
public class Movimientoavion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmovimientoavion")
    private Integer idmovimientoavion;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "idavion", referencedColumnName = "idavion")
    @ManyToOne(optional = false)
    private Avion idavion;
    @JoinColumn(name = "idaeropuerto", referencedColumnName = "idaeropuerto")
    @ManyToOne(optional = false)
    private Aeropuerto idaeropuerto;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estado idestado;

    public Movimientoavion() {
    }

    public Movimientoavion(Integer idmovimientoavion) {
        this.idmovimientoavion = idmovimientoavion;
    }

    public Movimientoavion(Integer idmovimientoavion, Date fecha) {
        this.idmovimientoavion = idmovimientoavion;
        this.fecha = fecha;
    }

    public Integer getIdmovimientoavion() {
        return idmovimientoavion;
    }

    public void setIdmovimientoavion(Integer idmovimientoavion) {
        this.idmovimientoavion = idmovimientoavion;
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

    public Aeropuerto getIdaeropuerto() {
        return idaeropuerto;
    }

    public void setIdaeropuerto(Aeropuerto idaeropuerto) {
        this.idaeropuerto = idaeropuerto;
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
        hash += (idmovimientoavion != null ? idmovimientoavion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimientoavion)) {
            return false;
        }
        Movimientoavion other = (Movimientoavion) object;
        if ((this.idmovimientoavion == null && other.idmovimientoavion != null) || (this.idmovimientoavion != null && !this.idmovimientoavion.equals(other.idmovimientoavion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Movimientoavion[ idmovimientoavion=" + idmovimientoavion + " ]";
    }
    
}
