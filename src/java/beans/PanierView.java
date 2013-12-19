package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Lucie
 */
@ManagedBean(name = "PanierView")
@RequestScoped
public class PanierView implements Serializable{

    /**
     * Creates a new instance of PanierView
     */
    public PanierView() {
    }
    
    public String createPage(){
        return "panier";
    }
}
