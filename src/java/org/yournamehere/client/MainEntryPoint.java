/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Main entry point.
 *
 * @author Anthony
 */
public class MainEntryPoint implements EntryPoint {

    /**
     * Creates a new instance of MainEntryPoint
     */
//    public MainEntryPoint() {
//    }

    /**
     * The entry point method, called automatically by loading a module that
     * declares an implementing class as an entry-point
     */
    @Override
    public void onModuleLoad() {
//        RootPanel.get().clear();
        
//        final GWTServiceAsync service = GWT.create(GWTService.class);
        
        DockPanel page = new DockPanel();
        DockPanel body = new DockPanel();
        AdminTemplate.createTemplate(page, body);
        RootPanel.get().add(page);
    }
}
