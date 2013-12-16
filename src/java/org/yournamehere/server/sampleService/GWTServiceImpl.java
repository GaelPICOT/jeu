/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.user.User;
import facade.UserFacade;
import javax.ejb.EJB;
import beans.UserView;
import com.google.gwt.user.client.Window;
import entity.encyclopedia.Accessory;
import entity.encyclopedia.Game;
import facade.AccessoryFacade;
import facade.GameFacade;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.yournamehere.client.sampleService.GWTService;

/**
 *
 * @author Anthony
 */

//@RequestScoped
public class GWTServiceImpl extends RemoteServiceServlet implements GWTService {
    
    @EJB
    private GameFacade gameFacade;
    private Game game;
    
    @EJB
    private AccessoryFacade accessoryFacade;
    private Accessory accessory;
    /**
     * Creates a new instance of BookView
     */
//    public GameView() {
//        this.game = new Game();
//    }
    
//    public Game getGame() {
////        logger.info("getUser");
//      return game;
//    }
    

//    @EJB
//    private UserFacade userFacade;
//    private User user;
    
    public void createAccessory(String name, String description) {
        accessory = new Accessory();
        accessory.setName(name);
        accessory.setDescription(description);
        accessoryFacade.create(accessory);
    }
    
    public String createGame(String name, String description) {
        game = new Game();
        game.setName(name);
        game.setDescription(description);
        gameFacade.create(game);
        return name + ";" + description;
    }

    public void disconnect() {
//        System.out.println("debut myMethod");
//        UserView userView = new UserView();
//        userFacade = new UserFacade();
//        this.user = ((UserView)((HttpSession) FacesContext.getCurrentInstance()
//             .getExternalContext()
//             .getSession(true)).getAttribute("UserView")).getUser();
//        user = userView.getUser();
//        userFacade = userView.getUserFacade();
//        System.out.println("mail: " + user.getMail());
//        System.out.println("prenom: " + user.getFirstName());
//        System.out.println("userFacade: " + userFacade);
        // Do something interesting with 's' here on the server.
//        return "mail: " + user.getMail();
//        return "Server says: " + s;
//        logger.info("createAccount");
//       this.messageFacade.create(message);

//        game = new Game();
//        game.setName("huh");
//        game.setDescription("huh2");
//        gameFacade.create(game);
        
        
        ((HttpSession) FacesContext.getCurrentInstance()
         .getExternalContext()
         .getSession(true)).invalidate();
        
//        return "worked";
    }
}