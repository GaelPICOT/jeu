/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet; 
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
    
    
    @Override
    public String createEncyclopediaNode(SemanticNode nodeAdd) {
        marche (nodeAdd);
          
        return "";
    }
    
    public void marche (SemanticNode nodeAdd) {
        //On crée un objet Class correspondant a la class du bean a traiter
        Class beanClass = nodeAdd.getClass();
        if(nodeAdd.getId()==null) {
        
//            for (Method meth : beanClass.getMethods()) {
//                if (meth.getReturnType().isAssignableFrom(nodeAdd.getClass()) && meth.getParameterTypes().length==0) {
//                    try {
//                        SemanticNode SN = (SemanticNode) meth.invoke(nodeAdd);
//                        if(SN!=null)
//                            marche(SN);
//                    } catch (IllegalAccessException ex) {
//                        Logger.getLogger(GWTServiceAddEncyclopediaImpl.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (IllegalArgumentException ex) {
//                        Logger.getLogger(GWTServiceAddEncyclopediaImpl.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (InvocationTargetException ex) {
//                        Logger.getLogger(GWTServiceAddEncyclopediaImpl.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//                if(meth.getReturnType().isAssignableFrom(List.class) && meth.getParameterTypes().length==0) {
//                    try {
//                        List laList = (List)meth.invoke(nodeAdd);
//                        if (laList.get(0).getClass().isAssignableFrom(SemanticNode.class)) {
//                            if (laList!=null)
//                                for (Object SN : laList) {
//                                    if(SN!=null)
//                                        marche((SemanticNode) SN);
//                                }
//                        }
//                    } catch (IllegalAccessException ex) {
//                        Logger.getLogger(GWTServiceAddEncyclopediaImpl.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (IllegalArgumentException ex) {
//                        Logger.getLogger(GWTServiceAddEncyclopediaImpl.class.getName()).log(Level.SEVERE, null, ex);
//                    } catch (InvocationTargetException ex) {
//                        Logger.getLogger(GWTServiceAddEncyclopediaImpl.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }

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
}
