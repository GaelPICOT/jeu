/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.client.sampleService;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import entity.encyclopedia.Image;

/**
 *
 * @author anthony
 */
@RemoteServiceRelativePath("sampleservice/gwtserviceaddimage")
public interface GWTServiceAddImage extends RemoteService {

    public int addImage(Image image);
}
