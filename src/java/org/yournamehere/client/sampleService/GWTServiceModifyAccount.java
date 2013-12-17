/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import entity.user.User;

/**
 *
 * @author anthony
 */
@RemoteServiceRelativePath("sampleservice/gwtservicemodifyaccount")
public interface GWTServiceModifyAccount extends RemoteService {

    public User getUser();
}
