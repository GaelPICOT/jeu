/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.semantic;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author inilog
 */
@Entity
public class PureSemanticRessource extends SemanticNode implements Serializable, SemanticRessource {
    private static final long serialVersionUID = 1L;
    @Column(unique = true)
    private String URI;
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getURI() {
        if (URI==null)
            return SemanticRessource.BASEURI + "ressource#" + getId();
        else
            return URI;
    }

    public void setURI(String URI) {
        this.URI = URI;
    }
    
}
