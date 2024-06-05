/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cena;

/**
 *
 * @author quiqu
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author quiqu
 */
public class filosofoDerecho extends Thread {
    private int id, resultado;
    private JLabel Conteo;
    private String reporte;
    private palillo palilloIzquierdo;
    private palillo palilloDerecho;
    private JLabel gifFilosofo;
    private JTextArea textArea;
    private JLabel semaforoIzquierdo;
    private JLabel semaforoDerecho;
    
    public filosofoDerecho(palillo izq, palillo der, int id, JLabel gifFilosofo, JTextArea textArea, JLabel semaforoIzquierdo, JLabel semaforoDerecho, JLabel Conteo){
        palilloIzquierdo = izq;
        palilloDerecho = der;
        this.id = id;
        this.gifFilosofo = gifFilosofo;
        this.textArea = textArea;
        this.semaforoIzquierdo = semaforoIzquierdo;
        this.semaforoDerecho = semaforoDerecho;
        this.Conteo = Conteo;
    }
    
    @Override
    public void run(){
        for(int i = 1; i <= 3; i++){
            reporte = "El filosofo " + id + " esta esperando palillo 1 \n";
            textArea.append(reporte);
            gifFilosofo.setIcon(new ImageIcon(getClass().getResource("/imagenes/esperando.gif")));
            
            palilloDerecho.tomarPalillo();
            reporte = "El filosofo " + id + " ha tomado el palillo derecho \n";
            
            textArea.append(reporte);
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(filosofoDerecho.class.getName()).log(Level.SEVERE, null, ex);
            }
            semaforoDerecho.setIcon(new ImageIcon(getClass().getResource("/imagenes/semaforoRojo.png")));
            
            
            reporte = "El filosofo " + id + " esta esperando palillo 2 \n";
            textArea.append(reporte);
            gifFilosofo.setIcon(new ImageIcon(getClass().getResource("/imagenes/esperando.gif")));
            palilloIzquierdo.tomarPalillo();
            
            
            reporte = "El filosofo " + id + " , consiguio sus 2 palillos, se pondra a comer \n";
            textArea.append(reporte);
            try {
                sleep(3000);  
            } catch (InterruptedException ex) {
                Logger.getLogger(filosofoDerecho.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            semaforoIzquierdo.setIcon(new ImageIcon(getClass().getResource("/imagenes/semaforoRojo.png")));
            gifFilosofo.setIcon(new ImageIcon(getClass().getResource("/imagenes/comiendo.gif")));
            reporte = "El filosofo " + id + " se puso a comer \n";
            textArea.append(reporte);
            try {
                sleep(4000);
            } catch (InterruptedException ex) {
                Logger.getLogger(filosofoDerecho.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            resultado += 1;
            Conteo.setText(String.valueOf(resultado));
            
            reporte = "El filosofo " + id + " termino de comer, suelta palillo derecho \n";
            textArea.append(reporte);
            palilloDerecho.dejarPalillo();
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(filosofoDerecho.class.getName()).log(Level.SEVERE, null, ex);
            }
            semaforoDerecho.setIcon(new ImageIcon(getClass().getResource("/imagenes/semaforoVerde.png")));
            
            reporte = "El filosofo " + id + " termino de comer, suelta palillo izquierdo \n";
            textArea.append(reporte);
            palilloIzquierdo.dejarPalillo();
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(filosofoDerecho.class.getName()).log(Level.SEVERE, null, ex);
            }
            semaforoIzquierdo.setIcon(new ImageIcon(getClass().getResource("/imagenes/semaforoVerde.png")));
            
            gifFilosofo.setIcon(new ImageIcon(getClass().getResource("/imagenes/durmiendo.gif")));
            reporte = "El filosofo " + id + " se pone en descanso \n";
            textArea.append(reporte);
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(filosofoDerecho.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            gifFilosofo.setIcon(new ImageIcon(getClass().getResource("/imagenes/pensando.gif")));
            reporte = "El filosofo " + id + " se pone a pensar \n";
            textArea.append(reporte);
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(filosofoDerecho.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        }
    
    }
}
