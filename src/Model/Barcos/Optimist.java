/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Barcos;

import Model.Barco;
import Model.Estat;

/**
 *
 * @author Jose
 */
public class Optimist extends Barco {

    public Optimist(String id, boolean disponible, Estat estat) {
        super(id, disponible, estat);
    }
    
    String tipus = "Optimist";
}
