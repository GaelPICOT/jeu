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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author inilog
 */
@Entity
public class Productible extends SemanticNode implements Serializable, SemanticRessource {
    private static final long serialVersionUID = 1L;
    @Column(nullable=false)
    private String name;
    @Lob
    @Column(nullable=false)
    private String description;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Copyright copyright;
    @ManyToMany(cascade=CascadeType.PERSIST)
    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Copyright getCopyright() {
        return copyright;
    }

    public void setCopyright(Copyright copyright) {
        this.copyright = copyright;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "productible#" + getId();
    }
    
}
