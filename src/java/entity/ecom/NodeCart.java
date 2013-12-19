/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.ecom;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import entity.encyclopedia.Release;
import entity.user.Comment;
import entity.user.User;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Un produit commercial.
 * @author inilog
 */
@Entity
public class NodeCart implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int quantity;

    public NodeCart() {
    }

    public NodeCart(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }
    
    
}
