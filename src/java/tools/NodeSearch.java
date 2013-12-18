/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.ArrayList;

/**
 *
 * @author kieffera
 */
public class NodeSearch {
    private String nomClass;
    private ArrayList listeRetour;

    public NodeSearch(String nomClass, ArrayList listeRetour) {
        this.nomClass = nomClass;
        this.listeRetour = listeRetour;
    }

    public String getNomClass() {
        return nomClass;
    }

    public void setNomClass(String nomClass) {
        this.nomClass = nomClass;
    }

    public ArrayList getListeRetour() {
        return listeRetour;
    }

    public void setListeRetour(ArrayList listeRetour) {
        this.listeRetour = listeRetour;
    }
}
