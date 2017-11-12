/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidor;

import static ClienteServidor.Frame.control;
import Control.Control;
import Juego.Ficha;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Nacho
 */
public class TableroPanel extends javax.swing.JPanel {

    EspacioFicha e;
    Ficha ficha;
    public static Map map = new HashMap();
    Dimension tam;
    Thread t = new Thread() {
        public void run() {
            int i = 0;
            while (true) {
                Centrar();
                if (e != null && ficha != null && e.collision(ficha)) {
                    System.out.println("Chocó we");
                    System.out.println(i);
                    i++;
                    ficha.setLocation(e.getLocation());
                    ficha.rotar(90);
                }
            }

        }
    };

    Thread t2 = new Thread() {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(TableroPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (control.getListaTablero().size() == 0) {
                    EspacioFicha e = new EspacioFicha();
//                    e.setLocation(100, 100);

                    //agrega el objeto en el MAP
                    map.put("Ficha", e);
                    //agrega el KEY en el List
//        listModel.addElement( "Objeto " + this.contador_de_objetos );
                    //agrega el objeto en el JPanel
                    PanelTablero2.add(e);
                    //actualiza graficos
                    PanelTablero2.repaint();
                    System.out.println("qwe");
                }
            }

        }
    };

    /**
     * Creates new form Tablero
     */
    public TableroPanel() {
        initComponents();
        tam = Toolkit.getDefaultToolkit().getScreenSize();
//        this.setSize(Frame.jPanel1.getWidth(), Frame.jPanel1.getHeight());
//        this.setVisible(true);
        ImageIcon icon = null;
        if (Control.listaIps.size() == 2) {
            URL url = this.getClass().getResource("/Imagenes/tablero.png");
            icon = new ImageIcon(url);
        } else {
            URL url = this.getClass().getResource("/Imagenes/tablero2.png");
            icon = new ImageIcon(url);
        }
        Hub.setIcon(icon);
        Hub.setLocation((int) tam.getWidth(), (int) tam.getHeight());
        Hub.repaint();
        this.repaint();
        t.start();
        pintarFichas();

//        t2.start();
    }

    public void pintarFichas() {
       
//        PanelTablero2.setVisible(false);
        for (int i = 0; i < 14; i++) {
//            Control.getJugador().getListaFichas().get(i).setLugar((PanelTablero2.getWidth() / 2) - (Control.getJugador().getListaFichas().get(i).getWidth() / 2), (PanelTablero2.getHeight() / 2) - ( Control.getJugador().getListaFichas().get(i).getWidth() / 2));

            if (i != 0) {
                Control.getJugador().getListaFichas().get(i).setLugar((int) Control.getJugador().getListaFichas().get(i - 1).getLocation().getX() + 45, ((int) tam.getHeight() / 2) + 270);
            } else {
                Control.getJugador().getListaFichas().get(i).setLugar(((int) tam.getWidth() / 2) - 350, ((int) tam.getHeight() / 2) + 270);
            }
            Control.getJugador().getListaFichas().get(i).rotar(90);
            //agrega el objeto en el MAP
            map.put("Ficha", Control.getJugador().getListaFichas().get(i));
            //agrega el KEY en el List
//        listModel.addElement( "Objeto " + this.contador_de_objetos );
            //agrega el objeto en el JPanel
            PanelTablero.add(Control.getJugador().getListaFichas().get(i));
            //actualiza graficos
            PanelTablero.repaint();
        }

    }

    public void Centrar() {

        PanelTablero2.setSize((int) tam.getWidth() - 190, (int) tam.getHeight() - 190);
//        jPanel1.setBounds((int) tam.getWidth()-500, (int) tam.getHeight()-500, (int) (tam.getWidth() / 2) - (jPanel1.getWidth() / 2), (int) (tam.getHeight() / 2) - (jPanel1.getHeight() / 2));
        PanelTablero2.repaint();
        this.repaint();
        PanelTablero2.setLocation((int) (tam.getWidth() / 2) - (PanelTablero2.getWidth() / 2), (int) (tam.getHeight() / 2) - (PanelTablero2.getHeight() / 2));
        PanelTablero2.repaint();
        this.repaint();

//        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelTablero = new javax.swing.JPanel();
        PanelTablero2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Hub = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 0, 102));

        PanelTablero.setBackground(new java.awt.Color(108, 122, 137));

        javax.swing.GroupLayout PanelTablero2Layout = new javax.swing.GroupLayout(PanelTablero2);
        PanelTablero2.setLayout(PanelTablero2Layout);
        PanelTablero2Layout.setHorizontalGroup(
            PanelTablero2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );
        PanelTablero2Layout.setVerticalGroup(
            PanelTablero2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("jButton2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTableroLayout = new javax.swing.GroupLayout(PanelTablero);
        PanelTablero.setLayout(PanelTableroLayout);
        PanelTableroLayout.setHorizontalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableroLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTableroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelTablero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(409, 409, 409))
            .addGroup(PanelTableroLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(Hub)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelTableroLayout.setVerticalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableroLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addGroup(PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelTableroLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(PanelTablero2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelTableroLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 306, Short.MAX_VALUE)
                .addComponent(Hub)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        e = new EspacioFicha();
        //coloca al objeto creado en una posicion aleatoria
//        e.setLocation((jPanel1.getWidth()/2)-(e.getWidth()/2), (jPanel1.getHeight()/2)-(e.getWidth()/2));
        e.setLugar((PanelTablero2.getWidth() / 2) - (e.getWidth() / 2), (PanelTablero2.getHeight() / 2) - (e.getWidth() / 2));
        //agrega el objeto en el MAP
        map.put("Ficha", e);
        //agrega el KEY en el List
//        listModel.addElement( "Objeto " + this.contador_de_objetos );
        //agrega el objeto en el JPanel
        PanelTablero2.add(e);
        //actualiza graficos
        PanelTablero2.repaint();
        System.out.println("qwe");

        if (control.getListaTablero().size() == 0) {
            e.rotar(90);
            e.repaint();
            this.repaint();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ficha = new Ficha(0, 0);
        //coloca al objeto creado en una posicion aleatoria
//        ficha.setLocation(100, 100);
        ficha.setLugar(100, 100);
        //agrega el objeto en el MAP    
        map.put("Ficha", ficha);
        //agrega el KEY en el List
//        listModel.addElement( "Objeto " + this.contador_de_objetos );
        //agrega el objeto en el JPanel
        this.PanelTablero2.add(ficha);
        //actualiza graficos
        this.PanelTablero2.repaint();

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Hub;
    private javax.swing.JPanel PanelTablero;
    public static javax.swing.JPanel PanelTablero2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables
}
