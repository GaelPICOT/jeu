/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yournamehere.server.sampleService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import entity.encyclopedia.Game;
import entity.semantic.SemanticNode;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.yournamehere.client.sampleService.GWTServiceAddEncyclopedia;

/**
 *
 * @author picotg
 */
public class GWTServiceAddEncyclopediaImpl extends RemoteServiceServlet implements GWTServiceAddEncyclopedia {

    @Override
    public String createEncyclopediaNode(SemanticNode nodeAdd) {
        //On crée un objet Class correspondant a la class facade du bean a traiter
        Class facadeClass;
        
        //On crée un objet Class correspondant a la class du bean a traiter
        Class beanClass;
        
        Object facade;
        
        beanClass = nodeAdd.getClass();
        String packageBean = beanClass.getPackage().getName();
        String classFacade = "facade." + beanClass.getName().substring(packageBean.length()+1) + "Facade";
        try {
            facadeClass = Class.forName(classFacade);
            facade = facadeClass.newInstance();
            Class[] obj = new Class[]{Object.class};
            Game newNode = new Game();
            newNode.setName("test");
            newNode.setDescription("oui");
            facadeClass.getMethod("create", obj).invoke(facade, newNode);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GWTServiceAddEncyclopediaImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GWTServiceAddEncyclopediaImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GWTServiceAddEncyclopediaImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(GWTServiceAddEncyclopediaImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(GWTServiceAddEncyclopediaImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(GWTServiceAddEncyclopediaImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(GWTServiceAddEncyclopediaImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return nodeAdd.getClass().getName();
    }
}
