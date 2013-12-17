/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import entity.user.User;
import java.util.List;
import org.yournamehere.client.CopyrightClient;

/**
 *
 * @author Anthony
 */
@RemoteServiceRelativePath("gwtservice")
public interface GWTService extends RemoteService {

//    public User getUser();
//    public List<CopyrightClient> getCopyright();
//    public void createAccessory(String name, String description);
//    public void createGame(String name, String description);
    public String disconnect();
}
