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
public class Barco implements Serializable {
    
    private String id;
    private boolean disponible;
    private Estat estat;
    private String tipus;
   

    Barco(String string, boolean b, Estat estat, String get) {
        id = string;
        disponible = b;
        this.estat = estat;
        tipus = get;
    
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
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
        String dispo;
        String est;
        if (disponible){
            dispo = "si";
        } else{
            dispo = "no";
        }
        if (estat.teDesperfecte()){
            est = "Per reparar";
        }else{
            est = "Llest per fer-se servir";
        }
        return tipus + "\nID: " + id + "\nDisponible: " +  dispo + "\nEstat: " + est;    
    }
    
   
    
    
}
