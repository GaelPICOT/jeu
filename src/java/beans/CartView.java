/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entity.ecom.Cart;
import entity.ecom.NodeCart;
import facade.CartFacade;
import facade.NodeCartFacade;
import facade.ProductFacade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author kieffera
 */
@ManagedBean(name="CartView")
@SessionScoped
public class CartView implements Serializable{
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

    public String getSize(){
        int total = 0;
        for (int i = 0; i < this.cart.getList().size(); i++) {
            total += this.cart.getList().get(i).getQuantity();
        }
        return("Panier ("+total+")");
    }
    
    /**
     * Creates a new instance of CartView
     */
    public CartView() {
        cart = new Cart();
    }
    
    public String addToCard(Long id){
        if(this.cart.getId() == null){
            cartFacade.create(cart);
        }
        int i = this.cart.isInCart(id);
        if(i == -1){
            this.nodeCart = new NodeCart();
            this.nodeCart.setProd(productFacade.find(id));
            this.nodeCart.setQuantity(this.quantiteVoulue);
            this.nodeCartFacade.create(nodeCart);
            this.cart.addProduct(nodeCart);
        }else{
//            this.nodeCart = nodeCartFacade.find(this.cart.getList().get(i).getId());
//            this.nodeCart.setQuantity(this.nodeCart.getQuantity() + quantite);
//            nodeCartFacade.edit(nodeCart);
            this.cart.majProd(i, this.cart.getList().get(i).getQuantity()+this.quantiteVoulue);
        }
        cartFacade.edit(cart);
        return "article";
    }
    
    public String addOneToCard(Long id){
        if(this.cart.getId() == null){
            cartFacade.create(cart);
        }
        int i = this.cart.isInCart(id);
        if(i == -1){
            this.nodeCart = new NodeCart();
            this.nodeCart.setProd(productFacade.find(id));
            this.nodeCart.setQuantity(1);
            this.nodeCartFacade.create(nodeCart);
            this.cart.addProduct(nodeCart);
        }else{
//            this.nodeCart = nodeCartFacade.find(this.cart.getList().get(i).getId());
//            this.nodeCart.setQuantity(this.nodeCart.getQuantity() + quantite);
//            nodeCartFacade.edit(nodeCart);
            this.cart.majProd(i, this.cart.getList().get(i).getQuantity()+1);
        }
        cartFacade.edit(cart);
        return "article";
    }
    
}
