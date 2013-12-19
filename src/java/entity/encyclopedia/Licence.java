/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.encyclopedia;

import entity.semantic.SemanticNode;
import entity.semantic.SemanticRessource;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 *
 * @author inilog
 */
@Entity
public class Licence extends SemanticNode implements Serializable, SemanticRessource {
    private static final long serialVersionUID = 1L;
    @Lob
    private String Text;
    @Column(nullable=false)
    private String name;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Copyright copyright;

    public Copyright getCopyright() {
        return copyright;
    }

    public void setCopyright(Copyright copyright) {
        this.copyright = copyright;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "licence#" + getId();
    }
    
    @Override
    public String toString() {
        return this.getName();
    }
}
