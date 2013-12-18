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
        this.showcase = product2Facade.findAll();
        
    }
    
 
}
