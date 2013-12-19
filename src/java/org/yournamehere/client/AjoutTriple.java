/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yournamehere.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.RootPanel;
import entity.user.UserStatu;
import org.yournamehere.client.sampleService.GWTServiceAddTriple;
import org.yournamehere.client.sampleService.GWTServiceAddTripleAsync;

/**
 *
 * @author picotg
 */
public class AjoutTriple implements EntryPoint {

    @Override
    public void onModuleLoad() {
        final GWTServiceAddTripleAsync service = GWT.create(GWTServiceAddTriple.class);
        
        DockPanel page = new DockPanel();
        DockPanel body = new DockPanel();
        AdminTemplate.createTemplate(page, body, UserStatu.ADMIN);
        
        
        
        RootPanel.get().add(page);
   }
    
}
