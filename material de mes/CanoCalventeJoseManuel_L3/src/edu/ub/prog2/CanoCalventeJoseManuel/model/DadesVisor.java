/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.CanoCalventeJoseManuel.model;

import edu.ub.prog2.utils.ImageFile;
import edu.ub.prog2.utils.Menu;
import edu.ub.prog2.utils.VisorException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Classe que interactua amb la classe VisorUB i guarda totes les dades del programa.
 * @author jcanocal8.alumnes
 */
public class DadesVisor implements Serializable {
    private BibliotecaImatges biblio;
    private ArrayList<AlbumImatges> albums;
    static private enum OpcionsMenu{MENU_OPCIO1,MENU_OPCIO2,MENU_SORTIR};
    static private String[] descMenu={"Nom",
                                      "Imatge representativa",
                                      "Menu Anterior"};
    
    /**
     * Constructor de la classe.
     */
    public DadesVisor(){
        biblio = new BibliotecaImatges(100);
        albums = new ArrayList();
    }
    
    /**
     * Crea i afegeix una imatge a la biblioteca.
     * @param sc 
     * @throws edu.ub.prog2.utils.VisorException 
     */
    public void afegirImatgeBiblioteca(Scanner sc) throws VisorException{
        System.out.println("\nNom de la imatge?: ");
        String nom = sc.nextLine();
        System.out.println("\nCami on es troba guardada?: ");
        String path = sc.nextLine();
        Imatge i = new Imatge(path, nom);
        biblio.addImage(i);
    }
    
    /**
     * Mostra les dades de la biblioteca per pantalla.
     */
    public void mostrarBiblioteca(){
        System.out.println(biblio);
    }
    
    /**
     * Elimina una imatge de la Biblioteca.
     * @param sc 
     */
    public void eliminarImatgeBiblioteca(Scanner sc){
        if (biblio.getSize() > 0){
            mostrarBiblioteca();
            System.out.println("\nIntrodueix el numero de la imatge que desitjes eliminar: ");
            int n = sc.nextInt();
            while ( n > biblio.getSize() || n <= 0){
                System.out.println("\nNo hi ha cap imatge en aquesta posició");
                System.out.println("\nIntrodueix el numero de la imatge que desitjes eliminar: ");
                n = sc.nextInt();
            }
            ImageFile i = biblio.getAt(n-1);
            Iterator j = albums.iterator();
            boolean trobada = false;
            while(j.hasNext() && !trobada){
                AlbumImatges a = (AlbumImatges) j.next();
                if (a.buscaImatge(i)){
                    trobada = true;
                    System.out.println("\nAquesta Imatge esta afegida a un album, no la pots eliminar");
                }
            }
            if (!trobada){
                biblio.removeImage(i);
                System.out.println("\nImatge eliminada\n");
            } 
            
        }else{
            System.out.println("\nLa biblioteca esta buida\n");
        }
    }
    
    /**
     * Crea i afegeix un album a la llista, demana les dades d'aquest a l'usuari.
     * @param sc 
     */
    public void afegirAlbum(Scanner sc){
        System.out.println("\nTitol del Album?: ");
        String titol = sc.nextLine();
        System.out.println("\nNom de l'Autor?: ");
        String autor = sc.nextLine();
        AlbumImatges album = new AlbumImatges(titol,autor);
        if (!buscaAlbum(album)){
            albums.add(album);
            System.out.println("\nAlbum afegit\n");
        }
        else{
            System.out.println("\nL'album ja es troba a la Biblioteca");
        }
        
    }
    
    /**
     * Donat un album, busca en una llista si aquest es troba a dins.
     * @param a
     * @return 
     */
    public boolean buscaAlbum(AlbumImatges a){
        boolean trobat = false;
        Iterator it = albums.iterator();
        while (it.hasNext() && !trobat){
            AlbumImatges b = (AlbumImatges) it.next();
            if (b.getNom().equals(a.getNom())){
                trobat = true;  
            }
        }
        return trobat;
    }
    
    /**
     * Mostra els albums.
     */
    public void mostrarAlbums(){
        if (albums.size() > 0){
            String cadena = "";
            System.out.println("-------------\n------------- ");
            for(int i = 0; i < albums.size(); i++){
                cadena = cadena + "[" + (i+1) + "]" + " Nom: " + albums.get(i).getNom() + " Autor: " + albums.get(i).getAutor() + "\n";
            }
            System.out.println(cadena);
        }
        else {
            System.out.println("\nNo hi ha cap album\n");
        }
    }
    /**
     * Elimina un album de la llista.
     * @param sc 
     */
    public void eliminarAlbum(Scanner sc){
        if (albums.size() > 0){
            mostrarAlbums();
            System.out.println("\nIntrodueix el numero de l'album que desitjes eliminar: ");
            int n = sc.nextInt();
            while ( n > albums.size() || n <= 0){
                System.out.println("\nNo hi ha cap album en aquesta posició");
                System.out.println("\nIntrodueix el numero de l'album que desitjes eliminar: ");
                n = sc.nextInt();
            }
            AlbumImatges a = albums.get(n-1);
            albums.remove(a);
            System.out.println("\nAlbum eliminat\n");
        }else{
            System.out.println("\nNo hi ha cap album\n");
        }
    }
    /**
     * Selecciona un album de la llista.
     * @param sc
     * @return 
     */
    public AlbumImatges seleccionaAlbum(Scanner sc){
        if (albums.isEmpty()){
            mostrarAlbums();
            return null;
        }else{
            mostrarAlbums();
            System.out.println("Quin album vols gestionar?");
            int n = sc.nextInt();
            while ( n > albums.size() || n <= 0){
                    System.out.println("\nNo hi ha cap album en aquesta posició");
                    System.out.println("\nIntrodueix el numero de l'album que desitjes gestionar: ");
                    n = sc.nextInt();
            }
            AlbumImatges a = albums.get(n-1);
            return a;
        }
    }
    
    /**
     * Guarda un album a la llista.
     * @param a 
     */
    public void guardaAlbum(AlbumImatges a){
        int n = albums.indexOf(a);
        albums.set(n, a);
    }
    
    /**
     * Guarda les dades de la llista d'albums en un fitxer.
     * @param path
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void guardaAlbumsFitxer(String path) throws FileNotFoundException, IOException{
        File f = new File(path);
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(albums);
        fos.close();
    }
    
    /**
     * Recupera les dades d'una llista d'albums guardada en un fitxer.
     * @param path
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public ArrayList recuperaAlbumsFitxer(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        File f = new File(path);
        FileInputStream fin = new FileInputStream(f);
        ObjectInputStream ios = new ObjectInputStream(fin);
        ArrayList l = (ArrayList) ios.readObject();
        fin.close();
        return l;
    }
    
    /**
     * Afegeix una imatge de la biblioteca a l'album.
     * @param a
     * @param sc 
     */
    public void afegirImatgeAlbum(AlbumImatges a, Scanner sc){
        if (biblio.getSize() > 0){
            mostrarBiblioteca();
            System.out.println("\nIntrodueix el numero de la imatge que vols afegir a l'album: ");
            int n = sc.nextInt();
            while ( n > biblio.getSize() || n <= 0){
                System.out.println("\nNo hi ha cap imatge en aquesta posició");
                System.out.println("\nIntrodueix el numero de la imatge que desitjes afegir a l'album: ");
                n = sc.nextInt();
            }
            ImageFile i = biblio.getAt(n-1);
            try {
                a.addImage(i);
            } catch (VisorException ex) {
                System.out.println(ex.getMessage());
            }
            System.out.println("\nImatge afegida\n");
        }else{
            System.out.println("\nLa biblioteca esta buida, no es pot seleccionar cap imatge\n");
        }
    }
    
    /**
     * Mostra per pantalla la informació d'un album.
     * @param a 
     */
    public void mostrarAlbum(AlbumImatges a){
        System.out.println(a);
    }
    
    /**
     * Elimina una imatga de l'album.
     * @param a
     * @param sc 
     */
    public void eliminarImatgeAlbum(AlbumImatges a, Scanner sc){
        if (a.getSize() > 0){
            mostrarAlbum(a);
            System.out.println("\nIntrodueix el numero de la imatge que desitjes eliminar: ");
            int n = sc.nextInt();
            while ( n > a.getSize() || n <= 0){
                System.out.println("No hi ha cap imatge en aquesta posició");
                System.out.println("\nIntrodueix el numero de la imatge que desitjes eliminar: ");
                n = sc.nextInt();
            }
            ImageFile i = a.getAt(n-1);
            a.removeImage(i);
            System.out.println("\nImatge eliminada");
        }else{
            System.out.println("\nL'Album esta buit");
        }
    }
    
    /**
     * Permet modificar el nom i la imatge representativa d'un album.
     * @param a
     * @param sc 
     */
    public void modificarDadesAlbum(AlbumImatges a, Scanner sc){
        Menu<OpcionsMenu> menu = new Menu<>("Modificar Dades",OpcionsMenu.values());
        menu.setDescripcions(descMenu);
        OpcionsMenu opcio = null;
        do{
            menu.mostrarMenu();
            opcio=menu.getOpcio(sc);
            switch(opcio){
                case MENU_OPCIO1:
                    System.out.println("Nou Nom?: ");
                    String nom = sc.next();
                    a.setNom(nom);
                    break;
                case MENU_OPCIO2:
                    mostrarAlbum(a);
                    if(a.getSize() > 0){
                        System.out.println("Quina imatge vols seleccionar com a representació?: ");
                        int x = sc.nextInt();
                        while ( x > a.getSize() || x <= 0){
                            System.out.println("No hi ha cap imatge en aquesta posició");
                            System.out.println("\nIntrodueix el numero de la imatge que desitjes seleccionar com a representació: ");
                            x = sc.nextInt();
                        }
                        a.setImRep(x-1);
                    }
                    break;
                
            }
        } while(opcio != OpcionsMenu.MENU_SORTIR);
    }
    
    /**
     * Guarda totes les dades del programa en un fitxer (biblioteca i llista d'albums).
     * @param sc 
     */
    public void guardarDades(Scanner sc){
        System.out.println("A quin fitxer vols guardar la biblioteca?: ");
        String path = sc.nextLine();
        try {
            biblio.escriu(path);
        } catch (IOException ex) {
            Logger.getLogger(DadesVisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("A quin fitxer vols guardar els albums?: ");
        path = sc.nextLine();
        try {
            guardaAlbumsFitxer(path);
        } catch (IOException ex) {
            Logger.getLogger(DadesVisor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Carrega les dades guardades en un fitxer (biblioteca i llista d'albums).
     * @param sc 
     */
    public void carregaDades(Scanner sc){
        System.out.println("On esta guardada la biblioteca?: ");
        String path = sc.nextLine();
        try {
            biblio = (BibliotecaImatges) biblio.llegir(path);
        } catch (IOException ex) {
            Logger.getLogger(DadesVisor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DadesVisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("On estan guardats els albums?: ");
        path = sc.nextLine();
        try {
            albums = recuperaAlbumsFitxer(path);
        } catch (IOException ex) {
            Logger.getLogger(DadesVisor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DadesVisor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void preVisualitzarBN(Imatge i){
        String path = i.getAbsolutePath();
        int pos = path.lastIndexOf('.');
        if (pos > -1) {
            path = path.substring(0,pos) + "_BN." + path.substring(pos+1);
        }
        ImatgeBN im = new ImatgeBN(i.getAbsolutePath());
        File f = new File (path);
        try {
            Imatge.saveImage(im.filtrar(),f);
        } catch (IOException ex) {
            Logger.getLogger(DadesVisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImatgeBN n = new ImatgeBN(path);
        visualitzarImatge(n);
        f.delete();
        
    }
    
    public void preVisualitzarSepia(Imatge i){
        String path = i.getAbsolutePath();
        int pos = path.lastIndexOf('.');
        if (pos > -1) {
            path = path.substring(0,pos) + "_Sepia." + path.substring(pos+1);
        }
        ImatgeSepia im = new ImatgeSepia(i.getAbsolutePath());
        File f = new File (path);
        try {
            Imatge.saveImage(im.filtrar(),f);
        } catch (IOException ex) {
            Logger.getLogger(DadesVisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImatgeSepia n = new ImatgeSepia(path);
        visualitzarImatge(n);
        f.delete();
        
    }
    
    public void visualitzarImatge(Imatge a){
        try {
            a.show(true);
        } catch (Exception ex) {
            Logger.getLogger(DadesVisor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void visualitzarImatgeBiblioteca(Scanner sc){
        if (biblio.getSize() > 0){
            mostrarBiblioteca();
            System.out.println("\nIntrodueix el numero de la imatge que desitjes visualitzar: ");
            int n = sc.nextInt();
            while ( n > biblio.getSize() || n <= 0){
                System.out.println("\nNo hi ha cap imatge en aquesta posició");
                System.out.println("\nIntrodueix el numero de la imatge que desitjes visualitzar: ");
                n = sc.nextInt();
            }
            Imatge i = (Imatge) biblio.getAt(n-1);
            visualitzarImatge(i);
            
        }else{
            System.out.println("\nLa biblioteca esta buida\n");
        }
    }
    
    public void visualitzarImatgeBibliotecaBN(Scanner sc){
        if (biblio.getSize() > 0){
            mostrarBiblioteca();
            System.out.println("\nIntrodueix el numero de la imatge que desitjes visualitzar: ");
            int n = sc.nextInt();
            while ( n > biblio.getSize() || n <= 0){
                System.out.println("\nNo hi ha cap imatge en aquesta posició");
                System.out.println("\nIntrodueix el numero de la imatge que desitjes visualitzar: ");
                n = sc.nextInt();
            }
            Imatge i = (Imatge) biblio.getAt(n-1);
            preVisualitzarBN(i);
            
        }else{
            System.out.println("\nLa biblioteca esta buida\n");
        }
    }
    
    public void visualitzarImatgeBibliotecaSepia(Scanner sc){
        if (biblio.getSize() > 0){
            mostrarBiblioteca();
            System.out.println("\nIntrodueix el numero de la imatge que desitjes visualitzar: ");
            int n = sc.nextInt();
            while ( n > biblio.getSize() || n <= 0){
                System.out.println("\nNo hi ha cap imatge en aquesta posició");
                System.out.println("\nIntrodueix el numero de la imatge que desitjes visualitzar: ");
                n = sc.nextInt();
            }
            Imatge i = (Imatge) biblio.getAt(n-1);
            preVisualitzarSepia(i);
            
        }else{
            System.out.println("\nLa biblioteca esta buida\n");
        }
    }
    
    
    public Imatge filtrarSepia(Imatge i){
        String path = i.getAbsolutePath();
        int pos = path.lastIndexOf('.');
        if (pos > -1) {
            path = path.substring(0,pos) + "_Sepia." + path.substring(pos+1);
        }
        ImatgeSepia im = new ImatgeSepia(i.getAbsolutePath());
        File f = new File (path);
        try {
            Imatge.saveImage(im.filtrar(),f);
        } catch (IOException ex) {
            Logger.getLogger(DadesVisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        i = new ImatgeSepia(path,i.getFileName());
        return i;
    }
    
    
    public void filtrarSepiaBiblioteca(Scanner sc){
        if (biblio.getSize() > 0){
            mostrarBiblioteca();
            System.out.println("\nIntrodueix el numero de la imatge que desitjes transformar: ");
            int n = sc.nextInt();
            while ( n > biblio.getSize() || n <= 0){
                System.out.println("\nNo hi ha cap imatge en aquesta posició");
                System.out.println("\nIntrodueix el numero de la imatge que desitjes transformar: ");
                n = sc.nextInt();
            }
            Imatge i = (Imatge) biblio.getAt(n-1);
            try {
                biblio.addImage(filtrarSepia(i));
            } catch (VisorException ex) {
                Logger.getLogger(DadesVisor.class.getName()).log(Level.SEVERE, null, ex);
            }
            biblio.removeImage(i);
            
        }else{
            System.out.println("\nLa biblioteca esta buida\n");
        }
    }
    
    public Imatge filtrarBlancNegre(Imatge i){
        String path = i.getAbsolutePath();
        int pos = path.lastIndexOf('.');
        if (pos > -1) {
            path = path.substring(0,pos) + "_BN." + path.substring(pos+1);
        }
        ImatgeBN im = new ImatgeBN(i.getAbsolutePath());
        File f = new File (path);
        try {
            Imatge.saveImage(im.filtrar(),f);
        } catch (IOException ex) {
            Logger.getLogger(DadesVisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        i = new ImatgeBN(path,i.getFileName());
        return i;
    }
    
    public void filtrarBlancNegreBiblioteca(Scanner sc){
        if (biblio.getSize() > 0){
            mostrarBiblioteca();
            System.out.println("\nIntrodueix el numero de la imatge que desitjes transformar: ");
            int n = sc.nextInt();
            while ( n > biblio.getSize() || n <= 0){
                System.out.println("\nNo hi ha cap imatge en aquesta posició");
                System.out.println("\nIntrodueix el numero de la imatge que desitjes transformar: ");
                n = sc.nextInt();
            }
            Imatge i = (Imatge) biblio.getAt(n-1);
            try {
                biblio.addImage(filtrarBlancNegre(i));
            } catch (VisorException ex) {
                Logger.getLogger(DadesVisor.class.getName()).log(Level.SEVERE, null, ex);
            }
            biblio.removeImage(i);
            
        }else{
            System.out.println("\nLa biblioteca esta buida\n");
        }
    }
    
    public Imatge treureFiltre(Imatge i){
        String path = i.getAbsolutePath();
        File f = new File (path);
        int pos = path.lastIndexOf('.');
        int pos2 = path.lastIndexOf('_');
        if (pos > -1) {
            path = path.substring(0,pos2) + path.substring(pos);
        }
        i = new Imatge(path, i.getFileName());
        f.delete();
        return i;
    }
    
    public void treureFiltreBiblioteca(Scanner sc){
        if (biblio.getSize() > 0){
            mostrarBiblioteca();
            System.out.println("\nIntrodueix el numero de la imatge que desitjes transformar: ");
            int n = sc.nextInt();
            while ( n > biblio.getSize() || n <= 0){
                System.out.println("\nNo hi ha cap imatge en aquesta posició");
                System.out.println("\nIntrodueix el numero de la imatge que desitjes transformar: ");
                n = sc.nextInt();
            }
            Imatge i = (Imatge) biblio.getAt(n-1);
            try {
                biblio.addImage(treureFiltre(i));
            } catch (VisorException ex) {
                Logger.getLogger(DadesVisor.class.getName()).log(Level.SEVERE, null, ex);
            }
            biblio.removeImage(i);
            
        }else{
            System.out.println("\nLa biblioteca esta buida\n");
        }
    }
}
