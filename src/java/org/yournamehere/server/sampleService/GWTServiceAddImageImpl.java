/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import org.yournamehere.client.sampleService.GWTServiceAddImage;

/**
 *
 * @author anthony
 */
public class GWTServiceAddImageImpl extends RemoteServiceServlet implements GWTServiceAddImage {

    public void addImage(String name, String description, String textAlt) {
        // Do something interesting with 's' here on the server.
//        return "Server says: " + s;
    }
}
