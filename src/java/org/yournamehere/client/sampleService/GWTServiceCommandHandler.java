/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import entity.ecom.Command;
import java.util.List;

/**
 *
 * @author anthony
 */
@RemoteServiceRelativePath("sampleservice/gwtservicecommandhandler")
public interface GWTServiceCommandHandler extends RemoteService {

    public List<Command> getCommand();
}
