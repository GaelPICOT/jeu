/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.yournamehere.client;

import java.io.Serializable;

/**
 *
 * @author picotg
 */
public class CopyrightClient implements Serializable {
    private String copychaine;
    
    public CopyrightClient() {
        this.copychaine = "";
    }
    
    public CopyrightClient(String copychaine) {
        this.copychaine = copychaine;
    }

    public String getCopychaine() {
        return copychaine;
    }

    public void setCopychaine(String copychaine) {
        this.copychaine = copychaine;
    }
}
