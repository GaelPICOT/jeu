/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.AsyncCallback;
import entity.encyclopedia.Copyright;
import java.util.List;

/**
 *
 * @author anthony
 */
public interface GWTServiceCopyrightAsync {

    public void getCopyright(AsyncCallback<List<Copyright>> callback);
}
