/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import beans.UserView;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.ecom.Command;
import entity.ecom.NodeCart;
import entity.ecom.Product;
import entity.user.Adress;
import entity.user.User;
import facade.UserFacade;
import java.util.ArrayList;
import javax.ejb.EJB;

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
        user = ((UserView) (getThreadLocalRequest().getSession().getAttribute("UserView"))).getUser();
        user.getCart().setList(new ArrayList<NodeCart>());
        user.setCommand(new ArrayList<Command>());
        ArrayList<Adress> listAddress = new ArrayList<>();
        for(Adress address : user.getAdresses()) {
            listAddress.add(address);
        }
        user.setAdresses(listAddress);
        return user;
    }
}
