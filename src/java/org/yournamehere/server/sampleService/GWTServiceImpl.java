/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
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
}
