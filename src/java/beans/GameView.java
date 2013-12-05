/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import entity.encyclopedia.Game;
import facade.GameFacade;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Anthony
 */
@ManagedBean(name="GameView")
@RequestScoped
public class GameView {
    @EJB
    private GameFacade gameFacade;
    private Game game;
    /**
     * Creates a new instance of BookView
     */
    public GameView() {
        this.game = new Game();
    }
    
    public Game getGame() {
//        logger.info("getUser");
      return game;
    }
    
    public String createGame(){
//        logger.info("createAccount");
//       this.messageFacade.create(message);
    gameFacade.create(game);
    return "jeuAjoute";
}
}
