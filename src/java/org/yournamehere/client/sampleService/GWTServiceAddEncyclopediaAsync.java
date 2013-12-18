/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.AsyncCallback;
import entity.semantic.SemanticNode;

/**
 *
 * @author picotg
 */
public interface GWTServiceAddEncyclopediaAsync {

    public void createEncyclopediaNode(SemanticNode nodeAdd, AsyncCallback<String> callback);
}
