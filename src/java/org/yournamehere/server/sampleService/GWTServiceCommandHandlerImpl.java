/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import beans.UserView;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.ecom.Command;
import entity.user.User;
import java.util.ArrayList;
import java.util.List;

import org.yournamehere.client.sampleService.GWTServiceCommandHandler;

/**
 *
 * @author anthony
 */
public class GWTServiceCommandHandlerImpl extends RemoteServiceServlet implements GWTServiceCommandHandler {

    public List<Command> getCommand() {
//        user = new User();
        List<Command> commands = new ArrayList<Command>();
        List<Command> commandsTemp = ((User) ((UserView) (getThreadLocalRequest().getSession().getAttribute("UserView"))).getUser()).getCommands();
//            ArrayList<Adress> listAddress = new ArrayList<>();
        for(Command command : commandsTemp) {
            commands.add(command);
        }
//        }
        
        return commands;
    }
}
