/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author jesus
 */
public class Ficha extends JLabel implements Serializable, MouseListener, MouseMotionListener {

    int ladoA;
    int ladoB;
    //si es true, es que ya está ocupado ese lado
    boolean estadoA = false;
    boolean estadoB = false;

    /**
     * Identificador de objeto
     */
    private String key = "";
    /**
     * Posicion de imagen
     */
    private Point posicion = new Point(0, 0);
    /**
     * Tamaño de imagen
     */
    private Dimension d = new Dimension(300, 300);
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
    /**
     * variables auxiliares para el desplazamiento del objeto
     */
    private int nuevo_X = 1;
    private int nuevo_Y = 1;
    
    public Ficha(int ladoA, int ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
                this.setToolTipText("Ficha");
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setSize(d);
        this.setPreferredSize(d);
        this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Fichas/"+ladoA+"_"+ladoB+".png")));
        this.setText("");
        this.setVisible(true);
        this.setLocation(posicion);
        //se agregan los listener
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public int getLadoA() {
        return ladoA;
    }

    public void setLadoA(int ladoA) {
        this.ladoA = ladoA;
    }

    public int getLadoB() {
        return ladoB;
    }

    public void setLadoB(int ladoB) {
        this.ladoB = ladoB;
    }

    public boolean isEstadoA() {
        return estadoA;
    }

    public void setEstadoA(boolean estadoA) {
        this.estadoA = estadoA;
    }

    public boolean isEstadoB() {
        return estadoB;
    }

    public void setEstadoB(boolean estadoB) {
        this.estadoB = estadoB;
    }

    @Override
    public String toString() {
        return "Ficha{" + "ladoA=" + ladoA + ", ladoB=" + ladoB + '}';
    }
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.start_drag = getScreenLocation(e);
        this.start_loc = this.getLocation();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        nuevo_X = (this.getLocation().x);
        nuevo_Y = (this.getLocation().y);
        this.setLocation(nuevo_X, nuevo_Y);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51), 1));

    }

    @Override
    public void mouseExited(MouseEvent e) {

        this.setBorder(null);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point current = this.getScreenLocation(e);
        offset = new Point((int) current.getX() - (int) start_drag.getX(), (int) current.getY() - (int) start_drag.getY());
        Point new_location = new Point((int) (this.start_loc.getX() + offset.getX()), (int) (this.start_loc.getY() + offset.getY()));
        this.setLocation(new_location);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    private Point getScreenLocation(MouseEvent evt) {
        Point cursor = evt.getPoint();
        Point target_location = this.getLocationOnScreen();
        return new Point((int) (target_location.getX() + cursor.getX()),
                (int) (target_location.getY() + cursor.getY()));
    }
   
        public void paintComponent(Graphics g) {

            Graphics2D gx = (Graphics2D) g;

            gx.rotate(0.2, getX() + getWidth() / 2, getY() + getHeight() / 2); //Rotate 0.2 radians around the center of the label

            super.paintComponent(g);

        }

    

    
}
