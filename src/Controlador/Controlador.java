/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Dades;
import Model.Gerent;
import Model.Monitor;
import Model.Sortida;
import Model.Usuari;
import Vista.Consola;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *Classe controladora de l'aplicació.
 * @author Jose
 */
public class Controlador {
    Dades dades;
    
    public Controlador() {
        dades = new Dades();
    }
   
    
    /**
     * Comprova que l'usuari i la contrasenya que introdueix, l'usuari son correctes, si ho son fa log-in
     * si no avisa a l'usuari. Retorna quin tipus d'usuari s'ha loguejat.
     * @param consola
     * @return 
     */
    public Usuari login(){
        Consola.escriu("Entra el teu usuari: ");
        String us = Consola.llegeixString();
        Consola.escriu("\nEntra la teva password: ");
        String password = Consola.llegeixString();
        ArrayList<Monitor> monitors = dades.getMonitors();
        Iterator it = monitors.iterator();
        boolean monitor_trobat = false;
        Monitor monitor = null;
        while (it.hasNext() && !monitor_trobat){
            monitor =  (Monitor) it.next();
            if (monitor.getUsuari().equals(us) && monitor.getPassword().equals(password) ){
                monitor_trobat = true;
            }
        }
        if (!monitor_trobat){
            ArrayList<Gerent> gerents = dades.getGerents();
            Iterator it2 = gerents.iterator();
            boolean gerent_trobat = false;
            Gerent gerent = null;
            while (it2.hasNext() && !gerent_trobat){
                gerent =  (Gerent) it2.next();
                if (gerent.getUsuari().equals(us) && gerent.getPassword().equals(password) ){
                    gerent_trobat = true;
                }
            }
            if(!gerent_trobat){
                Consola.escriu("\nERROR, l'usuari o la contrasenya no son correctes.");
                return null;
            }else{
                return gerent;
            }
        }else{
            return monitor;
        }
        
    }
    
    public void addMonitor(){
        dades.addMonitor();
    }
    
    public void mostrarMonitors(){
        dades.mostrarMonitors();
    }
    
    public void afegirMaterial(){
        dades.afegirMaterial();
    }
    
    public void afegirNouTipusMaterial(){
        dades.afegirNouTipusMaterial();
    }
    
    public void veurePerTipusMaterial(){
        dades.veureMaterialPerTipus();
    }

    /**
     *Crea una nova sortida automatica.
     * 
     * @param m Monitor que crea la sortida.
     */
    public void iniciarSortida(Monitor m) {
        
    }
    
    /**
     *Programa una sortida per a una hora concreta.
     * 
     */
    public void programarSortida() {
        
    }

    /**
     *Finalitzar una sortida que estava en curs.
     * @param m monitor qe vol acabar la sortida.
     * @return La sortida en curs del monitor m.
     */
    public Sortida acabarSortida(Monitor m) {
        return null;
    }
    
    
    
}
