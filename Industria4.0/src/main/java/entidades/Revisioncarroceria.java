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
@Table(name = "revisioncarroceria")
@NamedQueries({
    @NamedQuery(name = "Revisioncarroceria.findAll", query = "SELECT r FROM Revisioncarroceria r"),
    @NamedQuery(name = "Revisioncarroceria.findById", query = "SELECT r FROM Revisioncarroceria r WHERE r.id = :id"),
    @NamedQuery(name = "Revisioncarroceria.findByUniformidad", query = "SELECT r FROM Revisioncarroceria r WHERE r.uniformidad = :uniformidad"),
    @NamedQuery(name = "Revisioncarroceria.findByPorosidad", query = "SELECT r FROM Revisioncarroceria r WHERE r.porosidad = :porosidad"),
    @NamedQuery(name = "Revisioncarroceria.findByStatusrevision", query = "SELECT r FROM Revisioncarroceria r WHERE r.statusrevision = :statusrevision")})
public class Revisioncarroceria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Column(name = "uniformidad")
    private Short uniformidad;
    @Column(name = "porosidad")
    private Short porosidad;
    @Column(name = "statusrevision")
    private Short statusrevision;
    @OneToMany(mappedBy = "rcarroceria")
    private Collection<Procesoocho> procesoochoCollection;

    public Revisioncarroceria() {
    }

    public Revisioncarroceria(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Short getUniformidad() {
        return uniformidad;
    }

    public void setUniformidad(Short uniformidad) {
        this.uniformidad = uniformidad;
    }

    public Short getPorosidad() {
        return porosidad;
    }

    public void setPorosidad(Short porosidad) {
        this.porosidad = porosidad;
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
        if (!(object instanceof Revisioncarroceria)) {
            return false;
        }
        Revisioncarroceria other = (Revisioncarroceria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Revisioncarroceria[ id=" + id + " ]";
    }
    
}
