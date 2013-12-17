/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.semantic.subtriple.TripleOAccessory;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author anthony
 */
@Stateless
public class TripleOAccessoryFacade extends AbstractFacade<TripleOAccessory> {
    @PersistenceContext(unitName = "webEcomPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TripleOAccessoryFacade() {
        super(TripleOAccessory.class);
    }
    
}
