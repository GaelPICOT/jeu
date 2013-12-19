/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.encyclopedia;

import entity.semantic.SemanticNode;
import entity.semantic.SemanticRessource;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * droit (licence + propriétaire)
 * @author inilog
 */
@Entity
public class Copyright extends SemanticNode implements Serializable, SemanticRessource {
    private static final long serialVersionUID = 1L;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Licence licence;
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Actor autorCopyRight;

    public Actor getAutorCopyRight() {
        return autorCopyRight;
    }

    public void setAutorCopyRight(Actor autorCopyRight) {
        this.autorCopyRight = autorCopyRight;
    }

    public Licence getLicence() {
        return licence;
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }
    
    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "game#" + getId();
    }
    
    @Override
    public String toString() {
        return licence + " : " + autorCopyRight;
    }
}
