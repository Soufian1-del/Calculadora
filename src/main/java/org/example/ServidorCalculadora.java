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
            String mensaje1 = entrada.readLine();
            Integer numero2 = Integer.parseInt(mensaje1);
            String mensaje2 = entrada.readLine();
            Integer numero1 = Integer.parseInt(mensaje2);
            int resultado = numero1+numero2;
            System.out.println("resultado de: " + numero1 + " y " + numero2 + " enviado al cliente");
            System.out.println("resultado esperado:"  + resultado);

            PrintWriter salida = new PrintWriter(
                    cliente.getOutputStream(), true
            );
            salida.println(resultado);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
