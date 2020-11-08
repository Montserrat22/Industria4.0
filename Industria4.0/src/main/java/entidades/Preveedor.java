/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author jaker
 */
@Entity
@Table(name = "preveedor")
@NamedQueries({
    @NamedQuery(name = "Preveedor.findAll", query = "SELECT p FROM Preveedor p"),
    @NamedQuery(name = "Preveedor.findById", query = "SELECT p FROM Preveedor p WHERE p.id = :id"),
    @NamedQuery(name = "Preveedor.findByNombre", query = "SELECT p FROM Preveedor p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Preveedor.findByDireccion", query = "SELECT p FROM Preveedor p WHERE p.direccion = :direccion"),
    @NamedQuery(name = "Preveedor.findByTelefono", query = "SELECT p FROM Preveedor p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Preveedor.findByCorreo", query = "SELECT p FROM Preveedor p WHERE p.correo = :correo"),
    @NamedQuery(name = "Preveedor.findByStatus", query = "SELECT p FROM Preveedor p WHERE p.status = :status")})
public class Preveedor implements Serializable {

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
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private Long telefono;
    @Size(max = 10)
    @Column(name = "correo")
    private String correo;
    @Column(name = "status")
    private Short status;
    @OneToMany(mappedBy = "idProveedor")
    private Collection<Pieza> piezaCollection;
    @JoinColumn(name = "id_departamento", referencedColumnName = "id")
    @ManyToOne
    private Departamento idDepartamento;

    public Preveedor() {
    }

    public Preveedor(Short id) {
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

    public Collection<Pieza> getPiezaCollection() {
        return piezaCollection;
    }

    public void setPiezaCollection(Collection<Pieza> piezaCollection) {
        this.piezaCollection = piezaCollection;
    }

    public Departamento getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Departamento idDepartamento) {
        this.idDepartamento = idDepartamento;
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
        if (!(object instanceof Preveedor)) {
            return false;
        }
        Preveedor other = (Preveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Preveedor[ id=" + id + " ]";
    }
    
}
