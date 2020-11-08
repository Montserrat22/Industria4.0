/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import dao.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Departamento;
import entidades.Pieza;
import entidades.Preveedor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author jaker
 */
public class PreveedorJpaController implements Serializable {

    public PreveedorJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Preveedor preveedor) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (preveedor.getPiezaCollection() == null) {
            preveedor.setPiezaCollection(new ArrayList<Pieza>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Departamento idDepartamento = preveedor.getIdDepartamento();
            if (idDepartamento != null) {
                idDepartamento = em.getReference(idDepartamento.getClass(), idDepartamento.getId());
                preveedor.setIdDepartamento(idDepartamento);
            }
            Collection<Pieza> attachedPiezaCollection = new ArrayList<Pieza>();
            for (Pieza piezaCollectionPiezaToAttach : preveedor.getPiezaCollection()) {
                piezaCollectionPiezaToAttach = em.getReference(piezaCollectionPiezaToAttach.getClass(), piezaCollectionPiezaToAttach.getId());
                attachedPiezaCollection.add(piezaCollectionPiezaToAttach);
            }
            preveedor.setPiezaCollection(attachedPiezaCollection);
            em.persist(preveedor);
            if (idDepartamento != null) {
                idDepartamento.getPreveedorCollection().add(preveedor);
                idDepartamento = em.merge(idDepartamento);
            }
            for (Pieza piezaCollectionPieza : preveedor.getPiezaCollection()) {
                Preveedor oldIdProveedorOfPiezaCollectionPieza = piezaCollectionPieza.getIdProveedor();
                piezaCollectionPieza.setIdProveedor(preveedor);
                piezaCollectionPieza = em.merge(piezaCollectionPieza);
                if (oldIdProveedorOfPiezaCollectionPieza != null) {
                    oldIdProveedorOfPiezaCollectionPieza.getPiezaCollection().remove(piezaCollectionPieza);
                    oldIdProveedorOfPiezaCollectionPieza = em.merge(oldIdProveedorOfPiezaCollectionPieza);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findPreveedor(preveedor.getId()) != null) {
                throw new PreexistingEntityException("Preveedor " + preveedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Preveedor preveedor) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Preveedor persistentPreveedor = em.find(Preveedor.class, preveedor.getId());
            Departamento idDepartamentoOld = persistentPreveedor.getIdDepartamento();
            Departamento idDepartamentoNew = preveedor.getIdDepartamento();
            Collection<Pieza> piezaCollectionOld = persistentPreveedor.getPiezaCollection();
            Collection<Pieza> piezaCollectionNew = preveedor.getPiezaCollection();
            if (idDepartamentoNew != null) {
                idDepartamentoNew = em.getReference(idDepartamentoNew.getClass(), idDepartamentoNew.getId());
                preveedor.setIdDepartamento(idDepartamentoNew);
            }
            Collection<Pieza> attachedPiezaCollectionNew = new ArrayList<Pieza>();
            for (Pieza piezaCollectionNewPiezaToAttach : piezaCollectionNew) {
                piezaCollectionNewPiezaToAttach = em.getReference(piezaCollectionNewPiezaToAttach.getClass(), piezaCollectionNewPiezaToAttach.getId());
                attachedPiezaCollectionNew.add(piezaCollectionNewPiezaToAttach);
            }
            piezaCollectionNew = attachedPiezaCollectionNew;
            preveedor.setPiezaCollection(piezaCollectionNew);
            preveedor = em.merge(preveedor);
            if (idDepartamentoOld != null && !idDepartamentoOld.equals(idDepartamentoNew)) {
                idDepartamentoOld.getPreveedorCollection().remove(preveedor);
                idDepartamentoOld = em.merge(idDepartamentoOld);
            }
            if (idDepartamentoNew != null && !idDepartamentoNew.equals(idDepartamentoOld)) {
                idDepartamentoNew.getPreveedorCollection().add(preveedor);
                idDepartamentoNew = em.merge(idDepartamentoNew);
            }
            for (Pieza piezaCollectionOldPieza : piezaCollectionOld) {
                if (!piezaCollectionNew.contains(piezaCollectionOldPieza)) {
                    piezaCollectionOldPieza.setIdProveedor(null);
                    piezaCollectionOldPieza = em.merge(piezaCollectionOldPieza);
                }
            }
            for (Pieza piezaCollectionNewPieza : piezaCollectionNew) {
                if (!piezaCollectionOld.contains(piezaCollectionNewPieza)) {
                    Preveedor oldIdProveedorOfPiezaCollectionNewPieza = piezaCollectionNewPieza.getIdProveedor();
                    piezaCollectionNewPieza.setIdProveedor(preveedor);
                    piezaCollectionNewPieza = em.merge(piezaCollectionNewPieza);
                    if (oldIdProveedorOfPiezaCollectionNewPieza != null && !oldIdProveedorOfPiezaCollectionNewPieza.equals(preveedor)) {
                        oldIdProveedorOfPiezaCollectionNewPieza.getPiezaCollection().remove(piezaCollectionNewPieza);
                        oldIdProveedorOfPiezaCollectionNewPieza = em.merge(oldIdProveedorOfPiezaCollectionNewPieza);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = preveedor.getId();
                if (findPreveedor(id) == null) {
                    throw new NonexistentEntityException("The preveedor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Short id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Preveedor preveedor;
            try {
                preveedor = em.getReference(Preveedor.class, id);
                preveedor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The preveedor with id " + id + " no longer exists.", enfe);
            }
            Departamento idDepartamento = preveedor.getIdDepartamento();
            if (idDepartamento != null) {
                idDepartamento.getPreveedorCollection().remove(preveedor);
                idDepartamento = em.merge(idDepartamento);
            }
            Collection<Pieza> piezaCollection = preveedor.getPiezaCollection();
            for (Pieza piezaCollectionPieza : piezaCollection) {
                piezaCollectionPieza.setIdProveedor(null);
                piezaCollectionPieza = em.merge(piezaCollectionPieza);
            }
            em.remove(preveedor);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Preveedor> findPreveedorEntities() {
        return findPreveedorEntities(true, -1, -1);
    }

    public List<Preveedor> findPreveedorEntities(int maxResults, int firstResult) {
        return findPreveedorEntities(false, maxResults, firstResult);
    }

    private List<Preveedor> findPreveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Preveedor.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Preveedor findPreveedor(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Preveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getPreveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Preveedor> rt = cq.from(Preveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
