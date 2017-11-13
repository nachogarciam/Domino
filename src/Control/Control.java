/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import ClienteServidor.Conex;
import ClienteServidor.Frame;
import static ClienteServidor.Frame.jPanel1;
import ClienteServidor.SocketCliente;
import ClienteServidor.TableroPanel;
import Juego.Ficha;
import Juego.Jugador;
import Juego.Movimiento;
import Juego.Tablero;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Nacho
 */
public class Control {

    static ArrayList<Ficha> listaFichas = new ArrayList<Ficha>();
    static ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();
    public static ArrayList<String> listaIps = new ArrayList<String>();
    static Jugador jugador;
    static Conex c;
    static SocketCliente sc;
    public static SocketCliente sc2;
    static Tablero tablero;
    static String miIp = "192.168.0.19";

    public void iniciarServidor() {
        Thread t1 = new Thread() {
            public void run() {
                c = new Conex();
                c.initServer();
//            t2.start();
            }
        };
        t1.start();
    }

    public void conectarse(String ip) {
        sc = new SocketCliente("yo", ip);

        sc.run();
    }

    public static void conectarseDeVuelta(String ip) {
        sc2 = new SocketCliente("Yo", ip);
    }

    public void agregarIpLista(String ip) {
        listaIps.add(ip);
    }

    public ArrayList getListaIps() {
        return listaIps;
    }

    public static void crearFichas() {
        Ficha ficha1 = new Ficha(0, 0);
        Ficha ficha2 = new Ficha(0, 1);
        Ficha ficha3 = new Ficha(0, 2);
        Ficha ficha4 = new Ficha(0, 3);
        Ficha ficha5 = new Ficha(0, 4);
        Ficha ficha6 = new Ficha(0, 5);
        Ficha ficha7 = new Ficha(0, 6);
        Ficha ficha8 = new Ficha(1, 1);
        Ficha ficha9 = new Ficha(1, 2);
        Ficha ficha10 = new Ficha(1, 3);
        Ficha ficha11 = new Ficha(1, 4);
        Ficha ficha12 = new Ficha(1, 5);
        Ficha ficha13 = new Ficha(1, 6);
        Ficha ficha14 = new Ficha(2, 2);
        Ficha ficha15 = new Ficha(2, 3);
        Ficha ficha16 = new Ficha(2, 4);
        Ficha ficha17 = new Ficha(2, 5);
        Ficha ficha18 = new Ficha(2, 6);
        Ficha ficha19 = new Ficha(3, 3);
        Ficha ficha20 = new Ficha(3, 4);
        Ficha ficha21 = new Ficha(3, 5);
        Ficha ficha22 = new Ficha(3, 6);
        Ficha ficha23 = new Ficha(4, 4);
        Ficha ficha24 = new Ficha(4, 5);
        Ficha ficha25 = new Ficha(4, 6);
        Ficha ficha26 = new Ficha(5, 5);
        Ficha ficha27 = new Ficha(5, 6);
        Ficha ficha28 = new Ficha(6, 6);
        listaFichas.add(ficha1);
        listaFichas.add(ficha2);
        listaFichas.add(ficha3);
        listaFichas.add(ficha4);
        listaFichas.add(ficha5);
        listaFichas.add(ficha6);
        listaFichas.add(ficha7);
        listaFichas.add(ficha8);
        listaFichas.add(ficha9);
        listaFichas.add(ficha10);
        listaFichas.add(ficha11);
        listaFichas.add(ficha12);
        listaFichas.add(ficha13);
        listaFichas.add(ficha14);
        listaFichas.add(ficha15);
        listaFichas.add(ficha16);
        listaFichas.add(ficha17);
        listaFichas.add(ficha18);
        listaFichas.add(ficha19);
        listaFichas.add(ficha20);
        listaFichas.add(ficha21);
        listaFichas.add(ficha22);
        listaFichas.add(ficha23);
        listaFichas.add(ficha24);
        listaFichas.add(ficha25);
        listaFichas.add(ficha26);
        listaFichas.add(ficha27);
        listaFichas.add(ficha28);
        Collections.shuffle(listaFichas);

    }

    public static void crearJugador(String nombre) {
        ArrayList<Ficha> fichasJugador = new ArrayList<Ficha>();

        if (listaIps.size() == 2) {
            for (int i = 0; i < 14; i++) {
                fichasJugador.add(listaFichas.get(0));
                listaFichas.remove(0);
            }
        } else if (listaIps.size() == 4) {
            for (int i = 0; i < 7; i++) {
                fichasJugador.add(listaFichas.get(0));
                listaFichas.remove(0);
            }
        }

        jugador = new Jugador(nombre, fichasJugador);
        jugador.tieneMula();
        listaJugadores.add(jugador);
//        System.out.println(jugador.getListaFichas().size());
//        System.out.println(jugador.getListaFichas().toString());
//        System.out.println(listaFichas.toString());
    }

    public static void iniciar() {
        crearFichas();
        crearJugador("Player 1");

        tablero = new Tablero(listaFichas, listaJugadores, listaIps);
        System.out.println(listaIps.size());
        if (sc2 == null) {
            sc.enviarMensaje(tablero);
        } else {
            sc2.enviarMensaje(tablero);
        }
        tablero.getListaTablero().clear();
        pintarTablero();
        iniciarJuego();
    }

    public static void iniciarJuego() {
        Thread t = new Thread() {
            public void run() {
                while (true) {
                    if (jugador.isTurno()) {
                        //aqui algo para desbloquear las fichas
                        Frame.btnMensaje.setEnabled(true);

                    } else {
                        Frame.btnMensaje.setEnabled(false);
                    }
                }
            }

        };
        t.start();
    }

    public void enviarMensaje() {
        if (sc2 == null) {
            sc.enviarMensaje();
        } else {
            sc2.enviarMensaje();
        }
    }

    public void enviarMensaje(Object obj) {

    }

    public static void obtenerDatos(Tablero tablero2) {
        if (tablero2.getListaIps().size() == 4) {
            for (int i = 0; i < tablero2.getListaIps().size(); i++) {
                if (miIp.equalsIgnoreCase(tablero2.getListaIps().get(i))) {

                    if (i == 1) {
                        for (int j = 0; j < 7; j++) {
                            listaFichas.add(tablero2.getListaTablero().get(j));
                        }
                        jugador = new Jugador("Player " + i + 1, listaFichas);
                    }

                    if (i == 2) {
                        for (int j = 7; j < 14; j++) {
                            listaFichas.add(tablero2.getListaTablero().get(j));
                        }
                        jugador = new Jugador("Player " + i + 1, listaFichas);
                    }
                    if (i == 3) {
                        for (int j = 14; j < 21; j++) {
                            listaFichas.add(tablero2.getListaTablero().get(j));
                        }
                        jugador = new Jugador("Player " + i + 1, listaFichas);

                    }
                }
            }

        } else {
            jugador = new Jugador("Player 2", tablero2.getListaTablero());
        }
        System.out.println(tablero2.getListaTablero().toString());

        jugador.tieneMula();
//        if (jugador.isTurno()) {
//            jugador.setTurno(true);
//        }
        tablero2.getListaTablero().clear();
        tablero = tablero2;
        iniciarJuego();
    }

    public static Jugador getJugador() {
        return jugador;
    }

    public static Tablero getTablero() {
        return tablero;
    }

    public static String getMiIp() {
        return miIp;
    }

    public static void setMiIp(String miIp) {
        Control.miIp = miIp;
    }

    public void moverPieza() {
        //Pruebas
        tablero.getListaTablero().add(jugador.getListaFichas().get(0));
        jugador.getListaFichas().remove(0);
//        jugador.setTurno(false);
        Movimiento m = new Movimiento(jugador, tablero.getListaTablero());

        if (sc2 == null) {
            sc.enviarMensaje(m);
        } else {
            sc2.enviarMensaje(m);
        }
        jugador.setTurno(false);
        Frame.btnMensaje.setEnabled(false);
    }

    public ArrayList<Ficha> getListaTablero() {
        tablero = new Tablero();
        return tablero.getListaTablero();
    }

    public static void pintarTablero() {
        TableroPanel pt = new TableroPanel();

        pt.setSize(jPanel1.getWidth(), jPanel1.getHeight());

        jPanel1.removeAll();
        jPanel1.add(pt);
        jPanel1.revalidate();
        jPanel1.repaint();
//        pt.Centrar();
    }

}
