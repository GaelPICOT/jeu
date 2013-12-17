/*
 * To change this template, choose Tools | Templates
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
public class Image extends SemanticNode implements Serializable, SemanticRessource {
    @ManyToMany(mappedBy = "images")
    private List<Productible> productibles;
    private static final long serialVersionUID = 1L;
    @Column(nullable=false)
    private String name;
    @Column(nullable=false)
    private String textAlt;
    @Lob
    private String description;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Copyright copyright;
    private String URL;

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public List<Productible> getProductibles() {
        return productibles;
    }

    public void setProductibles(List<Productible> productibles) {
        this.productibles = productibles;
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

    public String getTextAlt() {
        return textAlt;
    }

    public void setTextAlt(String textAlt) {
        this.textAlt = textAlt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Copyright getLicence() {
        return copyright;
    }

    public void setLicence(Copyright copyright) {
        this.copyright = copyright;
    }
    
    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "image#" + getId();
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
}
