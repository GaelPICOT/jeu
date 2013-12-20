/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client; 

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
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
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.yournamehere.client.sampleService.GWTServiceAddEncyclopedia;
import org.yournamehere.client.sampleService.GWTServiceAddEncyclopediaAsync;
import org.yournamehere.client.sampleService.GWTServiceAddImage;
import org.yournamehere.client.sampleService.GWTServiceAddImageAsync;
import servlet.UploadServlet;

/**
 *
 * @author inilog
 */
public class AjoutImage implements EntryPoint {
    
//    final static Logger logger = Logger.getLogger("log");

    @Override
    public void onModuleLoad() {
        final GWTServiceAddEncyclopediaAsync service = GWT.create(GWTServiceAddEncyclopedia.class);
        final GWTServiceAddImageAsync service2 = GWT.create(GWTServiceAddImage.class);

        DockPanel page = new DockPanel();
	DockPanel body = new DockPanel();
	AdminTemplate.createTemplate(page, body, UserStatu.ADMIN);
        ImagePanel imagePanel = new ImagePanel(new ArrayList<Long>());
        body.add(imagePanel.getConcretPanel(), DockPanel.CENTER);
	RootPanel.get().add(page);
		
    }
    
}
