/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.semantic.subtriple;

import entity.encyclopedia.Accessory;
import entity.encyclopedia.Game;
import entity.semantic.Predicate;
import entity.semantic.SemanticNode;
import entity.semantic.Triple;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author inilog
 */
@Entity
public class TripleSAccessoryOGame implements Serializable, Triple {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Accessory sujet;
    @ManyToOne
    private Predicate predicate;
    @ManyToOne
    private Game objet;

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
        if (!(object instanceof TripleSAccessoryOGame)) {
            return false;
        }
        TripleSAccessoryOGame other = (TripleSAccessoryOGame) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.semantic.subtriple.TripleSAccessoryOGame[ id=" + id + " ]";
    }

    @Override
    public void setSujet(SemanticNode sujet) {
        if (sujet instanceof Accessory)
            this.sujet = (Accessory) sujet;
    }

    @Override
    public SemanticNode getSujet() {
        return sujet;
    }

    @Override
    public void setObjet(SemanticNode objet) {
        if (objet instanceof Game)
            this.objet = (Game) objet;
    }

    @Override
    public SemanticNode getObjet() {
        return objet;
    }

    @Override
    public Predicate getPredicate() {
        return predicate;
    }

    @Override
    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }
    
}
