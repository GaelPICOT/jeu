/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
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
}