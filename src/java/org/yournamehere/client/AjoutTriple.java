/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yournamehere.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
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
import entity.encyclopedia.Game;
import entity.encyclopedia.Licence;
import entity.encyclopedia.Person;
import entity.encyclopedia.Productible;
import entity.encyclopedia.Release;
import entity.encyclopedia.Rule;
import entity.encyclopedia.Theme;
import entity.semantic.Predicate;
import entity.semantic.PureSemanticRessource;
import entity.semantic.SemanticLiteral;
import entity.user.UserStatu;
import java.util.HashMap;
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
        final ListBox listTypeSujet = creéListEncylopedie ();
        listTypeSujet.setWidth("100");
        final ListBox listSujet = new ListBox();
        listSujet.setWidth("100");
        listSujet.setVisibleItemCount(10);
        selectSujetPanel.add(listTypeSujet);
        selectSujetPanel.add(listSujet);
        
        VerticalPanel predicatPanel = new VerticalPanel();
        final ListBox listPredicat = new ListBox();
        listPredicat.setWidth("100");
        predicatPanel.add(listPredicat);
        
        VerticalPanel selectObjetPanel = new VerticalPanel();
        final ListBox listTypeObjet = creéListEncylopedie ();
        listTypeObjet.setWidth("100");
        listTypeObjet.addItem("Litéral", SemanticLiteral.class.getName());
        final ListBox listObjet = new ListBox();
        listObjet.setWidth("100");
        listObjet.setVisibleItemCount(10);
        selectObjetPanel.add(listTypeObjet);
        selectObjetPanel.add(listObjet);
        
        SelectPanel.add(selectSujetPanel);
        SelectPanel.add(predicatPanel);
        SelectPanel.add(selectObjetPanel);
        Button addButton = new Button("Ajouter");
        
        bodyPanel.add(SelectPanel);
        bodyPanel.add(AffichagePanel);
        bodyPanel.add(addButton);
        
        addButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(ClickEvent event) {
                Long objetId = Long.parseLong(listObjet.getValue(listObjet.getSelectedIndex()));
                Long predicateId = Long.parseLong(listPredicat.getValue(listPredicat.getSelectedIndex()));
                Long sujetId = Long.parseLong(listSujet.getValue(listSujet.getSelectedIndex()));
                service.createTriple(sujetId, predicateId, objetId, null);
            }
        });
        
        final AsyncCallback<HashMap<Long, String>> selectSujetTypeCallback = new AsyncCallback<HashMap<Long, String> >() {

            @Override
            public void onFailure(Throwable caught) {
                System.out.println("game created");
                Window.alert("jeu créé" + caught);
            }

            @Override
            public void onSuccess(HashMap<Long, String>  result) {
                listSujet.clear();
                for (Long i : result.keySet()) {
                    listSujet.addItem(result.get(i), i.toString());
                }
            }
        };
        
        listTypeSujet.addChangeHandler(new ChangeHandler() {

            @Override
            public void onChange(ChangeEvent event) {
                service.getAllNodeFromType(listTypeSujet.getValue(listTypeSujet.getSelectedIndex()), selectSujetTypeCallback);
            }
        });
        
        final AsyncCallback<HashMap<Long, String>> selectObjetTypeCallback = new AsyncCallback<HashMap<Long, String> >() {

            @Override
            public void onFailure(Throwable caught) {
                System.out.println("game created");
                Window.alert("jeu créé" + caught);
            }

            @Override
            public void onSuccess(HashMap<Long, String>  result) {
                listObjet.clear();
                for (Long i : result.keySet()) {
                    listObjet.addItem(result.get(i), i.toString());
                }
            }
        };
        
        listTypeObjet.addChangeHandler(new ChangeHandler() {

            @Override
            public void onChange(ChangeEvent event) {
                service.getAllNodeFromType(listTypeObjet.getValue(listTypeObjet.getSelectedIndex()), selectObjetTypeCallback);
            }
        });
        
        final AsyncCallback<HashMap<Long, String>> listPredicatCallback = new AsyncCallback<HashMap<Long, String> >() {

            @Override
            public void onFailure(Throwable caught) {
                System.out.println("game created");
                Window.alert("jeu créé" + caught);
            }

            @Override
            public void onSuccess(HashMap<Long, String>  result) {
                for (Long i : result.keySet()) {
                    listPredicat.addItem(result.get(i), i.toString());
                }
            }
        };
        service.getAllNodeFromType(Predicate.class.getName(), listPredicatCallback);
        
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
