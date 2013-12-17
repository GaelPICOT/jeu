/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.encyclopedia.Game;
import facade.GameFacade;
import javax.ejb.EJB;

import org.yournamehere.client.sampleService.GWTServiceAddGame;

/**
 *
 * @author anthony
 */
public class GWTServiceAddGameImpl extends RemoteServiceServlet implements GWTServiceAddGame {

    @EJB
    private GameFacade gameFacade;
    private Game game;
    
    public void createGame(String name, String description) {
        game = new Game();
        game.setName(name);
        game.setDescription(description);
        gameFacade.create(game);
    }
}
