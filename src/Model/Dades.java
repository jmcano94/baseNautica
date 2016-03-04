/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Vista.Consola;
import java.util.ArrayList;

/**
 *
 * @author Jose
 */
public class Dades {
    private ArrayList<Gerent> gerents;
    private ArrayList<Monitor> monitors;
    
    
    public Dades(){
        gerents = new ArrayList();
        gerents.add(new Gerent("jmcano94", "940411cano", "77632596Y", "Jose Manuel", "Cano"));
        monitors = new ArrayList();
        monitors.add(new Monitor("mcc40", "mcc40", "11111111A", "Marc", "Calviño"));
        monitors.add(new Monitor("genjuasu" ,"genjuasu", "22222222B", "Gerard", "Enjuanes"));
    }

    public ArrayList<Gerent> getGerents() {
        return gerents;
    }

    public ArrayList<Monitor> getMonitors() {
        return monitors;
    }

    public void addMonitor(){
        Consola.escriu("Nom del Monitor?: ");
        String nom = Consola.llegeixString();
        Consola.escriu("\nCognom?: ");
        String cognom = Consola.llegeixString();
        Consola.escriu("\nEntra el seu DNI: ");
        String dni = Consola.llegeixDNI();
        Consola.escriu("\nQuin sera el username?: ");
        String username = Consola.llegeixString();
        Consola.escriu("\nQuina sera la contrasenya? ");
        String contrasenya = Consola.llegeixString();
        Monitor m = new Monitor(username,contrasenya,dni,nom,cognom);
        monitors.add(m);
        Consola.escriu("\nS'ha afegit el monitor.");
        
    }
    
    
    public void mostrarMonitors(){
        Consola.imprimirLista(monitors);
    }
    
}
