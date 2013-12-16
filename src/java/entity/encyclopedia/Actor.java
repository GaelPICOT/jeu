/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.encyclopedia;

import entity.semantic.SemanticNode;
import entity.semantic.SemanticRessource;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 *
 * @author inilog
 */
@Entity
public class Actor extends SemanticNode implements Serializable, SemanticRessource {
    private static final long serialVersionUID = 1L;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Article histoire;
    @Lob
    private String description;

    public Article getHistoire() {
        return histoire;
    }

    public void setHistoire(Article histoire) {
        this.histoire = histoire;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "actor#" + getId();
    }
    
}
