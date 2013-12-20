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
class SellGameComponent extends VerticalPanel {

    public SellGameComponent(ArrayList<Long> listIds) {
        super();
        HorizontalPanel nameField = new HorizontalPanel();
        HorizontalPanel descriptionField = new HorizontalPanel();
        HorizontalPanel creatorField = new HorizontalPanel();
        HorizontalPanel quantityField = new HorizontalPanel();
        Label gameNameLabel                 = new Label("Nom du jeu: ");
        final TextBox gameNameValue               = new TextBox();
        nameField.add(gameNameLabel);
        nameField.add(gameNameValue);
        this.add(nameField);
        Label gameDescriptionLabel      = new Label("Description du jeu: ");
        final TextArea gameDescriptionValue   = new TextArea();
        descriptionField.add(gameDescriptionLabel);
        descriptionField.add(gameDescriptionValue);
        this.add(descriptionField);
        Label gameCreatorLabel               = new Label("Créateur du jeu: ");
        final TextBox gameCreatorValue        = new TextBox();
        creatorField.add(gameCreatorLabel);
        creatorField.add(gameCreatorValue);
        this.add(creatorField);
        Label gameQuantityLabel              = new Label("Quantité de jeux: ");
        final TextBox gameQuantityValue       = new TextBox();
        quantityField.add(gameQuantityLabel);
        quantityField.add(gameQuantityValue);
        this.add(quantityField);
        ImagePanel imagePanel = new ImagePanel(listIds);
        this.add(imagePanel.getConcretPanel());
        Button createButton = new Button("Vendre jeu");
        this.add(createButton);
    }
}
