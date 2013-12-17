/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.encyclopedia.Actor;
import entity.encyclopedia.Copyright;
import entity.encyclopedia.Licence;
import entity.semantic.TripleEntity;
import entity.user.User;
import facade.CopyrightFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;

import org.yournamehere.client.sampleService.GWTServiceCopyright;

/**
 *
 * @author anthony
 */
public class GWTServiceCopyrightImpl extends RemoteServiceServlet implements GWTServiceCopyright {

    @EJB
    private CopyrightFacade copyrightFacade;
    
    @Override
    public List<Copyright> getCopyright() {
        List<Copyright> listCopyright = copyrightFacade.findAll();
        List<Copyright> retoure = new ArrayList<Copyright>();
        if (listCopyright!=null)
            for(Copyright cop : listCopyright) {
                cop.setSujet(new ArrayList<TripleEntity>(cop.getSujet()));
                retoure.add(cop);
            }
        return retoure;
    }
}
