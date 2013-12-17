/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.ModarateStatu;
import entity.encyclopedia.Actor;
import entity.encyclopedia.Copyright;
import entity.encyclopedia.Licence;
import facade.ActorFacade;
import facade.CopyrightFacade;
import facade.LicenceFacade;
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
    private LicenceFacade licenceFacade;
    
    @EJB
    private CopyrightFacade copyrightFacade;
    
    @EJB
    private ActorFacade actorFacade;
    
    @Override
    public List<Licence> getLicence() {
        List<Licence> listLic = licenceFacade.findAll();
        List<Licence> retour = new ArrayList<>();
        for(Licence lic : listLic) {
            if (lic.getModerate()==ModarateStatu.VALIDATE) {
                lic.setSujet(new ArrayList<>(lic.getSujet()));
                retour.add(lic);
            }
        }
        return retour;
    }
    

    @Override
    public List<Actor> getOwner() {
        List<Actor> listActor = actorFacade.findAll();
        List<Actor> retour = new ArrayList<>();
        for(Actor act : listActor) {
            if (act.getModerate()==ModarateStatu.VALIDATE) {
                act.setSujet(new ArrayList<>(act.getSujet()));
                retour.add(act);               
            }
        }
        return retour;
    }
    
    @Override
    public Copyright getCopyright(int licId, int ownerId){
        List<Copyright> listCop = copyrightFacade.findAll();
        for(Copyright cop : listCop) {
            if(cop.getLicence().getId()==licId)
                if(cop.getAutorCopyRight().getId()==ownerId){
                    cop.setSujet(new ArrayList<>(cop.getSujet()));
                    return cop;                   
                }
        }
        Copyright newCop = new Copyright();
        Licence lic = licenceFacade.find(licId);
        Actor owner = actorFacade.find(ownerId);
        newCop.setAutorCopyRight(owner);
        newCop.setLicence(lic);
        copyrightFacade.create(newCop);
        return newCop;
    }
    
}
