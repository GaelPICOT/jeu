/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.semantic.SemanticLiteral;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author inilog
 */
@Stateless
public class SemanticLiteralFacade extends AbstractFacade<SemanticLiteral> {
    @PersistenceContext(unitName = "webEcomPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SemanticLiteralFacade() {
        super(SemanticLiteral.class);
    }
    
}
