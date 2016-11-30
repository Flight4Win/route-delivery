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
@Table(name = "paquete")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paquete.findAll", query = "SELECT p FROM Paquete p")
    , @NamedQuery(name = "Paquete.findByIdpaquete", query = "SELECT p FROM Paquete p WHERE p.idpaquete = :idpaquete")
    , @NamedQuery(name = "Paquete.findByCodigounico", query = "SELECT p FROM Paquete p WHERE p.codigounico = :codigounico")
    , @NamedQuery(name = "Paquete.findByDescripcion", query = "SELECT p FROM Paquete p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Paquete.findByFechainicio", query = "SELECT p FROM Paquete p WHERE p.fechainicio = :fechainicio")
    , @NamedQuery(name = "Paquete.findByFechafin", query = "SELECT p FROM Paquete p WHERE p.fechafin = :fechafin")
    , @NamedQuery(name = "Paquete.findByFechasRegistro", query = "SELECT p FROM Paquete p WHERE  p.fechainicio BETWEEN :fechainicio AND  :fechafin")
    , @NamedQuery(name = "Paquete.findByTiempomaximo", query = "SELECT p FROM Paquete p WHERE p.tiempomaximo = :tiempomaximo")
    , @NamedQuery(name = "Paquete.findByTiempoestimado", query = "SELECT p FROM Paquete p WHERE p.tiempoestimado = :tiempoestimado")
    , @NamedQuery(name = "Paquete.findByCliente", query = "SELECT p FROM Paquete p WHERE p.idcliente = :idcliente")
    , @NamedQuery(name = "Paquete.findByOrigen", query = "SELECT p FROM Paquete p WHERE p.idorigen = :idorigen")
    , @NamedQuery(name = "Paquete.findByDestino", query = "SELECT p FROM Paquete p WHERE p.iddestino = :iddestino")
    , @NamedQuery(name = "Paquete.reportFechasEnvio", query = "SELECT p FROM Paquete p WHERE  p.fechainicio BETWEEN :fechainicio AND  :fechafin")
    , @NamedQuery(name = "Paquete.reportEstado", query = "SELECT p FROM Paquete p WHERE p.idestado = :idestado")
    , @NamedQuery(name = "Paquete.reportCliente", query = "SELECT p FROM Paquete p WHERE p.idcliente = :idcliente")
    , @NamedQuery(name = "Paquete.reportClienteEstado", query = "SELECT p FROM Paquete p WHERE p.idcliente = :idcliente AND p.idestado = :idestado")
    , @NamedQuery(name = "Paquete.reportClienteFecha", query = "SELECT p FROM Paquete p WHERE  p.idcliente = :idcliente AND (p.fechainicio BETWEEN :fechainicio AND  :fechafin)")
    , @NamedQuery(name = "Paquete.reportEstadoFecha", query = "SELECT p FROM Paquete p WHERE p.idestado = :idestado AND (p.fechainicio BETWEEN :fechainicio AND  :fechafin)")
    , @NamedQuery(name = "Paquete.reportClienteEstadoFecha", query = "SELECT p FROM Paquete p WHERE  p.idcliente = :idcliente AND  p.idestado = :idestado AND (p.fechainicio BETWEEN :fechainicio AND  :fechafin)")
    , @NamedQuery(name = "Paquete.unique", query ="SELECT p FROM Paquete p WHERE p.codigounico = :codigounico")    
})
public class Paquete implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaquete")
    private Integer idpaquete;
    @Basic(optional = false)
    @Column(name = "codigounico")
    private String codigounico;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "fechainicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicio;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fechafin", nullable = false,
    columnDefinition="TIMESTAMP default CURRENT_TIMESTAMP")
    private Date fechafin = new Date();
    @Basic(optional = false)
    @Column(name = "tiempomaximo")
    private int tiempomaximo;
    @Basic(optional = false)
    @Column(name = "tiempoestimado")
    private int tiempoestimado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paquete")
    private List<Itinerario> itinerarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpaquete")
    private List<Almacenavion> almacenavionList;
    @JoinColumn(name = "idorigen", referencedColumnName = "idaeropuerto")
    @ManyToOne(optional = false)
    private Aeropuerto idorigen;
    @JoinColumn(name = "iddestino", referencedColumnName = "idaeropuerto")
    @ManyToOne(optional = false)
    private Aeropuerto iddestino;
    @JoinColumn(name = "idpersona", referencedColumnName = "idpersona")
    @ManyToOne(optional = false)
    private Persona idpersona;
    @JoinColumn(name = "idestado", referencedColumnName = "idestado")
    @ManyToOne(optional = false)
    private Estado idestado;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpaquete")
    private List<Movimientoalmacen> movimientoalmacenList;

    public Paquete() {
    }

    public Paquete(Integer idpaquete) {
        this.idpaquete = idpaquete;
    }

    public Paquete(Integer idpaquete, String codigounico, String descripcion, Date fechainicio, int tiempomaximo, int tiempoestimado) {
        this.idpaquete = idpaquete;
        this.codigounico = codigounico;
        this.descripcion = descripcion;
        this.fechainicio = fechainicio;
        this.tiempomaximo = tiempomaximo;
        this.tiempoestimado = tiempoestimado;
    }

    public Paquete(String codigounico, String descripcion, Date fechainicio, Aeropuerto idorigen, Aeropuerto iddestino, Persona idpersona, Estado idestado, Cliente idcliente) {
        this.codigounico = codigounico;
        this.descripcion = descripcion;
        this.fechainicio = fechainicio;
        this.idorigen = idorigen;
        this.iddestino = iddestino;
        this.idpersona = idpersona;
        this.idestado = idestado;
        this.idcliente = idcliente;
    }

    
    
    public Integer getIdpaquete() {
        return idpaquete;
    }

    public void setIdpaquete(Integer idpaquete) {
        this.idpaquete = idpaquete;
    }

    public String getCodigounico() {
        return codigounico;
    }

    public void setCodigounico(String codigounico) {
        this.codigounico = codigounico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafin() {
        return fechafin;
    }

    public void setFechafin(Date fechafin) {
        this.fechafin = fechafin;
    }

    public int getTiempomaximo() {
        return tiempomaximo;
    }

    public void setTiempomaximo(int tiempomaximo) {
        this.tiempomaximo = tiempomaximo;
    }

    public int getTiempoestimado() {
        return tiempoestimado;
    }

    public void setTiempoestimado(int tiempoestimado) {
        this.tiempoestimado = tiempoestimado;
    }

    @XmlTransient
    public List<Itinerario> getItinerarioList() {
        return itinerarioList;
    }

    public void setItinerarioList(List<Itinerario> itinerarioList) {
        this.itinerarioList = itinerarioList;
    }

    @XmlTransient
    public List<Almacenavion> getAlmacenavionList() {
        return almacenavionList;
    }

    public void setAlmacenavionList(List<Almacenavion> almacenavionList) {
        this.almacenavionList = almacenavionList;
    }

    public Aeropuerto getIdorigen() {
        return idorigen;
    }

    public void setIdorigen(Aeropuerto idorigen) {
        this.idorigen = idorigen;
    }

    public Aeropuerto getIddestino() {
        return iddestino;
    }

    public void setIddestino(Aeropuerto iddestino) {
        this.iddestino = iddestino;
    }

    public Persona getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Persona idpersona) {
        this.idpersona = idpersona;
    }

    public Estado getIdestado() {
        return idestado;
    }

    public void setIdestado(Estado idestado) {
        this.idestado = idestado;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
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
        hash += (idpaquete != null ? idpaquete.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paquete)) {
            return false;
        }
        Paquete other = (Paquete) object;
        if ((this.idpaquete == null && other.idpaquete != null) || (this.idpaquete != null && !this.idpaquete.equals(other.idpaquete))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Paquete[ idpaquete=" + idpaquete + " ]";
    }
    
}
