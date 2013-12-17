/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.encyclopedia;

import entity.semantic.SemanticRessource;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Lob;
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
    @Lob
    private String summary;

    public Person getWriter() {
        return writer;
    }

    public void setWriter(Person writer) {
        this.writer = writer;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String getURI() {
        return SemanticRessource.BASEURI + "book#" + getId();
    }
}
