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
 * Association divers.
 * @author inilog
 */
@Entity
public class Association extends Actor implements Serializable, SemanticRessource {
    private static final long serialVersionUID = 1L;
    @OneToMany
    private List<Person> aderant;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Person> getAderant() {
        return aderant;
    }

    public void setAderant(List<Person> aderant) {
        this.aderant = aderant;
    }
    
    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "association#" + getId();
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
}
