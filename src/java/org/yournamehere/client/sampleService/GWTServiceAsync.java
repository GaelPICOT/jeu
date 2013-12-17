/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.AsyncCallback;
import entity.user.User;
import java.util.List;
import org.yournamehere.client.CopyrightClient;

/**
 *
 * @author Anthony
 */
public interface GWTServiceAsync {
//    public void getUser(AsyncCallback<User> callback);
//            
//    public void getCopyright(AsyncCallback<List<CopyrightClient>> callback);
    
    public void disconnect(AsyncCallback<String> callback);

//    public void createAccessory(String name, String description, AsyncCallback<String> asyncCallback);
//
//    public void createGame(String name, String description, AsyncCallback<String> asyncCallback);
}
