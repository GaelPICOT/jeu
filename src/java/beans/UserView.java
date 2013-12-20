/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.ecom.Cart;
import entity.ecom.NodeCart;
import entity.user.User;
import entity.user.UserStatu;
import facade.CartFacade;
import facade.NodeCartFacade;
import facade.ProductFacade;
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
    
    @EJB
    private NodeCartFacade nodeCartFacade;
    private NodeCart nodeCart;
    
    @EJB
    private ProductFacade productFacade;
    
    private int quantiteVoulue;
    
    public int getQuantiteVoulue() {
        return quantiteVoulue;
    }

    public void setQuantiteVoulue(int quantiteVoulue) {
        this.quantiteVoulue = quantiteVoulue;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    
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
        int total = 0;
        for (int i = 0; i < this.user.getCart().getList().size(); i++) {
            total += this.user.getCart().getList().get(i).getQuantity();
        }
        return("Panier ("+total+")");
    }

    public String createAccount(){
        cart = new Cart();
        cartFacade.create(cart);
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
            Cart c = ((CartView)((HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext()
                .getSession(true)).getAttribute("CartView")).getCart();
            if(userList.get(i).getMail().equals(user.getMail()) && userList.get(i).getHashPassword().equals(user.getHashPassword())) {
                user = userList.get(i);
                if(c.getId() != null){
                    for (int j = 0; j < c.getList().size(); j++) {
                        this.quantiteVoulue = c.getList().get(i).getQuantity();
                        addToCard(c.getList().get(i).getProd().getId());
                    }
                    ((HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext()
                    .getSession(true)).removeAttribute("CartView");
                }
                return "index";
            }
        }
        return "index";
    }
    
    public String addToCard(Long id){
        int i = this.user.getCart().isInCart(id);
        if(i == -1){
            this.nodeCart = new NodeCart();
            this.nodeCart.setProd(productFacade.find(id));
            this.nodeCart.setQuantity(this.quantiteVoulue);
            this.nodeCartFacade.create(nodeCart);
            this.user.getCart().addProduct(nodeCart);
        }else{
//            this.nodeCart = nodeCartFacade.find(this.cart.getList().get(i).getId());
//            this.nodeCart.setQuantity(this.nodeCart.getQuantity() + quantite);
//            nodeCartFacade.edit(nodeCart);
            this.user.getCart().majProd(i, this.user.getCart().getList().get(i).getQuantity()+this.quantiteVoulue);
        }
        userFacade.edit(this.user);
        return "article";
    }
    
    public String addOneToCard(Long id){
        int i = this.user.getCart().isInCart(id);
        if(i == -1){
            this.nodeCart = new NodeCart();
            this.nodeCart.setProd(productFacade.find(id));
            this.nodeCart.setQuantity(1);
            this.nodeCartFacade.create(nodeCart);
            this.user.getCart().addProduct(nodeCart);
        }else{
//            this.nodeCart = nodeCartFacade.find(this.cart.getList().get(i).getId());
//            this.nodeCart.setQuantity(this.nodeCart.getQuantity() + quantite);
//            nodeCartFacade.edit(nodeCart);
            this.user.getCart().majProd(i, this.user.getCart().getList().get(i).getQuantity()+1);
        }
        userFacade.edit(this.user);
        return "article";
    }
    
    public String addOneToCardFromCard(Long id){
        int i = this.user.getCart().isInCart(id);
        this.user.getCart().majProd(i, this.user.getCart().getList().get(i).getQuantity()+1);
        userFacade.edit(this.user);
        return "panier";
    }
    
    public String deleteOneToCard(Long id){
        int i = this.user.getCart().isInCart(id);
        if(this.user.getCart().getList().get(i).getQuantity()-1 == 0){
            this.user.getCart().removeProduct(i);
            userFacade.edit(this.user);
            return "panier";
        }
        this.user.getCart().majProd(i, this.user.getCart().getList().get(i).getQuantity()-1);
        userFacade.edit(this.user);
        return "panier";
    }
    
    public String deleteOfCard(Long id){
        int i = this.cart.isInCart(id);
        this.user.getCart().removeProduct(i);
        userFacade.edit(this.user);
        return "panier";
    }
    
    public String disconnect() {
        ((HttpSession) FacesContext.getCurrentInstance()
         .getExternalContext()
         .getSession(true)).invalidate();
        return "index";
    }
}
