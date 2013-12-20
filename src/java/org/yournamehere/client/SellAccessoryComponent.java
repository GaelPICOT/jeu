/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import entity.ecom.Product;
import java.util.ArrayList;

/**
 *
 * @author anthony
 */
class SellAccessoryComponent extends VerticalPanel {

    public SellAccessoryComponent(ArrayList<Long> listIds) {
        super();
        HorizontalPanel nameField = new HorizontalPanel();
        HorizontalPanel descriptionField = new HorizontalPanel();
        HorizontalPanel quantityField = new HorizontalPanel();
        Label accessoryNameLabel                 = new Label("Nom de l'accessoire: ");
        final TextBox accessoryNameValue               = new TextBox();
        nameField.add(accessoryNameLabel);
        nameField.add(accessoryNameValue);
        this.add(nameField);
        Label accessoryDescriptionLabel      = new Label("Description de l'accessoire: ");
        final TextArea accessoryDescriptionValue   = new TextArea();
        descriptionField.add(accessoryDescriptionLabel);
        descriptionField.add(accessoryDescriptionValue);
        this.add(descriptionField);
        Label accessoryQuantityLabel              = new Label("Quantité d'accessoires: ");
        final TextBox accessoryQuantityValue       = new TextBox();
        quantityField.add(accessoryQuantityLabel);
        quantityField.add(accessoryQuantityValue);
        this.add(quantityField);
        ImagePanel imagePanel = new ImagePanel(listIds);
        this.add(imagePanel.getConcretPanel());
        Button createButton = new Button("Vendre accessoire");
        this.add(createButton);
    }
}
