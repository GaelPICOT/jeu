/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.AsyncCallback;
import entity.semantic.Predicate;
import entity.semantic.SemanticNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author inilog
 */
public interface GWTServiceAddTripleAsync {

    public void getAllNodeFromType (String Type, AsyncCallback<HashMap<Long, String>> callback);
    public void createTriple(Long sujetId, Long predicateId, Long objetId, AsyncCallback<String> callback);
}
