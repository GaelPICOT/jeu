/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yournamehere.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
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
import entity.user.UserStatu;
import org.yournamehere.client.sampleService.GWTServiceAddTriple;
import org.yournamehere.client.sampleService.GWTServiceAddTripleAsync;

/**
 *
 * @author picotg
 */
public class AjoutTriple implements EntryPoint {

    @Override
    public void onModuleLoad() {
        final GWTServiceAddTripleAsync service = GWT.create(GWTServiceAddTriple.class);
        
        DockPanel page = new DockPanel();
        DockPanel body = new DockPanel();
        AdminTemplate.createTemplate(page, body, UserStatu.ADMIN);
        
        VerticalPanel bodyPanel = new VerticalPanel();
        HorizontalPanel SelectPanel = new HorizontalPanel();
        HorizontalPanel AffichagePanel = new HorizontalPanel();
        
        VerticalPanel selectSujetPanel = new VerticalPanel();
        ListBox listTypeSujet = creéListEncylopedie ();
        ListBox listSujet = new ListBox();
        listSujet.setVisibleItemCount(10);
        selectSujetPanel.add(listTypeSujet);
        selectSujetPanel.add(listSujet);
        
        VerticalPanel predicatPanel = new VerticalPanel();
        ListBox listPredicat = new ListBox();
        predicatPanel.add(listPredicat);
        
        VerticalPanel selectObjetPanel = new VerticalPanel();
        ListBox listTypeObjet = creéListEncylopedie ();
        ListBox listObjet = new ListBox();
        listObjet.setVisibleItemCount(10);
        listTypeObjet.addItem("Litéral", SemanticLiteral.class.getName());
        selectObjetPanel.add(listTypeObjet);
        selectObjetPanel.add(listObjet);
        
        SelectPanel.add(selectSujetPanel);
        SelectPanel.add(predicatPanel);
        SelectPanel.add(selectObjetPanel);
        
        bodyPanel.add(selectSujetPanel);
        
        body.add(bodyPanel, DockPanel.CENTER);
        
        RootPanel.get().add(page);
    }
    
    public ListBox creéListEncylopedie () {
        ListBox retour = new ListBox();
        retour.addItem("Accessoire", Accessory.class.getName());
        retour.addItem("Acteur", Actor.class.getName());
        retour.addItem("Article", Article.class.getName());
        retour.addItem("Association", Association.class.getName());
        retour.addItem("Livre", Book.class.getName());
        retour.addItem("Categorie", Category.class.getName());
        retour.addItem("Copyright", Copyright.class.getName());
        retour.addItem("Jeu", Game.class.getName());
        retour.addItem("Licence", Licence.class.getName());
        retour.addItem("Personne", Person.class.getName());
        retour.addItem("Productible", Productible.class.getName());
        retour.addItem("Release", Release.class.getName());
        retour.addItem("Règle", Rule.class.getName());
        retour.addItem("Thème", Theme.class.getName());
        retour.addItem("Ressource", PureSemanticRessource.class.getName());
        
        
        return retour;
    }
    
}
