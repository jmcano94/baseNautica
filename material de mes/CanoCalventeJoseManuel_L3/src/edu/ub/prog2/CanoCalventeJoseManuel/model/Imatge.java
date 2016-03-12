/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.CanoCalventeJoseManuel.model;
import edu.ub.prog2.utils.ImageFile;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.util.Date;


/**
 * Representa un arxiu d'imatge, deriva de la clase ImageFiile
 * @author Jose Manuel Cano
 */
public class Imatge extends ImageFile implements Serializable {

    
    private String imageName; //Nom que tindra la Imatge a la Llista, pot ser diferent del nom de l'arxiu que conte la Image.
    
    
    /**
     * Constructor amb 1 parametre de la classe.
     * @param path 
     */  
    public Imatge(String path) {
        super(path);
        imageName = ""; 
    }
    
    /**
     * Construcor amb 2 parametres de la classe.
     * @param path
     * @param nom 
     */
    public Imatge(String path, String nom){
        super(path);
        imageName = nom;
    }

    /**
     * Canvia el nom de la Imatge.
     * @param nom 
     */
    public void setImageName(String nom){
        imageName = nom;
    }
    
    /**
     * Retorna el nom de la Imatge.
     * @return 
     */
    public String getImageName(){
        return imageName;
    }
    
    /**
     * Retorna el nom del arxiu que conte la Imatge.
     * @return 
     */
    public String getFileName(){
        return getName();
    }
    
    /**
     * Retorna la data d'ultima modificacio, metode sobrecarregat.
     * @return 
     */
    @Override
    public Date getLastModification(){
        Date data;
        data = new Date(lastModified());
        return data;   
    }
    
    /**
     * Retorna el cami on es troba guardat l'arxiu de la Imatge, metode sobrecarregat.
     * @return 
     */
    @Override
    public String getFullPath() {
        return getAbsolutePath();  
    }
    
    /**
     * Retorna l'extensio de l'arxiu de la Imatge, metode sobrecarregat.
     * @return 
     */
    @Override
    public String getExtension(){
        String fileName = getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) //Trobat a internet
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";    
    }
    
    /**
     * Retorna l'informacio que defineix una Imatge en forma d'String, metode sobrecarregat.
     * @return 
     */
    @Override
    public String toString(){
        return "Imatge{nom= " + imageName + ", data=" + getLastModification() + ", nom fitxer=" + getFileName() + ", cami complet=" + getFullPath() + "}";
    }
    
}
