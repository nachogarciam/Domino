/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Juego;

import java.util.ArrayList;

/**
 *
 * @author Nacho
 */
public class Jugador {
    String nombre="Player";
    ArrayList<Ficha> listaFichas = new ArrayList<Ficha>();
    
    public Jugador(){
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Ficha> getListaFichas() {
        return listaFichas;
    }

    public void setListaFichas(ArrayList<Ficha> listaFichas) {
        this.listaFichas = listaFichas;
    }
    
    
    
}
