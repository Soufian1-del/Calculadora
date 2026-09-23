package org.example;
import java.io.*;
import java.net.Socket;
public class ClienteCalculadora {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost", 5000);
            PrintWriter salida = new PrintWriter(
                    socket.getOutputStream(), true
            );
            int mensaje1 = 5;
            int mensaje2 = 3;

            salida.println(mensaje1);
            salida.println(mensaje2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
