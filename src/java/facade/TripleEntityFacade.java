/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.semantic.TripleEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author anthony
 */
@Stateless
public class TripleEntityFacade extends AbstractFacade<TripleEntity> {
    @PersistenceContext(unitName = "webEcomPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TripleEntityFacade() {
        super(TripleEntity.class);
    }
    
}
