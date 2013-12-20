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
class SellBookComponent extends VerticalPanel {

    public SellBookComponent(ArrayList<Long> listIds) {
        super();
        HorizontalPanel nameField = new HorizontalPanel();
        HorizontalPanel descriptionField = new HorizontalPanel();
        HorizontalPanel creatorField = new HorizontalPanel();
        HorizontalPanel quantityField = new HorizontalPanel();
        Label bookNameLabel                 = new Label("Nom du livre: ");
        final TextBox bookNameValue               = new TextBox();
        nameField.add(bookNameLabel);
        nameField.add(bookNameValue);
        this.add(nameField);
        Label bookDescriptionLabel      = new Label("Description du livre: ");
        final TextArea bookDescriptionValue   = new TextArea();
        descriptionField.add(bookDescriptionLabel);
        descriptionField.add(bookDescriptionValue);
        this.add(descriptionField);
        Label bookCreatorLabel               = new Label("Créateur du livre: ");
        final TextBox bookCreatorValue        = new TextBox();
        creatorField.add(bookCreatorLabel);
        creatorField.add(bookCreatorValue);
        this.add(creatorField);
        Label bookQuantityLabel              = new Label("Quantité de livres: ");
        final TextBox bookQuantityValue       = new TextBox();
        quantityField.add(bookQuantityLabel);
        quantityField.add(bookQuantityValue);
        this.add(quantityField);
        ImagePanel imagePanel = new ImagePanel(listIds);
        this.add(imagePanel.getConcretPanel());
        Button createButton = new Button("Vendre livre");
        this.add(createButton);
    }
}
