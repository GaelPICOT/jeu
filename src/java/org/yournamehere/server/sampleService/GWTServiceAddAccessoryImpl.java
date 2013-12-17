/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.encyclopedia.Accessory;
import facade.AccessoryFacade;
import javax.ejb.EJB;

import org.yournamehere.client.sampleService.GWTServiceAddAccessory;

/**
 *
 * @author anthony
 */
public class GWTServiceAddAccessoryImpl extends RemoteServiceServlet implements GWTServiceAddAccessory {

    @EJB
    private AccessoryFacade accessoryFacade;
    private Accessory accessory;
    
    public void createAccessory(String name, String description) {
        accessory = new Accessory();
        accessory.setName(name);
        accessory.setDescription(description);
        accessoryFacade.create(accessory);
    }
}
