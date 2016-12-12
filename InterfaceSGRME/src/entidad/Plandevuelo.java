/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juani
 */
@Entity
@Table(name = "plandevuelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plandevuelo.findAll", query = "SELECT p FROM Plandevuelo p")
    , @NamedQuery(name = "Plandevuelo.findByIdplan", query = "SELECT p FROM Plandevuelo p WHERE p.idplan = :idplan")
    , @NamedQuery(name = "Plandevuelo.findByHorainicio", query = "SELECT p FROM Plandevuelo p WHERE p.horainicio = :horainicio")
    , @NamedQuery(name = "Plandevuelo.findByHorafin", query = "SELECT p FROM Plandevuelo p WHERE p.horafin = :horafin")
    , @NamedQuery(name = "Plandevuelo.findByCapacidad", query = "SELECT p FROM Plandevuelo p WHERE p.capacidad = :capacidad")
    , @NamedQuery(name = "Plandevuelo.findByNropaquetes", query = "SELECT p FROM Plandevuelo p WHERE p.nropaquetes = :nropaquetes")
    , @NamedQuery(name = "Plandevuelo.findByCapaviones", query = "SELECT p FROM Plandevuelo p WHERE p.capaviones = :capaviones")
    , @NamedQuery(name = "Plandevuelo.findByDistancia", query = "SELECT p FROM Plandevuelo p WHERE p.distancia = :distancia")})
public class Plandevuelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idplan")
    private Integer idplan;
    @Basic(optional = false)
    @Column(name = "horainicio")
    @Temporal(TemporalType.TIME)
    private Date horainicio;
    @Basic(optional = false)
    @Column(name = "horafin")
    @Temporal(TemporalType.TIME)
    private Date horafin;
    @Basic(optional = false)
    @Column(name = "capacidad")
    private int capacidad;
    @Basic(optional = false)
    @Column(name = "nropaquetes")
    private int nropaquetes;
    @Basic(optional = false)
    @Column(name = "capaviones")
    private int capaviones;
    @Basic(optional = false)
    @Column(name = "distancia")
    private int distancia;
    @JoinColumn(name = "idaeropuertoinicio", referencedColumnName = "idaeropuerto")
    @ManyToOne(optional = false)
    private Aeropuerto idaeropuertoinicio;
    @JoinColumn(name = "idaeropuertofin", referencedColumnName = "idaeropuerto")
    @ManyToOne(optional = false)
    private Aeropuerto idaeropuertofin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idplan")
    private List<Almacenplan> almacenplanList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "plandevuelo")
    private List<Itinerario> itinerarioList;

    public Plandevuelo() {
    }

    public Plandevuelo(Integer idplan) {
        this.idplan = idplan;
    }

    public Plandevuelo(Integer idplan, Date horainicio, Date horafin, int capacidad, int nropaquetes, int capaviones, int distancia) {
        this.idplan = idplan;
        this.horainicio = horainicio;
        this.horafin = horafin;
        this.capacidad = capacidad;
        this.nropaquetes = nropaquetes;
        this.capaviones = capaviones;
        this.distancia = distancia;
    }

    public Integer getIdplan() {
        return idplan;
    }

    public void setIdplan(Integer idplan) {
        this.idplan = idplan;
    }

    public Date getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Date horainicio) {
        this.horainicio = horainicio;
    }

    public Date getHorafin() {
        return horafin;
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getNropaquetes() {
        return nropaquetes;
    }

    public void setNropaquetes(int nropaquetes) {
        this.nropaquetes = nropaquetes;
    }

    public int getCapaviones() {
        return capaviones;
    }

    public void setCapaviones(int capaviones) {
        this.capaviones = capaviones;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public Aeropuerto getIdaeropuertoinicio() {
        return idaeropuertoinicio;
    }

    public void setIdaeropuertoinicio(Aeropuerto idaeropuertoinicio) {
        this.idaeropuertoinicio = idaeropuertoinicio;
    }

    public Aeropuerto getIdaeropuertofin() {
        return idaeropuertofin;
    }

    public void setIdaeropuertofin(Aeropuerto idaeropuertofin) {
        this.idaeropuertofin = idaeropuertofin;
    }

    @XmlTransient
    public List<Almacenplan> getAlmacenplanList() {
        return almacenplanList;
    }

    public void setAlmacenplanList(List<Almacenplan> almacenplanList) {
        this.almacenplanList = almacenplanList;
    }

    @XmlTransient
    public List<Itinerario> getItinerarioList() {
        return itinerarioList;
    }

    public void setItinerarioList(List<Itinerario> itinerarioList) {
        this.itinerarioList = itinerarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idplan != null ? idplan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plandevuelo)) {
            return false;
        }
        Plandevuelo other = (Plandevuelo) object;
        if ((this.idplan == null && other.idplan != null) || (this.idplan != null && !this.idplan.equals(other.idplan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Plandevuelo[ idplan=" + idplan + " ]";
    }
    
}
