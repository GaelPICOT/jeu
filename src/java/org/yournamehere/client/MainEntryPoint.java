/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import entity.user.User;
import java.util.List;
import org.yournamehere.client.sampleService.GWTService;
import org.yournamehere.client.sampleService.GWTServiceAsync;
import org.yournamehere.client.sampleService.GWTServiceModifyAccount;
import org.yournamehere.client.sampleService.GWTServiceModifyAccountAsync;

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
        
        final GWTServiceModifyAccountAsync service = GWT.create(GWTServiceModifyAccount.class);
        
        final User user = new User();
//        String name = "";
//        String firstName = "";
        
        
        
        DockPanel page = new DockPanel();
        DockPanel body = new DockPanel();
        AdminTemplate.createTemplate(page, body);
        HorizontalPanel form = new HorizontalPanel();
        VerticalPanel fieldName = new VerticalPanel();
        VerticalPanel fieldValue = new VerticalPanel();
        
        Label gameNameLabel = new Label("Nom: ");
        Label gameDescriptionLabel = new Label("Prénom: ");
        Label gameCopyrightLabel = new Label("Description du jeu: ");
        Button createGame = new Button("Creer jeu");

        
        fieldName.add(gameNameLabel);
        fieldName.add(gameDescriptionLabel);
        fieldName.add(gameCopyrightLabel);
        fieldName.add(createGame);

        form.add(fieldName);
        
        final TextBox gameNameValue = new TextBox();
        gameNameValue.setText(user.getName());
        final TextBox gameDescriptionValue = new TextBox();
        gameDescriptionValue.setText(user.getFirstName());
        final ListBox gameCopyrightValue = new ListBox();
        fieldValue.add(gameNameValue);
        fieldValue.add(gameDescriptionValue);
        fieldValue.add(gameCopyrightValue);
        
        AsyncCallback<User> callbackUser = new AsyncCallback<User>() {

            @Override
            public void onFailure(Throwable caught) {
                Window.alert("fail");
            }

            @Override
            public void onSuccess(User result) {
//                name = result.getName();
//                firstname = result.getFirstName();
                gameNameValue.setText(result.getName());
                gameDescriptionValue.setText(result.getFirstName());
                Window.alert("success: " + result.getFirstName());
//                Window.alert("success: ");
            }
        };
        
        service.getUser(callbackUser);
        

        
        form.add(fieldValue);
        
        
        body.add(form, DockPanel.CENTER);
        
//        final AsyncCallback<Void> callback = new AsyncCallback<String>() {
//                public void onSuccess(String result) {
//                        System.out.println("game created");
//                        Window.alert("jeu créé");
//                }
//
//                public void onFailure(Throwable caught) {
//                        System.out.println("error while creating game\n"+caught);
//                        Window.alert("erreur lors de la création du jeu");
//                }
//        };
        
//        AsyncCallback<List<CopyrightClient>> callbackCopyright;
//        callbackCopyright = new AsyncCallback<List<CopyrightClient>>() {
//            
//            @Override
//            public void onFailure(Throwable caught) {
//                System.out.println("error load copyright");
//                Window.alert("erreur lors du chargement copyright\n"+caught);
//            }
//            
//            @Override
//            public void onSuccess(List<CopyrightClient> result) {
//                List<CopyrightClient> listCopyright;
//                listCopyright = result;
//                if (result != null)
//                for (CopyrightClient cr : listCopyright) {
//                    gameCopyrightValue.addItem(cr.getCopychaine());
//                }
//            }
//        };
//        
//        service.getCopyright(callbackCopyright);
        
        
//        createGame.addClickHandler(new ClickHandler() {
//                @Override
//                public void onClick(ClickEvent event) {
//                        System.out.println("creation jeu: " + gameNameValue.getText() + " description: " + gameDescriptionValue.getText());
//                        service.createGame(gameNameValue.getText(), gameDescriptionValue.getText(), callback);
////                        Window.alert("jeu créé");
//                        gameNameValue.setText("");
//                        gameDescriptionValue.setText("");
//                        // TODO Auto-generated method stub
//
//                }
//        });
        RootPanel.get().add(page);
    }
}
