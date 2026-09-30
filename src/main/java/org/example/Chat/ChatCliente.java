package org.example.Chat;

import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

public class ChatCliente {
    public static void main(String[] args) {
        try {
            Socket ChatCliente = new Socket("localhost", 5000);
            System.out.println("Conexion establecida correctamente.");
            PrintWriter salida = new PrintWriter(
                    ChatCliente.getOutputStream(), true
            );
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(ChatServidor.getInputStream())
            );
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
