/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package org.yournamehere.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ChangeListener;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import entity.encyclopedia.Accessory;
import entity.encyclopedia.Book;
import entity.encyclopedia.Game;
import entity.encyclopedia.Image;
import entity.encyclopedia.Person;
import entity.user.User;
import entity.user.UserStatu;
import java.util.ArrayList;
import org.yournamehere.client.sampleService.GWTServiceAddEncyclopedia;
import org.yournamehere.client.sampleService.GWTServiceAddEncyclopediaAsync;
import org.yournamehere.client.sampleService.GWTServiceModifyAccount;
import org.yournamehere.client.sampleService.GWTServiceModifyAccountAsync;
//import org.yournamehere.client.sampleService.GWTServiceSellArticles;
//import org.yournamehere.client.sampleService.GWTServiceSellArticlesAsync;

/**
* Main entry point.
* 
* @author Meryeme
*/
public class VendreArticle implements EntryPoint {


	/**
	* Creates a new instance of Main
	*/
	public VendreArticle() {
	}

	/**
	* The entry point method, called automatically by loading a module that declares an implementing class as an
	* entry-point
	*/
	@Override
	public void onModuleLoad()  
	{
		final GWTServiceAddEncyclopediaAsync service = GWT.create(GWTServiceAddEncyclopedia.class);
		final GWTServiceModifyAccountAsync service2 = GWT.create(GWTServiceModifyAccount.class);
		
		
		final DockPanel page = new DockPanel();
		final DockPanel body = new DockPanel();
		
		final VerticalPanel formPanel      = new VerticalPanel();
		final VerticalPanel form      = new VerticalPanel();
		final VerticalPanel fieldName   = new VerticalPanel();
		final VerticalPanel fieldValue  = new VerticalPanel();
//		
//		Label articleTypeLabel              = new Label("Type de l'article: ");
//		fieldName.add(articleTypeLabel);
//		
//		
//		//Vars LIVRE
//		final Label bookLabel                = new Label("Titre du livre: ");
//		final Label bookDescriptionLabel     = new Label("Description du livre: ");
//		final Label bookAuthor               = new Label("Auteur du livre: ");
//		final Label bookQuantity             = new Label("Quantité de livres: ");
//		final TextBox bookValue              = new TextBox();
//		final TextArea bookDescriptionValue  = new TextArea();
//		final TextBox bookAuthorValue        = new TextBox();
//		final TextBox bookQuantityValue      = new TextBox();
//		final Button bookButton              = new Button("Vendre livre");
//		
//		
//		//Vars JEU
//		final Label gameLabel                 = new Label("Nom du jeu: ");
//		final Label gameDescriptionLabel      = new Label("Description du jeu: ");
//		final Label gameCreator               = new Label("Créateur du jeu: ");
//		final Label gameQuantity              = new Label("Quantité de jeux: ");
//		final TextBox gameValue               = new TextBox();
//		final TextArea gameDescriptionValue   = new TextArea();
//		final TextBox gameCreatorValue        = new TextBox();
//		final TextBox gameQuantityValue       = new TextBox();
//		final Button gameButton               = new Button("Vendre jeu");
//
//		
//		//Vars AUTRE
//		final Label otherLabel                = new Label("Nom du produit: ");
//		final Label otherDescriptionLabel     = new Label("Description du produit: ");
//		final Label otherQuantity             = new Label("Quantité de produits:");
//		final TextBox otherValue              = new TextBox();
//		final TextArea otherDescriptionValue  = new TextArea();
//		final TextBox otherQuantityValue      = new TextBox();
//		final Button otherButton              = new Button("Vendre produit");
//		
//		
//		
//		//Vars ACCESS
//		final Label accessoryLabel            = new Label("Nom de l'accessoire: ");
//		final Label accessoryDescriptionLabel = new Label("Description de l'accessoire: ");
//		final Label accessoryQuantity         = new Label("Quantité d'accessoires: ");
//		final TextBox accessoryValue             = new TextBox();
//		final TextArea accessoryDescriptionValue = new TextArea();
//		final TextBox accessoryQuantityValue     = new TextBox();
//		final Button accessoryButton             = new Button("Vendre accessoire");
//
//		
//		//Vars Items ListBox
//		final String livre = "Livre";
//		final String jeu = "Jeu";
//		final String access = "Accessoire";
//		final String autre = "Autre";
//
//
//		
//		form.add(fieldName);
//
		final ListBox articleTypeValue = new ListBox();
		articleTypeValue.addItem("Jeu");
		articleTypeValue.addItem("Livre");
		articleTypeValue.addItem("Accessoire");
//		articleTypeValue.addItem("Autre");
		
		final ArrayList<Long> listIds = new ArrayList<Long>();
//                final Button createButton = new Button();
                
		fieldValue.add(articleTypeValue);
		formPanel.add(fieldValue);
                formPanel.add(form);
		body.add(formPanel, DockPanel.CENTER);
                
                final SellGameComponent sellGameComponent = new SellGameComponent(listIds);
                final SellBookComponent sellBookComponent = new SellBookComponent(listIds);
                final SellAccessoryComponent sellAccessoryComponent = new SellAccessoryComponent(listIds);
                
                form.add(sellGameComponent);
                
                articleTypeValue.addClickHandler(new ClickHandler() {
                    @Override
                    public void onClick(ClickEvent event) {
                        form.clear();
                        switch(articleTypeValue.getSelectedIndex()) {
                            case 0: // jeu
                                form.add(sellGameComponent);
                                break;
                            case 1: // livre
                                form.add(sellBookComponent);
                                break;
                            case 2: // accessoire
                                form.add(sellAccessoryComponent);
                                break;
                            default:
                                break;
                        }
                    }
                });
//		
//		//Notre Listner
//		articleTypeValue.addChangeListener(new ChangeListener(){
//
//			@Override
//			public void onChange(Widget sender) {
//				int itemSelected = articleTypeValue.getSelectedIndex();
//				String itemStringSelected = articleTypeValue.getValue(itemSelected);
//				
//				//FORM LIVRE
//				if (itemStringSelected.equals(livre))
//				{
//					//Affiche FORM LIVRE
//					bookLabel.setVisible(true);
//					bookDescriptionLabel.setVisible(true);
//					bookAuthor.setVisible(true);
//					bookQuantity.setVisible(true);
//					bookValue.setVisible(true);
//					bookDescriptionValue.setVisible(true);
//					bookAuthorValue.setVisible(true);
//					bookQuantityValue.setVisible(true);
//					bookButton.setVisible(true);
//					
//					fieldName.add(bookLabel);
//					fieldName.add(bookDescriptionLabel);
//					fieldName.add(bookAuthor);
//					fieldName.add(bookQuantity);
//					form.add(fieldName);
//
//					fieldValue.add(bookValue);
//					fieldValue.add(bookDescriptionValue);
//					fieldValue.add(bookAuthorValue);
//					fieldValue.add(bookQuantityValue);
//					form.add(fieldValue); 
//					form.add(bookButton); 
//					
//					//On cache le FORM JEU
//					gameLabel.setVisible(false);
//					gameDescriptionLabel.setVisible(false);
//					gameCreator.setVisible(false);
//					gameQuantity.setVisible(false);
//					gameValue.setVisible(false);
//					gameDescriptionValue.setVisible(false);
//					gameCreatorValue.setVisible(false);
//					gameQuantityValue.setVisible(false);
//					gameButton.setVisible(false);
//					
//					//On cache FORM ACCESSOIRE
//					accessoryLabel.setVisible(false);
//					accessoryDescriptionLabel.setVisible(false);
//					accessoryQuantity.setVisible(false);
//					accessoryValue.setVisible(false);
//					accessoryDescriptionValue.setVisible(false);
//					accessoryQuantityValue.setVisible(false);
//					accessoryButton.setVisible(false);
//					
//					//On cache OTHER
//					otherLabel.setVisible(false);
//					otherDescriptionLabel.setVisible(false);
//					otherQuantity.setVisible(false);
//					otherValue.setVisible(false);
//					otherDescriptionValue.setVisible(false);
//					otherQuantityValue.setVisible(false);
//					otherButton.setVisible(false);
//					
//					/* TRAITEMENT */
//					final AsyncCallback<String> callback = new AsyncCallback<String>() {
//						@Override
//						public void onSuccess(String result) {
//							System.out.println("Book created");
//							Window.alert("Livre créé" + result);
//						}
//						@Override
//						public void onFailure(Throwable caught) {
//							System.out.println("error while creating book\n"+caught);
//							Window.alert("erreur lors de la création du Livre : "+caught);
//						}
//
//					};
//
//					bookButton.addClickHandler(new ClickHandler() {
//						@Override
//						public void onClick(ClickEvent event) {
//							System.out.println("Création Livre: " + bookValue.getText() + " Description: " + bookDescriptionValue.getText());
//							Book book = new Book();
//							Person author = new Person();
//							
//							book.setName(bookValue.getText());
//							book.setDescription(bookDescriptionValue.getText());
//							author.setName(bookAuthorValue.getText());    
//							
//							book.setWriter(author);
//							
//							
////							service.createEncyclopediaNode(book, callback);
//							bookValue.setText("");
//							bookDescriptionValue.setText("");
//							// TODO Auto-generated method stub
//
//						}
//					});
//					RootPanel.get().add(page);
//
//				}
//				
//				//FORM JEU
//				else if (itemStringSelected.equals(jeu))
//				{
//					//Affiche FORM GAME
//					gameLabel.setVisible(true);
//					gameDescriptionLabel.setVisible(true);
//					gameCreator.setVisible(true);
//					gameQuantity.setVisible(true);
//					gameValue.setVisible(true);
//					gameDescriptionValue.setVisible(true);
//					gameCreatorValue.setVisible(true);
//					gameQuantityValue.setVisible(true);
//					gameButton.setVisible(true);
//					
//					fieldName.add(gameLabel);
//					fieldName.add(gameDescriptionLabel);
//					fieldName.add(gameCreator);
//					fieldName.add(gameQuantity);
//					form.add(fieldName);
//					fieldValue.add(gameValue);
//					fieldValue.add(gameDescriptionValue);
//					fieldValue.add(gameCreatorValue);
//					fieldValue.add(gameQuantityValue);
//					form.add(fieldValue); 
//					form.add(gameButton);
//					
//					
//					//On cache le FORM BOOK
//					bookLabel.setVisible(false);
//					bookDescriptionLabel.setVisible(false);
//					bookAuthor.setVisible(false);
//					bookQuantity.setVisible(false);
//					bookValue.setVisible(false);
//					bookDescriptionValue.setVisible(false);
//					bookAuthorValue.setVisible(false);
//					bookQuantityValue.setVisible(false);
//					bookButton.setVisible(false);
//					
//					//On cache FORM ACCESSOIRE
//					accessoryLabel.setVisible(false);
//					accessoryDescriptionLabel.setVisible(false);
//					accessoryQuantity.setVisible(false);
//					accessoryValue.setVisible(false);
//					accessoryDescriptionValue.setVisible(false);
//					accessoryQuantityValue.setVisible(false);
//					accessoryButton.setVisible(false);
//					
//					//On cache OTHER
//					otherLabel.setVisible(false);
//					otherDescriptionLabel.setVisible(false);
//					otherQuantity.setVisible(false);
//					otherValue.setVisible(false);
//					otherDescriptionValue.setVisible(false);
//					otherQuantityValue.setVisible(false);
//					otherButton.setVisible(false);
//					
//					final AsyncCallback<String> callback = new AsyncCallback<String>() {
//						@Override
//						public void onSuccess(String result) {
//							System.out.println("Jeu created");
//							Window.alert("Jeu créé" + result);
//						}
//						@Override
//						public void onFailure(Throwable caught) {
//							System.out.println("error while creating game\n"+caught);
//							Window.alert("erreur lors de la création du Jeu : "+caught);
//						}
//
//					};
//
//					bookButton.addClickHandler(new ClickHandler() {
//						@Override
//						public void onClick(ClickEvent event) {
//							System.out.println("Création Jeu: " + gameValue.getText() + " Description: " + gameDescriptionValue.getText());
//							Game game = new Game();
//							
//							game.setName(bookValue.getText());
//							game.setDescription(gameDescriptionValue.getText());
//							
////							service.createEncyclopediaNode(game, callback);
//							gameValue.setText("");
//							gameDescriptionValue.setText("");
//							// TODO Auto-generated method stub
//
//						}
//					});
//					RootPanel.get().add(page);
//
//				}
//				
//				else if(itemStringSelected.equals(access))
//				{
//					//Affiche FORM ACCESSORY
//					accessoryLabel.setVisible(true);
//					accessoryDescriptionLabel.setVisible(true);
//					accessoryQuantity.setVisible(true);
//					accessoryValue.setVisible(true);
//					accessoryDescriptionValue.setVisible(true);
//					accessoryQuantityValue.setVisible(true);
//					accessoryButton.setVisible(true);
//					
//					fieldName.add(accessoryLabel);
//					fieldName.add(accessoryDescriptionLabel);
//					fieldName.add(accessoryQuantity);
//					form.add(fieldName);
//
//					fieldValue.add(accessoryValue);
//					fieldValue.add(accessoryDescriptionValue);
//					fieldValue.add(accessoryQuantityValue);
//					form.add(fieldValue);
//					form.add(accessoryButton);
//					
//					
//					//On cache le FORM JEU
//					gameLabel.setVisible(false);
//					gameDescriptionLabel.setVisible(false);
//					gameCreator.setVisible(false);
//					gameQuantity.setVisible(false);
//					gameValue.setVisible(false);
//					gameDescriptionValue.setVisible(false);
//					gameCreatorValue.setVisible(false);
//					gameQuantityValue.setVisible(false);
//					gameButton.setVisible(false);
//					
//					//On cache le FORM BOOK
//					bookLabel.setVisible(false);
//					bookDescriptionLabel.setVisible(false);
//					bookAuthor.setVisible(false);
//					bookQuantity.setVisible(false);
//					bookValue.setVisible(false);
//					bookDescriptionValue.setVisible(false);
//					bookAuthorValue.setVisible(false);
//					bookQuantityValue.setVisible(false);
//					bookButton.setVisible(false);
//					
//					//On cache OTHER
//					otherLabel.setVisible(false);
//					otherDescriptionLabel.setVisible(false);
//					otherQuantity.setVisible(false);
//					otherValue.setVisible(false);
//					otherDescriptionValue.setVisible(false);
//					otherQuantityValue.setVisible(false);
//					otherButton.setVisible(false);
//					
//					final AsyncCallback<String> callback = new AsyncCallback<String>() {
//						@Override
//						public void onSuccess(String result) {
//							System.out.println("Jeu created");
//							Window.alert("Livre créé" + result);
//						}
//						@Override
//						public void onFailure(Throwable caught) {
//							System.out.println("error while creating game\n"+caught);
//							Window.alert("erreur lors de la création du Jeu : "+caught);
//						}
//
//					};
//
//					bookButton.addClickHandler(new ClickHandler() {
//						@Override
//						public void onClick(ClickEvent event) {
//							System.out.println("Création Jeu: " + gameValue.getText() + " Description: " + gameDescriptionValue.getText());
//							Accessory accessory = new Accessory();
//							
//							accessory.setName(accessoryValue.getText());
//							accessory.setDescription(accessoryDescriptionValue.getText());
//							
////							service.create  EncyclopediaNode(accessory, callback);
//							accessoryValue.setText("");
//							accessoryDescriptionValue.setText("");
//							// TODO Auto-generated method stub
//
//						}
//					});
//					RootPanel.get().add(page);
//				}
//				
//				else if (itemStringSelected.equals(autre))
//				{
//					//Affiche FORM OTHER
//					otherLabel.setVisible(true);
//					otherDescriptionLabel.setVisible(true);
//					otherQuantity.setVisible(true);
//					otherValue.setVisible(true);
//					otherDescriptionValue.setVisible(true);
//					otherQuantityValue.setVisible(true);
//					otherButton.setVisible(true);
//					
//					fieldName.add(otherLabel);
//					fieldName.add(otherDescriptionLabel);
//					fieldName.add(otherQuantity);
//					form.add(fieldName);
//					fieldValue.add(otherValue);
//					fieldValue.add(otherDescriptionValue);
//					fieldValue.add(otherQuantityValue);
//					form.add(fieldValue); 
//					form.add(otherButton);
//					
//					
//					//On cache le FORM JEU
//					gameLabel.setVisible(false);
//					gameDescriptionLabel.setVisible(false);
//					gameCreator.setVisible(false);
//					gameQuantity.setVisible(false);
//					gameValue.setVisible(false);
//					gameDescriptionValue.setVisible(false);
//					gameCreatorValue.setVisible(false);
//					gameQuantityValue.setVisible(false);
//					gameButton.setVisible(false);
//					
//					//On cache le FORM BOOK
//					bookLabel.setVisible(false);
//					bookDescriptionLabel.setVisible(false);
//					bookAuthor.setVisible(false);
//					bookQuantity.setVisible(false);
//					bookValue.setVisible(false);
//					bookDescriptionValue.setVisible(false);
//					bookAuthorValue.setVisible(false);
//					bookQuantityValue.setVisible(false);
//					bookButton.setVisible(false);
//					
//					//On cache ACCESSORY
//					accessoryLabel.setVisible(false);
//					accessoryDescriptionLabel.setVisible(false);
//					accessoryQuantity.setVisible(false);
//					accessoryValue.setVisible(false);
//					accessoryDescriptionValue.setVisible(false);
//					accessoryQuantityValue.setVisible(false);
//					accessoryButton.setVisible(false);
//				}
//				
//				
//			}
//
//			private void getFormLivre(String livre, VerticalPanel fieldName, HorizontalPanel form, VerticalPanel fieldValue) {
//				throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//			}
//		});
	AsyncCallback<User> callbackUser = new AsyncCallback<User>() {

            @Override
            public void onFailure(Throwable caught) {
            }

            @Override
            public void onSuccess(User result) {
                AdminTemplate.createTemplate(page, body, result.getType());
            }
        };
        service2.getUser(callbackUser);
        RootPanel.get().add(page);
        } //FIN MODULE
        

	
}