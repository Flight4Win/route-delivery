/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juani
 */
@Entity
@Table(name = "aeropuerto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aeropuerto.findAll", query = "SELECT a FROM Aeropuerto a")
    , @NamedQuery(name = "Aeropuerto.findByIdaeropuerto", query = "SELECT a FROM Aeropuerto a WHERE a.idaeropuerto = :idaeropuerto")
    , @NamedQuery(name = "Aeropuerto.findByCodigo", query = "SELECT a FROM Aeropuerto a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Aeropuerto.findByCapacidad", query = "SELECT a FROM Aeropuerto a WHERE a.capacidad = :capacidad")
    , @NamedQuery(name = "Aeropuerto.findByNropaquetes", query = "SELECT a FROM Aeropuerto a WHERE a.nropaquetes = :nropaquetes")
    , @NamedQuery(name = "Aeropuerto.findByNroaviones", query = "SELECT a FROM Aeropuerto a WHERE a.nroaviones = :nroaviones")
    , @NamedQuery(name = "Aeropuerto.findByLongitud", query = "SELECT a FROM Aeropuerto a WHERE a.longitud = :longitud")
    , @NamedQuery(name = "Aeropuerto.findByLatitud", query = "SELECT a FROM Aeropuerto a WHERE a.latitud = :latitud")
    , @NamedQuery(name = "Aeropuerto.findByLugar", query = "SELECT a FROM Aeropuerto a WHERE a.idlugar = :idlugar") 
})
public class Aeropuerto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idaeropuerto")
    private Integer idaeropuerto;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "capacidad")
    private int capacidad;
    @Basic(optional = false)
    @Column(name = "nropaquetes")
    private int nropaquetes;
    @Basic(optional = false)
    @Column(name = "nroaviones")
    private int nroaviones;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "longitud")
    private Double longitud;
    @Column(name = "latitud")
    private Double latitud;
    @JoinColumn(name = "idlugar", referencedColumnName = "idlugar")
    @ManyToOne(optional = false)
    private Lugar idlugar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idaeropuertoinicio")
    private List<Plandevuelo> plandevueloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idaeropuertofin")
    private List<Plandevuelo> plandevueloList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idorigen")
    private List<Paquete> paqueteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddestino")
    private List<Paquete> paqueteList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idaeropuerto")
    private List<Movimientoalmacen> movimientoalmacenList;

    public Aeropuerto() {
    }

    public Aeropuerto(Integer idaeropuerto) {
        this.idaeropuerto = idaeropuerto;
    }

    public Aeropuerto(Integer idaeropuerto, String codigo, int capacidad, int nropaquetes, int nroaviones) {
        this.idaeropuerto = idaeropuerto;
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.nropaquetes = nropaquetes;
        this.nroaviones = nroaviones;
    }

    public Aeropuerto(String codigo, int capacidad, int nropaquetes, int nroaviones) {
        this.codigo=codigo;
        this.capacidad=capacidad;
        this.nropaquetes=nropaquetes;
        this.nroaviones=nroaviones;
    }

    public Aeropuerto(String codigo, int capacidad, Lugar l) {
        this.codigo=codigo;
        this.capacidad=capacidad;
        this.idlugar=l;
    }


    public Integer getIdaeropuerto() {
        return idaeropuerto;
    }

    public void setIdaeropuerto(Integer idaeropuerto) {
        this.idaeropuerto = idaeropuerto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
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

    public int getNroaviones() {
        return nroaviones;
    }

    public void setNroaviones(int nroaviones) {
        this.nroaviones = nroaviones;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Lugar getIdlugar() {
        return idlugar;
    }

    public void setIdlugar(Lugar idlugar) {
        this.idlugar = idlugar;
    }

    @XmlTransient
    public List<Plandevuelo> getPlandevueloList() {
        return plandevueloList;
    }

    public void setPlandevueloList(List<Plandevuelo> plandevueloList) {
        this.plandevueloList = plandevueloList;
    }

    @XmlTransient
    public List<Plandevuelo> getPlandevueloList1() {
        return plandevueloList1;
    }

    public void setPlandevueloList1(List<Plandevuelo> plandevueloList1) {
        this.plandevueloList1 = plandevueloList1;
    }

    @XmlTransient
    public List<Paquete> getPaqueteList() {
        return paqueteList;
    }

    public void setPaqueteList(List<Paquete> paqueteList) {
        this.paqueteList = paqueteList;
    }

    @XmlTransient
    public List<Paquete> getPaqueteList1() {
        return paqueteList1;
    }

    public void setPaqueteList1(List<Paquete> paqueteList1) {
        this.paqueteList1 = paqueteList1;
    }

    @XmlTransient
    public List<Movimientoalmacen> getMovimientoalmacenList() {
        return movimientoalmacenList;
    }

    public void setMovimientoalmacenList(List<Movimientoalmacen> movimientoalmacenList) {
        this.movimientoalmacenList = movimientoalmacenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idaeropuerto != null ? idaeropuerto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aeropuerto)) {
            return false;
        }
        Aeropuerto other = (Aeropuerto) object;
        if ((this.idaeropuerto == null && other.idaeropuerto != null) || (this.idaeropuerto != null && !this.idaeropuerto.equals(other.idaeropuerto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Aeropuerto[ idaeropuerto=" + idaeropuerto + " ]";
    }
    
}
