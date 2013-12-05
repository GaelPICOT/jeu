/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.semantic.subtriple;

import entity.ModarateStatu;
import entity.encyclopedia.Accessory;
import entity.semantic.Predicate;
import entity.semantic.SemanticNode;
import entity.semantic.PureSemanticTriple;
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
public class TripleSAccessory implements Serializable, Triple {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private static final long serialVersionUID = 1L;
    @ManyToOne
    private Accessory sujet;
    @ManyToOne
    private Predicate predicate;
    @ManyToOne
    private SemanticNode objet;
    private ModarateStatu moderate;

    @Override
    public Accessory getSujet() {
        return sujet;
    }

    @Override
    public Predicate getPredicate() {
        return predicate;
    }

    @Override
    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public SemanticNode getObjet() {
        return objet;
    }

    @Override
    public void setObjet(SemanticNode objet) {
        this.objet = objet;
    }

    public ModarateStatu getModerate() {
        return moderate;
    }

    public void setModerate(ModarateStatu moderate) {
        this.moderate = moderate;
    }

    @Override
    public void setSujet(SemanticNode sujet) {
        if (sujet instanceof Accessory)
            this.sujet = (Accessory) sujet;
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
        if (!(object instanceof PureSemanticTriple)) {
            return false;
        }
        TripleSAccessory other = (TripleSAccessory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.semantic.Triple[ id=" + id + " ]";
    }
    
}
