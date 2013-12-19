/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.encyclopedia.Image;
import facade.ImageFacade;
import javax.ejb.EJB;

import org.yournamehere.client.sampleService.GWTServiceAddImage;

/**
 *
 * @author anthony
 */
public class GWTServiceAddImageImpl extends RemoteServiceServlet implements GWTServiceAddImage {
    
    @EJB
    ImageFacade imageFacade;

    public int addImage(Image image) {
        return image.getId().intValue();
        // Do something interesting with 's' here on the server.
//        return "Server says: " + s;
    }
}
