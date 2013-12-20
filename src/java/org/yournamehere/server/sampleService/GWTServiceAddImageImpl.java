/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.encyclopedia.Image;
import facade.AccessoryFacade;
import facade.ActorFacade;
import facade.ArticleFacade;
import facade.AssociationFacade;
import facade.BookFacade;
import facade.CategoryFacade;
import facade.CopyrightFacade;
import facade.EntrepriseFacade;
import facade.GameFacade;
import facade.ImageFacade;
import facade.LicenceFacade;
import facade.PersonFacade;
import facade.PredicateFacade;
import facade.ProductibleFacade;
import facade.PureSemanticRessourceFacade;
import facade.ReleaseFacade;
import facade.RuleFacade;
import facade.SemanticLiteralFacade;
import facade.ThemeFacade;
import javax.ejb.EJB;

import org.yournamehere.client.sampleService.GWTServiceAddImage;

/**
 *
 * @author anthony
 */
public class GWTServiceAddImageImpl extends RemoteServiceServlet implements GWTServiceAddImage {
    
    @EJB
    private ImageFacade imageFacade;

    @Override
    public String addImage(Image image) {
        imageFacade.create(image);
        image.setURL("/home/anthony/images/" + image.getId().toString() + ".png");
        imageFacade.edit(image);
        return image.getId().toString();
    }
}
