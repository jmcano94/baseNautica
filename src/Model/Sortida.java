/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.Barcos.Neumatica;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jose
 */
public class Sortida {
    Monitor monitor;
    ArrayList<Barco> barcos;
    Date horaSortida;
    Date horaArribada;

    public Sortida(Monitor monitor, ArrayList<Barco> barcos, Date horaSortida) {
        this.monitor = monitor;
        this.barcos = barcos;
        this.horaSortida = horaSortida;
    }

    public ArrayList<Barco> getBarcos() {
        return barcos;
    }

    public Date getHoraArribada() {
        return horaArribada;
    }

    public Date getHoraSortida() {
        return horaSortida;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setHoraArribada(Date horaArribada) {
        this.horaArribada = horaArribada;
    }
    
    
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    
}
