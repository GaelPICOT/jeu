/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.encyclopedia;

import entity.semantic.PureSemanticRessource;
import entity.semantic.SemanticNode;
import entity.semantic.SemanticRessource;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author inilog
 */
@Entity
public class Rule extends SemanticNode implements Serializable, SemanticRessource {
    private static final long serialVersionUID = 1L;
    @ManyToOne
    private Copyright copyright;
    @ManyToMany
    private List<Image> images;
    @Lob
    private String rule;

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
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

    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "rule#" + getId();
    }
   
    @Override
    public String toString() {
        return this.getRule().substring(0, 255);
    }
}
