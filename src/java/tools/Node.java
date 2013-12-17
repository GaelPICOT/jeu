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
public class Node {
    private String nomClass;
    private String nomClassRetour;
    private ArrayList listeRetour;

    public Node(String nomClass, String nomClassRetour, ArrayList listeRetour) {
        this.nomClass = nomClass;
        this.nomClassRetour = nomClassRetour;
        this.listeRetour = listeRetour;
    }
    
    public boolean returnString(){
        return (nomClassRetour.equals("String"));
    }

    public String getNomClass() {
        return nomClass;
    }

    public void setNomClass(String nomClass) {
        this.nomClass = nomClass;
    }

    public String getNomClassRetour() {
        return nomClassRetour;
    }

    public void setNomClassRetour(String nomClassRetour) {
        this.nomClassRetour = nomClassRetour;
    }

    public ArrayList getListeRetour() {
        return listeRetour;
    }

    public void setListeRetour(ArrayList listeRetour) {
        this.listeRetour = listeRetour;
    }
    
}
