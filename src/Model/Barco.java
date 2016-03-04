/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Jose
 */
public abstract class Barco {
    
    String id;
    boolean disponible;
    Estat estat;

    public Barco(String id, boolean disponible, Estat estat) {
        this.id = id;
        this.disponible = disponible;
        this.estat = estat;
    }
    

   

    public Estat getEstat() {
        return estat;
    }

    public String getId() {
        return id;
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

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
