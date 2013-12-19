/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yournamehere.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import entity.encyclopedia.Image;
import entity.semantic.SemanticNode;
import gwtupload.client.IUploadStatus;
import gwtupload.client.IUploader;
import gwtupload.client.SingleUploader;
import java.util.Iterator;
import java.util.logging.Level;
import org.yournamehere.client.sampleService.GWTServiceAddImage;
import org.yournamehere.client.sampleService.GWTServiceAddImageAsync;

/**
 *
 * @author picotg
 */
public class ImagePanel extends SemanticPanel<Image> {
//    Panel concretPanel = new VerticalPanel();
    
//    public abstract T getSemanticObject();

    
    public ImagePanel() {
        final GWTServiceAddImageAsync service = GWT.create(GWTServiceAddImage.class);
        
        final VerticalPanel panel = new VerticalPanel();
        
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
        
//        final SingleUploader uploader = new SingleUploader(null, new Button());
        final SingleUploader uploader = new SingleUploader();
        uploader.setVisible(false);
        
        final Image image = new Image();
        
        final AsyncCallback<String> callback = new AsyncCallback<String>() {
                public void onSuccess(String result) {
                        System.out.println("image created");
                        uploader.setServletPath(uploader.getServletPath() + "?id=" + result);
                        uploader.setVisible(true);
                }
//
                public void onFailure(Throwable caught) {
                        System.out.println("error while creating image\n"+caught);
                        Window.alert("erreur lors de la création de l'image");
                }
        };
        
        
        createImage.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                image.setName(imageNameValue.getText());
                image.setDescription(imageDescriptionValue.getText());
                image.setTextAlt(imageTextAltValue.getText());
                service.addImage(image, callback); 
                createImage.setEnabled(false);
            }
        });
        
        panel.add(form);
        panel.add(uploader);
        panel.add(new Label("Images crées: "));

        uploader.addOnFinishUploadHandler(new IUploader.OnFinishUploaderHandler() {
            @Override  
            public void onFinish(IUploader iUploader) {
                if (iUploader.getStatus() == IUploadStatus.Status.SUCCESS) {
                    createImage.setEnabled(true);
                    imageNameValue.setText("");
                    imageDescriptionValue.setText("");
                    imageTextAltValue.setText("");
                    panel.add(new Label(iUploader.getFileName()));
                    uploader.setVisible(false);
                }
            }
        });
        this.setConcretPanel(panel);
    }

    
    
    @Override
    public Image getSemanticObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
