/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yournamehere.client;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import entity.semantic.SemanticNode;
import java.util.Iterator;

/**
 *
 * @author picotg
 */
public abstract class SemanticPanel<T extends SemanticNode> extends Panel {
    Panel concretPanel = new VerticalPanel();
    
    public abstract T getSemanticObject();

    public Panel getConcretPanel() {
        return concretPanel;
    }

    public void setConcretPanel(Panel concretPanel) {
        this.concretPanel = concretPanel;
    }
    @Override
    public boolean remove(Widget child) {
        return concretPanel.remove(child);
    }

    @Override
    public Iterator<Widget> iterator() {
        return concretPanel.iterator();
    }

    @Override
    public void clear() {
        concretPanel.clear(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(IsWidget child) {
        concretPanel.add(child); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Widget child) {
        concretPanel.add(child); //To change body of generated methods, choose Tools | Templates.
    }
    
}
