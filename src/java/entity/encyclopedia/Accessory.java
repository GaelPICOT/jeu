/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.encyclopedia;

import java.io.Serializable;
import javax.persistence.Entity;
import entity.semantic.SemanticRessource;

/**
 *
 * @author inilog
 */
@Entity
public class Accessory extends Productible implements Serializable, SemanticRessource {
    private static final long serialVersionUID = 1L;

    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "accessory#" + getId();
    }
    
    
    
}
