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
public class Movimiento implements Serializable {
    ArrayList<Ficha> listaFichas = new ArrayList<Ficha>();
    Jugador jugador=new Jugador();
    
    public Movimiento(Jugador jugador,ArrayList<Ficha> listaFichas){
        this.jugador=jugador;
        this.listaFichas.addAll(listaFichas);
    }

    public ArrayList<Ficha> getListaFichas() {
        return listaFichas;
    }

    public Jugador getJugador() {
        return jugador;
    }
    
    
    
}
