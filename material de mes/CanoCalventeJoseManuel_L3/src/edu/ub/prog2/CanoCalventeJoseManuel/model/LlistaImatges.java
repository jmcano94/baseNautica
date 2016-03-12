/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.CanoCalventeJoseManuel.model;
import edu.ub.prog2.utils.ImageFile;
import edu.ub.prog2.utils.ImageList;
import edu.ub.prog2.utils.InImageList;
import edu.ub.prog2.utils.VisorException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Estructura que guarda objectes de tipus Imatge en un ArrayList.
 * @author Jose Manuel Cano
 */
public class LlistaImatges extends ImageList implements Serializable{
    ArrayList<Imatge> llista;
    private int capacitatMax;
    /**
     * Constructor de classe
     * @param capacitat 
     */
    public LlistaImatges(int capacitat){
        capacitatMax = capacitat;
        llista = new ArrayList<Imatge>(capacitat);
        
    }
    /**
     * Retorna el numero d'Imatges que conte la taula, metode sobrecarregat.
     * @return 
     */
    @Override
    public int getSize() {
        return llista.size();
    }
    /**
     * Afegeix una Imatge a la taula, metode sobrecarregat.
     * @param i 
     * @throws edu.ub.prog2.utils.VisorException 
     */
    @Override
    public void addImage(ImageFile i) throws VisorException{
        llista.add((Imatge) i);
    }
    /**
     * Elimina la primera aparicio d'una Imatge de la taula, metode sobrecarregat.
     * @param i 
     */
    @Override
    public void removeImage(ImageFile i) {
        llista.remove(i);
        
    }
    /**
     * Retorna la Imatge que es troba a la posicio i de la taula, metode sobrecarregat.
     * @param i
     * @return (ArrayList<Imatge>)
     */
    @Override
    public ImageFile getAt(int i) {
        return llista.get(i);
    }
    /**
     * Elimina tots els elements de la taula, metode sobrecarregat.
     */
    @Override
    public void clear() {
        llista.clear();
    }
    /**
     * Comprova si la taula esta plena, metode sobrecarregat.
     * @return 
     */
    @Override
    public boolean isFull() {
        return llista.size() == capacitatMax;
        
    }
    
    /**
     * Escriu la llista en un fitxer
     * @param path
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public void escriu(String path) throws FileNotFoundException, IOException{
        File f = new File(path);
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        fos.close();
    }
    /**
     * LLegeix la llista desde un fitxer
     * @param path
     * @return 
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public InImageList llegir(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
        File f = new File(path);
        FileInputStream fin = new FileInputStream(f);
        ObjectInputStream ios = new ObjectInputStream(fin);
        InImageList l = (InImageList) ios.readObject();
        fin.close();
        return l;
    }
    /**
     * Retorna la informacio de la taula, es a dir totes les imatges que conte en forma d'String, metode sobrecarregat.
     * @return 
     */
    @Override
    public String toString() {
        if (getSize() > 0){
            String cadena = "";
            System.out.println("\nLlista Fitxers");
            System.out.println("-------------\n------------- ");
            for(int i = 0; i < llista.size(); i++){
                cadena = cadena + "[" + (i+1) + "]" + llista.get(i) + "\n";
            }
            return cadena;
        }
        else {
            return "\nLa llista es buida";
        }
    }
}
