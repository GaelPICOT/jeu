/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.ecom;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * panier d'un utilisateur.
 * @author inilog
 */
@Entity
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade=CascadeType.PERSIST)
    private List<NodeCart> list;

    /**
     * accés à la liste des produit d'un panier
     * @return liste des produit d'un panier
     */
    public List<NodeCart> getList() {
        return list;
    }

    /**
     * changer list des produit contenu dans le panier.
     * @param list nouvelle list.
     */
    public void setList(List<NodeCart> list) {
        this.list = list;
    }
    
    /**
     * ajouter un produit au panier
     * @param prod produit à ajouté.
     */
    public void addProduct(NodeCart prod) {
        this.list.add(prod);
    }
    
    public int isInCart(Long id){
        for(int i = 0; i< this.list.size(); i++){
            if(this.list.get(i).getProd().getId().equals(id)){
                return i;
            }
        }
        return -1;
    }
    
    public void majProd(int index, int quantite){
        this.list.get(index).setQuantity(quantite);
    }
    
    /**
     * supprimer un produit du panier
     * @param prod produit à supprimer.
     */
    public void removeProduct (NodeCart prod) {
        this.list.remove(prod);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Panier contenant " + list.size() + " article(s)";
    }
    
}
