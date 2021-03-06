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
@Table(name = "movimientoalmacen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Movimientoalmacen.findAll", query = "SELECT m FROM Movimientoalmacen m")
    , @NamedQuery(name = "Movimientoalmacen.findByIdmovimientoalmacen", query = "SELECT m FROM Movimientoalmacen m WHERE m.idmovimientoalmacen = :idmovimientoalmacen")
    , @NamedQuery(name = "Movimientoalmacen.findByFecha", query = "SELECT m FROM Movimientoalmacen m WHERE m.fecha = :fecha")})
public class Movimientoalmacen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmovimientoalmacen")
    private Integer idmovimientoalmacen;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @JoinColumn(name = "idpaquete", referencedColumnName = "idpaquete")
    @ManyToOne(optional = false)
    private Paquete idpaquete;
    @JoinColumn(name = "idaeropuerto", referencedColumnName = "idaeropuerto")
    @ManyToOne(optional = false)
    private Aeropuerto idaeropuerto;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estado idestado;

    public Movimientoalmacen() {
    }

    public Movimientoalmacen(Integer idmovimientoalmacen) {
        this.idmovimientoalmacen = idmovimientoalmacen;
    }

    public Movimientoalmacen(Integer idmovimientoalmacen, Date fecha) {
        this.idmovimientoalmacen = idmovimientoalmacen;
        this.fecha = fecha;
    }

    public Integer getIdmovimientoalmacen() {
        return idmovimientoalmacen;
    }

    public void setIdmovimientoalmacen(Integer idmovimientoalmacen) {
        this.idmovimientoalmacen = idmovimientoalmacen;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Paquete getIdpaquete() {
        return idpaquete;
    }

    public void setIdpaquete(Paquete idpaquete) {
        this.idpaquete = idpaquete;
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
        hash += (idmovimientoalmacen != null ? idmovimientoalmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Movimientoalmacen)) {
            return false;
        }
        Movimientoalmacen other = (Movimientoalmacen) object;
        if ((this.idmovimientoalmacen == null && other.idmovimientoalmacen != null) || (this.idmovimientoalmacen != null && !this.idmovimientoalmacen.equals(other.idmovimientoalmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Movimientoalmacen[ idmovimientoalmacen=" + idmovimientoalmacen + " ]";
    }
    
}
