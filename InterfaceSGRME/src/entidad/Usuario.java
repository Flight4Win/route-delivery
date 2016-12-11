/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author juani
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByIdusuario", query = "SELECT u FROM Usuario u WHERE u.idusuario = :idusuario")
    , @NamedQuery(name = "Usuario.findByUsuario", query = "SELECT u FROM Usuario u WHERE u.usuario = :usuario")
    , @NamedQuery(name = "Usuario.logueoByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo AND u.contrasenha = :contrasenha")
    , @NamedQuery(name = "Usuario.findByContrasenha", query = "SELECT u FROM Usuario u WHERE u.contrasenha = :contrasenha")
    , @NamedQuery(name = "Usuario.logueo", query = "SELECT u FROM Usuario u WHERE u.usuario= :usuario AND u.contrasenha = :contrasenha")
    , @NamedQuery(name = "Usuario.existeEmail", query = "SELECT u FROM Usuario u WHERE u.correo = :correo")
})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @Column(name = "contrasenha")
    private String contrasenha;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Cliente cliente;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "idusuario")
    private Empleado empleado;
    @JoinColumn(name = "idperfil", referencedColumnName = "idperfil")
    @ManyToOne(optional = false)
    private Perfil idperfil;

    public Usuario() {
    }

    public Usuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Usuario(Integer idusuario, String usuario, String correo, String contrasenha) {
        this.idusuario = idusuario;
        this.usuario = usuario;
        this.correo = correo;
        this.contrasenha = contrasenha;
    }
    
    public Usuario(String usuario, String correo, String contrasenha, Perfil perfil){
        this.usuario=usuario;
        this.correo=correo;
        this.contrasenha=contrasenha;
        this.idperfil=perfil;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
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

    public Perfil getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Perfil idperfil) {
        this.idperfil = idperfil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Usuario[ idusuario=" + idusuario + " ]";
    }
    
}
