/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.semantic.subtriple.TripleOGame;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author anthony
 */
@Stateless
public class TripleOGameFacade extends AbstractFacade<TripleOGame> {
    @PersistenceContext(unitName = "webEcomPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TripleOGameFacade() {
        super(TripleOGame.class);
    }
    
}
