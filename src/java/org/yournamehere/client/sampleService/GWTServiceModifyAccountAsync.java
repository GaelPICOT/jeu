/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.AsyncCallback;
import entity.user.User;

/**
 *
 * @author anthony
 */
public interface GWTServiceModifyAccountAsync {

    public void getUser(AsyncCallback<User> callback);
}
