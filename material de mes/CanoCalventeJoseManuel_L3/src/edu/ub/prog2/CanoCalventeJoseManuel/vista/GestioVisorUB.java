/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ub.prog2.CanoCalventeJoseManuel.vista;
import java.util.Scanner;
/**
 * Classe principal del programa que conte el main.
 * @author Jose Manuel Cano
 */
public class GestioVisorUB {

    public static void main(String[] args) {
        VisorUB3 vista = new VisorUB3();
        Scanner sc = new Scanner(System.in);
        vista.gestioVisorUB(sc);                                
    }  
}
