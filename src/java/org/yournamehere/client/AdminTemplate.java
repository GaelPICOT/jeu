package org.yournamehere.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.MenuBar;
import entity.user.UserStatu;
import org.yournamehere.client.sampleService.GWTService;
import org.yournamehere.client.sampleService.GWTServiceAsync;

public class AdminTemplate {
	public static void createTemplate(DockPanel page, DockPanel body, UserStatu userStatu) {
                final GWTServiceAsync service = GWT.create(GWTService.class);
                
		page.setSize("100%", "100%");
		page.setHorizontalAlignment(HasAlignment.ALIGN_CENTER);

		DockPanel header = new DockPanel();
		header.setWidth("100%");
		header.getElement().setId("header");

		Button homeButton = new Button("Acceuil");
		homeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
//				System.out.println("Acceuil");
				 Window.Location.replace("/jeu");
			}
		});

		final AsyncCallback<String> callback = new AsyncCallback<String>() {
			public void onSuccess(String result) {
				System.out.println("disconnected");
				Window.Location.replace("/jeu");
			}

			public void onFailure(Throwable caught) {
				System.out.println("error while disconnecting");
			}
		};

		Button discButton = new Button("Deconnexion");
		discButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
//				System.out.println("Deconnexion");
                                service.disconnect(callback);
			}
		});
		// discButton.getElement().setId("discButton");
		//
		header.add(homeButton, DockPanel.WEST);
		header.add(discButton, DockPanel.EAST);
		header.setCellHorizontalAlignment(discButton, HasAlignment.ALIGN_RIGHT);

		page.add(header, DockPanel.NORTH);
		page.setCellHeight(header, "10%");

		Command cmd = new Command() {
			public void execute() {
				Window.alert("You selected a menu item!");
			}
		};

		MenuBar accountMenu = new MenuBar(true);
		accountMenu.addItem("Modifier", new Command() {
			public void execute() {
				Window.Location.replace("../welcomeGWT.html");
			}
		});
		accountMenu.addItem("Supprimer", new Command() {
			public void execute() {
				Window.Location.replace("../supprimerCompte.html");
			}
		});
		accountMenu.addItem("Gestion des commandes", new Command() {
			public void execute() {
				Window.Location.replace("../gestionCommandes.html");
			}
		});
		accountMenu.getElement().setClassName("menu");

		MenuBar encyclopediaMenu = new MenuBar(true);
		encyclopediaMenu.addItem("Ajouter jeu", new Command() {
			public void execute() {
				Window.Location.replace("../ajouterJeu.html");
			}
		});
		encyclopediaMenu.addItem("Ajouter accessoire", new Command() {
			public void execute() {
				Window.Location.replace("../ajouterAccessoire.html");
			}
		});
                encyclopediaMenu.addItem("Ajouter image", new Command() {
			public void execute() {
				Window.Location.replace("../ajouterImage.html");
			}
		});
                encyclopediaMenu.addItem("Ajouter triple", new Command() {
			public void execute() {
				Window.Location.replace("../ajouterTriple.html");
			}
		});
		encyclopediaMenu.addItem("Ajouter autre", new Command() {

                    @Override
                    public void execute() {
                        Window.Location.replace("../ajouterAutre.html"); //To change body of generated methods, choose Tools | Templates.
                    }
                });
		encyclopediaMenu.addItem("Proposer modification", cmd);
		encyclopediaMenu.getElement().setClassName("menu");

		MenuBar salesMenu = new MenuBar(true);
		salesMenu.addItem("Vendre article", cmd);
		salesMenu.addItem("Gestion stock", cmd);
		salesMenu.getElement().setClassName("menu");

		MenuBar administrationMenu = new MenuBar(true);
		// administrationMenu.addSeparator();
		administrationMenu.addItem("Gestion", cmd);
		administrationMenu.addItem("Validation", cmd);
		administrationMenu.addItem("Vitrine", cmd);
		administrationMenu.getElement().setClassName("menu");

		MenuBar menu = new MenuBar();
		menu.addItem("Compte", accountMenu);
		menu.addItem("Encyclopedie", encyclopediaMenu);
                menu.addItem("Vente", salesMenu);
                switch(userStatu) {
                    case ADMIN :
                        menu.addItem("Administration", administrationMenu);
                        break;
                }

		// menu.setAnimationEnabled(true);
		menu.addSeparator();
		// menu.getElement().setId("menu");
		menu.getElement().setClassName("menu");

		body.getElement().setId("menu");
		// body.setSpacing("10%");
		body.add(menu, DockPanel.NORTH);
		// body.add(menu);

		page.add(body, DockPanel.CENTER);
		page.setCellHorizontalAlignment(body, HasAlignment.ALIGN_LEFT);
		page.setCellVerticalAlignment(body, HasAlignment.ALIGN_TOP);

		DockPanel footer = new DockPanel();
		footer.setSize("100%", "100%");
		footer.getElement().setId("footer");
		Label footerLabel = new Label("Pied de page");
		footer.add(footerLabel, DockPanel.CENTER);
		footer.setCellHorizontalAlignment(footerLabel, HasAlignment.ALIGN_CENTER);
		footer.setCellVerticalAlignment(footerLabel, HasAlignment.ALIGN_MIDDLE);

		page.add(footer, DockPanel.SOUTH);
		page.setCellHeight(footer, "20%");
	}
}
