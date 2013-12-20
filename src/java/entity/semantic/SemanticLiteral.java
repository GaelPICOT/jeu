/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.semantic;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

/**
 *
 * @author inilog
 */
@Entity
public class SemanticLiteral extends SemanticNode implements Serializable {
    private static final long serialVersionUID = 1L;

    @Lob
    @Column(nullable=false, name="ValueSN")
    private String value;
    @Column(length=2, name="languageSemantic")
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return this.getValue();
    }
}
