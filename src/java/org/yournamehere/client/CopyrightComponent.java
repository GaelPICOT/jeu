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
import java.util.List;
import org.yournamehere.client.sampleService.GWTServiceCopyright;
import org.yournamehere.client.sampleService.GWTServiceCopyrightAsync;

/**
 *
 * @author picotg
 */
public class CopyrightComponent extends VerticalPanel {
    public CopyrightComponent() {
        super();
        final GWTServiceCopyrightAsync service = GWT.create(GWTServiceCopyright.class);
        
        //creat interface :
        Label licencesLabel = new Label("Choix licence: ");
        final ListBox licencesList = new ListBox();
        final Button addLicence = new Button("Ajouter Licence");
        HorizontalPanel licencePanel = new HorizontalPanel();
        licencePanel.add(licencesLabel);
        licencePanel.add(licencesList);
        licencePanel.add(addLicence);
        Label actorLabel = new Label("Choix nouvel acteur: ");
        final ListBox actorList = new ListBox();
        final Button addActor = new Button("ajouter acteur");
        HorizontalPanel actorPanel = new HorizontalPanel();
        actorPanel.add(actorLabel);
        actorPanel.add(actorList);
        actorPanel.add(addActor);
        this.add(licencePanel);
        this.add(actorPanel);
        
        AsyncCallback<List<Licence>> callbackLicence;
        callbackLicence = new AsyncCallback<List<Licence>>() {
            
            @Override
            public void onFailure(Throwable caught) {
                System.out.println("error load copyright");
            }
            
            @Override
            public void onSuccess(List<Licence> result) {
                List<Licence> listLicence;
                listLicence = result;
                if (result != null)
                for (Licence lic : listLicence) {
                    licencesList.addItem(lic.toString(), lic.getId().toString());
                }
            }
        };
        
        service.getLicence(callbackLicence);
        
        AsyncCallback<List<Actor>> callbackActor;
        callbackActor = new AsyncCallback<List<Actor>>() {
            
            @Override
            public void onFailure(Throwable caught) {
                System.out.println("error load copyright");
            }
            
            @Override
            public void onSuccess(List<Actor> result) {
                List<Actor> listActor;
                listActor = result;
                if (result != null)
                for (Actor act : listActor) {
                    licencesList.addItem(act.toString(), act.getId().toString());
                }
            }
        };
        
        service.getOwner(callbackActor);
        
        
    }
    
}
