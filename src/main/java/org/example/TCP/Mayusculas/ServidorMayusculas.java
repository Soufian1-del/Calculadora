package org.example.TCP.Mayusculas;

import java.io.IOException;
import java.net.ConnectException;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ServidorMayusculas {
    public static void main(String[] args) {
        try {
            ServerSocket ChatServidor = new ServerSocket(6000);
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

            while(true){
                String Recibido = entrada.readLine();
                System.out.println("Recibido: "+ Recibido);
                System.out.print("Enviando: ");
                String Enviado = Recibido.toUpperCase();
                salida.println(Enviado);

                if(Recibido.equalsIgnoreCase("EXIt") || Enviado.equalsIgnoreCase("EXIt") ){
                    break;
                }
            }
            ChatServidor.close();
            chatCliente.close();

        } catch (ConnectException e){
            System.out.println("fallo en la conexion");
        } catch (IOException e) {
            System.out.println("fallo en la conexion");
        }
    }
}
