/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.encyclopedia;

import entity.semantic.SemanticNode;
import entity.semantic.SemanticRessource;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

/**
 *
 * @author inilog
 */
@Entity
public class Article extends SemanticNode implements Serializable, SemanticRessource {
    private static final long serialVersionUID = 1L;
    @Column(nullable=false)
    private String title;
    @Lob
    @Column(nullable=false)
    private String texte;
    @ManyToMany
    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "article#" + getId();
    }
    
}
