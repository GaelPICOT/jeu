/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import entity.user.Adress;
import entity.user.User;
import entity.user.UserStatu;
import java.util.ArrayList;
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
        
        final ArrayList<Adress> addresses = new ArrayList<Adress>();
        
        final DockPanel page = new DockPanel();
        final DockPanel body = new DockPanel();

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
        final VerticalPanel addressesPanel = new VerticalPanel();
        addressesPanel.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);
        addressesPanel.setWidth("50%");
        
        AsyncCallback<User> callbackUser = new AsyncCallback<User>() {

            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(User result) {
                userNameValue.setText(result.getName());
                userFirstNameValue.setText(result.getFirstName());
                userMailValue.setText(result.getMail());
                ArrayList<Adress> addressesTemp = (ArrayList<Adress>) result.getAdresses();
                for (Adress address : addressesTemp) {
                    addressesPanel.add(new AddressComponent(address));
                    addresses.add(address);
                }
                AdminTemplate.createTemplate(page, body, result.getType());
            }
        };
        
        service.getUser(callbackUser);
        
        HorizontalPanel bodyPanel = new HorizontalPanel();
        bodyPanel.setWidth("100%");
        bodyPanel.add(form);
        bodyPanel.add(addressesPanel);
        body.add(bodyPanel, DockPanel.CENTER);
        RootPanel.get().add(page);
    }
}
