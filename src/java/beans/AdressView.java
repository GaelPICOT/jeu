/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.user.Adress;
import entity.user.User;
import facade.AdressFacade;
import facade.UserFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
//import org.apache.log4j.Logger;

/**
 *
 * @author Anthony
 */
@ManagedBean(name="AdressView")
@RequestScoped
public class AdressView {
    @EJB
    private AdressFacade adressFacade;
    @EJB
    private UserFacade userFacade;
    private Adress adress;
    private User user;
    private Long id;
    
    /**
     * Creates a new instance of UserView
     */
    public AdressView() {
//        logger.info("constructor UserView");
        this.adress = new Adress();
        if(((HttpSession) FacesContext.getCurrentInstance()
         .getExternalContext()
         .getSession(true)).getAttribute("UserView") != null){
            this.user = ((UserView)((HttpSession) FacesContext.getCurrentInstance()
             .getExternalContext()
             .getSession(true)).getAttribute("UserView")).getUser();
        }else{
            this.user = null;
        }
    }

    public Adress getAdress() {
        return adress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String createAdress(){
        adressFacade.create(adress);
        if(this.user.getId() != null){
            this.user.addAdress(this.adress);
            this.userFacade.edit(user);
            return "paieEtape3";
        }
        return "paieEtape3";
    }
    
    public String validAdress(){
        if(this.user.getId() != null){
            adress = adressFacade.find(id);
            return "paieEtape3";
        }
        return "paieEtape2";
    }
}
