/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.semantic.PureSemanticRessource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Anthony
 */
@Stateless
public class PureSemanticRessourceFacade extends AbstractFacade<PureSemanticRessource> {
    @PersistenceContext(unitName = "webEcomPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PureSemanticRessourceFacade() {
        super(PureSemanticRessource.class);
    }
    
}
