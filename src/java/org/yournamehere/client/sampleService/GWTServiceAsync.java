/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.AsyncCallback;
import entity.user.UserStatu;

/**
 *
 * @author Anthony
 */
public interface GWTServiceAsync {
    
    public void disconnect(AsyncCallback<String> callback);
    public void getUserStatus(AsyncCallback<UserStatu> callback);
}
