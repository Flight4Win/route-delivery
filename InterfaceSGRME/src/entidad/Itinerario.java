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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "itinerario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Itinerario.findAll", query = "SELECT i FROM Itinerario i")
    , @NamedQuery(name = "Itinerario.findByIditinerario", query = "SELECT i FROM Itinerario i WHERE i.itinerarioPK.iditinerario = :iditinerario")
    , @NamedQuery(name = "Itinerario.findByIdpaquete", query = "SELECT i FROM Itinerario i WHERE i.itinerarioPK.idpaquete = :idpaquete")
    , @NamedQuery(name = "Itinerario.findByIdplan", query = "SELECT i FROM Itinerario i WHERE i.itinerarioPK.idplan = :idplan")
    , @NamedQuery(name = "Itinerario.findByFecha", query = "SELECT i FROM Itinerario i WHERE i.fecha = :fecha")
    , @NamedQuery(name = "Itinerario.findByNrocalculo", query = "SELECT i FROM Itinerario i WHERE i.nrocalculo = :nrocalculo")})
public class Itinerario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ItinerarioPK itinerarioPK;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "nrocalculo")
    private int nrocalculo;
    @JoinColumn(name = "idpaquete", referencedColumnName = "idpaquete", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Paquete paquete;
    @JoinColumn(name = "idplan", referencedColumnName = "idplan", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Plandevuelo plandevuelo;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estado idestado;

    public Itinerario() {
    }

    public Itinerario(ItinerarioPK itinerarioPK) {
        this.itinerarioPK = itinerarioPK;
    }

    public Itinerario(ItinerarioPK itinerarioPK, Date fecha, int nrocalculo) {
        this.itinerarioPK = itinerarioPK;
        this.fecha = fecha;
        this.nrocalculo = nrocalculo;
    }

    public Itinerario(int iditinerario, int idpaquete, int idplan) {
        this.itinerarioPK = new ItinerarioPK(iditinerario, idpaquete, idplan);
    }

    public ItinerarioPK getItinerarioPK() {
        return itinerarioPK;
    }

    public void setItinerarioPK(ItinerarioPK itinerarioPK) {
        this.itinerarioPK = itinerarioPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNrocalculo() {
        return nrocalculo;
    }

    public void setNrocalculo(int nrocalculo) {
        this.nrocalculo = nrocalculo;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public Plandevuelo getPlandevuelo() {
        return plandevuelo;
    }

    public void setPlandevuelo(Plandevuelo plandevuelo) {
        this.plandevuelo = plandevuelo;
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
        hash += (itinerarioPK != null ? itinerarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itinerario)) {
            return false;
        }
        Itinerario other = (Itinerario) object;
        if ((this.itinerarioPK == null && other.itinerarioPK != null) || (this.itinerarioPK != null && !this.itinerarioPK.equals(other.itinerarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Itinerario[ itinerarioPK=" + itinerarioPK + " ]";
    }
    
}
