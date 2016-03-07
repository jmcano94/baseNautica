/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Model.Gerent;
import Model.Monitor;
import Model.Usuari;
import edu.ub.prog2.utils.Menu;

/**
 *
 * @author Jose
 */
public class VisorMenu {
    Consola consola;
    Controlador controlador;
    static private enum opcionsMenu1{OPCIO1, EXIT};
    static private enum opcionsMenu4{OPCIO1, OPCIO2, OPCIO3, OPCIO4, EXIT};
    static private enum opcionsMenu2{OPCIO1, OPCIO2, EXIT};
    static private enum opcionsMenu3{OPCIO1, OPCIO2, OPCIO3, EXIT};
    static private String[] descLogin = {"Log-in", 
                                         "Sortir"};
    
    static private String[] descGerent = {"Gestió de Material", "Gestionar Sortides", "Gestionar Personal","Gestionar Barcos", "Sortir"};
    static private String[] descMonitor = {"Acabar Sortida", "Iniciar Sortida", "Sortir"};
    static private String[] gerentGestioPersonal = {"Afegir Monitor", "Veure Monitors", "Eliminar Monitor", "Enrere"};
    static private String[] gerentGestioSortides = {"Consultar Sortides", "Modificar Sortides", "Nova Sortida", "Enrere"};
    static private String[] gerentGestioBarcos = {"Afegir Barcos", "Veure Barcos", "Eliminar Barcos", "Enrere"};
    static private String[] gerentGestioMaterial = {"Afegir Material", "Afegir nou Tipus", "Eliminar Material", "Veure el Material", "Enrere"};
    /**
     * Constructor Simple
     */
    public VisorMenu(){
        consola = new Consola();
        controlador = new Controlador();
    }
    
    /**
     * Mostra el menu d'opcions a l'usuari.
     */
    public void mostrarMenuLogin(){
        Menu<opcionsMenu1> menuL = new Menu<>("BASE NAUTICA",opcionsMenu1.values());
        menuL.setDescripcions(descLogin);
        opcionsMenu1 opcio = null;
        do{
            menuL.mostrarMenu();
            opcio = menuL.getOpcio(consola.getSc());
            switch (opcio){
                case OPCIO1: // log-in
                    Usuari usuari = controlador.login();
                    if (usuari instanceof Gerent){
                        mostrarMenuGerent(Gerent.class.cast(usuari));
                    }
                    else if(usuari instanceof Monitor){
                        mostrarMenuMonitor(Monitor.class.cast(usuari));
                    }
                    break;
            }       
        }while (opcio != opcionsMenu1.EXIT);
    }
    
    /**
     * Mostra el menu d'opcions del gerent.
     * @param g gerent que veu les opcions.
     */
    public void mostrarMenuGerent(Gerent g){
        Menu<opcionsMenu4> menuG = new Menu<>("Bones " + g.getNom(), opcionsMenu4.values());
        menuG.setDescripcions(descGerent);
        opcionsMenu4 opcio = null;
        do{
            menuG.mostrarMenu();
            opcio = menuG.getOpcio(consola.getSc());
            switch (opcio){
                case OPCIO1: //gestio material
                    Menu<opcionsMenu4> menuGM = new Menu<>("Material ", opcionsMenu4.values());
                    menuGM.setDescripcions(gerentGestioMaterial);
                    opcionsMenu4 opcioGM = null;
                    do{
                        menuGM.mostrarMenu();
                        opcioGM = menuGM.getOpcio(consola.getSc());
                        switch (opcioGM) {
                            case OPCIO1: // afegir material
                                controlador.afegirMaterial();
                                break;
                            case OPCIO2:// afegir nou tipus de material
                                controlador.afegirNouTipusMaterial();
                                break;
                            case OPCIO3:// eliminar material
                                
                                break;
                            case OPCIO4:// veure material
                                controlador.veureMaterialPerTipus();
                                break;
                                
                        }
                    }while (opcioGM != opcionsMenu4.EXIT);
                    break;
                case OPCIO2: // gestio sortides
                    Menu<opcionsMenu3> menuGS = new Menu<>("Sortides ", opcionsMenu3.values());
                    menuGS.setDescripcions(gerentGestioSortides);
                    opcionsMenu3 opcioGS = null;
                    do {
                        menuGS.mostrarMenu();
                        opcioGS = menuGS.getOpcio(consola.getSc());
                        switch (opcioGS) {
                            case OPCIO1: //"Consultar Sortides"
                                
                                break;
                            case OPCIO2: //"Modificar Sortides"
                                
                                break;
                            case OPCIO3: //"Nova Sortida"
                                
                                break;
                        }
                    } while (opcioGS != opcionsMenu3.EXIT);
                    break;
                case OPCIO3: // gestio de personal
                    Menu<opcionsMenu3> menuGP = new Menu<>("Personal ", opcionsMenu3.values());
                    menuGP.setDescripcions(gerentGestioPersonal);
                    opcionsMenu3 opcioGP = null;
                    do {
                        menuGP.mostrarMenu();
                        opcioGP = menuGP.getOpcio(consola.getSc());
                        switch (opcioGP) {
                            case OPCIO1: // afegir monitor
                                controlador.addMonitor();
                                break;
                            case OPCIO2: // veure mnitors
                                controlador.mostrarMonitors();
                                break;
                            case OPCIO3: // eliminar monitor
                                //controlador.eliminarMonitor();
                                break;
                        }
                        
                    } while (opcioGP != opcionsMenu3.EXIT);
                    break;
                case OPCIO4:
                    Menu<opcionsMenu3> menuGB = new Menu<>("Personal ", opcionsMenu3.values());
                    menuGB.setDescripcions(gerentGestioBarcos);
                    opcionsMenu3 opcioGB = null;
                    do{
                        menuGB.mostrarMenu();
                        opcioGB = menuGB.getOpcio(consola.getSc());
                        switch(opcioGB){
                            case OPCIO1: //afegir Barcos
                                break;
                            case OPCIO2: //veure Barcos
                                break;
                            case OPCIO3: //eliminar Barcos
                                break;
                        }
                    }while( opcioGB != opcionsMenu3.EXIT);
            }
        }while (opcio != opcionsMenu4.EXIT);
    }
    
    /**
     *Mostrar menu d'opcions del monitor.
     * 
     * @param m
     */
    public void mostrarMenuMonitor(Monitor m){
        Menu<opcionsMenu2> menuM = new Menu<>("Bones " + m.getNom(), opcionsMenu2.values());
        menuM.setDescripcions(descMonitor);
        opcionsMenu2 opcio = null;
        do{
            menuM.mostrarMenu();
            opcio = menuM.getOpcio(consola.getSc());
            switch (opcio){
                case OPCIO1: // iniciar Sortida
                    controlador.iniciarSortida(m);
                    break;
                case OPCIO2: // acabar Sortida
                    controlador.acabarSortida(m);
                    break;
            }
        }while (opcio != opcionsMenu2.EXIT);
    }
}
