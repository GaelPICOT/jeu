/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.encyclopedia.Accessory;
import entity.encyclopedia.Book;
import entity.encyclopedia.Game;
import entity.encyclopedia.Productible;
import facade.AccessoryFacade;
import facade.BookFacade;
import facade.GameFacade;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Anthony
 */
@ManagedBean(name="ResearchView")
@RequestScoped
public class ResearchView {
    @EJB
    private BookFacade bookFacade;
    @EJB
    private GameFacade gameFacade;
    @EJB
    private AccessoryFacade accessoryFacade;
    private String search;
    private ArrayList<Productible> semanticNodeList;

    public ArrayList<Productible> getSemanticNodeList() {
        return semanticNodeList;
    }
    /**
     * Creates a new instance of ResearchView
     */
    public ResearchView() {
    }
    
    public List<Game> test() {
        List<Game> gameList = gameFacade.findAll();
        return gameList;
//        return this.getSemanticNodeList().get(0).getName();
    }
    
    public String getSearch() {
        return search;
    }
    
    public void setSearch(String s) {
        search = (String) s;
    }
    
    public String research() {
        semanticNodeList = new ArrayList<>();
        Game g = new Game();
        g.setName("poy");
        g.setId(Long.MIN_VALUE);
        semanticNodeList.add(g);
//        if(bookFacade.count() != 0) {
//        if(search!=null) {
//            List<Book> bookList = bookFacade.findAll();
//            for(int i = 0; i < bookList.size(); i++) {
//                if(bookList.get(i).getName().contains(search)) {
//                    semanticNodeList.add(bookList.get(i));
//                }
//            }
//        }
//        }
//        if(gameFacade.count() != 0) {
            List<Game> gameList = gameFacade.findAll();
            for(int i = 0; i < gameList.size(); i++) {
//                if(gameList.get(i).getName().contains(search)) {
                    semanticNodeList.add(gameList.get(i));
//                }
            }
//        }
//        if(accessoryFacade != null) {
//        if(accessoryFacade.count() != 0) {
//            List<Accessory> accessoryList = accessoryFacade.findAll();
//            for(int i = 0; i < accessoryList.size(); i++) {
//                if(accessoryList.get(i).getName().contains(search)) {
//                    semanticNodeList.add(accessoryList.get(i));
//                }
//            }
//        }
        return "recherche";
    }
}
