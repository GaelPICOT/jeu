/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import beans.UserView;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import facade.UserFacade;
import javax.ejb.EJB;

import org.yournamehere.client.sampleService.GWTServiceDeleteAccount;

/**
 *
 * @author anthony
 */
public class GWTServiceDeleteAccountImpl extends RemoteServiceServlet implements GWTServiceDeleteAccount {

    @EJB
    UserFacade userFacade;
//    User user;
    
    public void deleteAccount() {
        userFacade.remove(((UserView) (getThreadLocalRequest().getSession().getAttribute("UserView"))).getUser());
    }
}
