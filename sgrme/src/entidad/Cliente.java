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
import javax.persistence.OneToOne;
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
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByIdcliente", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente")
    , @NamedQuery(name = "Cliente.findByCodigo", query = "SELECT c FROM Cliente c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Cliente.findByDocumento", query = "SELECT c FROM Cliente c, Persona p WHERE c.idpersona= p.idpersona AND p.documento = :documento")
    , @NamedQuery(name = "Cliente.findByApellidos", query = "SELECT c FROM Cliente c, Persona p WHERE c.idpersona= p.idpersona AND p.apellidopat = :apellidopat")
    , @NamedQuery(name = "Cliente.findByFechadereg", query = "SELECT c FROM Cliente c WHERE c.fechadereg = :fechadereg")
    , @NamedQuery(name = "Cliente.delete", query = "DELETE FROM Cliente c WHERE c.idcliente = :ipCliente")
    , @NamedQuery(name = "Cliente.unique", query = "SELECT c FROM Cliente c WHERE c.codigo = :codigo")})

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Integer idcliente;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechadereg", nullable = false,
    columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
    private Date fechadereg = new Date();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcliente")
    private List<Paquete> paqueteList;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @OneToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @OneToOne(optional = false)
    private Usuario idusuario;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estado idestado;

    public Cliente() {
    }

    public Cliente(String codigo, Persona idpersona, Usuario idusuario, Estado idestado) {
        this.codigo = codigo;
        this.idpersona = idpersona;
        this.idusuario = idusuario;
        this.idestado = idestado;
    } 
    
    public Cliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public Cliente(Integer idcliente, String codigo) {
        this.idcliente = idcliente;
        this.codigo = codigo;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechadereg() {
        return fechadereg;
    }

    public void setFechadereg(Date fechadereg) {
        this.fechadereg = fechadereg;
    }

    
    
    @XmlTransient
    public List<Paquete> getPaqueteList() {
        return paqueteList;
    }

    public void setPaqueteList(List<Paquete> paqueteList) {
        this.paqueteList = paqueteList;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
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
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Cliente[ idcliente=" + idcliente + " ]";
    }
    
}
