/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Vista.Consola;
import java.util.ArrayList;
import java.util.HashMap;
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
    private Map<String,String> ids;
    
    public Dades(){
        gerents = new ArrayList();
        gerents.add(new Gerent("jmcano94", "940411cano", "77632596Y", "Jose Manuel", "Cano"));
        gerents.add(new Gerent("eldelbar", "mcc4040", "21776737S", "Marc", "Calviño"));
        monitors = new ArrayList();
        monitors.add(new Monitor("pedetration", "fuker", "11111111A", "Marcus", "Pedemontus"));
        monitors.add(new Monitor("genjuasu" ,"genjuasu", "22222222B", "Gerard", "Enjuanes"));
        material = new HashMap();
        material.put("Timo", new ArrayList());
        ids = new HashMap();
        ids.put("Timo", "TIM_");
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
        if 
        monitors.add(m);
        Consola.escriu("\nS'ha afegit el monitor.");
         
    }
    
    
    public void mostrarMonitors(){
        Consola.imprimirLista(monitors);
    }
    
    public void afegirMaterial(){
        Set tipus = material.keySet();
        ArrayList<String> list = new ArrayList(tipus);
        Consola.escriu("Escull un tipus de Material: " );
        Consola.imprimirLista(list);
        int i = Consola.selNumLista(list);
        ArrayList mat = material.get(list.get(i));
        Material m = new Material(ids.get(list.get(i)) + String.valueOf(mat.size()), true, new Estat(false," "), list.get(i));
        mat.add(m);
        Consola.escriu("Nou " + m.getNom() + " afegit: \n---------------");
        Consola.escriu(m.toString());   
    }
    
    
    public void afegirNouTipusMaterial(){
        Consola.escriu("Com es diu el nou tipus de material?: ");
        String tipus = Consola.llegeixString();
        Consola.escriu("\nQuin sera el seu ID?: ");
        String id = Consola.llegeixString();
        ArrayList<Material> mat = new ArrayList();
        material.put(tipus, mat);
        ids.put(tipus, id);
        Consola.escriu("\nNou tipus afegit: " + tipus);
    }
    
    public void veureMaterialPerTipus(){
        Set tipus = material.keySet();
        ArrayList<String> list = new ArrayList(tipus);
        Consola.escriu("Escull un tipus de Material: " );
        Consola.imprimirLista(list);
        int i = Consola.selNumLista(list);
        ArrayList mat = material.get(list.get(i));
        Consola.imprimirLista(mat);
    }
}
