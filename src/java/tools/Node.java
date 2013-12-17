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
}
