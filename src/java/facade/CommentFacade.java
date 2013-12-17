/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.user.Comment;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author anthony
 */
@Stateless
public class CommentFacade extends AbstractFacade<Comment> {
    @PersistenceContext(unitName = "webEcomPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommentFacade() {
        super(Comment.class);
    }
    
}
