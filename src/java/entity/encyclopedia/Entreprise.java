/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.encyclopedia;

import entity.semantic.SemanticRessource;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author inilog
 */
@Entity
public class Entreprise extends Actor implements Serializable, SemanticRessource {
    private static final long serialVersionUID = 1L;
    private String name;
    @OneToMany
    private List<Person> membre;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getMembre() {
        return membre;
    }

    public void setMembre(List<Person> membre) {
        this.membre = membre;
    }
    
    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "entreprise#" + getId();
    }
    
}
