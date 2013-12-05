/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.semantic;

import entity.ModarateStatu;
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
public class PureSemanticTriple implements Serializable, Triple {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @ManyToOne
    private Predicate predicate;
    @ManyToOne
    private SemanticNode sujet;
    @ManyToOne
    private SemanticNode objet;
    private ModarateStatu moderate;

    public ModarateStatu getModerate() {
        return moderate;
    }

    public void setmoderate(ModarateStatu moderate) {
        this.moderate = moderate;
    }

    @Override
    public SemanticNode getSujet() {
        return sujet;
    }

    @Override
    public void setSujet(SemanticNode sujet) {
        this.sujet = sujet;
    }


    @Override
    public SemanticNode getObjet() {
        return objet;
    }

    @Override
    public void setObjet(SemanticNode objet) {
        this.objet = objet;
    }

    @Override
    public Predicate getPredicate() {
        return predicate;
    }

    @Override
    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
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
        PureSemanticTriple other = (PureSemanticTriple) object;
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
