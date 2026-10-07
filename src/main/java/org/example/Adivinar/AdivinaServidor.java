package org.example.Adivinar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class AdivinaServidor {
    public static void main(String[] args) {
        try {
            ServerSocket ChatServidor = new ServerSocket(5000);
            System.out.println("Iniciando servidor");
            System.out.println("Esperando cliente");
            Socket chatCliente = ChatServidor.accept();
            PrintWriter salida = new PrintWriter(
                    chatCliente.getOutputStream(), true
            );
            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(chatCliente.getInputStream())
            );
            Scanner sc = new Scanner(System.in);
            int numero = (int) (Math.random() * 100) + 1;

            while(true){
                String Recibido = entrada.readLine();
                Integer recibidoNumero = Integer.parseInt(Recibido);
                if(numero<recibidoNumero){
                    String menor = "menor";
                    salida.println(menor);
                } else if (numero>recibidoNumero) {
                    String mayor = "mayor";
                    salida.println(mayor);
                } else{
                    String acertado = "numero acertado";
                    salida.println(acertado);
                    break;
                }
            }
            ChatServidor.close();
            chatCliente.close();

        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}

