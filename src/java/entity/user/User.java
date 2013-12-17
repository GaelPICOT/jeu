/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.user;

import entity.ecom.Cart;
import entity.ecom.Command;
import java.io.Serializable;
import java.util.ArrayList;
//import java.util.List;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author inilog
 */
@Entity
@Table(name="AppliUser")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String firstName;
    @Column(nullable=false, unique=true)
    private String mail;
    @Column(nullable=false)
    private String hashPassword;
    @OneToMany(cascade=CascadeType.PERSIST)
//    private Adress adresses;
    private List<Adress> adresses;
    @Column(name = "USERTYPE")
    private UserStatu type;
    @OneToOne(cascade=CascadeType.PERSIST)
    private Cart cart;
    @OneToMany(mappedBy = "user", cascade=CascadeType.PERSIST)
//    private Command commands;
    private List<Command> commands;

    public User() {
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Command> getCommands() {
//    public Command getCommands() {
        return commands;
    }

    public void setCommands(List<Command> commands) {
//    public void setCommands(Command commands) {
        this.commands = commands;
    }

    public UserStatu getType() {
        return type;
    }

    public void setType(UserStatu type) {
        this.type = type;
    }

    public List<Adress> getAdresses() {
//    public Adress getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adress> adresses) {
//    public void setAdresses(Adress adresses) {
        this.adresses = adresses;
    }
    
    public void addAdress(Adress adress){
        this.adresses.add(adress);
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.user.User[ id=" + id + " ]";
    }

    public void setCommand(ArrayList<Command> commands) {
        this.commands = commands;
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
