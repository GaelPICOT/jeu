/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.semantic.SemanticNode;
import facade.AbstractFacade;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import tools.Node;

/**
 *
 * @author kieffera
 */
@ManagedBean(name="DynamicView")
@SessionScoped
public class DynamicView implements Serializable {
    private String nomArticle;
    private ArrayList<Node> informations;
    private ArrayList<String> test;
    
    /**
     * Creates a new instance of ArticleView
     */
    public DynamicView() {
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

    public ArrayList<String> getTest() {
        return test;
    }

    public void setTest(ArrayList<String> test) {
        this.test = test;
    }
    
    
    
    /**
     * createPage retourne la page article après avoir récupéré tous les
     * champs à afficher dans celle ci
     * Utilisation d'introspection pour rester générique et pouvoir
     * récupérer tous les champs d'un objet peu importe sa classe
     * @return article
     */
    public String createPage(Long idArticle, String nomArticle, String nomClasseBean){
        this.nomArticle = nomArticle;
        this.informations = new ArrayList<>();
        this.test = new ArrayList<>();
        //On crée un objet Class correspondant a la class facade du bean a traiter
        Class facadeClass;
        
        //On crée un objet Class correspondant a la class du bean a traiter
        Class beanClass;
        
        Object facade;
        SemanticNode bean;
        Method[] meths;
        
        try {
            beanClass = Class.forName(nomClasseBean);
            
            String packageBean = beanClass.getPackage().getName();
            String classFacade = "facade." + nomClasseBean.substring(packageBean.length()+1) + "Facade";
            facadeClass = Class.forName(classFacade);
            
            //Nouvelle instance de la facade
            facade = facadeClass.newInstance();
            
            //Nouvelle instance de la facade
            bean = (SemanticNode) beanClass.newInstance();
            
            //Recuperation de toute les methodes du bean
            meths = bean.getClass().getMethods();
            
            Class[] find = new Class[]{Object.class};
            
            //Recuperation de l'objet dans la BD
            bean = (SemanticNode) facade.getClass().getMethod("find", find).invoke(facade,idArticle);
            
            //Pour chaque methode du bean
            for (Method meth : meths) {
                //Si c'est une methode get
                if(meth.getName().contains("get") && !meth.getName().contains("persistence") && !meth.getName().contains("URI") && !meth.getName().contains("Id") && !meth.getName().contains("Moderate") && !meth.getName().contains("Class")){
                    this.test.add(meth.toString());
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
                        ArrayList temp = new ArrayList();
                        try {
                            List t = (List)meth.invoke(bean);
                            for (int i = 0; i<t.size(); i++) {
                                temp.add(t.get(i));
                            }
                            //Invocation de cette methode get et Insertion dans la liste des informations du bean
                            this.informations.add(new Node(meth.getName().substring(3), meth.getReturnType().toString(), temp));
                        } catch (IllegalArgumentException | InvocationTargetException ex) {
                            Logger.getLogger(DynamicView.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    //Si la methode retourne un autre type
                    else{
                        ArrayList temp = new ArrayList<>();
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
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(DynamicView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(DynamicView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DynamicView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(DynamicView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "article";
    }
}
