/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import ClienteServidor.EspacioFicha;
import ClienteServidor.TableroPanel;
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
public class Ficha extends JLabel implements Serializable, MouseListener, MouseMotionListener {

    int ladoA;
    int ladoB;
    //si es true, es que ya está ocupado ese lado
    boolean estadoA = false;
    boolean estadoB = false;

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
        this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Fichas/" + ladoA + "_" + ladoB + ".png")));
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
//        System.out.println("Pressed");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x = (this.getLocation().x);
        y = (this.getLocation().y);
        nuevo_X = (this.getLocation().x);
        nuevo_Y = (this.getLocation().y);
        this.setLocation(nuevo_X, nuevo_Y);
        for (int i = 0; i < TableroPanel.listaEspacios.size(); i++) {
            if (collision(TableroPanel.e)) {
                if (TableroPanel.listaEspacios.get(i).isOcupada()) {

                } else {
                    System.out.println("Colision");
                    TableroPanel.listaEspacios.get(i).setOcupada(true);
                    this.setLocation(TableroPanel.listaEspacios.get(i).getLocation());
                    this.rotar(90);
                }
            }
        }

    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51), 1));

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
        this.x = (int) offset.getX();
        this.y = (int) offset.getY();
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

    public void rotar(int grados) {
        this.grados = grados;
        repaint();
    }

    public void paintComponent(Graphics g) {
        double r = Math.toRadians(grados); //se convierte a radianes lo grados

        Graphics2D gx = (Graphics2D) g;

        gx.rotate(r, getWidth() / 2, getHeight() / 2);

        super.paintComponent(g);

    }

    public void setLugar(int x, int y) {
        this.x = x;
        this.y = y;
        setLocation(x, y);
    }

    public boolean collision(EspacioFicha f) {
        return f.getBounds().intersects(getBounds());

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 78, 78);
    }
}
