/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import ClienteServidor.Conex;
import ClienteServidor.Frame;
import ClienteServidor.SocketCliente;
import Juego.Ficha;
import Juego.Jugador;
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
    static Jugador jugador;
    static Conex c;
    static SocketCliente sc;
    public static SocketCliente sc2;
    static Tablero tablero;

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
        c.listaIps.add(ip);
    }

    public ArrayList getListaIps() {
        return c.getListaIps();
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

        for (int i = 0; i < 14; i++) {
            fichasJugador.add(listaFichas.get(0));
            listaFichas.remove(0);
        }
        jugador = new Jugador(nombre, fichasJugador);
        jugador.tieneMula();
        listaJugadores.add(jugador);
//        System.out.println(jugador.getListaFichas().size());
//        System.out.println(jugador.getListaFichas().toString());
//        System.out.println(listaFichas.toString());
    }

    public static void iniciarJuego() {
//        crearFichas();
//        crearJugador("Player 1");
        
        tablero = new Tablero(listaFichas, listaJugadores);
        
//        if (sc2 == null) {
//            sc.enviarMensaje(tablero);
//        } else {
//            sc2.enviarMensaje(tablero);
//        }
//        tablero.getListaTablero().clear();
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
        jugador = new Jugador("Player 2", tablero2.getListaTablero());
        if(!tablero2.getListaJugadores().get(0).isTurno()){
            jugador.setTurno(true);
        }
        tablero2.getListaTablero().clear();
        tablero = tablero2;
    }

    public static Jugador getJugador() {
        return jugador;
    }

    public static Tablero getTablero() {
        return tablero;
    }

    public static void NACHONOCORRE(){
        
    }
}
