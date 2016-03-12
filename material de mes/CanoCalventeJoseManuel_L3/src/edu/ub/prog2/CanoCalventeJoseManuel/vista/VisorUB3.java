/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.CanoCalventeJoseManuel.vista;

import edu.ub.prog2.CanoCalventeJoseManuel.controlador.CtrlVisor;
import edu.ub.prog2.utils.Menu;
import java.util.Scanner;

/**
 *
 * @author jcanocal8.alumnes
 */
public class VisorUB3 {
    private CtrlVisor controlador = new CtrlVisor();
    static private enum OpcionsMenuPrincipal {MENU_OPCIO1,MENU_OPCIO2,MENU_OPCIO3,MENU_OPCIO4,MENU_SORTIR};
    static private enum OpcionsMenuBiblioteca{MENU_OPCIO1,MENU_OPCIO2,MENU_OPCIO3,MENU_OPCIO4,MENU_OPCIO5,MENU_OPCIO6,MENU_SORTIR};
    static private enum OpcionsMenuAlbums{MENU_OPCIO1,MENU_OPCIO2,MENU_OPCIO3,MENU_OPCIO4,MENU_SORTIR};
    static private enum OpcionsMenu{MENU_OPCIO1,MENU_OPCIO2,MENU_OPCIO3,MENU_SORTIR};
    static private String[] descMenu={"Gestió Biblioteca",
                                      "Gestió Àlbums",
                                      "Guardar Dades",
                                      "Recuperar Dades",
                                      "Sortir"};
    
    static private String[] descMenuBiblio={"Afegir Imatge",
                                            "Mostrar Biblioteca",
                                            "Eliminar Imatge",
                                            "Visualitzar Imatge",
                                            "Transformar Imatge",
                                            "Visualitzar Biblioteca",
                                            "Menú Anterior"};
    
    static private String[] descMenuGestioAlbums={"Afegir Àlbum",
                                                  "Mostrar Àlbums",
                                                  "Eliminar Àlbum",
                                                  "Gestionar Àlbum",
                                                  "Menú Anterior"};
    
    static private String[] descMenuVisualitzar={"Visualització sense filtre",
                                                 "Visualització amb filtre sèpia",
                                                 "Visualització amb filtre blanc i negre",
                                                 "Menú Anterior"};
    
    static private String[] descMenuTransformar={"Filtre sépia",
                                                 "Filtre blanc i negre",
                                                 "Sense filtre",
                                                 "Menu Anterior"};
    
    
    
    
    
    
    /**
     * Crea y mostra el menu d'opcions.
     * @param sc 
     */
    public void gestioVisorUB(Scanner sc) {
        Menu<OpcionsMenuPrincipal> menuP = new Menu<>("Menu Principal",OpcionsMenuPrincipal.values());
        menuP.setDescripcions(descMenu);
        OpcionsMenuPrincipal opcio = null;
        do {
            menuP.mostrarMenu();
            opcio=menuP.getOpcio(sc);
            switch(opcio)  {
                case MENU_OPCIO1:
                    Menu<OpcionsMenuBiblioteca> menuB = new Menu<>("Menu de Gestio de la Biblioteca",OpcionsMenuBiblioteca.values());
                    menuB.setDescripcions(descMenuBiblio);
                    OpcionsMenuBiblioteca oB = null;
                    do {
                        menuB.mostrarMenu();
                        oB = menuB.getOpcio(sc);
                        switch(oB)  {
                            case MENU_OPCIO1:  //afegir imatge  
                                controlador.afegirImatgeBiblioteca(sc);
                                break;
                            case MENU_OPCIO2: //mostrar biblioteca
                                controlador.mostrarBiblioteca();
                                break;
                            case MENU_OPCIO3: //eliminar imatge
                                controlador.eliminarImatgeBiblioteca(sc);
                                break;
                            case MENU_OPCIO4: //Visualitzar imatge
                                Menu<OpcionsMenu> menuV = new Menu<>("Menu de Visualització",OpcionsMenu.values());
                                menuV.setDescripcions(descMenuVisualitzar);
                                OpcionsMenu oV = null;
                                do{
                                    menuV.mostrarMenu();
                                    oV = menuV.getOpcio(sc);
                                    switch(oV) {
                                        case MENU_OPCIO1: //sense filtre
                                            controlador.visualitzarImatgeBiblioteca(sc);
                                            break;
                                        case MENU_OPCIO2: //filtre sepia
                                            controlador.visualitzarImatgeBibliotecaSepia(sc);
                                            break;
                                        case MENU_OPCIO3: //filtre B/N
                                            controlador.visualitzarImatgeBibliotecaBN(sc);
                                            break;
                                    }
                                }while(oV!= OpcionsMenu.MENU_SORTIR);
                                break;
                            case MENU_OPCIO5: //Transformar Imatge
                                Menu<OpcionsMenu> menuT = new Menu<>("Menu de Visualització",OpcionsMenu.values());
                                menuT.setDescripcions(descMenuTransformar);
                                OpcionsMenu oT = null;
                                do{
                                    menuT.mostrarMenu();
                                    oT = menuT.getOpcio(sc);
                                    switch(oT) {
                                        case MENU_OPCIO1: //filtre sepia
                                            
                                            break;
                                        case MENU_OPCIO2: //filtre B/N
                                            controlador.filtrarBlancNegreBiblioteca(sc);
                                            break;
                                        case MENU_OPCIO3: //sense filtre
                                            break;
                                    }
                                }while(oT!= OpcionsMenu.MENU_SORTIR);
                                break;
                            case MENU_OPCIO6: //visualitzar biblioteca sencera
                                break;
                        }           
                    } while(oB!= OpcionsMenuBiblioteca.MENU_SORTIR);
                    break;
                case MENU_OPCIO2:
                    Menu<OpcionsMenuAlbums> menuAs = new Menu<>("Menu de Gestio dels Albums",OpcionsMenuAlbums.values());
                    menuAs.setDescripcions(descMenuGestioAlbums);
                    OpcionsMenuAlbums oAs = null;
                    do {
                        menuAs.mostrarMenu();
                        oAs = menuAs.getOpcio(sc);
                        switch(oAs)  {
                            case MENU_OPCIO1: //afegir album
                                controlador.afegirAlbum(sc);
                                break;
                            case MENU_OPCIO2: //mostrar albums
                                controlador.mostrarAlbums();
                                break;
                            case MENU_OPCIO3: //eliminar album
                                controlador.eliminarAlbum(sc);
                                break;
                            case MENU_OPCIO4:
                                controlador.gestionaAblum(sc);
                                break;         
                        }           
                    } while(oAs!= OpcionsMenuAlbums.MENU_SORTIR);
                    break;
                case MENU_OPCIO3:
                    controlador.guardarDades(sc);
                    break;
                case MENU_OPCIO4:
                    controlador.carregaDades(sc);
                    break;
                case MENU_SORTIR:
                    System.out.println("\nHas triat SORTIR");
                    break;            
            }
        } while(opcio!= OpcionsMenuPrincipal.MENU_SORTIR);
    }
}
