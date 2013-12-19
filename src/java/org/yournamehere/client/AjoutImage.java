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
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import entity.encyclopedia.Image;
import entity.user.UserStatu;
import gwtupload.client.IUploadStatus.Status;
import gwtupload.client.IUploader;
import gwtupload.client.IUploader.OnFinishUploaderHandler;
import gwtupload.client.SingleUploader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.yournamehere.client.sampleService.GWTServiceAddEncyclopedia;
import org.yournamehere.client.sampleService.GWTServiceAddEncyclopediaAsync;
import org.yournamehere.client.sampleService.GWTServiceAddImage;
import org.yournamehere.client.sampleService.GWTServiceAddImageAsync;

/**
 *
 * @author inilog
 */
public class AjoutImage implements EntryPoint {
    
    final static Logger logger = Logger.getLogger("log");

    @Override
    public void onModuleLoad() {
        final GWTServiceAddEncyclopediaAsync service = GWT.create(GWTServiceAddEncyclopedia.class);
        final GWTServiceAddImageAsync service2 = GWT.create(GWTServiceAddImage.class);

        DockPanel page = new DockPanel();
	DockPanel body = new DockPanel();
	AdminTemplate.createTemplate(page, body, UserStatu.ADMIN);
        
        final VerticalPanel formPanel = new VerticalPanel();
        final HorizontalPanel form = new HorizontalPanel();
        VerticalPanel formFields = new VerticalPanel();
        
        HorizontalPanel fieldName = new HorizontalPanel();
        HorizontalPanel fieldDescription = new HorizontalPanel();
        HorizontalPanel fieldTextAlt = new HorizontalPanel();
        
        Label imageNameLabel = new Label("Nom de l'image: ");
        final TextBox imageNameValue = new TextBox();
        Label imageDescriptionLabel = new Label("Description de l'image: ");
        final TextArea imageDescriptionValue = new TextArea();
        Label imageTextAltLabel = new Label("TextAlt de l'image: ");
        final TextArea imageTextAltValue = new TextArea();
        final Button createImage = new Button("Creer image");

        
        fieldName.add(imageNameLabel);
        fieldName.add(imageNameValue);
        fieldDescription.add(imageDescriptionLabel);
        fieldDescription.add(imageDescriptionValue);
        fieldTextAlt.add(imageTextAltLabel);
        fieldTextAlt.add(imageTextAltValue);

        formFields.add(fieldName);
        formFields.add(fieldDescription);
        formFields.add(fieldTextAlt);
        formFields.add(createImage);
        
        form.add(formFields);
        form.add(new CopyrightComponent());
        
        final SingleUploader uploader = new SingleUploader(null, new Button());
        
        
        final AsyncCallback<String> callback = new AsyncCallback<String>() {
                public void onSuccess(String result) {
                        System.out.println("image created");
//                        imageId = result;
//                        imageId = new Integer(result);
//                        Window.alert("image créée" + result);
                        Window.alert("image créée");
//                        image.setId(result.longValue());
//                        logger.log(Level.INFO, "id: " + result);
                        formPanel.add(uploader);
                }
//
                public void onFailure(Throwable caught) {
                        System.out.println("error while creating image\n"+caught);
                        Window.alert("erreur lors de la création de l'image");
                }
        };
        
        final Image image = new Image();
        createImage.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                logger.log(Level.INFO, imageNameValue.getText() + " " + imageDescriptionValue.getText() + 
                        " " + imageTextAltValue.getText());
//                logger.log(Level.INFO, image.getId().toString());
                
                image.setName(imageNameValue.getText());
                image.setDescription(imageDescriptionValue.getText());
                image.setTextAlt(imageTextAltValue.getText());
//                image.setURL("aaa");
//                service.createEncyclopediaNode(image, callback);
                service2.addImage(image, callback);
                createImage.setEnabled(false);
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
        
        
        
        
        formPanel.add(form);
        uploader.addOnFinishUploadHandler(new OnFinishUploaderHandler() {
            @Override  
            public void onFinish(IUploader uploader) {
  //        	loggerJava.log(Level.SEVERE, "upload ended");
                if (uploader.getStatus() == Status.SUCCESS) {
//                    formPanel.add(new Label(uploader.getFileName()));
//                    RootPanel.get().add(new Label(uploader.getFileName()));
                    logger.log(Level.INFO, "upload success");
//                    service2.updateURL();
                }
            }
        });
        
        
        
        body.add(formPanel, DockPanel.CENTER);
	RootPanel.get().add(page);
		
    }
    
}
