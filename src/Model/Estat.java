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
public class Estat {
    boolean usable;
    String descripcio;

    public Estat(boolean usable, String descripcio) {
        this.usable = usable;
        this.descripcio = descripcio;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}