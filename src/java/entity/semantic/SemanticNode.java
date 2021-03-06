/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.semantic;

import entity.ModarateStatu;
import entity.user.User;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author inilog
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class SemanticNode implements Serializable {
    @OneToMany(mappedBy = "sujet", cascade=CascadeType.PERSIST)
    private List<TripleEntity> sujet;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private ModarateStatu moderate;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private User autor;

    public List<TripleEntity> getSujet() {
        return sujet;
    }

    public void setSujet(List<TripleEntity> sujet) {
        this.sujet = sujet;
    }

    public User getAutor() {
        return autor;
    }

    public void setAutor(User autor) {
        this.autor = autor;
    }

    public ModarateStatu getModerate() {
        return moderate;
    }

    public void setModerate(ModarateStatu moderate) {
        this.moderate = moderate;
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
        if (!(object instanceof SemanticNode)) {
            return false;
        }
        SemanticNode other = (SemanticNode) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.semantic.SemanticNode[ id=" + id + " ]";
    }
    
}
