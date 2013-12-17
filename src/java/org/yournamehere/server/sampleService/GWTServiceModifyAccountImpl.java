/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import beans.UserView;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.ecom.Cart;
import entity.user.User;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.yournamehere.client.sampleService.GWTServiceModifyAccount;

/**
 *
 * @author anthony
 */
public class GWTServiceModifyAccountImpl extends RemoteServiceServlet implements GWTServiceModifyAccount {
    private User user;
    public User getUser() {
        user = new User();
        user = ((UserView) (getThreadLocalRequest().getSession().getAttribute("UserView"))).getUser();
        user.setCart(new Cart());
        return user;
//        return((UserView)((HttpSession) FacesContext.getCurrentInstance().getExternalContext()
//            .getSession(true)).getAttribute("UserView")).getUser();
    }
}
