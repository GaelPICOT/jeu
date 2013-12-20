/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import entity.user.User;
import entity.user.UserStatu;
import java.util.ArrayList;
import java.util.HashMap;
import org.yournamehere.client.sampleService.GWTServiceAddEncyclopedia;
import org.yournamehere.client.sampleService.GWTServiceAddEncyclopediaAsync;
import org.yournamehere.client.sampleService.GWTServiceModifyAccount;
import org.yournamehere.client.sampleService.GWTServiceModifyAccountAsync;

/**
 *
 * @author picotg
 */
public class AjoutAutre implements EntryPoint {

    @Override
    public void onModuleLoad() {
        final GWTServiceAddEncyclopediaAsync service = GWT.create(GWTServiceAddEncyclopedia.class);
        final GWTServiceModifyAccountAsync service2 = GWT.create(GWTServiceModifyAccount.class);

        final DockPanel page = new DockPanel();
	final DockPanel body = new DockPanel();
	AdminTemplate.createTemplate(page, body, UserStatu.ADMIN);
        
        final VerticalPanel formPanel = new VerticalPanel();
        
        final ListBox listChoix = new ListBox();
        formPanel.add(listChoix);
        
        final HashMap<Integer, SemanticPanel> map = new HashMap<Integer, SemanticPanel>();
        
        map.put(0, new PredicatePanel());
        listChoix.addItem("prédicat", "0");
        map.put(1, new AccessoryPanel());
        listChoix.addItem("accessoire", "1");
        map.put(2, new LicencePanel());
        listChoix.addItem("Licence", "2");
        
        final Button okButton = new Button("Enregistrer");
        
        listChoix.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                formPanel.clear();
                formPanel.add(listChoix);
                formPanel.add(map.get(Integer.parseInt(listChoix.getValue(listChoix.getSelectedIndex()))).getConcretPanel());
                formPanel.add(okButton);
            }
        });
        final AsyncCallback<String> callback = new AsyncCallback<String>() {
                public void onSuccess(String result) {
                        System.out.println("game created");
                        Window.alert("jeu créé" + result);
                }

                public void onFailure(Throwable caught) {
                        System.out.println("error while creating game\n"+caught);
                        Window.alert("erreur lors de la création du jeu : "+caught);
                }
        };
        okButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                service.createEncyclopediaNode(map.get(Integer.parseInt(listChoix.getValue(listChoix.getSelectedIndex()))).getSemanticObject(), new ArrayList<Long>(), callback);
//                service.createEncyclopediaNode(map.get(Integer.parseInt(listChoix.getValue(listChoix.getSelectedIndex()))).getSemanticObject(), listIds, callback);
            }
        });
        
        body.add(formPanel, DockPanel.CENTER);
        
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
