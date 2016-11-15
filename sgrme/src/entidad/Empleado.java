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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juani
 */
@Entity
@Table(name = "empleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e")
    , @NamedQuery(name = "Empleado.findByIdempleado", query = "SELECT e FROM Empleado e WHERE e.idempleado = :idempleado")
    , @NamedQuery(name = "Empleado.findByCodigo", query = "SELECT e FROM Empleado e WHERE e.codigo = :codigo")
    , @NamedQuery(name = "Empleado.findByDocumento", query = "SELECT e FROM Empleado e, Persona p WHERE e.idpersona= p.idpersona AND p.documento = :documento")
    , @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e, Persona p WHERE e.idpersona= p.idpersona AND (p.apellidopat = :apellidopat OR p.apellidomat = :apellidopat)")
    , @NamedQuery(name = "Empleado.findByFechadereg", query = "SELECT e FROM Empleado e WHERE e.fechadereg = :fechadereg")
    , @NamedQuery(name = "Empleado.delete", query = "DELETE FROM Empleado e WHERE e.idempleado = :idEmpleado")})

public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idempleado")
    private Integer idempleado;
    @Basic(optional = false)
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "fechadereg")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechadereg;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @OneToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
    @OneToOne(optional = false)
    private Usuario idusuario;
    @JoinColumn(name = "idcargo", referencedColumnName = "idcargo")
    @ManyToOne(optional = false)
    private Cargo idcargo;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estado idestado;

    public Empleado() {
    }

    public Empleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public Empleado(Integer idempleado, String codigo) {
        this.idempleado = idempleado;
        this.codigo = codigo;
    }

    public Empleado(String codigo, Persona idpersona, Usuario idusuario, Cargo idcargo, Estado idestado) {
        this.codigo = codigo;
        this.idpersona = idpersona;
        this.idusuario = idusuario;
        this.idcargo = idcargo;
        this.idestado = idestado;
    }

    
    
    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
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

    public Cargo getIdcargo() {
        return idcargo;
    }

    public void setIdcargo(Cargo idcargo) {
        this.idcargo = idcargo;
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
        hash += (idempleado != null ? idempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.idempleado == null && other.idempleado != null) || (this.idempleado != null && !this.idempleado.equals(other.idempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Empleado[ idempleado=" + idempleado + " ]";
    }
    
}
