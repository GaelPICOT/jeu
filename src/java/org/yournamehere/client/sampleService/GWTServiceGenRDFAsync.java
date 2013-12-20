/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author inilog
 */
public interface GWTServiceGenRDFAsync {

    public void genRDF(AsyncCallback<String> callback);
    public void getAllGetterFromType (String Type, AsyncCallback<ArrayList<String>> callback);
    public void getAllPredicate (AsyncCallback<HashMap<Long, String>> callback);
    
}
