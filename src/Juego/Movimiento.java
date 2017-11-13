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
    Ficha ficha;
    Jugador jugador=new Jugador();
    
    public Movimiento(Jugador jugador,Ficha Ficha){
        System.out.println(jugador.getNombre());
        this.jugador.setNombre(jugador.getNombre());
        this.jugador.setTurno(jugador.isTurno());
        this.ficha=ficha;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

  

    public Jugador getJugador() {
        return jugador;
    }
    
    
    
}
