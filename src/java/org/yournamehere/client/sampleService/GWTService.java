/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.List;
import org.yournamehere.client.CopyrightClient;

/**
 *
 * @author Anthony
 */
@RemoteServiceRelativePath("gwtservice")
public interface GWTService extends RemoteService {

    public List<CopyrightClient> getCopyright();
    public String createAccessory(String name, String description);
    public String createGame(String name, String description);
    public String disconnect();
}
