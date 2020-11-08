/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.sessions;

import entidades.Revisioncarroceria;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jaker
 */
@Stateless
public class RevisioncarroceriaFacade extends AbstractFacade<Revisioncarroceria> {

    @PersistenceContext(unitName = "com.mycompany_Industria4.0_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RevisioncarroceriaFacade() {
        super(Revisioncarroceria.class);
    }
    
}