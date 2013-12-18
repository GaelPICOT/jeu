/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.ecom.Product2;
import facade.Product2Facade;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author xc1427
 */
@ManagedBean(name="Product2View")
@RequestScoped
public class Product2View {
    @EJB
    private Product2Facade product2Facade;
    
    private Product2 product2;

    public Product2 getProduct2() {
        return product2;
    }

    /**
     * Creates a new instance of Prod2View
     */
    public Product2View() {
        this.product2 = new Product2();
    }
    
    public String createProduct2(){
//        logger.info("createAccount");
//       this.messageFacade.create(message);
        product2Facade.create(product2);
        return "product2Ajoute";
    }
    
    public int countProduct2(){
        return product2Facade.findAll().size();
    }
}
