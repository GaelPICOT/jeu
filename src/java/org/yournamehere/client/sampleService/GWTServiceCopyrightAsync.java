/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;
import org.yournamehere.client.CopyrightClient;

/**
 *
 * @author anthony
 */
public interface GWTServiceCopyrightAsync {

    public void getCopyright(AsyncCallback<List<CopyrightClient>> callback);
}
