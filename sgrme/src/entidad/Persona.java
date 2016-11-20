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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author juani
 */

@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByIdpersona", query = "SELECT p FROM Persona p WHERE p.idpersona = :idpersona")
    , @NamedQuery(name = "Persona.findByDocumento", query = "SELECT p FROM Persona p WHERE p.documento = :documento")
    , @NamedQuery(name = "Persona.findByApellidopat", query = "SELECT p FROM Persona p WHERE p.apellidopat = :apellidopat")
    , @NamedQuery(name = "Persona.findByApellidomat", query = "SELECT p FROM Persona p WHERE p.apellidomat = :apellidomat")
    , @NamedQuery(name = "Persona.findByNombres", query = "SELECT p FROM Persona p WHERE p.nombres = :nombres")
    , @NamedQuery(name = "Persona.findByCelular", query = "SELECT p FROM Persona p WHERE p.celular = :celular")
    , @NamedQuery(name = "Persona.findByCorreo", query = "SELECT p FROM Persona p WHERE p.correo = :correo")
    , @NamedQuery(name = "Persona.delete", query = "DELETE FROM Persona p WHERE p.idpersona = :ipPersona")
    , @NamedQuery(name = "Persona.update", query = "UPDATE Persona p SET p.documento = :documento, p.apellidopat = :apPaterno, p.apellidomat = :apMaterno, p.nombres = :nombre, p.celular = :celular, p.correo = :correo WHERE p.idpersona = :ipPersona")})

public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersona")
    private Integer idpersona;
    @Basic(optional = false)
    @Column(name = "documento")
    private String documento;
    @Basic(optional = false)
    @Column(name = "apellidopat")
    private String apellidopat;
    @Basic(optional = false)
    @Column(name = "apellidomat")
    private String apellidomat;
    @Basic(optional = false)
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "celular")
    private String celular;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpersona")
    private List<Paquete> paqueteList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idpersona")
    private Cliente cliente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idpersona")
    private Empleado empleado;

    public Persona() {
    }

    public Persona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public Persona(Integer idpersona, String documento, String apellidopat, String apellidomat, String nombres, String correo) {
        this.idpersona = idpersona;
        this.documento = documento;
        this.apellidopat = apellidopat;
        this.apellidomat = apellidomat;
        this.nombres = nombres;
        this.correo = correo;
    }

    public Persona(Integer idpersona, String documento, String apellidopat, String apellidomat, String nombres, String celular, String correo) {
        this.idpersona = idpersona;
        this.documento = documento;
        this.apellidopat = apellidopat;
        this.apellidomat = apellidomat;
        this.nombres = nombres;
        this.celular = celular;
        this.correo = correo;
    }

    public Persona(String documento, String apellidopat, String apellidomat, String nombres, String celular, String correo) {
        this.documento = documento;
        this.apellidopat = apellidopat;
        this.apellidomat = apellidomat;
        this.nombres = nombres;
        this.celular = celular;
        this.correo = correo;
    }
    
    
    
    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getApellidopat() {
        return apellidopat;
    }

    public void setApellidopat(String apellidopat) {
        this.apellidopat = apellidopat;
    }

    public String getApellidomat() {
        return apellidomat;
    }

    public void setApellidomat(String apellidomat) {
        this.apellidomat = apellidomat;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public List<Paquete> getPaqueteList() {
        return paqueteList;
    }

    public void setPaqueteList(List<Paquete> paqueteList) {
        this.paqueteList = paqueteList;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersona != null ? idpersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idpersona == null && other.idpersona != null) || (this.idpersona != null && !this.idpersona.equals(other.idpersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Persona[ idpersona=" + idpersona + " ]";
    }
    
}
