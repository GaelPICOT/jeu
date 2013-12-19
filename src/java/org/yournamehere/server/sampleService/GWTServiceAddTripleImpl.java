/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import beans.DynamicView;
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
import entity.semantic.SemanticLiteral;
import entity.semantic.SemanticNode;
import entity.semantic.SemanticRessource;
import entity.semantic.TripleEntity;
import entity.semantic.subtriple.TripleOAccessory;
import entity.semantic.subtriple.TripleOActor;
import entity.semantic.subtriple.TripleOArticle;
import entity.semantic.subtriple.TripleOAssociation;
import entity.semantic.subtriple.TripleOBook;
import entity.semantic.subtriple.TripleOCategory;
import entity.semantic.subtriple.TripleOCopyright;
import entity.semantic.subtriple.TripleOEntreprise;
import entity.semantic.subtriple.TripleOGame;
import entity.semantic.subtriple.TripleOImage;
import entity.semantic.subtriple.TripleOLicence;
import entity.semantic.subtriple.TripleOPerson;
import entity.semantic.subtriple.TripleOProductible;
import entity.semantic.subtriple.TripleORelease;
import entity.semantic.subtriple.TripleORule;
import entity.semantic.subtriple.TripleOSemanticLiteral;
import entity.semantic.subtriple.TripleOTheme;
import facade.TripleEntityFacade;
import facade.TripleOAccessoryFacade;
import facade.TripleOActorFacade;
import facade.TripleOArticleFacade;
import facade.TripleOAssociationFacade;
import facade.TripleOBookFacade;
import facade.TripleOCategoryFacade;
import facade.TripleOCopyrightFacade;
import facade.TripleOEntrepriseFacade;
import facade.TripleOGameFacade;
import facade.TripleOImageFacade;
import facade.TripleOLicenceFacade;
import facade.TripleOPersonFacade;
import facade.TripleOProductibleFacade;
import facade.TripleOReleaseFacade;
import facade.TripleORuleFacade;
import facade.TripleOSemanticLiteralFacade;
import facade.TripleOThemeFacade;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

import org.yournamehere.client.sampleService.GWTServiceAddTriple;

/**
 *
 * @author inilog
 */
public class GWTServiceAddTripleImpl extends RemoteServiceServlet implements GWTServiceAddTriple {

    @EJB
    private TripleOAccessoryFacade tripleOAccessoryFacade;
    @EJB
    private TripleOActorFacade tripleOActorFacade;
    @EJB
    private TripleOArticleFacade tripleOArticleFacade;
    @EJB
    private TripleOAssociationFacade tripleOAssociationFacade;
    @EJB
    private TripleOBookFacade tripleOBookFacade;
    @EJB
    private TripleOCategoryFacade tripleOCategoryFacade;
    @EJB
    private TripleOCopyrightFacade tripleOCopyrightFacade;
    @EJB
    private TripleOEntrepriseFacade tripleOEntrepriseFacade;
    @EJB
    private TripleOGameFacade tripleOGameFacade;
    @EJB
    private TripleOImageFacade tripleOImageFacade;
    @EJB
    private TripleOLicenceFacade tripleOLicenceFacade;
    @EJB
    private TripleOPersonFacade tripleOPersonFacade;
    @EJB
    private TripleOProductibleFacade tripleOProductibleFacade;
    @EJB
    private TripleOReleaseFacade tripleOReleaseFacade;
    @EJB
    private TripleORuleFacade tripleORuleFacade;
    @EJB
    private TripleOThemeFacade tripleOThemeFacade;
    @EJB
    private TripleOSemanticLiteralFacade tripleOSemanticLiteralFacade;
    @EJB
    TripleEntityFacade tripleEntityFacade;
    
    @Override
    public String createTriple(SemanticNode sujet, Predicate predicate, SemanticNode objet) {
        Class beanClass = objet.getClass();
        if (beanClass.getName().equals(Accessory.class.getName())) {
            TripleOAccessory triple = new TripleOAccessory();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOAccessoryFacade.create(triple);
        } else if (beanClass.getName().equals(Actor.class.getName())) {
            TripleOActor triple = new TripleOActor();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOActorFacade.create(triple);
        } else if (beanClass.getName().equals(Article.class.getName())) {
            TripleOArticle triple = new TripleOArticle();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOArticleFacade.create(triple);
        } else if (beanClass.getName().equals(Association.class.getName())) {
            TripleOAssociation triple = new TripleOAssociation();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOAssociationFacade.create(triple);
        } else if (beanClass.getName().equals(Book.class.getName())) {
            TripleOBook triple = new TripleOBook();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOBookFacade.create(triple);
        } else if (beanClass.getName().equals(Category.class.getName())) {
            TripleOCategory triple = new TripleOCategory();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOCategoryFacade.create(triple);
        } else if (beanClass.getName().equals(Copyright.class.getName())) {
            TripleOCopyright triple = new TripleOCopyright();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOCopyrightFacade.create(triple);
        } else if (beanClass.getName().equals(Entreprise.class.getName())) {
            TripleOEntreprise triple = new TripleOEntreprise();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOEntrepriseFacade.create(triple);
        } else if (beanClass.getName().equals(Game.class.getName())) {
            TripleOGame triple = new TripleOGame();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOGameFacade.create(triple);
        } else if (beanClass.getName().equals(Image.class.getName())) {
            TripleOImage triple = new TripleOImage();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOImageFacade.create(triple);
        } else if (beanClass.getName().equals(Licence.class.getName())) {
            TripleOLicence triple = new TripleOLicence();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOLicenceFacade.create(triple);
        } else if (beanClass.getName().equals(Productible.class.getName())) {
            TripleOProductible triple = new TripleOProductible();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOProductibleFacade.create(triple);
        } else if (beanClass.getName().equals(Release.class.getName())) {
            TripleORelease triple = new TripleORelease();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOReleaseFacade.create(triple);
        } else if (beanClass.getName().equals(Rule.class.getName())) {
            TripleORule triple = new TripleORule();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleORuleFacade.create(triple);
        } else if (beanClass.getName().equals(Theme.class.getName())) {
            TripleOTheme triple = new TripleOTheme();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOThemeFacade.create(triple);
        } else if (beanClass.getName().equals(Person.class.getName())) {
            TripleOPerson triple = new TripleOPerson();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOPersonFacade.create(triple);
        } else if (beanClass.getName().equals(SemanticLiteral.class.getName())) {
            TripleOSemanticLiteral triple = new TripleOSemanticLiteral();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleOSemanticLiteralFacade.create(triple);
        } else {
            TripleEntity triple = new TripleEntity();
            triple.setSujet((SemanticRessource) sujet);
            triple.setPredicate(predicate);
            triple.setObjet(objet);
            tripleEntityFacade.create(triple);
        }
        return "Server says: ";
    }

    @Override
    public HashMap<Long, String> getAllNodeFromType(String Type) {
        //On crée un objet Class correspondant a la class facade du bean a traiter
        Class facadeClass;
        Class beanClass;
        
        Object facade;
        
        HashMap<Long, String> retour;
        retour = new HashMap<> ();
        try {
            beanClass = Class.forName(Type);
            
            String packageBean = beanClass.getPackage().getName();
            String classFacade = "facade." + Type.substring(packageBean.length()+1) + "Facade";
            facadeClass = Class.forName(classFacade);
            
            //Nouvelle instance de la facade
            facade = facadeClass.newInstance();
            
            Class[] find = new Class[]{};
            
            List<SemanticNode> tmp = (List<SemanticNode>) facade.getClass().getMethod("findAll", find).invoke(facade);
            for (SemanticNode SN : tmp) {
                retour.put(SN.getId(), SN.toString());
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(GWTServiceAddTripleImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retour;
    }
}
