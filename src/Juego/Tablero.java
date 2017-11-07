/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Nacho
 */
public class Tablero implements Serializable {

    ArrayList<Ficha> listaTablero = new ArrayList<Ficha>();
     ArrayList<Jugador> listaJugadores = new ArrayList<Jugador>();

    public Tablero(){
        
    }
    
    public Tablero(ArrayList<Ficha> lista, ArrayList<Jugador> listaJugador){
        this.listaTablero.addAll(lista);
        this.listaJugadores.addAll(listaJugador);
    }

    public ArrayList<Ficha> getListaTablero() {
        return listaTablero;
    }

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }
    
    
    
}
