package org.example.Chat;

import java.io.IOException;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.util.Scanner;

public class ChatCliente {
    public static void main(String[] args) {
        try {
            Socket ChatCliente = new Socket("localhost", 5000);
            System.out.println("Conexion establecida correctamente.");
            PrintWriter salida = new PrintWriter(
                    ChatCliente.getOutputStream(), true
            );
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(ChatCliente.getInputStream())
            );
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.print("Enviando: ");
                String Enviado = sc.nextLine();
                salida.println(Enviado);
                String Recibido = entrada.readLine();
                System.out.println("Recibido: "+ Recibido);
                if(Enviado.equalsIgnoreCase("EXIt") || Recibido.equalsIgnoreCase("EXIt")){
                    break;
                }
            }
            ChatCliente.close();

        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
