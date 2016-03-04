/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Jose
 */
public final class Consola {
    private static String lletres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static String numeros = "0123456789";
    private static Scanner sc;

    public Consola() {
        sc = new Scanner(System.in);
    }
    
    public Scanner getSc() {
        return sc;
    }

    /**
     * Escriu un valor enter a la pantalla.
     *
     * @param i
     */
    public static void escriu(int i) {
        System.out.println(i);
    }

    /**
     * Escriu un String per pantalla.
     *
     * @param s
     */
    public static void escriu(String s) {
        System.out.println(s);
    }

    /**
     * Escriu un valor en coma flotant a la pantalla.
     *
     * @param f
     */
    public static void escriu(float f) {
        System.out.println(f);
    }

    /**
     * Escriu una data per pantalla.
     *
     * @param d
     */
    public static void escriu(Date d) {
        System.out.println(d);
    }

    /**
     * Mostra per pantalla  c'array "c" que pasem com a parametre.
     *
     * @param c Array a mostrar.
     */
    public static void imprimirLista(Collection c) {
        if (!c.isEmpty()) {
            Iterator it = c.iterator();
            int i = 0;
            while (it.hasNext()) {
                Object o = it.next();
                System.out.println("-------------------" + "\n[" + Integer.toString(i) + "] " + o.toString() + "\n");
                i = i + 1;
            }
        } else {
            System.out.println("\nNo hi ha cap element a la lista.");
        }
    }

    /**
     * Llegeix un valor enter que s'ha entrat per teclat i el retorna.
     *
     * @return int
     */
    public static int llegeixInt() {
        while (!sc.hasNextInt()) {
            System.out.println("\nAixo no es un numero.");
            sc.next();
        }
        return sc.nextInt();
    }

    public static double llegeixDouble() {
        while (!sc.hasNextDouble()) {
            System.out.println("\nAixo no es un numero.");
            sc.next();
        }
        return sc.nextDouble();
    }

    /**
     * Llegeix un String que s'ha entrat per teclat i el retorna.
     *
     * @return
     */
    public static String llegeixString() {
        return sc.next();
    }

    /**
     * Pide un número por pantalla hasta que se introduzca uno que pertenezca al
     * array.
     *
     * @param l array
     * @return Opción seleccionada.
     */
    public static int selNumMenu(String[] l) {
        int num = llegeixInt();
        while (l.length + 1 < num || num < 0) {
            System.out.println("\nEl numero ha de pertanyer a la llista (maxim " + (l.length + 1) + ").");
            num = llegeixInt();
        }
        return num;
    }

    /**
     * Pide un número por pantalla hasta que se introduzca uno que pertenezca a
     * la lista.
     *
     * @param c.
     * @return Opción seleccionada.
     */
    public static int selNumLista(Collection c) {
        if (!c.isEmpty()) {
            int num = llegeixInt();
            while (c.size() - 1 < num || num < 0) {
                System.out.println("\nEl numero ha de pertanyer a la llista (maxim " + (c.size() - 1) + ").");
                num = llegeixInt();
            }
            return num;
        }
        return -1;
    }

    /**
     * Llegeix un String que despres transforma en un Date i el retorna.
     *
     * @return Date
     */
    public static Date llegeixData() {
        boolean bona = false;
        String s = sc.next();
        SimpleDateFormat format = new SimpleDateFormat("HH:mm/dd/MM/yyyy", Locale.ENGLISH);
        Date d = null;
        while (!bona) {
            try {
                d = format.parse(s);
                bona = true;
            } catch (ParseException ex) {
                System.out.println("\nError a l'hora d'introduir la data, recorda (hh:mm/dd/MM/yyyy");
                s = sc.next();
                bona = false;
            }
        }
        return d;
    }

    /**
     * Lee un string en formato DNI. 8 números y 1 letra mayúscula.
     *
     * @return DNI
     */
    public static String llegeixDNI() {
        String s = sc.next();
        boolean correcte = false;
        while (!correcte) {
            boolean es_numero = true;
            boolean es_lletra = false;
            if (s.length() == 9) {
                int i = 0;
                while (i < 8 && es_numero) {
                    String c = s.substring(i, i + 1);
                    es_numero = numeros.contains(c);
                    i++;
                }
                String c = s.substring(8, 9);
                es_lletra = lletres.contains(c);
            }

            if (es_numero && es_lletra) {
                correcte = true;
            } else {
                System.out.println("\nAquest no es un dni valid, entra un DNI amb 8 numeros i una lletra MAJUSCULA si us plau: ");
                s = sc.next();
            }
        }
        return s;
    }
}
