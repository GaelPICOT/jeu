/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.AsyncCallback;
import entity.semantic.Predicate;
import entity.semantic.SemanticNode;
import java.util.List;

/**
 *
 * @author inilog
 */
public interface GWTServiceAddTripleAsync {

    public void getAllNodeFromType (String Type, AsyncCallback<List<SemanticNode>> callback);
    public void createTriple(SemanticNode sujet, Predicate predicate, SemanticNode objet, AsyncCallback<String> callback);
}
