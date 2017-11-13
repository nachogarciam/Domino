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
import java.util.ArrayList;
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

    public static EspacioFicha e;
    Hub hub;
    Ficha ficha;
    public static Map map = new HashMap();
    Dimension tam;

    public static ArrayList<EspacioFicha> listaEspacios = new ArrayList<EspacioFicha>();

    Thread t = new Thread() {
        public void run() {
            int i = 0;
//            while (true) {
//             
//                if (e != null && ficha != null && e.collision(ficha)) {
//                    System.out.println("Chocó we");
//                    System.out.println(i);
//                    i++;
//                    ficha.setLocation(e.getLocation());
//                    ficha.rotar(90);
//                }else{
////                    System.out.println("kpex");
//                }
//            }

        }
    };

    Thread t2 = new Thread() {
        public void run() {

        }
    };

    /**
     * Creates new form Tablero
     */
    public TableroPanel() {
        initComponents();
        tam = Toolkit.getDefaultToolkit().getScreenSize();

        pintarFichas();
        if (Control.listaIps.size() == 2) {
            hub = new Hub(1);
        } else {
            hub = new Hub(2);
        }
        hub.setLocation((int) (tam.getWidth() / 2) - (hub.getWidth() / 2), (int) (tam.getHeight() / 2) + 230);
        map.put("Hub", hub);
        PanelTablero.add(hub);
        PanelTablero.repaint();
        this.repaint();
        t.start();

//        t2.start();
    }

    public void pintarFichas() {
//        PanelTablero2.setVisible(false);
        for (int i = 0; i < 14; i++) {
//            Control.getJugador().getListaFichas().get(i).setLugar((PanelTablero2.getWidth() / 2) - (Control.getJugador().getListaFichas().get(i).getWidth() / 2), (PanelTablero2.getHeight() / 2) - ( Control.getJugador().getListaFichas().get(i).getWidth() / 2));

            if (i != 0) {
                Control.getJugador().getListaFichas().get(i).setLugar((int) Control.getJugador().getListaFichas().get(i - 1).getLocation().getX() + 45, ((int) tam.getHeight() / 2) + 265);
            } else {
                Control.getJugador().getListaFichas().get(i).setLugar(((int) tam.getWidth() / 2) - 340, ((int) tam.getHeight() / 2) + 265);
            }
            Control.getJugador().getListaFichas().get(i).rotar(90);
            //agrega el objeto en el MAP
            map.put("Ficha", Control.getJugador().getListaFichas().get(i));
            //agrega el KEY en el List
//        listModel.addElement( "Objeto " + this.contador_de_objetos );
            //agrega el objeto en el JPanel
            PanelTablero.add(Control.getJugador().getListaFichas().get(i));

            if (!Control.getJugador().isTurno()) {
                Control.getJugador().getListaFichas().get(i).setEnabled(false);
                Control.getJugador().getListaFichas().get(i).setFocusable(false);
            }
            //actualiza graficos
            PanelTablero.repaint();
        }

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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 0, 102));

        PanelTablero.setBackground(new java.awt.Color(108, 122, 137));

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

        jButton3.setText("Rotar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelTableroLayout = new javax.swing.GroupLayout(PanelTablero);
        PanelTablero.setLayout(PanelTableroLayout);
        PanelTableroLayout.setHorizontalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableroLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(159, 159, 159)
                .addComponent(jButton3)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTableroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(744, 744, 744))
        );
        PanelTableroLayout.setVerticalGroup(
            PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTableroLayout.createSequentialGroup()
                .addGroup(PanelTableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(27, 27, 27)
                .addComponent(jButton2)
                .addContainerGap(435, Short.MAX_VALUE))
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
        crearSombra();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
//         TODO add your handling code here:
//              

        ficha = new Ficha(0, 0);
        //coloca al objeto creado en una posicion aleatoria
//        ficha.setLocation(100, 100);
        ficha.setLugar(100, 100);
        //agrega el objeto en el MAP    
        map.put("Ficha", ficha);
        //agrega el KEY en el List
//        listModel.addElement( "Objeto " + this.contador_de_objetos );
        //agrega el objeto en el JPanel
        this.PanelTablero.add(ficha);
        //actualiza graficos
        this.PanelTablero.repaint();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        e.rotar(90);
//        e.acomodar();
    }//GEN-LAST:event_jButton3ActionPerformed

    public void crearSombra() {

        if (Control.getTablero().getListaTablero().size() == 0) {
            listaEspacios.add(new EspacioFicha(5, 5));
            listaEspacios.get(0).setLugar((PanelTablero.getWidth() / 2) - (listaEspacios.get(0).getWidth() / 2), (PanelTablero.getHeight() / 2) - (listaEspacios.get(0).getWidth() / 2));
            map.put("Ficha", listaEspacios.get(0));
            PanelTablero.add(listaEspacios.get(0));
            PanelTablero.repaint();

            listaEspacios.get(0).rotar(90);
            listaEspacios.get(0).repaint();
            this.repaint();

        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JPanel PanelTablero;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    // End of variables declaration//GEN-END:variables
}
