/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import entity.semantic.SemanticNode;
import java.util.ArrayList;

/**
 *
 * @author picotg
 */
@RemoteServiceRelativePath("sampleService/gwtserviceaddencyclopedia")
public interface GWTServiceAddEncyclopedia extends RemoteService {

    public String createEncyclopediaNode(SemanticNode nodeAdd, ArrayList<Long> listIds);
    public String editEncyclopediaNode(SemanticNode nodeAdd);
}
