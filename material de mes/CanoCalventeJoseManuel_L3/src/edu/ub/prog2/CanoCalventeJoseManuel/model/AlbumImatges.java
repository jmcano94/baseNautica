/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.CanoCalventeJoseManuel.model;

import edu.ub.prog2.utils.ImageFile;
import java.util.Iterator;

/**
 * Estructura que guarda Imatges i permet repeticións d'aquestes.
 * @author Jose Manuel Cano
 */
public class AlbumImatges extends LlistaImatges {
    private String nom; 
    private String autor;
    private ImageFile imRep;
    private static final int capacitat = 10;
                                    

    /**
     * Constructor de la classe
     * @param nom
     * @param autor
     */
    public AlbumImatges(String nom, String autor){
        super(capacitat);
        if (getSize() == 0){
            this.imRep = null;
        }
        else{
            this.imRep = getAt(0);
        }
        this.nom = nom;
        this.autor = autor;
    }
    
    public boolean buscaImatge(ImageFile i){
        boolean trobada = false;
        Iterator it = llista.iterator();
        while (it.hasNext() && !trobada){
            Imatge f = (Imatge) it.next();
            if ((f.getName().equals(i.getName())) && (f.getExtension().equals(i.getExtension())) && (f.getFullPath().equals(i.getFullPath()))){
                trobada = true;
                
            }
        }
        return trobada;
    }
    
    /**
     * Retorna la informacio de l'album en forma d'String.
     * @return 
     */
    @Override
    public String toString() {
        if (getSize() > 0){
            String cadena = "";
            System.out.println("\nTitol: " + nom + " Autor: " + autor);
            System.out.println("-------------\n------------- ");
            for(int i = 0; i < llista.size(); i++){
                cadena = cadena + "[" + (i+1) + "]" + llista.get(i) + "\n";
            }
            return cadena;
        }
        else {
            System.out.println("\nTitol: " + nom + " Autor: " + autor);
            System.out.println("-------------\n------------- ");
            return "L'Album esta buit";
        }
    }
    
    /**
     * Canvia el nom de l'album.
     * @param nom 
     */
    public void setNom(String nom){
        this.nom = nom;
    }
    
    /**
     * Retorna el nom de l'album.
     * @return 
     */
    public String getNom(){
        return nom;
    }
    
    /**
     * Canvia el nom de l'autor.
     * @param autor 
     */
    public void setAutor(String autor){
        this.autor = autor;
    }
    
    /**
     * Retorna el nom de l'autor.
     * @return 
     */
    public String getAutor(){
        return autor;
    }
    /**
     * Canvia la imatge representativa de l'Album.
     * @param i 
     */
    public void setImRep(int i){
        imRep = llista.get(i);
    }
}
