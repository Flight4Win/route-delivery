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
@Table(name = "lugar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lugar.findAll", query = "SELECT l FROM Lugar l")
    , @NamedQuery(name = "Lugar.findByIdlugar", query = "SELECT l FROM Lugar l WHERE l.idlugar = :idlugar")
    , @NamedQuery(name = "Lugar.findByContinente", query = "SELECT l FROM Lugar l WHERE l.continente = :continente")
    , @NamedQuery(name = "Lugar.findByPais", query = "SELECT l FROM Lugar l WHERE l.pais = :pais")
    , @NamedQuery(name = "Lugar.findByCiudad", query = "SELECT l FROM Lugar l WHERE l.ciudad = :ciudad")
    , @NamedQuery(name = "Lugar.findByGmt", query = "SELECT l FROM Lugar l WHERE l.gmt = :gmt")
    , @NamedQuery(name = "Lugar.masEnvios", query="SELECT l.ciudad FROM Paquete p, Aeropuerto a, Lugar l WHERE  p.idorigen = a.idaeropuerto AND a.idlugar = l.idlugar GROUP BY (l.ciudad) ORDER BY COUNT(l.ciudad) DESC ")
})
public class Lugar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idlugar")
    private Integer idlugar;
    @Basic(optional = false)
    @Column(name = "continente")
    private String continente;
    @Basic(optional = false)
    @Column(name = "pais")
    private String pais;
    @Basic(optional = false)
    @Column(name = "ciudad")
    private String ciudad;
    @Basic(optional = false)
    @Column(name = "gmt")
    private int gmt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idlugar")
    private List<Aeropuerto> aeropuertoList;

    public Lugar() {
    }

    public Lugar(Integer idlugar) {
        this.idlugar = idlugar;
    }

    public Lugar(Integer idlugar, String continente, String pais, String ciudad, int gmt) {
        this.idlugar = idlugar;
        this.continente = continente;
        this.pais = pais;
        this.ciudad = ciudad;
        this.gmt = gmt;
    }

    public Lugar(String continente, String pais, String ciudad, int gmt) {
        this.continente = continente;
        this.pais = pais;
        this.ciudad = ciudad;
        this.gmt = gmt;
    }

    public Integer getIdlugar() {
        return idlugar;
    }

    public void setIdlugar(Integer idlugar) {
        this.idlugar = idlugar;
    }

    public String getContinente() {
        return continente;
    }

    public void setContinente(String continente) {
        this.continente = continente;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getGmt() {
        return gmt;
    }

    public void setGmt(int gmt) {
        this.gmt = gmt;
    }

    @XmlTransient
    public List<Aeropuerto> getAeropuertoList() {
        return aeropuertoList;
    }

    public void setAeropuertoList(List<Aeropuerto> aeropuertoList) {
        this.aeropuertoList = aeropuertoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlugar != null ? idlugar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lugar)) {
            return false;
        }
        Lugar other = (Lugar) object;
        if ((this.idlugar == null && other.idlugar != null) || (this.idlugar != null && !this.idlugar.equals(other.idlugar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Lugar[ idlugar=" + idlugar + " ]";
    }
    
}
