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
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import entity.encyclopedia.Accessory;
import entity.encyclopedia.Game;
import entity.semantic.SemanticNode;
import entity.user.UserStatu;
import java.util.ArrayList;
import java.util.logging.Level;
import org.yournamehere.client.sampleService.GWTServiceAddEncyclopedia;
import org.yournamehere.client.sampleService.GWTServiceAddEncyclopediaAsync;
//import com.sencha.gxt.core.client.util.Margins;
//import com.sencha.gxt.widget.core.client.ContentPanel;
//import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
//import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
//import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
//import com.sencha.gxt.widget.core.client.container.MarginData;
//import com.gwtext.client.widgets.layout.BorderLayout; 
//import java.awt.BorderLayout; 

/**
 * Main entry point.
 * 
 * @author Anthony
 */
public class AjoutAccessoire implements EntryPoint {

	/**
	 * Creates a new instance of Main
	 */
//	public AjoutAccessoire() {
//	}

	/**
	 * The entry point method, called automatically by loading a module that declares an implementing class as an
	 * entry-point
	 */
	@Override
	public void onModuleLoad() {
//		RootPanel.get().clear();
		final GWTServiceAddEncyclopediaAsync service = GWT.create(GWTServiceAddEncyclopedia.class);
        
		DockPanel page = new DockPanel();
		DockPanel body = new DockPanel();
		AdminTemplate.createTemplate(page, body, UserStatu.ADMIN);
		VerticalPanel formPanel = new VerticalPanel();
                HorizontalPanel form = new HorizontalPanel();
                VerticalPanel fieldName = new VerticalPanel();
                VerticalPanel fieldValue = new VerticalPanel();

                Label accessoryNameLabel = new Label("Nom de l'accessoire: ");
                Label accessoryDescriptionLabel = new Label("Description de l'accessoire: ");
                Button createGame = new Button("Créer accessoire");


                fieldName.add(accessoryNameLabel);
                fieldName.add(accessoryDescriptionLabel);

                form.add(fieldName);

                final TextBox accessoryNameValue = new TextBox();
                final TextArea accessoryDescriptionValue = new TextArea();
                fieldValue.add(accessoryNameValue);
                fieldValue.add(accessoryDescriptionValue);


                form.add(fieldValue);


                form.add(new CopyrightComponent());

                formPanel.add(form);
                final ArrayList<Long> listIds = new ArrayList<Long>();
                ImagePanel imagePanel = new ImagePanel(listIds);
                formPanel.add(imagePanel.getConcretPanel());
                formPanel.add(createGame);

                body.add(formPanel, DockPanel.CENTER);

                final AsyncCallback<String> callback = new AsyncCallback<String>() {
                        public void onSuccess(String result) {
                                System.out.println("accessory created");
//                                logger.log(Level.INFO, "accessory created");
            //                        Window.alert("jeu créé" + result);
                        }
            //
                        public void onFailure(Throwable caught) {
                                System.out.println("error while creating accessory\n"+caught);
                                Window.alert("erreur lors de la création de l'accessoire : "+caught);
                        }

                };





                createGame.addClickHandler(new ClickHandler() {
                        @Override
                        public void onClick(ClickEvent event) {
                                System.out.println("creation accessoire: " + accessoryNameValue.getText() + " description: " + accessoryDescriptionValue.getText());
//                                logger.log(Level.INFO, listIds.toString());
                                Accessory accessory = new Accessory();
                                accessory.setName(accessoryNameValue.getText());
                                accessory.setDescription(accessoryDescriptionValue.getText());
                                service.createEncyclopediaNode(accessory, listIds, callback);
                                accessoryNameValue.setText("");
                                accessoryDescriptionValue.setText("");
                        }
                }); 
		RootPanel.get().add(page);
	}
}
