/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.Scanner;

/**
 *
 * @author Jose
 */
public class Consola {
    Scanner sc;

    public Consola() {
        sc = new Scanner(System.in);
    }
    
    public void escriu(String s){
        System.out.println(s);
    }
    
    public void escriu(int i){
        System.out.println(i);
    }
    
    public void escriu(double d){
        System.out.println(d);
    }
    
    public String llegeixString(){
        return sc.next();
    }
    
    public int llegeixInt(){
        return sc.nextInt();
    }
    
    public double llegixDouble(){
        return sc.nextDouble();
    }
}
