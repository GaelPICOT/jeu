/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 *
 * @author anthony
 */
public interface GWTServiceAddImageAsync {

    public void addImage(String name, String description, String textAlt, AsyncCallback<String> callback);
}
