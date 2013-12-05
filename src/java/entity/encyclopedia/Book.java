/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.encyclopedia;

import entity.semantic.SemanticRessource;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author inilog
 */
@Entity
public class Book extends Productible implements Serializable, SemanticRessource {
    private static final long serialVersionUID = 1L;
    @ManyToOne
    private Person writer;

    public Person getWriter() {
        return writer;
    }

    public void setWriter(Person writer) {
        this.writer = writer;
    }

    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "book#" + getId();
    }
}
