/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yournamehere.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import entity.encyclopedia.Accessory;

/**
 *
 * @author picotg
 */
public class AccessoryPanel extends SemanticPanel<Accessory> {
    
    TextBox nameValue = new TextBox();
    TextArea descriptionValue = new TextArea();

    public AccessoryPanel() {
        HorizontalPanel namePanel = new HorizontalPanel();
        Label nameLabel = new Label("Nom de l'accessoire: ");
        namePanel.add(nameLabel);
        namePanel.add(nameValue);
        HorizontalPanel descriptionPanel = new HorizontalPanel();
        Label descriptionLabel = new Label("Description de l'accessoire: ");
        descriptionPanel.add(descriptionLabel);
        descriptionPanel.add(descriptionValue);
        
        getConcretPanel().add(namePanel);
        getConcretPanel().add(descriptionPanel);
    }
    
    @Override
    public Accessory getSemanticObject() {
        Accessory retour = new Accessory();
        retour.setName(nameValue.getText());
        retour.setDescription(descriptionValue.getText());
        return retour;
    }
    
}
