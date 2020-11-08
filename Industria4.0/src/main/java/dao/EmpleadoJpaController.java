/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.exceptions.NonexistentEntityException;
import dao.exceptions.PreexistingEntityException;
import dao.exceptions.RollbackFailureException;
import entidades.Empleado;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidades.Usuario;
import entidades.Procesoseis;
import java.util.ArrayList;
import java.util.Collection;
import entidades.Procesouno;
import entidades.Procesocuatro;
import entidades.Procesodos;
import entidades.Procesocinco;
import entidades.Procesoocho;
import entidades.Procesosiete;
import entidades.Procesotres;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author jaker
 */
public class EmpleadoJpaController implements Serializable {

    public EmpleadoJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (empleado.getProcesoseisCollection() == null) {
            empleado.setProcesoseisCollection(new ArrayList<Procesoseis>());
        }
        if (empleado.getProcesounoCollection() == null) {
            empleado.setProcesounoCollection(new ArrayList<Procesouno>());
        }
        if (empleado.getProcesocuatroCollection() == null) {
            empleado.setProcesocuatroCollection(new ArrayList<Procesocuatro>());
        }
        if (empleado.getProcesodosCollection() == null) {
            empleado.setProcesodosCollection(new ArrayList<Procesodos>());
        }
        if (empleado.getProcesocincoCollection() == null) {
            empleado.setProcesocincoCollection(new ArrayList<Procesocinco>());
        }
        if (empleado.getProcesoochoCollection() == null) {
            empleado.setProcesoochoCollection(new ArrayList<Procesoocho>());
        }
        if (empleado.getProcesosieteCollection() == null) {
            empleado.setProcesosieteCollection(new ArrayList<Procesosiete>());
        }
        if (empleado.getProcesotresCollection() == null) {
            empleado.setProcesotresCollection(new ArrayList<Procesotres>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Usuario idUsuario = empleado.getIdUsuario();
            if (idUsuario != null) {
                idUsuario = em.getReference(idUsuario.getClass(), idUsuario.getId());
                empleado.setIdUsuario(idUsuario);
            }
            Collection<Procesoseis> attachedProcesoseisCollection = new ArrayList<Procesoseis>();
            for (Procesoseis procesoseisCollectionProcesoseisToAttach : empleado.getProcesoseisCollection()) {
                procesoseisCollectionProcesoseisToAttach = em.getReference(procesoseisCollectionProcesoseisToAttach.getClass(), procesoseisCollectionProcesoseisToAttach.getId());
                attachedProcesoseisCollection.add(procesoseisCollectionProcesoseisToAttach);
            }
            empleado.setProcesoseisCollection(attachedProcesoseisCollection);
            Collection<Procesouno> attachedProcesounoCollection = new ArrayList<Procesouno>();
            for (Procesouno procesounoCollectionProcesounoToAttach : empleado.getProcesounoCollection()) {
                procesounoCollectionProcesounoToAttach = em.getReference(procesounoCollectionProcesounoToAttach.getClass(), procesounoCollectionProcesounoToAttach.getId());
                attachedProcesounoCollection.add(procesounoCollectionProcesounoToAttach);
            }
            empleado.setProcesounoCollection(attachedProcesounoCollection);
            Collection<Procesocuatro> attachedProcesocuatroCollection = new ArrayList<Procesocuatro>();
            for (Procesocuatro procesocuatroCollectionProcesocuatroToAttach : empleado.getProcesocuatroCollection()) {
                procesocuatroCollectionProcesocuatroToAttach = em.getReference(procesocuatroCollectionProcesocuatroToAttach.getClass(), procesocuatroCollectionProcesocuatroToAttach.getId());
                attachedProcesocuatroCollection.add(procesocuatroCollectionProcesocuatroToAttach);
            }
            empleado.setProcesocuatroCollection(attachedProcesocuatroCollection);
            Collection<Procesodos> attachedProcesodosCollection = new ArrayList<Procesodos>();
            for (Procesodos procesodosCollectionProcesodosToAttach : empleado.getProcesodosCollection()) {
                procesodosCollectionProcesodosToAttach = em.getReference(procesodosCollectionProcesodosToAttach.getClass(), procesodosCollectionProcesodosToAttach.getId());
                attachedProcesodosCollection.add(procesodosCollectionProcesodosToAttach);
            }
            empleado.setProcesodosCollection(attachedProcesodosCollection);
            Collection<Procesocinco> attachedProcesocincoCollection = new ArrayList<Procesocinco>();
            for (Procesocinco procesocincoCollectionProcesocincoToAttach : empleado.getProcesocincoCollection()) {
                procesocincoCollectionProcesocincoToAttach = em.getReference(procesocincoCollectionProcesocincoToAttach.getClass(), procesocincoCollectionProcesocincoToAttach.getId());
                attachedProcesocincoCollection.add(procesocincoCollectionProcesocincoToAttach);
            }
            empleado.setProcesocincoCollection(attachedProcesocincoCollection);
            Collection<Procesoocho> attachedProcesoochoCollection = new ArrayList<Procesoocho>();
            for (Procesoocho procesoochoCollectionProcesoochoToAttach : empleado.getProcesoochoCollection()) {
                procesoochoCollectionProcesoochoToAttach = em.getReference(procesoochoCollectionProcesoochoToAttach.getClass(), procesoochoCollectionProcesoochoToAttach.getId());
                attachedProcesoochoCollection.add(procesoochoCollectionProcesoochoToAttach);
            }
            empleado.setProcesoochoCollection(attachedProcesoochoCollection);
            Collection<Procesosiete> attachedProcesosieteCollection = new ArrayList<Procesosiete>();
            for (Procesosiete procesosieteCollectionProcesosieteToAttach : empleado.getProcesosieteCollection()) {
                procesosieteCollectionProcesosieteToAttach = em.getReference(procesosieteCollectionProcesosieteToAttach.getClass(), procesosieteCollectionProcesosieteToAttach.getId());
                attachedProcesosieteCollection.add(procesosieteCollectionProcesosieteToAttach);
            }
            empleado.setProcesosieteCollection(attachedProcesosieteCollection);
            Collection<Procesotres> attachedProcesotresCollection = new ArrayList<Procesotres>();
            for (Procesotres procesotresCollectionProcesotresToAttach : empleado.getProcesotresCollection()) {
                procesotresCollectionProcesotresToAttach = em.getReference(procesotresCollectionProcesotresToAttach.getClass(), procesotresCollectionProcesotresToAttach.getId());
                attachedProcesotresCollection.add(procesotresCollectionProcesotresToAttach);
            }
            empleado.setProcesotresCollection(attachedProcesotresCollection);
            em.persist(empleado);
            if (idUsuario != null) {
                idUsuario.getEmpleadoCollection().add(empleado);
                idUsuario = em.merge(idUsuario);
            }
            for (Procesoseis procesoseisCollectionProcesoseis : empleado.getProcesoseisCollection()) {
                Empleado oldIdEmpleadoOfProcesoseisCollectionProcesoseis = procesoseisCollectionProcesoseis.getIdEmpleado();
                procesoseisCollectionProcesoseis.setIdEmpleado(empleado);
                procesoseisCollectionProcesoseis = em.merge(procesoseisCollectionProcesoseis);
                if (oldIdEmpleadoOfProcesoseisCollectionProcesoseis != null) {
                    oldIdEmpleadoOfProcesoseisCollectionProcesoseis.getProcesoseisCollection().remove(procesoseisCollectionProcesoseis);
                    oldIdEmpleadoOfProcesoseisCollectionProcesoseis = em.merge(oldIdEmpleadoOfProcesoseisCollectionProcesoseis);
                }
            }
            for (Procesouno procesounoCollectionProcesouno : empleado.getProcesounoCollection()) {
                Empleado oldIdEmpleadoOfProcesounoCollectionProcesouno = procesounoCollectionProcesouno.getIdEmpleado();
                procesounoCollectionProcesouno.setIdEmpleado(empleado);
                procesounoCollectionProcesouno = em.merge(procesounoCollectionProcesouno);
                if (oldIdEmpleadoOfProcesounoCollectionProcesouno != null) {
                    oldIdEmpleadoOfProcesounoCollectionProcesouno.getProcesounoCollection().remove(procesounoCollectionProcesouno);
                    oldIdEmpleadoOfProcesounoCollectionProcesouno = em.merge(oldIdEmpleadoOfProcesounoCollectionProcesouno);
                }
            }
            for (Procesocuatro procesocuatroCollectionProcesocuatro : empleado.getProcesocuatroCollection()) {
                Empleado oldIdEmpleadoOfProcesocuatroCollectionProcesocuatro = procesocuatroCollectionProcesocuatro.getIdEmpleado();
                procesocuatroCollectionProcesocuatro.setIdEmpleado(empleado);
                procesocuatroCollectionProcesocuatro = em.merge(procesocuatroCollectionProcesocuatro);
                if (oldIdEmpleadoOfProcesocuatroCollectionProcesocuatro != null) {
                    oldIdEmpleadoOfProcesocuatroCollectionProcesocuatro.getProcesocuatroCollection().remove(procesocuatroCollectionProcesocuatro);
                    oldIdEmpleadoOfProcesocuatroCollectionProcesocuatro = em.merge(oldIdEmpleadoOfProcesocuatroCollectionProcesocuatro);
                }
            }
            for (Procesodos procesodosCollectionProcesodos : empleado.getProcesodosCollection()) {
                Empleado oldIdEmpleadoOfProcesodosCollectionProcesodos = procesodosCollectionProcesodos.getIdEmpleado();
                procesodosCollectionProcesodos.setIdEmpleado(empleado);
                procesodosCollectionProcesodos = em.merge(procesodosCollectionProcesodos);
                if (oldIdEmpleadoOfProcesodosCollectionProcesodos != null) {
                    oldIdEmpleadoOfProcesodosCollectionProcesodos.getProcesodosCollection().remove(procesodosCollectionProcesodos);
                    oldIdEmpleadoOfProcesodosCollectionProcesodos = em.merge(oldIdEmpleadoOfProcesodosCollectionProcesodos);
                }
            }
            for (Procesocinco procesocincoCollectionProcesocinco : empleado.getProcesocincoCollection()) {
                Empleado oldIdEmpleadoOfProcesocincoCollectionProcesocinco = procesocincoCollectionProcesocinco.getIdEmpleado();
                procesocincoCollectionProcesocinco.setIdEmpleado(empleado);
                procesocincoCollectionProcesocinco = em.merge(procesocincoCollectionProcesocinco);
                if (oldIdEmpleadoOfProcesocincoCollectionProcesocinco != null) {
                    oldIdEmpleadoOfProcesocincoCollectionProcesocinco.getProcesocincoCollection().remove(procesocincoCollectionProcesocinco);
                    oldIdEmpleadoOfProcesocincoCollectionProcesocinco = em.merge(oldIdEmpleadoOfProcesocincoCollectionProcesocinco);
                }
            }
            for (Procesoocho procesoochoCollectionProcesoocho : empleado.getProcesoochoCollection()) {
                Empleado oldIdEmpleadoOfProcesoochoCollectionProcesoocho = procesoochoCollectionProcesoocho.getIdEmpleado();
                procesoochoCollectionProcesoocho.setIdEmpleado(empleado);
                procesoochoCollectionProcesoocho = em.merge(procesoochoCollectionProcesoocho);
                if (oldIdEmpleadoOfProcesoochoCollectionProcesoocho != null) {
                    oldIdEmpleadoOfProcesoochoCollectionProcesoocho.getProcesoochoCollection().remove(procesoochoCollectionProcesoocho);
                    oldIdEmpleadoOfProcesoochoCollectionProcesoocho = em.merge(oldIdEmpleadoOfProcesoochoCollectionProcesoocho);
                }
            }
            for (Procesosiete procesosieteCollectionProcesosiete : empleado.getProcesosieteCollection()) {
                Empleado oldIdEmpleadoOfProcesosieteCollectionProcesosiete = procesosieteCollectionProcesosiete.getIdEmpleado();
                procesosieteCollectionProcesosiete.setIdEmpleado(empleado);
                procesosieteCollectionProcesosiete = em.merge(procesosieteCollectionProcesosiete);
                if (oldIdEmpleadoOfProcesosieteCollectionProcesosiete != null) {
                    oldIdEmpleadoOfProcesosieteCollectionProcesosiete.getProcesosieteCollection().remove(procesosieteCollectionProcesosiete);
                    oldIdEmpleadoOfProcesosieteCollectionProcesosiete = em.merge(oldIdEmpleadoOfProcesosieteCollectionProcesosiete);
                }
            }
            for (Procesotres procesotresCollectionProcesotres : empleado.getProcesotresCollection()) {
                Empleado oldIdEmpleadoOfProcesotresCollectionProcesotres = procesotresCollectionProcesotres.getIdEmpleado();
                procesotresCollectionProcesotres.setIdEmpleado(empleado);
                procesotresCollectionProcesotres = em.merge(procesotresCollectionProcesotres);
                if (oldIdEmpleadoOfProcesotresCollectionProcesotres != null) {
                    oldIdEmpleadoOfProcesotresCollectionProcesotres.getProcesotresCollection().remove(procesotresCollectionProcesotres);
                    oldIdEmpleadoOfProcesotresCollectionProcesotres = em.merge(oldIdEmpleadoOfProcesotresCollectionProcesotres);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findEmpleado(empleado.getId()) != null) {
                throw new PreexistingEntityException("Empleado " + empleado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empleado empleado) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Empleado persistentEmpleado = em.find(Empleado.class, empleado.getId());
            Usuario idUsuarioOld = persistentEmpleado.getIdUsuario();
            Usuario idUsuarioNew = empleado.getIdUsuario();
            Collection<Procesoseis> procesoseisCollectionOld = persistentEmpleado.getProcesoseisCollection();
            Collection<Procesoseis> procesoseisCollectionNew = empleado.getProcesoseisCollection();
            Collection<Procesouno> procesounoCollectionOld = persistentEmpleado.getProcesounoCollection();
            Collection<Procesouno> procesounoCollectionNew = empleado.getProcesounoCollection();
            Collection<Procesocuatro> procesocuatroCollectionOld = persistentEmpleado.getProcesocuatroCollection();
            Collection<Procesocuatro> procesocuatroCollectionNew = empleado.getProcesocuatroCollection();
            Collection<Procesodos> procesodosCollectionOld = persistentEmpleado.getProcesodosCollection();
            Collection<Procesodos> procesodosCollectionNew = empleado.getProcesodosCollection();
            Collection<Procesocinco> procesocincoCollectionOld = persistentEmpleado.getProcesocincoCollection();
            Collection<Procesocinco> procesocincoCollectionNew = empleado.getProcesocincoCollection();
            Collection<Procesoocho> procesoochoCollectionOld = persistentEmpleado.getProcesoochoCollection();
            Collection<Procesoocho> procesoochoCollectionNew = empleado.getProcesoochoCollection();
            Collection<Procesosiete> procesosieteCollectionOld = persistentEmpleado.getProcesosieteCollection();
            Collection<Procesosiete> procesosieteCollectionNew = empleado.getProcesosieteCollection();
            Collection<Procesotres> procesotresCollectionOld = persistentEmpleado.getProcesotresCollection();
            Collection<Procesotres> procesotresCollectionNew = empleado.getProcesotresCollection();
            if (idUsuarioNew != null) {
                idUsuarioNew = em.getReference(idUsuarioNew.getClass(), idUsuarioNew.getId());
                empleado.setIdUsuario(idUsuarioNew);
            }
            Collection<Procesoseis> attachedProcesoseisCollectionNew = new ArrayList<Procesoseis>();
            for (Procesoseis procesoseisCollectionNewProcesoseisToAttach : procesoseisCollectionNew) {
                procesoseisCollectionNewProcesoseisToAttach = em.getReference(procesoseisCollectionNewProcesoseisToAttach.getClass(), procesoseisCollectionNewProcesoseisToAttach.getId());
                attachedProcesoseisCollectionNew.add(procesoseisCollectionNewProcesoseisToAttach);
            }
            procesoseisCollectionNew = attachedProcesoseisCollectionNew;
            empleado.setProcesoseisCollection(procesoseisCollectionNew);
            Collection<Procesouno> attachedProcesounoCollectionNew = new ArrayList<Procesouno>();
            for (Procesouno procesounoCollectionNewProcesounoToAttach : procesounoCollectionNew) {
                procesounoCollectionNewProcesounoToAttach = em.getReference(procesounoCollectionNewProcesounoToAttach.getClass(), procesounoCollectionNewProcesounoToAttach.getId());
                attachedProcesounoCollectionNew.add(procesounoCollectionNewProcesounoToAttach);
            }
            procesounoCollectionNew = attachedProcesounoCollectionNew;
            empleado.setProcesounoCollection(procesounoCollectionNew);
            Collection<Procesocuatro> attachedProcesocuatroCollectionNew = new ArrayList<Procesocuatro>();
            for (Procesocuatro procesocuatroCollectionNewProcesocuatroToAttach : procesocuatroCollectionNew) {
                procesocuatroCollectionNewProcesocuatroToAttach = em.getReference(procesocuatroCollectionNewProcesocuatroToAttach.getClass(), procesocuatroCollectionNewProcesocuatroToAttach.getId());
                attachedProcesocuatroCollectionNew.add(procesocuatroCollectionNewProcesocuatroToAttach);
            }
            procesocuatroCollectionNew = attachedProcesocuatroCollectionNew;
            empleado.setProcesocuatroCollection(procesocuatroCollectionNew);
            Collection<Procesodos> attachedProcesodosCollectionNew = new ArrayList<Procesodos>();
            for (Procesodos procesodosCollectionNewProcesodosToAttach : procesodosCollectionNew) {
                procesodosCollectionNewProcesodosToAttach = em.getReference(procesodosCollectionNewProcesodosToAttach.getClass(), procesodosCollectionNewProcesodosToAttach.getId());
                attachedProcesodosCollectionNew.add(procesodosCollectionNewProcesodosToAttach);
            }
            procesodosCollectionNew = attachedProcesodosCollectionNew;
            empleado.setProcesodosCollection(procesodosCollectionNew);
            Collection<Procesocinco> attachedProcesocincoCollectionNew = new ArrayList<Procesocinco>();
            for (Procesocinco procesocincoCollectionNewProcesocincoToAttach : procesocincoCollectionNew) {
                procesocincoCollectionNewProcesocincoToAttach = em.getReference(procesocincoCollectionNewProcesocincoToAttach.getClass(), procesocincoCollectionNewProcesocincoToAttach.getId());
                attachedProcesocincoCollectionNew.add(procesocincoCollectionNewProcesocincoToAttach);
            }
            procesocincoCollectionNew = attachedProcesocincoCollectionNew;
            empleado.setProcesocincoCollection(procesocincoCollectionNew);
            Collection<Procesoocho> attachedProcesoochoCollectionNew = new ArrayList<Procesoocho>();
            for (Procesoocho procesoochoCollectionNewProcesoochoToAttach : procesoochoCollectionNew) {
                procesoochoCollectionNewProcesoochoToAttach = em.getReference(procesoochoCollectionNewProcesoochoToAttach.getClass(), procesoochoCollectionNewProcesoochoToAttach.getId());
                attachedProcesoochoCollectionNew.add(procesoochoCollectionNewProcesoochoToAttach);
            }
            procesoochoCollectionNew = attachedProcesoochoCollectionNew;
            empleado.setProcesoochoCollection(procesoochoCollectionNew);
            Collection<Procesosiete> attachedProcesosieteCollectionNew = new ArrayList<Procesosiete>();
            for (Procesosiete procesosieteCollectionNewProcesosieteToAttach : procesosieteCollectionNew) {
                procesosieteCollectionNewProcesosieteToAttach = em.getReference(procesosieteCollectionNewProcesosieteToAttach.getClass(), procesosieteCollectionNewProcesosieteToAttach.getId());
                attachedProcesosieteCollectionNew.add(procesosieteCollectionNewProcesosieteToAttach);
            }
            procesosieteCollectionNew = attachedProcesosieteCollectionNew;
            empleado.setProcesosieteCollection(procesosieteCollectionNew);
            Collection<Procesotres> attachedProcesotresCollectionNew = new ArrayList<Procesotres>();
            for (Procesotres procesotresCollectionNewProcesotresToAttach : procesotresCollectionNew) {
                procesotresCollectionNewProcesotresToAttach = em.getReference(procesotresCollectionNewProcesotresToAttach.getClass(), procesotresCollectionNewProcesotresToAttach.getId());
                attachedProcesotresCollectionNew.add(procesotresCollectionNewProcesotresToAttach);
            }
            procesotresCollectionNew = attachedProcesotresCollectionNew;
            empleado.setProcesotresCollection(procesotresCollectionNew);
            empleado = em.merge(empleado);
            if (idUsuarioOld != null && !idUsuarioOld.equals(idUsuarioNew)) {
                idUsuarioOld.getEmpleadoCollection().remove(empleado);
                idUsuarioOld = em.merge(idUsuarioOld);
            }
            if (idUsuarioNew != null && !idUsuarioNew.equals(idUsuarioOld)) {
                idUsuarioNew.getEmpleadoCollection().add(empleado);
                idUsuarioNew = em.merge(idUsuarioNew);
            }
            for (Procesoseis procesoseisCollectionOldProcesoseis : procesoseisCollectionOld) {
                if (!procesoseisCollectionNew.contains(procesoseisCollectionOldProcesoseis)) {
                    procesoseisCollectionOldProcesoseis.setIdEmpleado(null);
                    procesoseisCollectionOldProcesoseis = em.merge(procesoseisCollectionOldProcesoseis);
                }
            }
            for (Procesoseis procesoseisCollectionNewProcesoseis : procesoseisCollectionNew) {
                if (!procesoseisCollectionOld.contains(procesoseisCollectionNewProcesoseis)) {
                    Empleado oldIdEmpleadoOfProcesoseisCollectionNewProcesoseis = procesoseisCollectionNewProcesoseis.getIdEmpleado();
                    procesoseisCollectionNewProcesoseis.setIdEmpleado(empleado);
                    procesoseisCollectionNewProcesoseis = em.merge(procesoseisCollectionNewProcesoseis);
                    if (oldIdEmpleadoOfProcesoseisCollectionNewProcesoseis != null && !oldIdEmpleadoOfProcesoseisCollectionNewProcesoseis.equals(empleado)) {
                        oldIdEmpleadoOfProcesoseisCollectionNewProcesoseis.getProcesoseisCollection().remove(procesoseisCollectionNewProcesoseis);
                        oldIdEmpleadoOfProcesoseisCollectionNewProcesoseis = em.merge(oldIdEmpleadoOfProcesoseisCollectionNewProcesoseis);
                    }
                }
            }
            for (Procesouno procesounoCollectionOldProcesouno : procesounoCollectionOld) {
                if (!procesounoCollectionNew.contains(procesounoCollectionOldProcesouno)) {
                    procesounoCollectionOldProcesouno.setIdEmpleado(null);
                    procesounoCollectionOldProcesouno = em.merge(procesounoCollectionOldProcesouno);
                }
            }
            for (Procesouno procesounoCollectionNewProcesouno : procesounoCollectionNew) {
                if (!procesounoCollectionOld.contains(procesounoCollectionNewProcesouno)) {
                    Empleado oldIdEmpleadoOfProcesounoCollectionNewProcesouno = procesounoCollectionNewProcesouno.getIdEmpleado();
                    procesounoCollectionNewProcesouno.setIdEmpleado(empleado);
                    procesounoCollectionNewProcesouno = em.merge(procesounoCollectionNewProcesouno);
                    if (oldIdEmpleadoOfProcesounoCollectionNewProcesouno != null && !oldIdEmpleadoOfProcesounoCollectionNewProcesouno.equals(empleado)) {
                        oldIdEmpleadoOfProcesounoCollectionNewProcesouno.getProcesounoCollection().remove(procesounoCollectionNewProcesouno);
                        oldIdEmpleadoOfProcesounoCollectionNewProcesouno = em.merge(oldIdEmpleadoOfProcesounoCollectionNewProcesouno);
                    }
                }
            }
            for (Procesocuatro procesocuatroCollectionOldProcesocuatro : procesocuatroCollectionOld) {
                if (!procesocuatroCollectionNew.contains(procesocuatroCollectionOldProcesocuatro)) {
                    procesocuatroCollectionOldProcesocuatro.setIdEmpleado(null);
                    procesocuatroCollectionOldProcesocuatro = em.merge(procesocuatroCollectionOldProcesocuatro);
                }
            }
            for (Procesocuatro procesocuatroCollectionNewProcesocuatro : procesocuatroCollectionNew) {
                if (!procesocuatroCollectionOld.contains(procesocuatroCollectionNewProcesocuatro)) {
                    Empleado oldIdEmpleadoOfProcesocuatroCollectionNewProcesocuatro = procesocuatroCollectionNewProcesocuatro.getIdEmpleado();
                    procesocuatroCollectionNewProcesocuatro.setIdEmpleado(empleado);
                    procesocuatroCollectionNewProcesocuatro = em.merge(procesocuatroCollectionNewProcesocuatro);
                    if (oldIdEmpleadoOfProcesocuatroCollectionNewProcesocuatro != null && !oldIdEmpleadoOfProcesocuatroCollectionNewProcesocuatro.equals(empleado)) {
                        oldIdEmpleadoOfProcesocuatroCollectionNewProcesocuatro.getProcesocuatroCollection().remove(procesocuatroCollectionNewProcesocuatro);
                        oldIdEmpleadoOfProcesocuatroCollectionNewProcesocuatro = em.merge(oldIdEmpleadoOfProcesocuatroCollectionNewProcesocuatro);
                    }
                }
            }
            for (Procesodos procesodosCollectionOldProcesodos : procesodosCollectionOld) {
                if (!procesodosCollectionNew.contains(procesodosCollectionOldProcesodos)) {
                    procesodosCollectionOldProcesodos.setIdEmpleado(null);
                    procesodosCollectionOldProcesodos = em.merge(procesodosCollectionOldProcesodos);
                }
            }
            for (Procesodos procesodosCollectionNewProcesodos : procesodosCollectionNew) {
                if (!procesodosCollectionOld.contains(procesodosCollectionNewProcesodos)) {
                    Empleado oldIdEmpleadoOfProcesodosCollectionNewProcesodos = procesodosCollectionNewProcesodos.getIdEmpleado();
                    procesodosCollectionNewProcesodos.setIdEmpleado(empleado);
                    procesodosCollectionNewProcesodos = em.merge(procesodosCollectionNewProcesodos);
                    if (oldIdEmpleadoOfProcesodosCollectionNewProcesodos != null && !oldIdEmpleadoOfProcesodosCollectionNewProcesodos.equals(empleado)) {
                        oldIdEmpleadoOfProcesodosCollectionNewProcesodos.getProcesodosCollection().remove(procesodosCollectionNewProcesodos);
                        oldIdEmpleadoOfProcesodosCollectionNewProcesodos = em.merge(oldIdEmpleadoOfProcesodosCollectionNewProcesodos);
                    }
                }
            }
            for (Procesocinco procesocincoCollectionOldProcesocinco : procesocincoCollectionOld) {
                if (!procesocincoCollectionNew.contains(procesocincoCollectionOldProcesocinco)) {
                    procesocincoCollectionOldProcesocinco.setIdEmpleado(null);
                    procesocincoCollectionOldProcesocinco = em.merge(procesocincoCollectionOldProcesocinco);
                }
            }
            for (Procesocinco procesocincoCollectionNewProcesocinco : procesocincoCollectionNew) {
                if (!procesocincoCollectionOld.contains(procesocincoCollectionNewProcesocinco)) {
                    Empleado oldIdEmpleadoOfProcesocincoCollectionNewProcesocinco = procesocincoCollectionNewProcesocinco.getIdEmpleado();
                    procesocincoCollectionNewProcesocinco.setIdEmpleado(empleado);
                    procesocincoCollectionNewProcesocinco = em.merge(procesocincoCollectionNewProcesocinco);
                    if (oldIdEmpleadoOfProcesocincoCollectionNewProcesocinco != null && !oldIdEmpleadoOfProcesocincoCollectionNewProcesocinco.equals(empleado)) {
                        oldIdEmpleadoOfProcesocincoCollectionNewProcesocinco.getProcesocincoCollection().remove(procesocincoCollectionNewProcesocinco);
                        oldIdEmpleadoOfProcesocincoCollectionNewProcesocinco = em.merge(oldIdEmpleadoOfProcesocincoCollectionNewProcesocinco);
                    }
                }
            }
            for (Procesoocho procesoochoCollectionOldProcesoocho : procesoochoCollectionOld) {
                if (!procesoochoCollectionNew.contains(procesoochoCollectionOldProcesoocho)) {
                    procesoochoCollectionOldProcesoocho.setIdEmpleado(null);
                    procesoochoCollectionOldProcesoocho = em.merge(procesoochoCollectionOldProcesoocho);
                }
            }
            for (Procesoocho procesoochoCollectionNewProcesoocho : procesoochoCollectionNew) {
                if (!procesoochoCollectionOld.contains(procesoochoCollectionNewProcesoocho)) {
                    Empleado oldIdEmpleadoOfProcesoochoCollectionNewProcesoocho = procesoochoCollectionNewProcesoocho.getIdEmpleado();
                    procesoochoCollectionNewProcesoocho.setIdEmpleado(empleado);
                    procesoochoCollectionNewProcesoocho = em.merge(procesoochoCollectionNewProcesoocho);
                    if (oldIdEmpleadoOfProcesoochoCollectionNewProcesoocho != null && !oldIdEmpleadoOfProcesoochoCollectionNewProcesoocho.equals(empleado)) {
                        oldIdEmpleadoOfProcesoochoCollectionNewProcesoocho.getProcesoochoCollection().remove(procesoochoCollectionNewProcesoocho);
                        oldIdEmpleadoOfProcesoochoCollectionNewProcesoocho = em.merge(oldIdEmpleadoOfProcesoochoCollectionNewProcesoocho);
                    }
                }
            }
            for (Procesosiete procesosieteCollectionOldProcesosiete : procesosieteCollectionOld) {
                if (!procesosieteCollectionNew.contains(procesosieteCollectionOldProcesosiete)) {
                    procesosieteCollectionOldProcesosiete.setIdEmpleado(null);
                    procesosieteCollectionOldProcesosiete = em.merge(procesosieteCollectionOldProcesosiete);
                }
            }
            for (Procesosiete procesosieteCollectionNewProcesosiete : procesosieteCollectionNew) {
                if (!procesosieteCollectionOld.contains(procesosieteCollectionNewProcesosiete)) {
                    Empleado oldIdEmpleadoOfProcesosieteCollectionNewProcesosiete = procesosieteCollectionNewProcesosiete.getIdEmpleado();
                    procesosieteCollectionNewProcesosiete.setIdEmpleado(empleado);
                    procesosieteCollectionNewProcesosiete = em.merge(procesosieteCollectionNewProcesosiete);
                    if (oldIdEmpleadoOfProcesosieteCollectionNewProcesosiete != null && !oldIdEmpleadoOfProcesosieteCollectionNewProcesosiete.equals(empleado)) {
                        oldIdEmpleadoOfProcesosieteCollectionNewProcesosiete.getProcesosieteCollection().remove(procesosieteCollectionNewProcesosiete);
                        oldIdEmpleadoOfProcesosieteCollectionNewProcesosiete = em.merge(oldIdEmpleadoOfProcesosieteCollectionNewProcesosiete);
                    }
                }
            }
            for (Procesotres procesotresCollectionOldProcesotres : procesotresCollectionOld) {
                if (!procesotresCollectionNew.contains(procesotresCollectionOldProcesotres)) {
                    procesotresCollectionOldProcesotres.setIdEmpleado(null);
                    procesotresCollectionOldProcesotres = em.merge(procesotresCollectionOldProcesotres);
                }
            }
            for (Procesotres procesotresCollectionNewProcesotres : procesotresCollectionNew) {
                if (!procesotresCollectionOld.contains(procesotresCollectionNewProcesotres)) {
                    Empleado oldIdEmpleadoOfProcesotresCollectionNewProcesotres = procesotresCollectionNewProcesotres.getIdEmpleado();
                    procesotresCollectionNewProcesotres.setIdEmpleado(empleado);
                    procesotresCollectionNewProcesotres = em.merge(procesotresCollectionNewProcesotres);
                    if (oldIdEmpleadoOfProcesotresCollectionNewProcesotres != null && !oldIdEmpleadoOfProcesotresCollectionNewProcesotres.equals(empleado)) {
                        oldIdEmpleadoOfProcesotresCollectionNewProcesotres.getProcesotresCollection().remove(procesotresCollectionNewProcesotres);
                        oldIdEmpleadoOfProcesotresCollectionNewProcesotres = em.merge(oldIdEmpleadoOfProcesotresCollectionNewProcesotres);
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
                Short id = empleado.getId();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.");
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
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.", enfe);
            }
            Usuario idUsuario = empleado.getIdUsuario();
            if (idUsuario != null) {
                idUsuario.getEmpleadoCollection().remove(empleado);
                idUsuario = em.merge(idUsuario);
            }
            Collection<Procesoseis> procesoseisCollection = empleado.getProcesoseisCollection();
            for (Procesoseis procesoseisCollectionProcesoseis : procesoseisCollection) {
                procesoseisCollectionProcesoseis.setIdEmpleado(null);
                procesoseisCollectionProcesoseis = em.merge(procesoseisCollectionProcesoseis);
            }
            Collection<Procesouno> procesounoCollection = empleado.getProcesounoCollection();
            for (Procesouno procesounoCollectionProcesouno : procesounoCollection) {
                procesounoCollectionProcesouno.setIdEmpleado(null);
                procesounoCollectionProcesouno = em.merge(procesounoCollectionProcesouno);
            }
            Collection<Procesocuatro> procesocuatroCollection = empleado.getProcesocuatroCollection();
            for (Procesocuatro procesocuatroCollectionProcesocuatro : procesocuatroCollection) {
                procesocuatroCollectionProcesocuatro.setIdEmpleado(null);
                procesocuatroCollectionProcesocuatro = em.merge(procesocuatroCollectionProcesocuatro);
            }
            Collection<Procesodos> procesodosCollection = empleado.getProcesodosCollection();
            for (Procesodos procesodosCollectionProcesodos : procesodosCollection) {
                procesodosCollectionProcesodos.setIdEmpleado(null);
                procesodosCollectionProcesodos = em.merge(procesodosCollectionProcesodos);
            }
            Collection<Procesocinco> procesocincoCollection = empleado.getProcesocincoCollection();
            for (Procesocinco procesocincoCollectionProcesocinco : procesocincoCollection) {
                procesocincoCollectionProcesocinco.setIdEmpleado(null);
                procesocincoCollectionProcesocinco = em.merge(procesocincoCollectionProcesocinco);
            }
            Collection<Procesoocho> procesoochoCollection = empleado.getProcesoochoCollection();
            for (Procesoocho procesoochoCollectionProcesoocho : procesoochoCollection) {
                procesoochoCollectionProcesoocho.setIdEmpleado(null);
                procesoochoCollectionProcesoocho = em.merge(procesoochoCollectionProcesoocho);
            }
            Collection<Procesosiete> procesosieteCollection = empleado.getProcesosieteCollection();
            for (Procesosiete procesosieteCollectionProcesosiete : procesosieteCollection) {
                procesosieteCollectionProcesosiete.setIdEmpleado(null);
                procesosieteCollectionProcesosiete = em.merge(procesosieteCollectionProcesosiete);
            }
            Collection<Procesotres> procesotresCollection = empleado.getProcesotresCollection();
            for (Procesotres procesotresCollectionProcesotres : procesotresCollection) {
                procesotresCollectionProcesotres.setIdEmpleado(null);
                procesotresCollectionProcesotres = em.merge(procesotresCollectionProcesotres);
            }
            em.remove(empleado);
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

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
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

    public Empleado findEmpleado(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
