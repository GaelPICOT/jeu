/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
//import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
//import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import org.yournamehere.client.sampleService.GWTService;
import org.yournamehere.client.sampleService.GWTServiceAsync;
//import com.sencha.gxt.widget.core.client.container.MarginData;
//import com.gwtext.client.widgets.layout.BorderLayout; 
//import java.awt.BorderLayout; 

/**
 * Main entry point.
 *
 * @author Anthony
 */
public class MainEntryPoint implements EntryPoint {

    /**
     * Creates a new instance of MainEntryPoint
     */
    public MainEntryPoint() {
    }

    /**
     * The entry point method, called automatically by loading a module that
     * declares an implementing class as an entry-point
     */
    @Override
    public void onModuleLoad() {
        RootPanel.get().clear();
//        final Label label = new Label("Hello, GWT!!!");
//        final Button button = new Button("Click me!");
        final GWTServiceAsync service = GWT.create(GWTService.class);
        
//        button.addClickHandler(new ClickHandler() {
//            public void onClick(ClickEvent event) {
//                label.setVisible(!label.isVisible());
//            }
//        });
        
        
        
        
//        BorderLayoutContainer borderLayoutContainer = new BorderLayoutContainer();
//        borderLayoutContainer.setStyleName("container");
//        
////        HorizontalLayoutContainer horizontalLayoutContainer = new HorizontalLayoutContainer();
//        BorderLayoutContainer borderLayoutContainer2 = new BorderLayoutContainer();
//        borderLayoutContainer2.setStyleName("container");
//        horizontalLayoutContainer.setStyleName("container");
//        ContentPanel westPanel = new ContentPanel();
//        westPanel.setStyleName("container");
//        ContentPanel eastPanel = new ContentPanel();
//        eastPanel.setStyleName("container");
        
        DockPanel dockPanel = new DockPanel();
        dockPanel.setSize("100%", "100%");
//        dockPanel.setVerticalAlignment(HasAlignment.ALIGN_MIDDLE);
        dockPanel.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);
        DockPanel dockPanel2 = new DockPanel();
        dockPanel2.setWidth("100%");
//        HorizontalPanel horizontalPanel = new HorizontalPanel();
//        horizontalPanel.setWidth("100%");
//        BorderLayout 
        
        Button homeButton = new Button("Acceuil");
        homeButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
                Window.Location.replace("/jeu");
            }
        });
//        homeButton.setStyleName("homeButton");
        
        final AsyncCallback<String> callback = new AsyncCallback<String>() {
            public void onSuccess(String result) {
//                lblServerReply.setText(result);
//                label.setText(result);
                System.out.println("disconnected");
                Window.Location.replace("/jeu");
            }
            
            public void onFailure(Throwable caught) {
//                lblServerReply.setText("Communication failed");
//                label.setText("fail");
                System.out.println("error while disconnecting");
//                Window.Location.replace("/jeu/faces");
            }
        };
        
        Button discButton = new Button("Deconnexion");
        discButton.addClickHandler(new ClickHandler() {
            public void onClick(ClickEvent event) {
//                Window.Location.replace("/jeu");
                service.disconnect(callback);
            }
        });
//        discButton.
//        discButton.setStyleName("discButton");
//
        dockPanel2.add(homeButton, DockPanel.WEST);
        dockPanel2.add(discButton, DockPanel.EAST);
        
        dockPanel.add(dockPanel2, DockPanel.NORTH);
        

        
        Command cmd = new Command() {
            public void execute() {
              Window.alert("You selected a menu item!");
            }
        };
        
        MenuBar accountMenu = new MenuBar(true);
        accountMenu.addItem("Modifier", cmd);
        accountMenu.addItem("Supprimer", cmd);
        accountMenu.addItem("Gestion des commandes", cmd);

        MenuBar encyclopediaMenu = new MenuBar(true);
        encyclopediaMenu.addItem("Ajouter jeu", cmd);
        encyclopediaMenu.addItem("Ajouter accessoire", cmd);
        encyclopediaMenu.addItem("Ajouter autre", cmd);
        encyclopediaMenu.addItem("Proposer modification", cmd);

        MenuBar salesMenu = new MenuBar(true);
        salesMenu.addItem("Vendre article", cmd);
        salesMenu.addItem("Gestion stock", cmd);
        
        MenuBar administrationMenu = new MenuBar(true);
        administrationMenu.addItem("Gestion", cmd);
        administrationMenu.addItem("Validation", cmd);
        administrationMenu.addItem("Vitrine", cmd);

        MenuBar menu = new MenuBar();
        menu.addItem("Compte", accountMenu);
        menu.addItem("Encyclopédie", encyclopediaMenu);
        menu.addItem("Vente", salesMenu);
        menu.addItem("Administration", administrationMenu);
        
        dockPanel.add(menu, DockPanel.CENTER);
        
        Label footer = new Label("Pied de page");
        
        dockPanel.add(footer, DockPanel.SOUTH);
        
        
        
        RootPanel.get().add(dockPanel);
        
//        homeButton.setWidth("50%");
//        westPanel.add(homeButton);
//        eastPanel.add(discButton);
//        borderLayoutContainer2.setWestWidget(westPanel);
//        borderLayoutContainer2.setEastWidget(eastPanel);
//        horizontalLayoutContainer.add(label);
//        horizontalLayoutContainer.add(new GWTServiceUsageExample());
        
//        ContentPanel topPanel = new ContentPanel();
//        topPanel.setStyleName("container");
//        topPanel.setHeadingText("Top");
     

//        BorderLayoutData topData = new BorderLayoutData(200);
//        topPanel.add(borderLayoutContainer2);
//        borderLayoutContainer.setNorthWidget(topData);
//        borderLayoutContainer.setNorthWidget(topPanel);
//        RootPanel.get().add(borderLayoutContainer);
//        RootPanel.get().add(button);
//        RootPanel.get().add(label);
//        RootPanel.get().add(new GWTServiceUsageExample());
    }
}
