/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.TextArea;
import entity.encyclopedia.Copyright;
import java.util.List;
//import com.sencha.gxt.core.client.util.Margins;
//import com.sencha.gxt.widget.core.client.ContentPanel;
//import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
//import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
//import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import org.yournamehere.client.sampleService.GWTService;
import org.yournamehere.client.sampleService.GWTServiceAddGame;
import org.yournamehere.client.sampleService.GWTServiceAddGameAsync;
import org.yournamehere.client.sampleService.GWTServiceDeleteAccount;
import org.yournamehere.client.sampleService.GWTServiceDeleteAccountAsync;
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
//        RootPanel.get().clear();
        final GWTServiceDeleteAccountAsync service = GWT.create(GWTServiceDeleteAccount.class);
        
        DockPanel page = new DockPanel();
        DockPanel body = new DockPanel();
        AdminTemplate.createTemplate(page, body);
        HorizontalPanel form = new HorizontalPanel();
        Button deleteAccount = new Button("Supprimer compte");
        
        form.add(deleteAccount);
        
        body.add(form, DockPanel.CENTER);
        
        final AsyncCallback<String> callback = new AsyncCallback<String>() {
                public void onSuccess(String result) {
                        System.out.println("account deleted");
                        Window.alert("compte supprimé");
                }
//
                public void onFailure(Throwable caught) {
                        System.out.println("error while deleting account\n"+caught);
                        Window.alert("error while deleting account");
                }

//            @Override
//            public void onSuccess(Void result) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
        };
        
        
  
        
        
        deleteAccount.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                    service.deleteAccount(callback);
//                        System.out.println("creation jeu: " + gameNameValue.getText() + " description: " + gameDescriptionValue.getText());
//                        service.createGame(gameNameValue.getText(), gameDescriptionValue.getText(), callback);
////                        Window.alert("jeu créé");
//                        gameNameValue.setText("");
//                        gameDescriptionValue.setText("");
                        // TODO Auto-generated method stub

                }
        });
//        body.setCellHorizontalAlignment(form, HasAlignment.ALIGN_CENTER);
//        body.add(label);
//        page.add(label, DockPanel.CENTER);
        RootPanel.get().add(page);
    }
}
