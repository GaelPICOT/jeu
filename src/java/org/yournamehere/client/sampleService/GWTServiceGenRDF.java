/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 *
 * @author inilog
 */
@RemoteServiceRelativePath("sampleService/gwtservicegenrdf")
public interface GWTServiceGenRDF extends RemoteService {

    public String myMethod(String s);
}
