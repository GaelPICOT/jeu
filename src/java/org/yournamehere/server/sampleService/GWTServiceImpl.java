/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import beans.UserView;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.user.User;
import entity.user.UserStatu;
import org.yournamehere.client.sampleService.GWTService;

/**
 *
 * @author Anthony
 */

//@RequestScoped
public class GWTServiceImpl extends RemoteServiceServlet implements GWTService {

    public void disconnect() {
        getThreadLocalRequest().getSession().invalidate();
    }
     
    public UserStatu getUserStatus() {
        return ((User) ((UserView) (getThreadLocalRequest().getSession().getAttribute("UserView"))).getUser()).getType();
    }
}
