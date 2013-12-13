/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.encyclopedia;

import entity.ecom.Product;
import entity.semantic.SemanticNode;
import entity.semantic.SemanticRessource;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author inilog
 */
@Entity
@Table(name="AppliRelease")
public class Release extends SemanticNode implements Serializable, SemanticRessource {
    @OneToMany(mappedBy = "productibleType")
    private List<Product> products;
    private static final long serialVersionUID = 1L;
    @ManyToOne
    private Copyright copyright;
    @ManyToMany
    private List<Image> images;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

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
    
    @Lob
    @Column(nullable=false)
    private String descriptionDetails;
    @ManyToOne
    @JoinColumn(nullable=false)
    private Productible productibleType;

    public String getDescriptionDetails() {
        return descriptionDetails;
    }

    public void setDescriptionDetails(String descriptionDetails) {
        this.descriptionDetails = descriptionDetails;
    }

    public Productible getProductibleType() {
        return productibleType;
    }

    public void setProductibleType(Productible productibleType) {
        this.productibleType = productibleType;
    }

    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "release#" + getId();
    }
    
    
}
