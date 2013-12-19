/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import entity.encyclopedia.Licence;

/**
 *
 * @author inilog
 */
public class LicencePanel extends SemanticPanel<Licence> {
    
    TextBox nameValue = new TextBox();
    TextArea textValue = new TextArea();
    
    public LicencePanel () {
        HorizontalPanel namePanel = new HorizontalPanel();
        Label nameLabel = new Label("Nom de la licence: ");
        namePanel.add(nameLabel);
        namePanel.add(nameValue);
        HorizontalPanel textPanel = new HorizontalPanel();
        Label textLabel = new Label("Texte de la licence: ");
        textPanel.add(textLabel);
        textPanel.add(textValue);
        
        getConcretPanel().add(namePanel);
        getConcretPanel().add(textPanel);
    }

    @Override
    public Licence getSemanticObject() {
        Licence lic = new Licence();
        lic.setName(nameValue.getText());
        lic.setText(textValue.getText());
        return lic;
    }
    
}
