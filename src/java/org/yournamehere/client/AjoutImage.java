/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.RootPanel;
import entity.user.UserStatu;
import org.yournamehere.client.sampleService.GWTServiceAddImage;
import org.yournamehere.client.sampleService.GWTServiceAddImageAsync;

/**
 *
 * @author inilog
 */
public class AjoutImage implements EntryPoint {

    @Override
    public void onModuleLoad() {
        final GWTServiceAddImageAsync service = GWT.create(GWTServiceAddImage.class);

        DockPanel page = new DockPanel();
	DockPanel body = new DockPanel();
	AdminTemplate.createTemplate(page, body, UserStatu.ADMIN);
        
        final FormPanel formPanel;
        formPanel = new FormPanel();
        formPanel.setAction(GWT.getModuleBaseURL() + "GWTServiceAddImage");
        formPanel.setEncoding(FormPanel.ENCODING_MULTIPART);
        formPanel.setMethod(FormPanel.METHOD_POST);
        final FileUpload uploader = new FileUpload();
        uploader.setName("image");
        formPanel.add(uploader);
        
        Button uploadButton = new Button("upload image");
        uploadButton.addClickHandler(new ClickHandler() {

            @Override
            public void onClick(final ClickEvent event) {
                if(!uploader.getFilename().equalsIgnoreCase("")) {
                    formPanel.submit();
                }

            }
        });
        formPanel.add(uploadButton);
        
        body.add(formPanel);
	RootPanel.get().add(page);
		
    }
    
}
