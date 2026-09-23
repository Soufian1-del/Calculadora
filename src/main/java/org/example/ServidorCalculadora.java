package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorCalculadora {
    public static void main(String[] args) {
        try {
            ServerSocket Servidor = new ServerSocket(5000);
            Socket cliente = Servidor.accept();
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(cliente.getInputStream())
            );
            int mensaje1 = entrada.read();
            int mensaje2 = entrada.read();
            System.out.println(mensaje1);
            System.out.println(mensaje2);
            System.out.println(mensaje1 + mensaje2);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
