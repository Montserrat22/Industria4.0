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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author jaker
 */
@Entity
@Table(name = "revisioninteriores")
@NamedQueries({
    @NamedQuery(name = "Revisioninteriores.findAll", query = "SELECT r FROM Revisioninteriores r"),
    @NamedQuery(name = "Revisioninteriores.findById", query = "SELECT r FROM Revisioninteriores r WHERE r.id = :id"),
    @NamedQuery(name = "Revisioninteriores.findByFreno", query = "SELECT r FROM Revisioninteriores r WHERE r.freno = :freno"),
    @NamedQuery(name = "Revisioninteriores.findByVolante", query = "SELECT r FROM Revisioninteriores r WHERE r.volante = :volante"),
    @NamedQuery(name = "Revisioninteriores.findByAsiento", query = "SELECT r FROM Revisioninteriores r WHERE r.asiento = :asiento"),
    @NamedQuery(name = "Revisioninteriores.findByStatusrevision", query = "SELECT r FROM Revisioninteriores r WHERE r.statusrevision = :statusrevision")})
public class Revisioninteriores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Column(name = "freno")
    private Short freno;
    @Column(name = "volante")
    private Short volante;
    @Column(name = "asiento")
    private Short asiento;
    @Column(name = "statusrevision")
    private Short statusrevision;
    @OneToMany(mappedBy = "rinteriores")
    private Collection<Procesoocho> procesoochoCollection;

    public Revisioninteriores() {
    }

    public Revisioninteriores(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Short getFreno() {
        return freno;
    }

    public void setFreno(Short freno) {
        this.freno = freno;
    }

    public Short getVolante() {
        return volante;
    }

    public void setVolante(Short volante) {
        this.volante = volante;
    }

    public Short getAsiento() {
        return asiento;
    }

    public void setAsiento(Short asiento) {
        this.asiento = asiento;
    }

    public Short getStatusrevision() {
        return statusrevision;
    }

    public void setStatusrevision(Short statusrevision) {
        this.statusrevision = statusrevision;
    }

    public Collection<Procesoocho> getProcesoochoCollection() {
        return procesoochoCollection;
    }

    public void setProcesoochoCollection(Collection<Procesoocho> procesoochoCollection) {
        this.procesoochoCollection = procesoochoCollection;
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
        if (!(object instanceof Revisioninteriores)) {
            return false;
        }
        Revisioninteriores other = (Revisioninteriores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Revisioninteriores[ id=" + id + " ]";
    }
    
}
