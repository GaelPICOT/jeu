/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.AsyncCallback;
import entity.encyclopedia.Actor;
import entity.encyclopedia.Copyright;
import entity.encyclopedia.Licence;
import java.util.List;

/**
 *
 * @author anthony
 */
public interface GWTServiceCopyrightAsync {

    public void getCopyright(int licId, int ownerId, AsyncCallback<Copyright> callback);
    public void getLicence(AsyncCallback<List<Licence>> callback);
    public void getOwner(AsyncCallback<List<Actor>> callback);
}
