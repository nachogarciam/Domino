/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

/**
 *
 * @author jesus
 */
public class Ficha {

    int ladoA;
    int ladoB;
    //si es true, es que ya está ocupado ese lado
    boolean estadoA = false;
    boolean estadoB = false;

    public Ficha(int ladoA, int ladoB) {
        this.ladoA = ladoA;
        this.ladoB = ladoB;
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
    
    
    
}
