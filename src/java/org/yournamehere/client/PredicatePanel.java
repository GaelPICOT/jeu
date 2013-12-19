/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yournamehere.client;

import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import entity.semantic.Predicate;

/**
 *
 * @author picotg
 */
public class PredicatePanel extends SemanticPanel<Predicate> {
    
    TextBox labelValue = new TextBox();
    
    public PredicatePanel () {
        HorizontalPanel labelPanel = new HorizontalPanel();
        Label labelLabel = new Label("Label du predicat: ");
        labelPanel.add(labelLabel);
        labelPanel.add(labelValue);
        
        this.add(labelPanel);
    }

    @Override
    public Predicate getSemanticObject() {
        Predicate pred = new Predicate();
        pred.setLabel(labelValue.getText());
        pred.setURI("URI#pred");
        return pred;
    }
}
