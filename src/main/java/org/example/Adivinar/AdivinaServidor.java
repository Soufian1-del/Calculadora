package org.example.Adivinar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class AdivinaServidor {
    public static void main(String[] args) {
        try {
            ServerSocket servidor = new ServerSocket(5000);
            System.out.println("Esperando cliente");
            Socket cliente = servidor.accept();
            System.out.println("Cliente conectado correctamente");
            int random = (int) (Math.random() * 100) + 1; //numero random [1,100]
            PrintWriter salida = new PrintWriter(cliente.getOutputStream(), true);
            salida.println("Adivina el numero entre 1 y 100");
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
            while(true) {
                String intentoStr = entrada.readLine();
                int intento;
                try {
                    intento = Integer.parseInt(intentoStr);
                } catch (Exception e) {
                    salida.println("Intento no válido");
                    continue;
                }
                if(intento < random){
                    salida.println("Mayor");
                } else if (intento > random) {
                    salida.println("Menor");
                }else{
                    salida.println("Enhorabuena el número era: " + random);
                    break;
                }
            }
            servidor.close();
            cliente.close();
        } catch (Exception e) {
            System.out.println("No se ha podido establecer conexión");
        }
    }
}

