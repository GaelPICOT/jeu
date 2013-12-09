/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.semantic.subtriple;

import entity.encyclopedia.Game;
import entity.semantic.SemanticNode;
import entity.semantic.TripleEntity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author inilog
 */
@Entity
public class TripleOGame extends TripleEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @ManyToOne
    private Game objet;
    
    @Override
    public SemanticNode getObjet() {
        return objet;
    }

    @Override
    public void setObjet(SemanticNode objet) {
        if (objet instanceof Game)
            this.objet = (Game)objet;
    }
}
