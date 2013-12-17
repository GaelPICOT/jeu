/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.encyclopedia.Person;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author anthony
 */
@Stateless
public class PersonFacade extends AbstractFacade<Person> {
    @PersistenceContext(unitName = "webEcomPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonFacade() {
        super(Person.class);
    }
    
}
