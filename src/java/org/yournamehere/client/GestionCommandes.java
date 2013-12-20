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
import entity.user.User;
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
import org.yournamehere.client.sampleService.GWTServiceModifyAccount;
import org.yournamehere.client.sampleService.GWTServiceModifyAccountAsync;
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
        final GWTServiceCommandHandlerAsync service = GWT.create(GWTServiceCommandHandler.class);
        final GWTServiceModifyAccountAsync service2 = GWT.create(GWTServiceModifyAccount.class);
        
        final DockPanel page = new DockPanel();
        final DockPanel body = new DockPanel();
        
        VerticalPanel bodyPanel = new VerticalPanel();
        bodyPanel.add(new Label("Vos commandes: "));
        final VerticalPanel form = new VerticalPanel();
        bodyPanel.add(form);
        
        final AsyncCallback<List<Command>> callback = new AsyncCallback<List<Command>>() {
                public void onSuccess(List<Command> result) {
                    ArrayList<Command> commandsTemp = (ArrayList<Command>) result;
                    for (Command command : commandsTemp) {
                        form.add(new CommandComponent(command));
                    }
                }

                public void onFailure(Throwable caught) {
                        System.out.println("error while getting commands\n"+caught);
                        Window.alert("error while getting commands");
                }
        };
        
        service.getCommand(callback);
  
        
        body.add(bodyPanel, DockPanel.CENTER);
        
        AsyncCallback<User> callbackUser = new AsyncCallback<User>() {

            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(User result) {
                AdminTemplate.createTemplate(page, body, result.getType());
            }
        };
        service2.getUser(callbackUser);
        
        RootPanel.get().add(page);
    }
}
