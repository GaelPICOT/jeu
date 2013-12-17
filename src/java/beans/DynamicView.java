/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.semantic.SemanticNode;
import facade.AbstractFacade;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tools.Node;

/**
 *
 * @author kieffera
 */
@ManagedBean(name="DynamicView")
@RequestScoped
public class DynamicView {
    private Long idArticle;
    private String nomArticle;
    private String nomClasseBean;
    private ArrayList<Node> informations;
    
    /**
     * Creates a new instance of ArticleView
     */
    public DynamicView() {
        this.informations = new ArrayList<>();
    }

    public String getNomClasseBean() {
        return nomClasseBean;
    }

    public void setNomClasseBean(String nomClasseBean) {
        this.nomClasseBean = nomClasseBean;
    }

    public Long getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(Long idArticle) {
        this.idArticle = idArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public ArrayList<Node> getInformations() {
        return informations;
    }

    public void setInformations(ArrayList<Node> informations) {
        this.informations = informations;
    }
    
    /**
     * createPage retourne la page article après avoir récupéré tous les
     * champs à afficher dans celle ci
     * Utilisation d'introspection pour rester générique et pouvoir
     * récupérer tous les champs d'un objet peu importe sa classe
     * Insere les champs dans la HashMap informations sous forme :
     * <String, ArrayList>
     * @return article
     */
    public String createPage(){
        //On crée un objet Class correspondant a la class facade du bean a traiter
        Class facadeClass;
        
        //On crée un objet Class correspondant a la class du bean a traiter
        Class beanClass;
        
        AbstractFacade facade;
        SemanticNode bean;
        Method[] meths;
        
        try {
            facadeClass = Class.forName(nomClasseBean+"Facade");
            
            //Nouvelle instance de la facade
            facade = (AbstractFacade) facadeClass.newInstance();
            
            beanClass = Class.forName(nomClasseBean);
            
            //Nouvelle instance de la facade
            bean = (SemanticNode) facadeClass.newInstance();
            
            //Recuperation de toute les methodes du bean
            meths = beanClass.getClass().getMethods();
            
            //Recuperation de l'objet dans la BD
            bean = (SemanticNode) facade.find(idArticle);
            
            //Pour chaque methode du bean
            for (Method meth : meths) {
                //Si c'est une methode get
                if(meth.getName().contains("get")){
                    //Si la methode retourne un String
                    if(meth.getReturnType().toString().equals("String")){
                        ArrayList temp = new ArrayList();
                        try {
                            //Invocation de cette methode get
                            temp.add(meth.invoke(bean).toString());
                            //Insertion dans la liste des informations du bean
                            this.informations.add(new Node(meth.getName().substring(3), meth.getReturnType().toString(), temp));
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                            Logger.getLogger(DynamicView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    //Si la methode retourne une liste
                    else if(meth.getReturnType().toString().contains("List")){
                        try {
                            //Invocation de cette methode get et Insertion dans la liste des informations du bean
                            this.informations.add(new Node(meth.getName().substring(3), meth.getReturnType().toString(), (ArrayList) meth.invoke(bean)));
                        } catch (IllegalArgumentException | InvocationTargetException ex) {
                            Logger.getLogger(DynamicView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    //Si la methode retourne un autre type
                    else{
                        ArrayList temp = new ArrayList();
                        try {
                            //Invocation de cette methode get
                            temp.add(meth.invoke(bean));
                            //Insertion dans la liste des informations du bean
                            this.informations.add(new Node(meth.getName().substring(3), meth.getReturnType().toString(), temp));
                        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                            Logger.getLogger(DynamicView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DynamicView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DynamicView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DynamicView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "article";
    }
}
