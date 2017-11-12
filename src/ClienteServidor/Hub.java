/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidor;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Nacho
 */
public class Hub extends JLabel {

    /**
     * Identificador de objeto
     */
    private String key = "";
    /**
     * Posicion de imagen
     */
    int x = 0;
    int y = 0;
    private Point posicion = new Point(x, y);
    /**
     * Tamaño de imagen
     */
    private Dimension d = new Dimension(672, 122);
    /**
     * variable que sirve para calcular el movimiento del objeto
     */
    private Point start_loc;
    /**
     * variable que sirve para calcular el movimiento del objeto
     */
    private Point start_drag;
    /**
     * variable que sirve para calcular el movimiento del objeto
     */
    private Point offset;

    public Hub(int tipo) {
        this.setSize(d);
        this.setPreferredSize(d);
        if (tipo == 1) {
            this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Tablero.png")));
        } else {
            this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Tablero2.png")));

        }
        this.setText("");
        this.setVisible(true);
        this.setLocation(posicion);
    }
    
//     public void paintComponent(Graphics g) {
////        double r = Math.toRadians(grados); //se convierte a radianes lo grados
//
//        Graphics2D gx = (Graphics2D) g;
//
//        gx.rotate(0, getWidth() / 2, getHeight() / 2); //Rotate 0.2 radians around the center of the label
//
//        super.paintComponent(g);
//
//    }
}
