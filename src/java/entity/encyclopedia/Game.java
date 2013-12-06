/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.encyclopedia;

import entity.semantic.SemanticRessource;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 *
 * @author inilog
 */
@Entity
public class Game extends Productible implements Serializable, SemanticRessource {
    private static final long serialVersionUID = 1L;
    @ManyToMany
    private List<Category> categories;
    @ManyToMany
    private List<Theme> themes;

    public List<Theme> getThemes() {
        return themes;
    }

    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }
    

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "game#" + getId();
    }
    
    
}
