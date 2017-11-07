/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nacho
 */
public class SocketCliente implements Runnable {

    private Socket socket;
    String nombre;
    ObjectOutputStream mensaje;
    DataInputStream entrada;
    ArrayList<Socket> lista = new ArrayList<Socket>();
    int puerto = 5000;
//    ObjectOutputStream salida;

    public SocketCliente(String nombre, String ip) {
        try {
            this.nombre = nombre;
            socket = new Socket(ip, puerto);
            lista.add(socket);
        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensaje() {
        try {
            mensaje = new ObjectOutputStream(socket.getOutputStream());

            mensaje.writeObject("hola");

        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void enviarMensaje(Object obj) {
        try {
            mensaje = new ObjectOutputStream(socket.getOutputStream());

            mensaje.writeObject(obj);

        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {

        try {
            mensaje = new ObjectOutputStream(socket.getOutputStream());

            mensaje.writeObject("Conectado");

        } catch (IOException ex) {
            Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
       

//            socket.close();
    }

}
