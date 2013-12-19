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

    @Override
    public String addImage(Image image) {
        imageFacade.create(image);
//        imageFacade.f
//        image.setURL("/home/anthony/images/" + image.getId().toString() + ".png");
//        imageFacade.edit(image);
//        return image.getId().intValue();
        return "0";
//        return image.getId().intValue();
        // Do something interesting with 's' here on the server.
//        return "Server says: " + s;
    }
}
