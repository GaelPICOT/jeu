/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.user.User;
import facade.UserFacade;
import javax.ejb.EJB;
import beans.UserView;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.yournamehere.client.sampleService.GWTService;

/**
 *
 * @author Anthony
 */
public class GWTServiceImpl extends RemoteServiceServlet implements GWTService {
    
//    @EJB
//    private UserFacade userFacade;
    private User user;

    public String disconnect() {
//        System.out.println("debut myMethod");
//        UserView userView = new UserView();
//        userFacade = new UserFacade();
//        this.user = ((UserView)((HttpSession) FacesContext.getCurrentInstance()
//             .getExternalContext()
//             .getSession(true)).getAttribute("UserView")).getUser();
//        user = userView.getUser();
//        userFacade = userView.getUserFacade();
//        System.out.println("mail: " + user.getMail());
//        System.out.println("prenom: " + user.getFirstName());
//        System.out.println("userFacade: " + userFacade);
        // Do something interesting with 's' here on the server.
//        return "mail: " + user.getMail();
//        return "Server says: " + s;
        ((HttpSession) FacesContext.getCurrentInstance()
         .getExternalContext()
         .getSession(true)).invalidate();
        
        return "worked";
    }
}
