/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.semantic;

import entity.ModarateStatu;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 *
 * @author inilog
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class TripleEntity implements Serializable, Triple {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Predicate predicate;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private SemanticNode sujet;
    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    private PureSemanticRessource objetSem;
    private ModarateStatu moderate;

    public ModarateStatu getModerate() {
        return moderate;
    }

    public void setmoderate(ModarateStatu moderate) {
        this.moderate = moderate;
    }

    @Override
    public SemanticRessource getSujet() {
        if (sujet instanceof SemanticRessource)
            return (SemanticRessource)sujet;
        else
            return null;
    }

    @Override
    public void setSujet(SemanticRessource sujet) {
        if (sujet instanceof SemanticNode)
            this.sujet = (SemanticNode)sujet;
    }


    @Override
    public SemanticNode getObjet() {
        return objetSem;
    }

    @Override
    public void setObjet(SemanticNode objet) {
        this.objetSem = (PureSemanticRessource) objet;
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
        if (!(object instanceof TripleEntity)) {
            return false;
        }
        TripleEntity other = (TripleEntity) object;
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
