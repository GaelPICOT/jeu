/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client;

import org.yournamehere.client.sampleService.GWTService;
import org.yournamehere.client.sampleService.GWTServiceAsync;

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
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import entity.user.UserStatu;
import org.yournamehere.client.sampleService.GWTServiceAddAccessory;
import org.yournamehere.client.sampleService.GWTServiceAddAccessoryAsync;
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
		final GWTServiceAddAccessoryAsync service = GWT.create(GWTServiceAddAccessory.class);

		DockPanel page = new DockPanel();
		DockPanel body = new DockPanel();
		AdminTemplate.createTemplate(page, body, UserStatu.ADMIN);
		HorizontalPanel form = new HorizontalPanel();
		VerticalPanel fieldName = new VerticalPanel();
		VerticalPanel fieldValue = new VerticalPanel();

		Label accessoryNameLabel = new Label("Nom de l'accessoire: ");
		Label accessoryDescriptionLabel = new Label("Description de l'accessoire: ");
		Button createAccessory = new Button("Creer accessoire");

		fieldName.add(accessoryNameLabel);
		fieldName.add(accessoryDescriptionLabel);
		fieldName.add(createAccessory);

		form.add(fieldName);

		final TextBox accessoryNameValue = new TextBox();
		final TextBox accessoryDescriptionValue = new TextBox();
		fieldValue.add(accessoryNameValue);
		fieldValue.add(accessoryDescriptionValue);

		form.add(fieldValue);

		Label label = new Label("Bonjour, je suis un test et je dois arriver au bout de la ligne ou au moins quasiment");
		body.add(form, DockPanel.CENTER);
                
                final AsyncCallback<String> callback = new AsyncCallback<String>() {
                        public void onSuccess(String result) {
                                System.out.println("accessory created");
                                Window.alert("accesoire créé");
                        }
//
                        public void onFailure(Throwable caught) {
                                System.out.println("error while creating accessory");
                                Window.alert("erreur lors de la création de l'accessoire");
                        }

//                    @Override
//                    public void onSuccess(Void result) {
//                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                    }
                };

		createAccessory.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				System.out.println("creation accessoire: " + accessoryNameValue.getText() + " description: "
						+ accessoryDescriptionValue.getText());
                                service.createAccessory(accessoryNameValue.getText(), accessoryDescriptionValue.getText(), callback);
//                                Window.alert("accessoire créé");
                                accessoryNameValue.setText("");
                                accessoryDescriptionValue.setText("");
				// TODO Auto-generated method stub

			}
		});
		// body.setCellHorizontalAlignment(form, HasAlignment.ALIGN_CENTER);
		// body.add(label);
		// page.add(label, DockPanel.CENTER);
		RootPanel.get().add(page);
	}
}
