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
    static private enum opcionsMenuLogin{OPCIO1, EXIT};
    static private enum opcionsMenuGerent{OPCIO1, OPCIO2, OPCIO3, EXIT};
    static private enum opcionsMenuMonitor{OPCIO1, OPCIO2, EXIT};
    static private String[] descLogin = {"Log-in", 
                                         "Sortir"};
    
    static private String[] descGerent = {"Consultes de Material", "Gestionar Sortides", "Gestionar Personal", "Sortir"};
    static private String[] descMonitor = {"Consultar Sortides", "Nova Sortida", "Sortir"};
    static private String[] gerentGestioPersonal = {"Afegir Monitor", "Veure Monitors", "Eliminar Monitor", "Sortir"};
    static private String[] gerentGestioSortides = {"Consultar Sortides", "Modificar Sortides", "Nova Sortida", "Sortir"};
    
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
        Menu<opcionsMenuLogin> menuL = new Menu<>("BASE NAUTICA",opcionsMenuLogin.values());
        menuL.setDescripcions(descLogin);
        opcionsMenuLogin opcio = null;
        do{
            menuL.mostrarMenu();
            opcio = menuL.getOpcio(consola.getSc());
            switch (opcio){
                case OPCIO1:
                    Usuari usuari = controlador.login();
                    if (usuari instanceof Gerent){
                        mostrarMenuGerent(Gerent.class.cast(usuari));
                    }
                    else if(usuari instanceof Monitor){
                        mostrarMenuMonitor(Monitor.class.cast(usuari));
                    }
                    break;
            }       
        }while (opcio != opcionsMenuLogin.EXIT);
    }
    
    /**
     * Mostra el menu d'opcions del gerent.
     */
    public void mostrarMenuGerent(Gerent g){
        Menu<opcionsMenuGerent> menuG = new Menu<>("Bones " + g.getNom(), opcionsMenuGerent.values());
        menuG.setDescripcions(descGerent);
        opcionsMenuGerent opcio = null;
        do{
            menuG.mostrarMenu();
            opcio = menuG.getOpcio(consola.getSc());
            switch (opcio){
                case OPCIO1:
                    break;
                case OPCIO2:
                    Menu<opcionsMenuGerent> menuGS = new Menu<>("Bones " + g.getNom(), opcionsMenuGerent.values());
                    menuGS.setDescripcions(gerentGestioSortides);
                    opcionsMenuGerent opcioGS = null;
                    do {
                        menuGS.mostrarMenu();
                        opcioGS = menuGS.getOpcio(consola.getSc());
                        switch (opcio) {
                            case OPCIO1:
                                //"Consultar Sortides"
                                break;
                            case OPCIO2:
                                //"Modificar Sortides"
                                break;
                            case OPCIO3:
                                //"Nova Sortida"
                                break;
                        }
                    } while (opcioGS != opcionsMenuGerent.EXIT);
                    break;
                case OPCIO3:
                    Menu<opcionsMenuGerent> menuGP = new Menu<>("Bones " + g.getNom(), opcionsMenuGerent.values());
                    menuGP.setDescripcions(gerentGestioPersonal);
                    opcionsMenuGerent opcioGP = null;
                    do {
                        menuGP.mostrarMenu();
                        opcioGP = menuGP.getOpcio(consola.getSc());
                        switch (opcio) {
                            case OPCIO1:
                                controlador.addMonitor();
                                break;
                            case OPCIO2:
                                controlador.mostrarMonitors();
                                break;
                            case OPCIO3:
                                //controlador.eliminarMonitor();
                                break;
                        }
                        
                    } while (opcioGP != opcionsMenuGerent.EXIT);
                    break;
                    
            }
        }while (opcio != opcionsMenuGerent.EXIT);
    }
    
    public void mostrarMenuMonitor(Monitor m){
        Menu<opcionsMenuMonitor> menuM = new Menu<>("Bones " + m.getNom(), opcionsMenuMonitor.values());
        menuM.setDescripcions(descMonitor);
        opcionsMenuMonitor opcio = null;
        do{
            menuM.mostrarMenu();
            opcio = menuM.getOpcio(consola.getSc());
            switch (opcio){
                case OPCIO1:
                    break;
                case OPCIO2:
                    break;
            }
        }while (opcio != opcionsMenuMonitor.EXIT);
    }
}
