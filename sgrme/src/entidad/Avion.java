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
@Table(name = "avion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Avion.findAll", query = "SELECT a FROM Avion a")
    , @NamedQuery(name = "Avion.findByIdavion", query = "SELECT a FROM Avion a WHERE a.idavion = :idavion")
    , @NamedQuery(name = "Avion.findByCodigo", query = "SELECT a FROM Avion a WHERE a.codigo = :codigo")
    , @NamedQuery(name = "Avion.findByCapacidad", query = "SELECT a FROM Avion a WHERE a.capacidad = :capacidad")
    , @NamedQuery(name = "Avion.findByNropaquetes", query = "SELECT a FROM Avion a WHERE a.nropaquetes = :nropaquetes")})
public class Avion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idavion")
    private Integer idavion;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Basic(optional = false)
    @Column(name = "capacidad")
    private int capacidad;
    @Basic(optional = false)
    @Column(name = "nropaquetes")
    private int nropaquetes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idavion")
    private List<Almacenavion> almacenavionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idavion")
    private List<Vuelo> vueloList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idavion")
    private List<Movimientoavion> movimientoavionList;

    public Avion() {
    }

    public Avion(Integer idavion) {
        this.idavion = idavion;
    }

    public Avion(Integer idavion, String codigo, int capacidad, int nropaquetes) {
        this.idavion = idavion;
        this.codigo = codigo;
        this.capacidad = capacidad;
        this.nropaquetes = nropaquetes;
    }

    public Integer getIdavion() {
        return idavion;
    }

    public void setIdavion(Integer idavion) {
        this.idavion = idavion;
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

    @XmlTransient
    public List<Almacenavion> getAlmacenavionList() {
        return almacenavionList;
    }

    public void setAlmacenavionList(List<Almacenavion> almacenavionList) {
        this.almacenavionList = almacenavionList;
    }

    @XmlTransient
    public List<Vuelo> getVueloList() {
        return vueloList;
    }

    public void setVueloList(List<Vuelo> vueloList) {
        this.vueloList = vueloList;
    }

    @XmlTransient
    public List<Movimientoavion> getMovimientoavionList() {
        return movimientoavionList;
    }

    public void setMovimientoavionList(List<Movimientoavion> movimientoavionList) {
        this.movimientoavionList = movimientoavionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idavion != null ? idavion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avion)) {
            return false;
        }
        Avion other = (Avion) object;
        if ((this.idavion == null && other.idavion != null) || (this.idavion != null && !this.idavion.equals(other.idavion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Avion[ idavion=" + idavion + " ]";
    }
    
}
