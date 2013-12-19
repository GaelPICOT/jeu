/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.ecom.Cart;
import facade.CartFacade;
import facade.ProductFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kieffera
 */
@ManagedBean(name="CartView")
@SessionScoped
public class CartView {
    @EJB
    private CartFacade cartFacade;
    private Cart cart;
    
    @EJB
    private ProductFacade productFacade;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
    
    public String getSize(){
        return("Panier ("+this.cart.getList().size()+")");
    }
    
    /**
     * Creates a new instance of CartView
     */
    public CartView() {
        cart = new Cart();
    }
    
    public String addToCard(Long id, int quantite){
        if(this.cart.getId() == null){
            cartFacade.create(cart);
        }
        for (int i = 0; i < quantite; i++) {
            this.cart.addProduct(productFacade.find(id));
        }
        cartFacade.edit(cart);
        return "article";
    }
    
}
