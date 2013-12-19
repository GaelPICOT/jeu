/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import org.yournamehere.client.sampleService.GWTServiceGenRDF;

/**
 *
 * @author inilog
 */
public class GWTServiceGenRDFImpl extends RemoteServiceServlet implements GWTServiceGenRDF {

    public String myMethod(String s) {
        // Do something interesting with 's' here on the server.
        return "Server says: " + s;
    }
}
