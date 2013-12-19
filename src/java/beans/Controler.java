/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import entity.ecom.Product;
import java.lang.reflect.Method;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
/**
 *
 * @author kieffera
 */
@ManagedBean(name="Controler")
@RequestScoped
public class Controler {

    /**
     * Creates a new instance of Controler
     */
    public Controler() {
    }
    
    public String getTestPaie(){
        return "jsf/paieEtape1";
    }
    
    public boolean isProductible(Object b){
        Method[] c = b.getClass().getMethods();
        for (Method method : c) {
           if(method.getName().contains("Release")){
                return true;
            } 
        }
        return false;
    }
    
    public boolean isBeanProduct(Object b){
        return b.getClass().equals(Product.class);
    }
}
