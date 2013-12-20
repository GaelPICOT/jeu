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
public class Person extends Actor implements Serializable, SemanticRessource {
    private static final long serialVersionUID = 1L;
    private String firstName;
    private String Name;
    @ManyToMany
    private List<Image> images;

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void addImage(Image image) {
        this.images.add(image);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "person#" + getId();
    }
    
    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getName();
    }
}
