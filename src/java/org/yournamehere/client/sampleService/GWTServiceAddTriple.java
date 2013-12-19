/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import entity.semantic.Predicate;
import entity.semantic.SemanticNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author inilog
 */
@RemoteServiceRelativePath("sampleService/gwtserviceaddtriple")
public interface GWTServiceAddTriple extends RemoteService {

    public HashMap<Long, String> getAllNodeFromType (String Type);
    public String createTriple(Long sujetId, Long predicateId, Long objetId);
}
