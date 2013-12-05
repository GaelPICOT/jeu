/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.semantic;

/**
 *
 * @author inilog
 */
public interface Triple {
    public void setSujet(SemanticNode sujet);
    public SemanticNode getSujet();
    public void setObjet(SemanticNode sujet);
    public SemanticNode getObjet();
    public Predicate getPredicate();
    public void setPredicate(Predicate predicate);
}
