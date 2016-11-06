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
@Table(name = "vuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v")
    , @NamedQuery(name = "Vuelo.findByIdvuelo", query = "SELECT v FROM Vuelo v WHERE v.idvuelo = :idvuelo")
    , @NamedQuery(name = "Vuelo.findByFecha", query = "SELECT v FROM Vuelo v WHERE v.fecha = :fecha")
    , @NamedQuery(name = "Vuelo.findByTiempovuelo", query = "SELECT v FROM Vuelo v WHERE v.tiempovuelo = :tiempovuelo")})
public class Vuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idvuelo")
    private Integer idvuelo;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "tiempovuelo")
    private int tiempovuelo;
    @JoinColumn(name = "idavion", referencedColumnName = "idavion")
    @ManyToOne(optional = false)
    private Avion idavion;
    @JoinColumn(name = "idplan", referencedColumnName = "idplan")
    @ManyToOne(optional = false)
    private Plandevuelo idplan;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estado idestado;

    public Vuelo() {
    }

    public Vuelo(Integer idvuelo) {
        this.idvuelo = idvuelo;
    }

    public Vuelo(Integer idvuelo, Date fecha, int tiempovuelo) {
        this.idvuelo = idvuelo;
        this.fecha = fecha;
        this.tiempovuelo = tiempovuelo;
    }

    public Integer getIdvuelo() {
        return idvuelo;
    }

    public void setIdvuelo(Integer idvuelo) {
        this.idvuelo = idvuelo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTiempovuelo() {
        return tiempovuelo;
    }

    public void setTiempovuelo(int tiempovuelo) {
        this.tiempovuelo = tiempovuelo;
    }

    public Avion getIdavion() {
        return idavion;
    }

    public void setIdavion(Avion idavion) {
        this.idavion = idavion;
    }

    public Plandevuelo getIdplan() {
        return idplan;
    }

    public void setIdplan(Plandevuelo idplan) {
        this.idplan = idplan;
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
        hash += (idvuelo != null ? idvuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.idvuelo == null && other.idvuelo != null) || (this.idvuelo != null && !this.idvuelo.equals(other.idvuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Vuelo[ idvuelo=" + idvuelo + " ]";
    }
    
}
