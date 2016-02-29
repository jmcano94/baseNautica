/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Model.Material;
import Model.Monitor;
import Vista.Menu;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *Classe controladora de l'aplicació.
 * @author Jose
 */
public class Main {
    
    private ArrayList<Material> material;
    private ArrayList<Monitor> monitors;
    private ArrayList<String[]> opciones;

    public Main() {
        material = new ArrayList();
        monitors = new ArrayList();
        
         // menu
        opciones = new ArrayList(); // [0][x] - usuario, [1][x] - cliente, [2][x] - gerente, [3][x] - admin
        inicializarOpciones();
        menu = new Menu(opciones.get(0)); // usuario
        menu.setTitulo("\n---------\nBase Nàutica\n---------");
        menu.setTipoUsuario("usuario");
    }
    
    public static void main(String args[]){
        
    }
    
    public void loadData(){
        
    }
    
     private void inicializarOpciones() {
        String[] usuario = {"Log in", "Registrar"};
        String[] monitor = {"Reservar moto", "Modificar desti", "Donar-se de baixa", "Log out"};
        String[] gerent = {"Entregar moto", "Recollir moto", "Gestionar local", "Veure estat local", "Log out"};
        

        opciones.add(usuario);
        opciones.add(monitor);
        opciones.add(gerent);
    }
    
    
    
}
