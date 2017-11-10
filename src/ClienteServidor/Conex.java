package ClienteServidor;

import Control.Control;
import Juego.Tablero;
import java.net.*;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conex {

    final int PUERTO = 5000;
    ServerSocket sc;
    Socket so;
    PrintStream salida;

    ArrayList<Thread> lista = new ArrayList<Thread>();
    ArrayList<Socket> listaSockets = new ArrayList<Socket>();
   

    String ip;
    ObjectOutputStream mensaje;

//SERVIDOR
    public void initServer() {

        try {
            sc = new ServerSocket(PUERTO);/* crea socket servidor que escuchara en puerto 5000*/
            so = new Socket();

            System.out.println("Esperando una conexión:");
            Control.listaIps.add(Control.getMiIp());
            while (true) {
                so = sc.accept();

//Inicia el socket, ahora esta esperando una conexión por parte del cliente
                System.out.println("Un cliente se ha conectado.");

                System.out.println("Confirmando conexion al cliente....");
                System.out.println(Control.listaIps);

                Thread t = new Thread() {
                    public void run() {
                        while (true) {
                            try {

                                String mensajeRecibido = null;
                                SocketCliente sc;
                                ObjectInputStream entrada;
                                entrada = new ObjectInputStream(so.getInputStream());
                                Object o = new Object();
                                o = entrada.readObject();
//                                System.out.println(o.getClass().to);
                                if (o.getClass().toString().equals("class java.lang.String")) {
                                    mensajeRecibido = (String) o;
                                } else if (o.getClass().toString().equals("class Juego.Tablero")) {
                                    Frame.pintarTablero();
                                    Control.obtenerDatos((Tablero) o);
                                    System.out.println("Tu turno es: " + Control.getJugador().isTurno());
                                }
//                                

                                ip = so.getInetAddress().toString();
                                ip = ip.substring(1);
                                System.out.println(mensajeRecibido);

                                if (Control.listaIps.isEmpty()) {
                                    System.out.println(ip);
                                    Control.listaIps.add(ip);
                                    Control.conectarseDeVuelta(ip);

                                } else if (!ip.equals(Control.listaIps.get(Control.listaIps.size() - 1))) {

                                    System.out.println(ip + "  &   " + Control.listaIps.get(Control.listaIps.size() - 1));
                                    Control.listaIps.add(ip);
                                    Control.conectarseDeVuelta(ip);
                                } else {
                                    //ya esta conectado
//                                    System.out.println("Ya estas conecto, no ocupas volverte a conectar kbron uwu");
                                }

                            } catch (IOException ex) {
                                Logger.getLogger(Conex.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(Conex.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                    }
                };
//                SocketCliente cliente = new SocketCliente("player", so.getInetAddress().toString());
                lista.add(t);
                listaSockets.add(so);
                t.start();
            }

//   sc.close();//Aqui se cierra la conexión con el cliente
        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

        }

    }

   

}
