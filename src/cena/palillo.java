/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cena;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author quiqu
 */
public class palillo {
    private int valor = 1;
    
    public palillo(){
        valor = 1;
    }
    
    // Definimos el método para cuando el filósofo intente tomar el palillo
    synchronized void tomarPalillo() {
        while (valor <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        valor--;
    }
    
    // Definimos el método para cuando el filósofo deje de comer
    synchronized void dejarPalillo(){
        valor++;
        notify();
    }
    
    public int Valor(){
        return valor;
    }
}
