/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.CanoCalventeJoseManuel.controlador;

import edu.ub.prog2.CanoCalventeJoseManuel.model.AlbumImatges;
import edu.ub.prog2.CanoCalventeJoseManuel.model.DadesVisor;
import edu.ub.prog2.utils.BasicCtrl;
import edu.ub.prog2.utils.Menu;
import edu.ub.prog2.utils.VisorException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Controlador de l'aplicació.
 * @author jcanocal8.alumnes
 */
public class CtrlVisor extends BasicCtrl{
    private DadesVisor dades = new DadesVisor();
    static private enum OpcionsMenuAlbum{MENU_OPCIO1,MENU_OPCIO2,MENU_OPCIO3,MENU_OPCIO4,MENU_OPCIO5,MENU_OPCIO6,MENU_OPCIO7,MENU_SORTIR};
    static private enum OpcionsMenu{MENU_OPCIO1,MENU_OPCIO2,MENU_OPCIO3,MENU_SORTIR};
    
    static private String[] descMenuGestioAlbum={"Afegir Imatge",
                                                  "Mostrar Àlbum",
                                                  "Eliminar Imatge",
                                                  "Visualitzar Imatge",
                                                  "Transformar Imatge",
                                                  "Visualitzar Album",
                                                  "Modificar Dades",
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
     * Crea i afegeix una imatge a la biblioteca.
     * @param sc 
     */
    public void afegirImatgeBiblioteca(Scanner sc){
        try {
            dades.afegirImatgeBiblioteca(sc);
        } catch (VisorException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Mostra les dades de la biblioteca per pantalla.
     */
    public void mostrarBiblioteca(){
        dades.mostrarBiblioteca();
    }
    
    /**
     * Elimina una imatge de la Biblioteca.
     * @param sc 
     */
    public void eliminarImatgeBiblioteca(Scanner sc){
        dades.eliminarImatgeBiblioteca(sc);
    }
    
    /**
     * Crea i afegeix un album a la llista, demana les dades d'aquest a l'usuari.
     * @param sc 
     */
    public void afegirAlbum(Scanner sc){
        dades.afegirAlbum(sc);
    }
    
    /**
     * Mostra els albums.
     */
    public void mostrarAlbums(){
        dades.mostrarAlbums();
    }
    
    /**
     * Elimina un album de la llista.
     * @param sc 
     */
    public void eliminarAlbum(Scanner sc){
        dades.eliminarAlbum(sc);
    }
    
    /**
     * Afegeix una imatge de la biblioteca a l'album.
     * @param a
     * @param sc 
     */
    public void afegirImatgeAlbum(AlbumImatges a, Scanner sc){
        dades.afegirImatgeAlbum(a, sc);
    }
    
    /**
     * Mostra per pantalla la informació d'un album.
     * @param a 
     */
    public void mostrarAlbum(AlbumImatges a){
        dades.mostrarAlbum(a);
    }
    
    /**
     * Elimina una imatga de l'album.
     * @param a
     * @param sc 
     */
    public void eliminarImatgeAlbum(AlbumImatges a, Scanner sc){
        dades.eliminarImatgeAlbum(a, sc);
    }
    
    /**
     * Permet modificar el nom i la imatge representativa d'un album.
     * @param a
     * @param sc 
     */
    public void modificarDadesAlbum(AlbumImatges a, Scanner sc){
        dades.modificarDadesAlbum(a, sc);
    }
    
    /**
     * Guarda totes les dades del programa en un fitxer (biblioteca i llista d'albums).
     * @param sc 
     */
    public void guardarDades(Scanner sc){
        dades.guardarDades(sc);
    }
    
    /**
     * Carrega les dades guardades en un fitxer (biblioteca i llista d'albums).
     * @param sc 
     */
    public void carregaDades(Scanner sc){
        dades.carregaDades(sc);
    }
    
    /**
     * Mostra el menú de gestió d'un album.
     * @param sc 
     */
    public void gestionaAblum(Scanner sc){
        AlbumImatges a = dades.seleccionaAlbum(sc);
        if (a != null){
            Menu<CtrlVisor.OpcionsMenuAlbum> menuA = new Menu<>("Menu de Gestio de l'Album: " + a.getNom(),CtrlVisor.OpcionsMenuAlbum.values());
            menuA.setDescripcions(descMenuGestioAlbum);
            CtrlVisor.OpcionsMenuAlbum oA = null;
            do {
                menuA.mostrarMenu();
                oA = menuA.getOpcio(sc);
                switch(oA)  {
                    case MENU_OPCIO1: //afegir imatge
                        dades.afegirImatgeAlbum(a, sc);
                        break;
                    case MENU_OPCIO2: //mostrar album
                        dades.mostrarAlbum(a);
                        break;
                    case MENU_OPCIO3: //eliminar imatge
                        dades.eliminarImatgeAlbum(a, sc);
                        break;
                    case MENU_OPCIO4: //visualitzar imatge
                        Menu<OpcionsMenu> menuV = new Menu<>("Menu de Visualització",OpcionsMenu.values());
                        menuV.setDescripcions(descMenuVisualitzar);
                        OpcionsMenu oV = null;
                        do{
                            menuV.mostrarMenu();
                            oV = menuV.getOpcio(sc);
                            switch(oV) {
                                case MENU_OPCIO1: //sense filtre
                                    break;
                                case MENU_OPCIO2: //filtre sepia
                                    break;
                                case MENU_OPCIO3: //filtre B/N
                                    break;
                            }
                        }while(oV!= OpcionsMenu.MENU_SORTIR);
                        break;
                    case MENU_OPCIO5: //transformar imatge
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
                                    break;
                                case MENU_OPCIO3: //sense filtre
                                    break;
                            }
                        }while(oT!= OpcionsMenu.MENU_SORTIR);
                        break;
                    case MENU_OPCIO6: //visualitzar album sencer
                        break;
                    case MENU_OPCIO7:
                        dades.modificarDadesAlbum(a, sc);
                }           
            } while(oA!= CtrlVisor.OpcionsMenuAlbum.MENU_SORTIR);
            dades.guardaAlbum(a);
        }
    }
    
    public void visualitzarImatgeBiblioteca(Scanner sc){
        dades.visualitzarImatgeBiblioteca(sc);
    }
    
    public void visualitzarImatgeBibliotecaBN(Scanner sc){
        dades.visualitzarImatgeBibliotecaBN(sc);
    }
    
    public void visualitzarImatgeBibliotecaSepia(Scanner sc){
        dades.visualitzarImatgeBibliotecaSepia(sc);
    }
    
    
    /*public void filtrarSepiaBiblioteca(Scanner sc){
        dades.filtrarSepiaBiblioteca(sc);
    }*/
    
    public void filtrarBlancNegreBiblioteca(Scanner sc){
        dades.filtrarBlancNegreBiblioteca(sc);
    }
                                   
}


