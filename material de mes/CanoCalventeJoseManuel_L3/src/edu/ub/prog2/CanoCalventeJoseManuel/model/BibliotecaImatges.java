/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.CanoCalventeJoseManuel.model;

import edu.ub.prog2.utils.ImageFile;
import java.util.Iterator;
import edu.ub.prog2.utils.VisorException;
/**
 * Estructura que guarda objectes de tipus Imatge i no permet repeticions.
 * @author jcanocal8.alumnes
 */
public class BibliotecaImatges extends LlistaImatges{

    public BibliotecaImatges(int capacitat) {
        super(capacitat);
    }
    /**
     * Afegeix una imatge si aquesta no es troba ja dins de la biblioteca.
     * @param i 
     * @throws edu.ub.prog2.utils.VisorException 
     */
    @Override
    public void addImage(ImageFile i) throws VisorException{
        if (buscaImatge(i)){
            VisorException ex = new VisorException("Aquesta imatge ja es troba a la biblioteca");
            throw ex;
        }else{
            if (i.exists()){
                llista.add((Imatge) i);
            }else{
                VisorException ex = new VisorException("Aquesta imatge no es troba al disc");
                throw ex;
            }
        }
    }
    /**
     * Donada una imatge, busca si aquesta es troba dins de la biblioteca.
     * @param i
     * @return 
     */
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
     * Retorna la infomració de la bilbioteca en forma d'String.
     * @return 
     */
    @Override
    public String toString() {
        if (getSize() > 0){
            String cadena = "";
            System.out.println("-------------\n------------- ");
            for(int i = 0; i < llista.size(); i++){
                cadena = cadena + "[" + (i+1) + "]" + llista.get(i) + "\n";
            }
            return cadena;
        }
        else {
            return "\nLa Bibloteca esta buida";
        }
    }
}
