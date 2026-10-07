package org.example.Adivinar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class AdivinaCliente {
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
                System.out.print("numero: ");
                String Enviado = sc.nextLine();
                salida.println(Enviado);
                String Recibido = entrada.readLine();
                System.out.println("Recibido: "+ Recibido);
                if(Recibido.equalsIgnoreCase("numero acertado")){
                    break;
                }
            }
            ChatCliente.close();

        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}


