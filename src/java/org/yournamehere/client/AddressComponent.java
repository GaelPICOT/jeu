/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import entity.encyclopedia.Actor;
import entity.encyclopedia.Licence;
import entity.user.Adress;
import java.util.List;
import org.yournamehere.client.sampleService.GWTServiceCopyright;
import org.yournamehere.client.sampleService.GWTServiceCopyrightAsync;

/**
 *
 * @author picotg
 */
public class AddressComponent extends VerticalPanel {
    public AddressComponent(Adress address) {
        super();
        HorizontalPanel namePanel = new HorizontalPanel();
        namePanel.add(new Label(address.getName() + " " + address.getFirstname()));
        this.add(namePanel);
        HorizontalPanel addressPanel = new HorizontalPanel();
        addressPanel.add(new Label(address.getAdress()));
        this.add(addressPanel);
        HorizontalPanel addressPanel2 = new HorizontalPanel();
        addressPanel2.add(new Label(address.getComplement() + " code: " + address.getAccessCode()));
        this.add(addressPanel2);
        HorizontalPanel cityPanel = new HorizontalPanel();
        cityPanel.add(new Label(address.getCity() + ", " + address.getZipCode()));
        this.add(cityPanel);
        HorizontalPanel phonePanel = new HorizontalPanel();
        phonePanel.add(new Label(address.getPhoneNumber()));
        this.add(phonePanel);
    }
}
