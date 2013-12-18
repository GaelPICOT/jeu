/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.semantic.SemanticNode;

import org.yournamehere.client.sampleService.GWTServiceAddEncyclopedia;

/**
 *
 * @author picotg
 */
public class GWTServiceAddEncyclopediaImpl extends RemoteServiceServlet implements GWTServiceAddEncyclopedia {

    @Override
    public String createEncyclopediaNode(SemanticNode nodeAdd) {
           return nodeAdd.getClass().getName();
    }
}
