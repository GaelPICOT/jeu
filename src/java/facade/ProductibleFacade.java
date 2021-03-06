/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.encyclopedia.Productible;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author kieffera
 */
@Stateless
public class ProductibleFacade extends AbstractFacade<Productible> {
    @PersistenceContext(unitName = "webEcomPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        if(this.em == null){
               EntityManagerFactory factory =
                       Persistence.createEntityManagerFactory(
                               "webEcomPU", System.getProperties());
               this.em = factory.createEntityManager();
         }
        return em;
    }

    public ProductibleFacade() {
        super(Productible.class);
    }
    
}
