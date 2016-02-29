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
public abstract class Usuari {
    String usuari;
    String password;
    String DNI;
    String Nom;
    String Cognom;

    public Usuari(String usuari, String password, String DNI, String Nom, String Cognom) {
        this.usuari = usuari;
        this.password = password;
        this.DNI = DNI;
        this.Nom = Nom;
        this.Cognom = Cognom;
    }

    public String getCognom() {
        return Cognom;
    }

    public String getDNI() {
        return DNI;
    }

    public String getPassword() {
        return password;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public void setCognom(String Cognom) {
        this.Cognom = Cognom;
    }

    public String getUsuari() {
        return usuari;
    }

    public String getNom() {
        return Nom;
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    
}
