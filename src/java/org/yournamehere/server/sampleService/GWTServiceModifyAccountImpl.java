/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import beans.UserView;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.ecom.Cart;
import entity.ecom.Command;
import entity.ecom.Product;
import entity.user.Adress;
import entity.user.User;
import facade.UserFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.yournamehere.client.sampleService.GWTServiceModifyAccount;

/**
 *
 * @author anthony
 */
public class GWTServiceModifyAccountImpl extends RemoteServiceServlet implements GWTServiceModifyAccount {
    
    @EJB
    private UserFacade userFacade;
    private User user;
    
    public User getUser() {
//        user = new User();
        user = ((UserView) (getThreadLocalRequest().getSession().getAttribute("UserView"))).getUser();
//        List<User> users = userFacade.findAll();
//        user = users.get(1);
        user.getCart().setList(new ArrayList<Product>());
//        user.setCart(new Cart());
        user.setCommand(new ArrayList<Command>());
        user.setAdresses(new ArrayList<Adress>());
        
        return user;
//        return((UserView)((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
//            .getSession(true)).getAttribute("UserView")).getUser();
    }
}