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
    private String nom;
    private String id;
    private boolean disponible;
    private Estat estat;

    public Material(String id, boolean disponible, Estat estat, String nom) {
        this.id = id;
        this.disponible = disponible;
        this.estat = estat;
        this.nom = nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
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
        return nom + "\nID: " + id + "\nDisponible: " +  dispo + "\nEstat: " + est;
    }
    
     
}
