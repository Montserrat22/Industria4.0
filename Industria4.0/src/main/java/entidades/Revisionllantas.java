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
@Table(name = "revisionllantas")
@NamedQueries({
    @NamedQuery(name = "Revisionllantas.findAll", query = "SELECT r FROM Revisionllantas r"),
    @NamedQuery(name = "Revisionllantas.findById", query = "SELECT r FROM Revisionllantas r WHERE r.id = :id"),
    @NamedQuery(name = "Revisionllantas.findByNumllantas", query = "SELECT r FROM Revisionllantas r WHERE r.numllantas = :numllantas"),
    @NamedQuery(name = "Revisionllantas.findByLlantasnuevas", query = "SELECT r FROM Revisionllantas r WHERE r.llantasnuevas = :llantasnuevas"),
    @NamedQuery(name = "Revisionllantas.findByStatusrevision", query = "SELECT r FROM Revisionllantas r WHERE r.statusrevision = :statusrevision")})
public class Revisionllantas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Short id;
    @Column(name = "numllantas")
    private Short numllantas;
    @Column(name = "llantasnuevas")
    private Short llantasnuevas;
    @Column(name = "statusrevision")
    private Short statusrevision;
    @OneToMany(mappedBy = "rllantas")
    private Collection<Procesoocho> procesoochoCollection;

    public Revisionllantas() {
    }

    public Revisionllantas(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Short getNumllantas() {
        return numllantas;
    }

    public void setNumllantas(Short numllantas) {
        this.numllantas = numllantas;
    }

    public Short getLlantasnuevas() {
        return llantasnuevas;
    }

    public void setLlantasnuevas(Short llantasnuevas) {
        this.llantasnuevas = llantasnuevas;
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
        if (!(object instanceof Revisionllantas)) {
            return false;
        }
        Revisionllantas other = (Revisionllantas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Revisionllantas[ id=" + id + " ]";
    }
    
}
