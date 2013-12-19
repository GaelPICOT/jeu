/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.ecom.Cart;
import entity.user.User;
import entity.user.UserStatu;
import facade.CartFacade;
//import entity.user.UserStatu; 
import facade.UserFacade;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
//import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
//import org.apache.log4j.Logger;

/**
 *
 * @author Anthony
 */
@ManagedBean(name="UserView")
@SessionScoped
public class UserView implements Serializable {
    @EJB
    private UserFacade userFacade;
    private User user;
    
    @EJB
    private CartFacade cartFacade;
    private Cart cart;
    
    /**
     * Creates a new instance of UserView
     */
    public UserView() {
//        logger.info("constructor UserView");
        this.user = new User();
//        this.user.setType(UserStatu.CLIENT);
    }

    public User getUser() {
//        logger.info("getUser");
        return user;
    }
    
    public String getSize(){
        return("Panier ("+this.user.getCart().getList().size()+")");
    }

    public String createAccount(){
//        logger.info("createAccount");
        cart = new Cart();
//        cart.setList(new ArrayList<Product>());
        cartFacade.create(cart);
//        user.setCart(cart);
//        user.setAdresses(new ArrayList<Adress>());
        user.setType(UserStatu.CLIENT);
        userFacade.create(user);
        user.setCart(cart);
        userFacade.edit(user);
        return "compteCree";
    }
    
    public String findAccount(){
//        logger.info("createAccount");
//       this.messageFacade.create(message);
        List<User> userList = userFacade.findAll();
        for(int i = 0; i < userList.size(); i++) {
            if(userList.get(i).getMail().equals(user.getMail()) && userList.get(i).getHashPassword().equals(user.getHashPassword())) {
                user = userList.get(i);
                return "index";
            }
        }
        return "index";
    }
    
    public String disconnect() {
        ((HttpSession) FacesContext.getCurrentInstance()
         .getExternalContext()
         .getSession(true)).invalidate();
        return "index";
    }
}
