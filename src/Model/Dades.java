/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Vista.Consola;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jose
 */
public class Dades {
    private ArrayList<Gerent> gerents;
    private ArrayList<Monitor> monitors;
    private ArrayList<Sortida> sortides;
    private Map<String,ArrayList<Material>> material;
    
    public Dades(){
        gerents = new ArrayList();
        gerents.add(new Gerent("jmcano94", "940411cano", "77632596Y", "Jose Manuel", "Cano"));
        gerents.add(new Gerent("eldelbar", "mcc4040", "21776737S", "Marc", "Calviño"));
        monitors = new ArrayList();
        monitors.add(new Monitor("pedetration", "fuker", "11111111A", "Marcus", "Pedemontus"));
        monitors.add(new Monitor("genjuasu" ,"genjuasu", "22222222B", "Gerard", "Enjuanes"));
        material = new HashMap();
        material.put("Timo", new ArrayList());
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
    
    public void afegirMaterial(){
        Set tipus = material.keySet();
        Consola.escriu("Escull un tipus de Material: " );
        Consola.imprimirLista(tipus);
        Consola.selNumLista(tipus);
        
    }
    
}
