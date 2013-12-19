/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.encyclopedia.Accessory;
import entity.encyclopedia.Actor;
import entity.encyclopedia.Article;
import entity.encyclopedia.Association;
import entity.encyclopedia.Book;
import entity.encyclopedia.Copyright;
import entity.encyclopedia.Entreprise;
import entity.encyclopedia.Game;
import entity.encyclopedia.Licence;
import entity.encyclopedia.Person;
import entity.encyclopedia.Theme;
import facade.AccessoryFacade;
import facade.ActorFacade;
import facade.ArticleFacade;
import facade.AssociationFacade;
import facade.BookFacade;
import facade.CopyrightFacade;
import facade.EntrepriseFacade;
import facade.GameFacade;
import facade.LicenceFacade;
import facade.PersonFacade;
import facade.ThemeFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tools.NodeSearch;

/**
 *
 * @author Anthony
 */
@ManagedBean(name="ResearchView")
@SessionScoped
public class ResearchView implements Serializable{
    @EJB
    private AccessoryFacade accessoryFacade;
    @EJB
    private ActorFacade actorFacade;
    @EJB
    private ArticleFacade articleFacade;
    @EJB
    private AssociationFacade associationFacade;
    @EJB
    private BookFacade bookFacade;
    @EJB
    private CopyrightFacade copyrightFacade;
    @EJB
    private EntrepriseFacade entrepriseFacade;
    @EJB
    private GameFacade gameFacade;
    @EJB
    private LicenceFacade licenceFacade;
    @EJB
    private PersonFacade personFacade;
    @EJB
    private ThemeFacade themeFacade;

    private String search;
    private String select;
    private ArrayList<NodeSearch> nodeList;

     /**
     * Creates a new instance of ResearchView
     */
    public ResearchView() {
    }
    
    public ArrayList<NodeSearch> getNodeList() {
        return nodeList;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }
    
    public Game test() {
        List<Game> gameList = gameFacade.findAll();
        return gameList.get(0);
//        return this.getSemanticNodeList().get(0).getName();
    }
    
    public String getSearch() {
        return search;
    }
    
    public void setSearch(String s) {
        search = (String) s;
    } 
    
    public String research() {
        this.nodeList = new ArrayList<>();
        ArrayList semanticNodeList = new ArrayList();
        
        if(this.select.equals("accessory") || this.select.equals("all")){
            List<Accessory> accessoryList = accessoryFacade.findAll();
            for(int i = 0; i < accessoryList.size(); i++) {
                if(accessoryList.get(i).getName().contains(search)) {
                    semanticNodeList.add(accessoryList.get(i));
                }
            }

            if(!semanticNodeList.isEmpty()){
                this.nodeList.add(new NodeSearch("Accessoire",semanticNodeList));
                semanticNodeList = new ArrayList();
            }
        }
        
        if(this.select.equals("actor") || this.select.equals("all")){
            List<Actor> actorList = actorFacade.findAll();
            for(int i = 0; i < actorList.size(); i++) {
                if(actorList.get(i).toString().contains(search)) {
                    semanticNodeList.add(actorList.get(i));
                }
            }

            if(!semanticNodeList.isEmpty()){
                this.nodeList.add(new NodeSearch("Acteur",semanticNodeList));
                semanticNodeList = new ArrayList();
            }
        }
        
        if(this.select.equals("article") || this.select.equals("all")){
            List<Article> articleList = articleFacade.findAll();
            for(int i = 0; i < articleList.size(); i++) {
                if(articleList.get(i).toString().contains(search)) {
                    semanticNodeList.add(articleList.get(i));
                }
            }

            if(!semanticNodeList.isEmpty()){
                this.nodeList.add(new NodeSearch("Article",semanticNodeList));
                semanticNodeList = new ArrayList();
            }
        }
        
        if(this.select.equals("assoc") || this.select.equals("all")){
            List<Association> associationList = associationFacade.findAll();
            for(int i = 0; i < associationList.size(); i++) {
                if(associationList.get(i).getName().contains(search)) {
                    semanticNodeList.add(associationList.get(i));
                }
            }

            if(!semanticNodeList.isEmpty()){
                this.nodeList.add(new NodeSearch("Association",semanticNodeList));
                semanticNodeList = new ArrayList();
            }
        }
        
        if(this.select.equals("book") || this.select.equals("all")){
            List<Book> bookList = bookFacade.findAll();
            for(int i = 0; i < bookList.size(); i++) {
                if(bookList.get(i).getName().contains(search)) {
                    semanticNodeList.add(bookList.get(i));
                }
            }

            if(!semanticNodeList.isEmpty()){
                this.nodeList.add(new NodeSearch("Livre",semanticNodeList));
                semanticNodeList = new ArrayList();
            }
        }
        
        if(this.select.equals("copy") || this.select.equals("all")){
            List<Copyright> copyrightList = copyrightFacade.findAll();
            for(int i = 0; i < copyrightList.size(); i++) {
                if(copyrightList.get(i).toString().contains(search)) {
                    semanticNodeList.add(copyrightList.get(i));
                }
            }

            if(!semanticNodeList.isEmpty()){
                this.nodeList.add(new NodeSearch("Copyright",semanticNodeList));
                semanticNodeList = new ArrayList();
            }
        }
        
        if(this.select.equals("entre") || this.select.equals("all")){
            List<Entreprise> entrepriseList = entrepriseFacade.findAll();
            for(int i = 0; i < entrepriseList.size(); i++) {
                if(entrepriseList.get(i).getName().contains(search)) {
                    semanticNodeList.add(entrepriseList.get(i));
                }
            }

            if(!semanticNodeList.isEmpty()){
                this.nodeList.add(new NodeSearch("Entreprise",semanticNodeList));
                semanticNodeList = new ArrayList();
            }
        }
        
        if(this.select.equals("game") || this.select.equals("all")){
            List<Game> gameList = gameFacade.findAll();
            for(int i = 0; i < gameList.size(); i++) {
                if(gameList.get(i).getName().contains(search)) {
                    semanticNodeList.add(gameList.get(i));
                }
            }

            if(!semanticNodeList.isEmpty()){
                this.nodeList.add(new NodeSearch("Jeu",semanticNodeList));
                semanticNodeList = new ArrayList();
            }
        }
        
        List<Licence> licenceList = licenceFacade.findAll();
        for(int i = 0; i < licenceList.size(); i++) {
            if(licenceList.get(i).getName().contains(search)) {
                semanticNodeList.add(licenceList.get(i));
            }
        }
        
        if(!semanticNodeList.isEmpty()){
            this.nodeList.add(new NodeSearch("Licence",semanticNodeList));
            semanticNodeList = new ArrayList();
        }
        
        List<Person> personList = personFacade.findAll();
        for(int i = 0; i < personList.size(); i++) {
            if(personList.get(i).getName().contains(search)) {
                semanticNodeList.add(personList.get(i));
            }
        }
        
        if(!semanticNodeList.isEmpty()){
            this.nodeList.add(new NodeSearch("Personne",semanticNodeList));
            semanticNodeList = new ArrayList();
        }
        
        List<Theme> themeList = themeFacade.findAll();
        for(int i = 0; i < themeList.size(); i++) {
            if(themeList.get(i).toString().contains(search)) {
                semanticNodeList.add(themeList.get(i));
            }
        }
        
        if(!semanticNodeList.isEmpty()){
            this.nodeList.add(new NodeSearch("Theme",semanticNodeList));
            semanticNodeList = new ArrayList();
        }
            
        return "recherche";
    }
}