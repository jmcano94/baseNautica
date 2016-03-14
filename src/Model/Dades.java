/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Vista.Consola;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jose
 */
public class Dades implements Serializable{
    private ArrayList<Gerent> gerents;
    private ArrayList<Monitor> monitors;
    private ArrayList<Sortida> sortides;
    private ArrayList<Neumatica> Llanxes;
    private Map<String,ArrayList<Material>> material;
    private Map<String,String> ids;
    private Map<String,ArrayList<Barco>> barcos;
    private final long  serialVersionUID = 2401479884442105427L;
    
    public Dades(){
        gerents = new ArrayList();
        gerents.add(new Gerent("jmcano94", "940411cano", "77632596Y", "Jose Manuel", "Cano"));
        gerents.add(new Gerent("eldelbar", "mcc4040", "21776737S", "Marc", "Sumnormal"));
        gerents.add(new Gerent("alejo", "acanocal", "77632597F", "Alejandro", "Cano"));
        monitors = new ArrayList();
        monitors.add(new Monitor("pedetration", "fuker", "11111111A", "Marcus", "Pedemontus"));
        monitors.add(new Monitor("genjuasu" ,"genjuasu", "22222222B", "Gerard", "Enjuanes"));
        material = new HashMap();
        barcos = new HashMap();
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
        Iterator<Monitor> it = monitors.iterator();
        boolean trobat = false;
        while ( it.hasNext() && !trobat) {
            trobat = it.next().pasEquals(m);
        }
        if (trobat) {
            Consola.escriu("\nAquest usuari ja existeix.");
            m = null;
        } else {
            monitors.add(m);
            Consola.escriu("\nS'ha afegit el monitor.");
        }
         
    }
    
    
    public void mostrarMonitors(){
        Consola.imprimirLista(monitors);
    }
    
    public void eliminarMonitor(){
        Consola.escriu("\nEscull el monitor que vols eliminar:");
        Consola.imprimirLista(monitors);
        int i = Consola.selNumLista(monitors);
        monitors.remove(i);
        Consola.escriu("\nMonitor eliminat correctament.");
    }
    
    
    public void afegirMaterial(){
        Set tipus = material.keySet();
        ArrayList<String> list = new ArrayList(tipus);
        Consola.escriu("\nEscull un tipus de Material: " );
        Consola.imprimirLista(list);
        int i = Consola.selNumLista(list);
        ArrayList mat = material.get(list.get(i));
        Material m = new Material(ids.get(list.get(i)) + String.valueOf(mat.size()), true, new Estat(false," "), list.get(i));
        mat.add(m);
        Consola.escriu("Nou " + m.getNom() + " afegit: \n---------------");
        Consola.escriu(m.toString());   
    }
    
    
    public void afegirNouTipusMaterial(){
        Consola.escriu("\nCom es diu el nou tipus de material?: ");
        boolean trobat = false;
        Set llistaTipus = material.keySet();
        String tipus = Consola.llegeixString();
        Iterator it = llistaTipus.iterator();
        while (it.hasNext() && !trobat){
            String element = (String) it.next();
            trobat = element.equals(tipus);
        }
        if (!trobat){
            Consola.escriu("\nQuin sera el seu ID?: ");
            String id = Consola.llegeixString();
            ArrayList<Material> mat = new ArrayList();
            material.put(tipus, mat);
            ids.put(tipus, id);
            Consola.escriu("\nNou tipus afegit: " + tipus);
        }else{
            Consola.escriu("\nJa existeix aquest tipus de material.");
        }
    }
    
    public void eliminarMaterial(){
        Consola.escriu("\nEntra l'ID del material.");
        String id = Consola.llegeixString();
        String tipus = (String) getKeyFromValue(ids, id);
        if (tipus != null){
            ArrayList<Material> array = material.get(tipus);
            Iterator it = array.iterator();
            boolean trobat = false;
            while (it.hasNext() && !trobat){
                Material m = (Material) it.next();
                if(m.getId().equals(id)){
                    trobat = true;
                    array.remove(m);
                }
            }
            if (!trobat){
                Consola.escriu("\nNo existeix cap material amb aquest ID");
            } else{
                Consola.escriu("\nMaterial eliminat correctament");
            }
        }else{
            Consola.escriu("\nNo existeix l'ID introduit.");
        }   
    }
    
    public void eliminarTipusMaterial(){
        Consola.escriu("\nIntrodueix el tipus que vols esborrar:");
        Consola.imprimirLista(material.keySet());
        String s = Consola.llegeixString();
        while(!material.keySet().contains(s)){
            Consola.escriu("\nAquest no es un tipus de la llista, siusplau introdueix un tipus valid");
            s = Consola.llegeixString();
        }
        Consola.escriu("\nEstas segur de que vols eliminar aquest tipus i tots els seus elements?(S/N): ");
        String resposta = Consola.llegeixString();
        while (!resposta.equals("S") || !resposta.equals("N")){
            Consola.escriu("No he entes, respon S o N.");
            resposta = Consola.llegeixString();
        }
        if(resposta.equals("S")){
            material.remove(s);
            Consola.escriu("\nS'ha esborrat el tipus.");
        }
        else{
            Consola.escriu("\nS'ha cancelat l'operació.");
        }
        
        
    }
    
    public void veureMaterialPerTipus(){
        Set tipus = material.keySet();
        ArrayList<String> list = new ArrayList(tipus);
        Consola.escriu("\nEscull un tipus de Material: " );
        Consola.imprimirLista(list);
        int i = Consola.selNumLista(list);
        ArrayList mat = material.get(list.get(i));
        Consola.imprimirLista(mat);
    }
    
    /**
     *
     * @param m
     */
    public void ferSortida(Monitor m) {
        Consola.escriu("hola");
        Date data = new Date();
        ArrayList<Barco> b = new ArrayList();
        ArrayList<Neumatica> n = new ArrayList();
        Consola.escriu("\nEscull els barcos que faras servir: ");
        Consola.escriu("\nEscull la neumatica amb la que sortiras");
        mostrarBarcosDisponibles();
        
        
        sortides.add(new Sortida(m,b,data,n));
    }
    
    public void programarSortida() {
        
    }

    private void mostrarBarcosDisponibles() {
        
    }
    
    public void afegirBarco(){
        Set tipus = barcos.keySet();
        ArrayList<String> list = new ArrayList(tipus);
        Consola.escriu("Escull un tipus de Barco: " );
        Consola.imprimirLista(list);
        int i = Consola.selNumLista(list);
        ArrayList barc = barcos.get(list.get(i));
        Barco b = new Barco(ids.get(list.get(i)) + String.valueOf(barc.size()), true, new Estat(false," "), list.get(i));
        barc.add(b);
        Consola.escriu("Nou " + b.getTipus() + " afegit: \n---------------");
        Consola.escriu(b.toString());   
    }
    
    public void afegirNouTipusBarco(){
        Consola.escriu("\nCom es diu el nou tipus de barco?: ");
        String tipus = Consola.llegeixString();
        boolean trobat = false;
        Set llistaBarcos = barcos.keySet();
        Iterator it = llistaBarcos.iterator();
        while (it.hasNext() && !trobat){
            String element = (String) it.next();
            trobat = element.equals(tipus);
        }
        if (!trobat){
            Consola.escriu("\nQuin sera el seu ID?: ");
            String id = Consola.llegeixString();
            ArrayList<Barco> barc = new ArrayList();
            barcos.put(tipus, barc);
            ids.put(tipus, id);
            Consola.escriu("\nNou tipus afegit: " + tipus);
        }else{
            Consola.escriu("\nJa existeix aquest tipus de barco");
        }
    }
    
    public void eliminarBarco(){
        Consola.escriu("\nEntra l'ID del barco: ");
        String id = Consola.llegeixString();
        String tipus = (String) getKeyFromValue(ids, id);
        if (tipus != null){
            ArrayList<Barco> array = barcos.get(tipus);
            Iterator it = array.iterator();
            boolean trobat = false;
            while (it.hasNext() && !trobat){
                Barco b = (Barco) it.next();
                if(b.getId().equals(id)){
                    trobat = true;
                    array.remove(b);
                }
            }
            if (!trobat){
                Consola.escriu("\nNo existeix cap barco amb aquest ID");
            } else{
                Consola.escriu("\nBarco eliminat correctament");
            }
        }else{
            Consola.escriu("\nNo existeix l'ID introduit.");
        }
    }
    
    public void veureBarcosPerTiupus(){
        Set tipus = barcos.keySet();
        ArrayList<String> list = new ArrayList(tipus);
        Consola.escriu("Escull un tipus de Barco: " );
        Consola.imprimirLista(list);
        int i = Consola.selNumLista(list);
        ArrayList barc = barcos.get(list.get(i));
        Consola.imprimirLista(barc);
    }
    
    private static Object getKeyFromValue(Map m, Object value){
        for(Object o : m.keySet()){
            if(m.get(o).equals(value)){
                return o;
            }
        }
        return null;
    }
}
