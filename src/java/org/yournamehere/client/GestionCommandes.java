/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockPanel;
import entity.ecom.Command;
import entity.user.UserStatu;
import java.util.ArrayList;
import java.util.List;
//import com.sencha.gxt.core.client.util.Margins;
//import com.sencha.gxt.widget.core.client.ContentPanel;
//import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
//import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
//import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import org.yournamehere.client.sampleService.GWTServiceCommandHandler;
import org.yournamehere.client.sampleService.GWTServiceCommandHandlerAsync;
//import com.sencha.gxt.widget.core.client.container.MarginData;
//import com.gwtext.client.widgets.layout.BorderLayout; 
//import java.awt.BorderLayout; 

/**
 * Main entry point.
 *
 * @author Anthony
 */
public class GestionCommandes implements EntryPoint {

    /**
     * Creates a new instance of Main
     */
//    public AjoutJeu() {
//    }

    /**
     * The entry point method, called automatically by loading a module that
     * declares an implementing class as an entry-point
     */
    @Override
    public void onModuleLoad() {
//        RootPanel.get().clear();
        final GWTServiceCommandHandlerAsync service = GWT.create(GWTServiceCommandHandler.class);
        
        DockPanel page = new DockPanel();
        DockPanel body = new DockPanel();
        AdminTemplate.createTemplate(page, body, UserStatu.ADMIN);
        
        VerticalPanel bodyPanel = new VerticalPanel();
        bodyPanel.add(new Label("Vos commandes: "));
        final VerticalPanel form = new VerticalPanel();
        bodyPanel.add(form);
        
        final AsyncCallback<List<Command>> callback = new AsyncCallback<List<Command>>() {
                public void onSuccess(List<Command> result) {
//                        System.out.println("account deleted");
//                        Window.alert("compte supprimé");
                    ArrayList<Command> commandsTemp = (ArrayList<Command>) result;
                    for (Command command : commandsTemp) {
                        form.add(new CommandComponent(command));
                    }
                }
//
                public void onFailure(Throwable caught) {
                        System.out.println("error while getting commands\n"+caught);
                        Window.alert("error while getting commands");
                }

//            @Override
//            public void onSuccess(Void result) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
        };
        
        service.getCommand(callback);
  
        
        body.add(bodyPanel, DockPanel.CENTER);
        
        RootPanel.get().add(page);
    }
}
