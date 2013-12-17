/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.ecom;

import entity.user.Adress;
import entity.user.User;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 * Une commande : un panier valider avecd une adresse d'envoi.
 * @author xc1427
 */
@Entity
public class Command implements Serializable {
    @ManyToOne(cascade=CascadeType.PERSIST)
    private User user;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Adress adress;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date predictedDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    Date sendDate;
    @OneToOne(cascade=CascadeType.PERSIST)
    private Cart content;

    /**
     * Recherche le contenu de la commende.
     * @return Contenu de la commende.
     */
    public Cart getContent() {
        return content;
    }

    /**
     * Change le contenu d'une commande.
     * @param content nouveau contenu de la commande
     */
    public void setContent(Cart content) {
        this.content = content;
    }

    /**
     * Recherche la date prévisionnelle d'envoi.
     * @return date prévisionnelle d'envoi.
     */
    public Date getPredictedDate() {
        return predictedDate;
    }

    public void setPredictedDate(Date predictedDate) {
        this.predictedDate = predictedDate;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
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
        if (!(object instanceof Command)) {
            return false;
        }
        Command other = (Command) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "commande envoyé chez " + this.adress.getFirstname() +" " + this.adress.getName();
    }
    
}
