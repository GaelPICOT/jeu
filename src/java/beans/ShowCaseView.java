/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.ecom.Product2;
import facade.Product2Facade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author xc1427
 */
@ManagedBean(name="ShowCaseView",eager=true)
@RequestScoped
public class ShowCaseView {
    @EJB
    private Product2Facade product2Facade;
    private List<Product2> showcase;

    public List<Product2> getShowcase() {
        return showcase;
    }
    /**
     * Creates a new instance of ShowCaseView2
     */
    public ShowCaseView() {
        this.showcase = new ArrayList<>();
        
    }
    
    public void initShowCase() {
        //this.showcase = product2Facade.findAll();
        
        // test sans base de donne
        Product2 p1 = new Product2();
        
        p1.setName("produit1");
        p1.setDescription("description jolie de 1");
        p1.setImage("img/prima1.jpg");
        p1.setPrice(10);
        p1.setReduction(1);
        
        Product2 p2 = new Product2();
        
        p2.setName("produit2");
        p2.setDescription("description jolie de 2");
        p2.setImage("img/prima2.jpg");
        p2.setPrice(20);
        p2.setReduction(2);
        
        Product2 p3 = new Product2();
        
        p3.setName("produit3");
        p3.setDescription("description jolie de 3");
        p3.setImage("img/prima3.jpg");
        p3.setPrice(30);
        p2.setReduction(3);
        
        Product2 p4= new Product2();
        
        p4.setName("produit4");
        p4.setDescription("description jolie de 4");
        p4.setImage("img/prima4.jpg");
        p4.setPrice(40);
        p4.setReduction(4);
        
        this.showcase.add(p1);
        this.showcase.add(p2);
        this.showcase.add(p3);
        this.showcase.add(p4);
                
        
    }
    
 
}
