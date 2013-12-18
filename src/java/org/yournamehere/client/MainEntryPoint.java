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
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import entity.user.Adress;
import entity.user.User;
import java.util.ArrayList;
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
        
//        final User user = new User();
//        String name = "";
//        String firstName = "";
        final ArrayList<Adress> addresses = new ArrayList<Adress>();
        
        
        DockPanel page = new DockPanel();
        DockPanel body = new DockPanel();
        AdminTemplate.createTemplate(page, body);
        VerticalPanel form = new VerticalPanel();
        HorizontalPanel fieldName = new HorizontalPanel();
        HorizontalPanel fieldFirstName = new HorizontalPanel();
        HorizontalPanel fieldMail = new HorizontalPanel();
        HorizontalPanel fieldOldPassword = new HorizontalPanel();
        HorizontalPanel fieldNewPassword = new HorizontalPanel();
        HorizontalPanel fieldConfirmNewPassword = new HorizontalPanel();
        
        Label userNameLabel = new Label("Nom: ");
        userNameLabel.getElement().setClassName("form");
        final TextBox userNameValue = new TextBox();
        userNameValue.setEnabled(false);
        fieldName.add(userNameLabel);
        fieldName.add(userNameValue);
        form.add(fieldName);
        Label userFirstNameLabel = new Label("Prénom: ");
        userFirstNameLabel.getElement().setClassName("form");
        final TextBox userFirstNameValue = new TextBox();
        userFirstNameValue.setEnabled(false);
        fieldFirstName.add(userFirstNameLabel);
        fieldFirstName.add(userFirstNameValue);
        form.add(fieldFirstName);
        Label userMailLabel = new Label("Adresse email: ");
        userMailLabel.getElement().setClassName("form");
        final TextBox userMailValue = new TextBox();
        fieldMail.add(userMailLabel);
        fieldMail.add(userMailValue);
        form.add(fieldMail);
        Label userOldPasswordLabel = new Label("Ancien mot de passe: ");
        userOldPasswordLabel.getElement().setClassName("form");
        final TextBox userOldPasswordValue = new TextBox();
        fieldOldPassword.add(userOldPasswordLabel);
        fieldOldPassword.add(userOldPasswordValue);
        form.add(fieldOldPassword);
        Label userNewPasswordLabel = new Label("Nouveau mot de passe: ");
        userNewPasswordLabel.getElement().setClassName("form");
        final TextBox userNewPasswordValue = new TextBox();
        fieldNewPassword.add(userNewPasswordLabel);
        fieldNewPassword.add(userNewPasswordValue);
        form.add(fieldNewPassword);
        Label userConfirmNewPasswordLabel = new Label("Confirmation mot de passe: ");
        userConfirmNewPasswordLabel.getElement().setClassName("form");
        final TextBox userConfirmNewPasswordValue = new TextBox();
        fieldConfirmNewPassword.add(userConfirmNewPasswordLabel);
        fieldConfirmNewPassword.add(userConfirmNewPasswordValue);
        form.add(fieldConfirmNewPassword);
//        Button createGame = new Button("Creer jeu");

        
//        fieldName.add(createGame);

//        form.add(fieldName);
        
//        fieldValue.add(userNameValue);
//        fieldValue.add(userFirstNameValue);
//        fieldValue.add(userMailValue);
//        fieldValue.add(userOldPasswordValue);
//        fieldValue.add(userNewPasswordValue);
//        fieldValue.add(userConfirmNewPasswordValue);
//        final Label temp = new Label();
        final VerticalPanel addressesPanel = new VerticalPanel();
        addressesPanel.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);
        addressesPanel.setWidth("50%");
//        addressesPanel.getElement().setId("addresses");
        
        AsyncCallback<User> callbackUser = new AsyncCallback<User>() {

            @Override
            public void onFailure(Throwable caught) {
//                Window.alert("fail");
            }

            @Override
            public void onSuccess(User result) {
//                name = result.getName();
//                firstname = result.getFirstName();
                userNameValue.setText(result.getName());
                userFirstNameValue.setText(result.getFirstName());
                userMailValue.setText(result.getMail());
//                if (result.getAdresses() != null) {
                ArrayList<Adress> addressesTemp = (ArrayList<Adress>) result.getAdresses();
                for (Adress address : addressesTemp) {
                    addressesPanel.add(new AddressComponent(address));
                    addresses.add(address);
                }
//                temp.setText("nombre d'adresses: " + addresses.size());
////                    addresses.add(result.getAdresses().get(0));
//                }
//                addresses = new ArrayList<Adress>(result.getAdresses());
//                Window.alert("success: " + result.getFirstName());
//                Window.alert("success: ");
            }
        };
        
        service.getUser(callbackUser);
        

        
//        form.add(fieldValue);
        
        HorizontalPanel bodyPanel = new HorizontalPanel();
        bodyPanel.setWidth("100%");
        bodyPanel.add(form);
//        temp.setText("nombre d'adresses: " + addresses.size());
        
//        for(Adress address : addresses) {
//            Window.alert(address.toString());
//            temp.setText(temp.getText() + "address: " + address.getAdress() + " " + address.getZipCode());
//            addressesPanel.add(new AddressComponent(address));
//        }
//        bodyPanel.add(temp);
        bodyPanel.add(addressesPanel);
        
        body.add(bodyPanel, DockPanel.CENTER);
//        body.setWidth("100%");
        
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
