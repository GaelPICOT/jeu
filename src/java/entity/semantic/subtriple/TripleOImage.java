/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.semantic.subtriple;

import entity.encyclopedia.Entreprise;
import entity.encyclopedia.Image;
import entity.semantic.SemanticNode;
import entity.semantic.TripleEntity;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;



/**
 * 
 * @author picotg
 */
@Entity
public class TripleOImage extends TripleEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @ManyToOne
    private Image objet;
    
    @Override
    public SemanticNode getObjet() {
        return objet;
    }

    @Override
    public void setObjet(SemanticNode objet) {
        if (objet instanceof Image)
            this.objet = (Image)objet;
    }
    
}
