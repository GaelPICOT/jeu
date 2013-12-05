/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.semantic.subtriple.TripleSAccessoryOGame;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anthony
 */
@Stateless
public class TripleSAccessoryOGameFacade extends AbstractFacade<TripleSAccessoryOGame> {
    @PersistenceContext(unitName = "webEcomPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TripleSAccessoryOGameFacade() {
        super(TripleSAccessoryOGame.class);
    }
    
}
