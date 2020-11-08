/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jaker
 */
@Entity
@Table(name = "empleado")
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findById", query = "SELECT e FROM Empleado e WHERE e.id = :id"),
    @NamedQuery(name = "Empleado.findByNombre", query = "SELECT e FROM Empleado e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "Empleado.findByApellidos", query = "SELECT e FROM Empleado e WHERE e.apellidos = :apellidos"),
    @NamedQuery(name = "Empleado.findByFechanacimiento", query = "SELECT e FROM Empleado e WHERE e.fechanacimiento = :fechanacimiento"),
    @NamedQuery(name = "Empleado.findByDireccion", query = "SELECT e FROM Empleado e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empleado.findByTelefono", query = "SELECT e FROM Empleado e WHERE e.telefono = :telefono"),
    @NamedQuery(name = "Empleado.findByCorreo", query = "SELECT e FROM Empleado e WHERE e.correo = :correo"),
    @NamedQuery(name = "Empleado.findByStatus", query = "SELECT e FROM Empleado e WHERE e.status = :status")})
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Size(max = 99)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 99)
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "fechanacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechanacimiento;
    @Size(max = 99)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private Long telefono;
    @Size(max = 99)
    @Column(name = "correo")
    private String correo;
    @Column(name = "status")
    private Short status;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Procesoseis> procesoseisCollection;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Procesouno> procesounoCollection;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Procesocuatro> procesocuatroCollection;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    @ManyToOne
    private Usuario idUsuario;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Procesodos> procesodosCollection;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Procesocinco> procesocincoCollection;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Procesoocho> procesoochoCollection;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Procesosiete> procesosieteCollection;
    @OneToMany(mappedBy = "idEmpleado")
    private Collection<Procesotres> procesotresCollection;

    public Empleado() {
    }

    public Empleado(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Collection<Procesoseis> getProcesoseisCollection() {
        return procesoseisCollection;
    }

    public void setProcesoseisCollection(Collection<Procesoseis> procesoseisCollection) {
        this.procesoseisCollection = procesoseisCollection;
    }

    public Collection<Procesouno> getProcesounoCollection() {
        return procesounoCollection;
    }

    public void setProcesounoCollection(Collection<Procesouno> procesounoCollection) {
        this.procesounoCollection = procesounoCollection;
    }

    public Collection<Procesocuatro> getProcesocuatroCollection() {
        return procesocuatroCollection;
    }

    public void setProcesocuatroCollection(Collection<Procesocuatro> procesocuatroCollection) {
        this.procesocuatroCollection = procesocuatroCollection;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Collection<Procesodos> getProcesodosCollection() {
        return procesodosCollection;
    }

    public void setProcesodosCollection(Collection<Procesodos> procesodosCollection) {
        this.procesodosCollection = procesodosCollection;
    }

    public Collection<Procesocinco> getProcesocincoCollection() {
        return procesocincoCollection;
    }

    public void setProcesocincoCollection(Collection<Procesocinco> procesocincoCollection) {
        this.procesocincoCollection = procesocincoCollection;
    }

    public Collection<Procesoocho> getProcesoochoCollection() {
        return procesoochoCollection;
    }

    public void setProcesoochoCollection(Collection<Procesoocho> procesoochoCollection) {
        this.procesoochoCollection = procesoochoCollection;
    }

    public Collection<Procesosiete> getProcesosieteCollection() {
        return procesosieteCollection;
    }

    public void setProcesosieteCollection(Collection<Procesosiete> procesosieteCollection) {
        this.procesosieteCollection = procesosieteCollection;
    }

    public Collection<Procesotres> getProcesotresCollection() {
        return procesotresCollection;
    }

    public void setProcesotresCollection(Collection<Procesotres> procesotresCollection) {
        this.procesotresCollection = procesotresCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Empleado[ id=" + id + " ]";
    }
    
}
