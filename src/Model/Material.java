/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Jose
 */
public class Material implements Serializable {
    String id;
    boolean disponible;
    Estat estat;

    public Material(String id, boolean disponible, Estat estat) {
        this.id = id;
        this.disponible = disponible;
        this.estat = estat;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setEstat(Estat estat) {
        this.estat = estat;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Estat getEstat() {
        return estat;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
     
}
