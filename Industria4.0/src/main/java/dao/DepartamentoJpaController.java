/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import dao.exceptions.RollbackFailureException;
import entidades.Departamento;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Preveedor;
import java.util.ArrayList;
import java.util.Collection;
import entidades.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author jaker
 */
public class DepartamentoJpaController implements Serializable {

    public DepartamentoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Departamento departamento) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (departamento.getPreveedorCollection() == null) {
            departamento.setPreveedorCollection(new ArrayList<Preveedor>());
        }
        if (departamento.getUsuarioCollection() == null) {
            departamento.setUsuarioCollection(new ArrayList<Usuario>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Preveedor> attachedPreveedorCollection = new ArrayList<Preveedor>();
            for (Preveedor preveedorCollectionPreveedorToAttach : departamento.getPreveedorCollection()) {
                preveedorCollectionPreveedorToAttach = em.getReference(preveedorCollectionPreveedorToAttach.getClass(), preveedorCollectionPreveedorToAttach.getId());
                attachedPreveedorCollection.add(preveedorCollectionPreveedorToAttach);
            }
            departamento.setPreveedorCollection(attachedPreveedorCollection);
            Collection<Usuario> attachedUsuarioCollection = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionUsuarioToAttach : departamento.getUsuarioCollection()) {
                usuarioCollectionUsuarioToAttach = em.getReference(usuarioCollectionUsuarioToAttach.getClass(), usuarioCollectionUsuarioToAttach.getId());
                attachedUsuarioCollection.add(usuarioCollectionUsuarioToAttach);
            }
            departamento.setUsuarioCollection(attachedUsuarioCollection);
            em.persist(departamento);
            for (Preveedor preveedorCollectionPreveedor : departamento.getPreveedorCollection()) {
                Departamento oldIdDepartamentoOfPreveedorCollectionPreveedor = preveedorCollectionPreveedor.getIdDepartamento();
                preveedorCollectionPreveedor.setIdDepartamento(departamento);
                preveedorCollectionPreveedor = em.merge(preveedorCollectionPreveedor);
                if (oldIdDepartamentoOfPreveedorCollectionPreveedor != null) {
                    oldIdDepartamentoOfPreveedorCollectionPreveedor.getPreveedorCollection().remove(preveedorCollectionPreveedor);
                    oldIdDepartamentoOfPreveedorCollectionPreveedor = em.merge(oldIdDepartamentoOfPreveedorCollectionPreveedor);
                }
            }
            for (Usuario usuarioCollectionUsuario : departamento.getUsuarioCollection()) {
                Departamento oldIdDepartamentoOfUsuarioCollectionUsuario = usuarioCollectionUsuario.getIdDepartamento();
                usuarioCollectionUsuario.setIdDepartamento(departamento);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
                if (oldIdDepartamentoOfUsuarioCollectionUsuario != null) {
                    oldIdDepartamentoOfUsuarioCollectionUsuario.getUsuarioCollection().remove(usuarioCollectionUsuario);
                    oldIdDepartamentoOfUsuarioCollectionUsuario = em.merge(oldIdDepartamentoOfUsuarioCollectionUsuario);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findDepartamento(departamento.getId()) != null) {
                throw new PreexistingEntityException("Departamento " + departamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Departamento departamento) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Departamento persistentDepartamento = em.find(Departamento.class, departamento.getId());
            Collection<Preveedor> preveedorCollectionOld = persistentDepartamento.getPreveedorCollection();
            Collection<Preveedor> preveedorCollectionNew = departamento.getPreveedorCollection();
            Collection<Usuario> usuarioCollectionOld = persistentDepartamento.getUsuarioCollection();
            Collection<Usuario> usuarioCollectionNew = departamento.getUsuarioCollection();
            Collection<Preveedor> attachedPreveedorCollectionNew = new ArrayList<Preveedor>();
            for (Preveedor preveedorCollectionNewPreveedorToAttach : preveedorCollectionNew) {
                preveedorCollectionNewPreveedorToAttach = em.getReference(preveedorCollectionNewPreveedorToAttach.getClass(), preveedorCollectionNewPreveedorToAttach.getId());
                attachedPreveedorCollectionNew.add(preveedorCollectionNewPreveedorToAttach);
            }
            preveedorCollectionNew = attachedPreveedorCollectionNew;
            departamento.setPreveedorCollection(preveedorCollectionNew);
            Collection<Usuario> attachedUsuarioCollectionNew = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionNewUsuarioToAttach : usuarioCollectionNew) {
                usuarioCollectionNewUsuarioToAttach = em.getReference(usuarioCollectionNewUsuarioToAttach.getClass(), usuarioCollectionNewUsuarioToAttach.getId());
                attachedUsuarioCollectionNew.add(usuarioCollectionNewUsuarioToAttach);
            }
            usuarioCollectionNew = attachedUsuarioCollectionNew;
            departamento.setUsuarioCollection(usuarioCollectionNew);
            departamento = em.merge(departamento);
            for (Preveedor preveedorCollectionOldPreveedor : preveedorCollectionOld) {
                if (!preveedorCollectionNew.contains(preveedorCollectionOldPreveedor)) {
                    preveedorCollectionOldPreveedor.setIdDepartamento(null);
                    preveedorCollectionOldPreveedor = em.merge(preveedorCollectionOldPreveedor);
                }
            }
            for (Preveedor preveedorCollectionNewPreveedor : preveedorCollectionNew) {
                if (!preveedorCollectionOld.contains(preveedorCollectionNewPreveedor)) {
                    Departamento oldIdDepartamentoOfPreveedorCollectionNewPreveedor = preveedorCollectionNewPreveedor.getIdDepartamento();
                    preveedorCollectionNewPreveedor.setIdDepartamento(departamento);
                    preveedorCollectionNewPreveedor = em.merge(preveedorCollectionNewPreveedor);
                    if (oldIdDepartamentoOfPreveedorCollectionNewPreveedor != null && !oldIdDepartamentoOfPreveedorCollectionNewPreveedor.equals(departamento)) {
                        oldIdDepartamentoOfPreveedorCollectionNewPreveedor.getPreveedorCollection().remove(preveedorCollectionNewPreveedor);
                        oldIdDepartamentoOfPreveedorCollectionNewPreveedor = em.merge(oldIdDepartamentoOfPreveedorCollectionNewPreveedor);
                    }
                }
            }
            for (Usuario usuarioCollectionOldUsuario : usuarioCollectionOld) {
                if (!usuarioCollectionNew.contains(usuarioCollectionOldUsuario)) {
                    usuarioCollectionOldUsuario.setIdDepartamento(null);
                    usuarioCollectionOldUsuario = em.merge(usuarioCollectionOldUsuario);
                }
            }
            for (Usuario usuarioCollectionNewUsuario : usuarioCollectionNew) {
                if (!usuarioCollectionOld.contains(usuarioCollectionNewUsuario)) {
                    Departamento oldIdDepartamentoOfUsuarioCollectionNewUsuario = usuarioCollectionNewUsuario.getIdDepartamento();
                    usuarioCollectionNewUsuario.setIdDepartamento(departamento);
                    usuarioCollectionNewUsuario = em.merge(usuarioCollectionNewUsuario);
                    if (oldIdDepartamentoOfUsuarioCollectionNewUsuario != null && !oldIdDepartamentoOfUsuarioCollectionNewUsuario.equals(departamento)) {
                        oldIdDepartamentoOfUsuarioCollectionNewUsuario.getUsuarioCollection().remove(usuarioCollectionNewUsuario);
                        oldIdDepartamentoOfUsuarioCollectionNewUsuario = em.merge(oldIdDepartamentoOfUsuarioCollectionNewUsuario);
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
                Short id = departamento.getId();
                if (findDepartamento(id) == null) {
                    throw new NonexistentEntityException("The departamento with id " + id + " no longer exists.");
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
            Departamento departamento;
            try {
                departamento = em.getReference(Departamento.class, id);
                departamento.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The departamento with id " + id + " no longer exists.", enfe);
            }
            Collection<Preveedor> preveedorCollection = departamento.getPreveedorCollection();
            for (Preveedor preveedorCollectionPreveedor : preveedorCollection) {
                preveedorCollectionPreveedor.setIdDepartamento(null);
                preveedorCollectionPreveedor = em.merge(preveedorCollectionPreveedor);
            }
            Collection<Usuario> usuarioCollection = departamento.getUsuarioCollection();
            for (Usuario usuarioCollectionUsuario : usuarioCollection) {
                usuarioCollectionUsuario.setIdDepartamento(null);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
            }
            em.remove(departamento);
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

    public List<Departamento> findDepartamentoEntities() {
        return findDepartamentoEntities(true, -1, -1);
    }

    public List<Departamento> findDepartamentoEntities(int maxResults, int firstResult) {
        return findDepartamentoEntities(false, maxResults, firstResult);
    }

    private List<Departamento> findDepartamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Departamento.class));
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

    public Departamento findDepartamento(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Departamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getDepartamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Departamento> rt = cq.from(Departamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
