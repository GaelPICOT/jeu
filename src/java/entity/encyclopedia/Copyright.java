/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.encyclopedia;

import entity.semantic.SemanticNode;
import entity.semantic.SemanticRessource;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author inilog
 */
@Entity
public class Copyright extends SemanticNode implements Serializable, SemanticRessource {
    private static final long serialVersionUID = 1L;
    @ManyToOne
    private Licence licence;
    @ManyToOne
    private Person autorCopyRight;
    @ManyToOne
    private Copyright copyright;

    public Copyright getCopyright() {
        return copyright;
    }

    public void setCopyright(Copyright copyright) {
        this.copyright = copyright;
    }

    public Licence getLicence() {
        return licence;
    }

    public void setLicence(Licence licence) {
        this.licence = licence;
    }

    public Person getAutorCopyRight() {
        return autorCopyRight;
    }

    public void setAutorCopyRight(Person autorCopyRight) {
        this.autorCopyRight = autorCopyRight;
    }
    
    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "game#" + getId();
    }
    
}
