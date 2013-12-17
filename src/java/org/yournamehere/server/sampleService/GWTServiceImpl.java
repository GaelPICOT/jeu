/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.yournamehere.client.sampleService.GWTService;

/**
 *
 * @author Anthony
 */

//@RequestScoped
public class GWTServiceImpl extends RemoteServiceServlet implements GWTService {
    
//    @EJB
//    private GameFacade gameFacade;
//    private Game game;
//    
//    @EJB
//    private CopyrightFacade copyrightFacade;
//    
//    @EJB
//    private AccessoryFacade accessoryFacade;
//    private Accessory accessory;
//
//    public User getUser() {
//        return((UserView)((HttpSession) FacesContext.getCurrentInstance()
//            .getExternalContext()
//            .getSession(true)).getAttribute("UserView")).getUser();
//    }
//    
//    public void createAccessory(String name, String description) {
//        accessory = new Accessory();
//        accessory.setName(name);
//        accessory.setDescription(description);
//        accessoryFacade.create(accessory);
//    }
//    
//    public void createGame(String name, String description) {
//        game = new Game();
//        game.setName(name);
//        game.setDescription(description);
//        gameFacade.create(game);
//    }
//    
//    @Override
//    public List<CopyrightClient> getCopyright() {
//        List<Copyright> listCopyright = copyrightFacade.findAll();
//        List<CopyrightClient> listCopyrightClient = new ArrayList<CopyrightClient>();
//        if (listCopyright!=null)
//            for(Copyright cop : listCopyright) {
//                listCopyrightClient.add(new CopyrightClient(cop.toString()));
//            }
//        return listCopyrightClient;
//    }

    public String disconnect() {
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
        getThreadLocalRequest().getSession().invalidate();
        
//        ((HttpSession) FacesContext.getCurrentInstance()
//         .getExternalContext()
//         .getSession(true)).invalidate();
        
//        return "worked";
        return null;
    }
}
