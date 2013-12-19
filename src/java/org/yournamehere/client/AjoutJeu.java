/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client;

import org.yournamehere.client.sampleService.GWTServiceAddEncyclopedia;
import org.yournamehere.client.sampleService.GWTServiceAddEncyclopediaAsync;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.TextArea;
import entity.encyclopedia.Game;
import entity.user.UserStatu;
//import com.sencha.gxt.widget.core.client.container.MarginData;
//import com.gwtext.client.widgets.layout.BorderLayout; 
//import java.awt.BorderLayout; 

/**
 * Main entry point.
 *
 * @author Anthony
 */
public class AjoutJeu implements EntryPoint {

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
        final GWTServiceAddEncyclopediaAsync service = GWT.create(GWTServiceAddEncyclopedia.class);
        
        DockPanel page = new DockPanel();
        DockPanel body = new DockPanel();
        AdminTemplate.createTemplate(page, body, UserStatu.ADMIN);
        VerticalPanel formPanel = new VerticalPanel();
        HorizontalPanel form = new HorizontalPanel();
        VerticalPanel fieldName = new VerticalPanel();
        VerticalPanel fieldValue = new VerticalPanel();
        
        Label gameNameLabel = new Label("Nom du jeu: ");
        Label gameDescriptionLabel = new Label("Description du jeu: ");
        Button createGame = new Button("Creer jeu");

        
        fieldName.add(gameNameLabel);
        fieldName.add(gameDescriptionLabel);

        form.add(fieldName);
        
        final TextBox gameNameValue = new TextBox();
        final TextArea gameDescriptionValue = new TextArea();
        fieldValue.add(gameNameValue);
        fieldValue.add(gameDescriptionValue);
        
        
        form.add(fieldValue);
        
        
        form.add(new CopyrightComponent());
        
        formPanel.add(form);
        ImagePanel imagePanel = new ImagePanel();
        formPanel.add(imagePanel.getConcretPanel());
        formPanel.add(createGame);
        
        body.add(formPanel, DockPanel.CENTER);
        
        final AsyncCallback<String> callback = new AsyncCallback<String>() {
                public void onSuccess(String result) {
                        System.out.println("game created");
                        Window.alert("jeu créé" + result);
                }
//
                public void onFailure(Throwable caught) {
                        System.out.println("error while creating game\n"+caught);
                        Window.alert("erreur lors de la création du jeu : "+caught);
                }

        };
        
        
  
        
        
        createGame.addClickHandler(new ClickHandler() {
                @Override
                public void onClick(ClickEvent event) {
                        System.out.println("creation jeu: " + gameNameValue.getText() + " description: " + gameDescriptionValue.getText());
                        Game game = new Game();
                        game.setName(gameNameValue.getText());
                        game.setDescription(gameDescriptionValue.getText());
                        service.createEncyclopediaNode(game, callback);
                        gameNameValue.setText("");
                        gameDescriptionValue.setText("");
                }
        });
        RootPanel.get().add(page);
    }
}
