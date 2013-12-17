/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.encyclopedia.Copyright;
import facade.CopyrightFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import org.yournamehere.client.CopyrightClient;

import org.yournamehere.client.sampleService.GWTServiceCopyright;

/**
 *
 * @author anthony
 */
public class GWTServiceCopyrightImpl extends RemoteServiceServlet implements GWTServiceCopyright {

    @EJB
    private CopyrightFacade copyrightFacade;
    
    public List<CopyrightClient> getCopyright() {
        List<Copyright> listCopyright = copyrightFacade.findAll();
        List<CopyrightClient> listCopyrightClient = new ArrayList<CopyrightClient>();
        if (listCopyright!=null)
            for(Copyright cop : listCopyright) {
                listCopyrightClient.add(new CopyrightClient(cop.toString()));
            }
        return listCopyrightClient;
    }
}
