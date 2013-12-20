/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockPanel;
import entity.user.User;
import entity.user.UserStatu;
import org.yournamehere.client.sampleService.GWTServiceDeleteAccount;
import org.yournamehere.client.sampleService.GWTServiceDeleteAccountAsync;
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
public class SupprimerCompte implements EntryPoint {

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
        final GWTServiceDeleteAccountAsync service = GWT.create(GWTServiceDeleteAccount.class);
        final GWTServiceModifyAccountAsync service2 = GWT.create(GWTServiceModifyAccount.class);
        
        final DockPanel page = new DockPanel();
        final DockPanel body = new DockPanel();
        HorizontalPanel form = new HorizontalPanel();
        Button deleteAccount = new Button("Supprimer compte");
        
        form.add(deleteAccount);
        
        body.add(form, DockPanel.CENTER);
        
        final AsyncCallback<String> callback = new AsyncCallback<String>() {
                public void onSuccess(String result) {
                        System.out.println("account deleted");
                        Window.alert("compte supprimé");
                }

                public void onFailure(Throwable caught) {
                        System.out.println("error while deleting account\n"+caught);
                        Window.alert("error while deleting account");
                }
        };
        
        deleteAccount.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    service.deleteAccount(callback);
                    Window.Location.replace("../");
                }
        });
        
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
