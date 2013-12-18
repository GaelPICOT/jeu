/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import entity.ecom.Product;

/**
 *
 * @author anthony
 */
class ProductComponent extends VerticalPanel {

    public ProductComponent(Product product) {
        super();
        this.add(new Label("prix: " + product.getPrix()));
    }
}
