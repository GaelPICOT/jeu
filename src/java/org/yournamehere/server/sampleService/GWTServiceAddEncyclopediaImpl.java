/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yournamehere.server.sampleService;

import beans.UserView;
import com.google.gwt.user.server.rpc.RemoteServiceServlet; 
import entity.ModarateStatu;
import entity.encyclopedia.Accessory;
import entity.encyclopedia.Actor;
import entity.encyclopedia.Article;
import entity.encyclopedia.Association;
import entity.encyclopedia.Book;
import entity.encyclopedia.Category;
import entity.encyclopedia.Copyright;
import entity.encyclopedia.Entreprise;
import entity.encyclopedia.Game;
import entity.encyclopedia.Image;
import entity.encyclopedia.Licence;
import entity.encyclopedia.Person;
import entity.encyclopedia.Productible;
import entity.encyclopedia.Release;
import entity.encyclopedia.Rule;
import entity.encyclopedia.Theme;
import entity.semantic.Predicate;
import entity.semantic.PureSemanticRessource;
import entity.semantic.SemanticLiteral;
import entity.semantic.SemanticNode;
import entity.user.User;
import entity.user.UserStatu;
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

import org.yournamehere.client.sampleService.GWTServiceAddEncyclopedia;

/**
 *
 * @author picotg
 */
public class GWTServiceAddEncyclopediaImpl extends RemoteServiceServlet implements GWTServiceAddEncyclopedia {
    @EJB
    private AccessoryFacade accessoryFacade;
    @EJB
    private ActorFacade actorFacade;
    @EJB
    private ArticleFacade articleFacade;
    @EJB
    private AssociationFacade associationFacade;
    @EJB
    private BookFacade bookFacade;
    @EJB
    private CategoryFacade categoryFacade;
    @EJB
    private CopyrightFacade copyrightFacade;
    @EJB
    private EntrepriseFacade entrepriseFacade;
    @EJB
    private GameFacade gameFacade;
    @EJB
    private ImageFacade imageFacade;
    @EJB
    private LicenceFacade licenceFacade;
    @EJB
    private PersonFacade personFacade;
    @EJB
    private ProductibleFacade productibleFacade;
    @EJB
    private ReleaseFacade releaseFacade;
    @EJB
    private RuleFacade ruleFacade;
    @EJB
    private ThemeFacade themeFacade;
    @EJB
    private PureSemanticRessourceFacade pureSemanticRessourceFacade;
    @EJB
    private SemanticLiteralFacade semanticLiteralFacade;
    @EJB
    private PredicateFacade predicateFacade;
    
    private User user;
    private ModarateStatu MS;
    
    
    @Override
    public String createEncyclopediaNode(SemanticNode nodeAdd) {
        createSemNode (nodeAdd);
        user = ((UserView) (getThreadLocalRequest().getSession().getAttribute("UserView"))).getUser();
        switch(user.getType()) {
            case ADMIN :
                MS = ModarateStatu.VALIDATE;
                break;
            case CLIENT :
                MS = ModarateStatu.TO_BE_MODERATE;
                break;
            case CERTIFIED :
                if (nodeAdd instanceof Release)
                    MS = ModarateStatu.VALIDATE;
                else
                    MS = ModarateStatu.TO_BE_MODERATE;
                break;
        }
        nodeAdd.setAutor(user);
        nodeAdd.setModerate(MS);
        editSemNode (nodeAdd);
        
        return user.getType().toString();
    }
    
    public void createSemNode (SemanticNode nodeAdd) {
        //On crée un objet Class correspondant a la class du bean a traiter
        Class beanClass = nodeAdd.getClass();
        if(nodeAdd.getId()==null) {
            if (beanClass.getName().equals(Accessory.class.getName())) {
                accessoryFacade.create((Accessory)nodeAdd);
            } else if (beanClass.getName().equals(Actor.class.getName())) {
                actorFacade.create((Actor)nodeAdd);
            } else if (beanClass.getName().equals(Article.class.getName())) {
                articleFacade.create((Article)nodeAdd);
            } else if (beanClass.getName().equals(Association.class.getName())) {
                associationFacade.create((Association)nodeAdd);
            } else if (beanClass.getName().equals(Book.class.getName())) {
                bookFacade.create((Book)nodeAdd);
            } else if (beanClass.getName().equals(Category.class.getName())) {
                categoryFacade.create((Category)nodeAdd);
            } else if (beanClass.getName().equals(Entreprise.class.getName())) {
                entrepriseFacade.create((Entreprise)nodeAdd);
            } else if (beanClass.getName().equals(Game.class.getName())) {
                gameFacade.create((Game)nodeAdd);
            } else if (beanClass.getName().equals(Image.class.getName())) {
                imageFacade.create((Image)nodeAdd);
            } else if (beanClass.getName().equals(Licence.class.getName())) {
                licenceFacade.create((Licence)nodeAdd);
            } else if (beanClass.getName().equals(Copyright.class.getName())) {
                copyrightFacade.create((Copyright)nodeAdd);
            } else if (beanClass.getName().equals(Productible.class.getName())) {
                productibleFacade.create((Productible)nodeAdd);
            } else if (beanClass.getName().equals(Release.class.getName())) {
                releaseFacade.create((Release)nodeAdd);
            } else if (beanClass.getName().equals(Rule.class.getName())) {
                ruleFacade.create((Rule)nodeAdd);
            } else if (beanClass.getName().equals(Theme.class.getName())) {
                themeFacade.create((Theme)nodeAdd);
            } else if (beanClass.getName().equals(Person.class.getName())) {
                personFacade.create((Person)nodeAdd);
            } else if (beanClass.getName().equals(PureSemanticRessource.class.getName())) {
                pureSemanticRessourceFacade.create((PureSemanticRessource)nodeAdd);
            } else if (beanClass.getName().equals(SemanticLiteral.class.getName())) {
                semanticLiteralFacade.create((SemanticLiteral)nodeAdd);
            } else if (beanClass.getName().equals(Predicate.class.getName())) {
                predicateFacade.create((Predicate)nodeAdd);
            }
        }
    }
    
    public void editSemNode (SemanticNode nodeAdd) {
        //On crée un objet Class correspondant a la class du bean a traiter
        Class beanClass = nodeAdd.getClass();
            if (beanClass.getName().equals(Accessory.class.getName())) {
                accessoryFacade.edit((Accessory)nodeAdd);
            } else if (beanClass.getName().equals(Actor.class.getName())) {
                actorFacade.edit((Actor)nodeAdd);
            } else if (beanClass.getName().equals(Article.class.getName())) {
                articleFacade.edit((Article)nodeAdd);
            } else if (beanClass.getName().equals(Association.class.getName())) {
                associationFacade.edit((Association)nodeAdd);
            } else if (beanClass.getName().equals(Book.class.getName())) {
                bookFacade.edit((Book)nodeAdd);
            } else if (beanClass.getName().equals(Category.class.getName())) {
                categoryFacade.edit((Category)nodeAdd);
            } else if (beanClass.getName().equals(Entreprise.class.getName())) {
                entrepriseFacade.edit((Entreprise)nodeAdd);
            } else if (beanClass.getName().equals(Game.class.getName())) {
                gameFacade.edit((Game)nodeAdd);
            } else if (beanClass.getName().equals(Image.class.getName())) {
                imageFacade.edit((Image)nodeAdd);
            } else if (beanClass.getName().equals(Licence.class.getName())) {
                licenceFacade.edit((Licence)nodeAdd);
            } else if (beanClass.getName().equals(Copyright.class.getName())) {
                copyrightFacade.edit((Copyright)nodeAdd);
            } else if (beanClass.getName().equals(Productible.class.getName())) {
                productibleFacade.edit((Productible)nodeAdd);
            } else if (beanClass.getName().equals(Release.class.getName())) {
                releaseFacade.edit((Release)nodeAdd);
            } else if (beanClass.getName().equals(Rule.class.getName())) {
                ruleFacade.edit((Rule)nodeAdd);
            } else if (beanClass.getName().equals(Theme.class.getName())) {
                themeFacade.edit((Theme)nodeAdd);
            } else if (beanClass.getName().equals(Person.class.getName())) {
                personFacade.edit((Person)nodeAdd);
            } else if (beanClass.getName().equals(PureSemanticRessource.class.getName())) {
                pureSemanticRessourceFacade.edit((PureSemanticRessource)nodeAdd);
            } else if (beanClass.getName().equals(SemanticLiteral.class.getName())) {
                semanticLiteralFacade.edit((SemanticLiteral)nodeAdd);
            } else if (beanClass.getName().equals(Predicate.class.getName())) {
                predicateFacade.edit((Predicate)nodeAdd);
        }
    }
}
