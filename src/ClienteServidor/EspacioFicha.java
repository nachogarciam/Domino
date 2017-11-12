/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidor;

import Juego.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jesus
 */
public class EspacioFicha extends JLabel {

    int grados = 0;
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
    private Dimension d = new Dimension(78, 78);
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
 

    int widthColi = 78;
    int heightColi = 40;

    public EspacioFicha() {

        this.setToolTipText("Ficha");
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setSize(d);
        this.setPreferredSize(d);
        this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Fichas/FichaSombra.png")));
        this.setText("");
        this.setVisible(true);
        this.setLocation(posicion);

    }

    public void rotar(int grados) {
        this.grados = grados;
        widthColi = 40;
        heightColi = 78;
//        d.setSize(40, 78);
//        this.setSize(d);
//        this.setPreferredSize(d);
        this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51), 1));
        this.repaint();
//        this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51), 1));

    }

    public void paintComponent(Graphics g) {
        double r = Math.toRadians(grados); //se convierte a radianes lo grados

        Graphics2D gx = (Graphics2D) g;

        gx.rotate(r, getWidth() / 2, getHeight() / 2); //Rotate 0.2 radians around the center of the label

        super.paintComponent(g);

    }

    public void setLugar(int x, int y) {
        this.x = x;
        this.y = y;
        setLocation(x, y);
    }

    public boolean collision(Ficha f) {
        return f.getBounds().intersects(getBounds());

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 78, 78);
    }
}
