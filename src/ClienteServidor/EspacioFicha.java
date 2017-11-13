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
    boolean ocupada = false;
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

    int ladoDispA;
    int ladoDispB;
    
    boolean ocupadoA=false;
    boolean ocupadoB=false;

    String orientacion = "Horizontal";

    public EspacioFicha(int ladoA, int ladoB) {
        this.ladoDispA = ladoA;
        this.ladoDispB = ladoB;
        this.setToolTipText("Ficha");
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setSize(d);
        this.setPreferredSize(d);
        this.setIcon(new ImageIcon(getClass().getResource("/Imagenes/Fichas/FichaSombra.png")));
        this.setText("");
        this.setVisible(true);
        this.setLocation(posicion);

    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public int getLadoDispA() {
        return ladoDispA;
    }

    public void setLadoDispA(int ladoDispA) {
        this.ladoDispA = ladoDispA;
    }

    public int getLadoDispB() {
        return ladoDispB;
    }

    public void setLadoDispB(int ladoDispB) {
        this.ladoDispB = ladoDispB;
    }

    public boolean isOcupadoA() {
        return ocupadoA;
    }

    public void setOcupadoA(boolean ocupadoA) {
        this.ocupadoA = ocupadoA;
    }

    public boolean isOcupadoB() {
        return ocupadoB;
    }

    public void setOcupadoB(boolean ocupadoB) {
        this.ocupadoB = ocupadoB;
    }

    public void rotar(int grados) {
        this.grados = grados;
        widthColi = 40;
        heightColi = 78;
//        this.x = x + (this.getWidth() / 2);
//        this.y = y - (this.getHeight() / 4);
        this.orientacion = "Vertical";
        this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51), 1));
        this.repaint();
//     
//        this.setBorder(BorderFactory.createLineBorder(new java.awt.Color(204, 0, 51), 1));

    }

    public void acomodar() {
        d.setSize(40, 78);
        this.setSize(d);
        this.setPreferredSize(d);
        this.setLugar(x, y);
        this.repaint();
    }

    public void paintComponent(Graphics g) {
        double r = Math.toRadians(grados); //se convierte a radianes lo grados

        Graphics2D gx = (Graphics2D) g;

        gx.rotate(r, getWidth() / 2, getHeight() / 2); //Rotate 0.2 radians around the center of the label

//        gx.drawRect(x, y, widthColi, heightColi);
//        g.drawRect(x, y, widthColi, heightColi);
//        g.setColor(Color.GREEN);
        super.paintComponent(g);

    }

    public void setLugar(int x, int y) {
        this.x = x;
        this.y = y;
//        this.y =y-((this.getHeight()/2)-20);

        setLocation(x, y);
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public boolean collision(Ficha f) {
        return f.getBounds().intersects(getBounds());

    }

    public Rectangle getBounds() {
        if (this.orientacion.equalsIgnoreCase("Horizontal")) {
            return new Rectangle(x, y - ((this.getHeight() / 2) - 20), widthColi, heightColi);
        } else {
            return new Rectangle(x + ((this.getWidth() / 2) - 39), y, widthColi, heightColi);
        }
    }
}
