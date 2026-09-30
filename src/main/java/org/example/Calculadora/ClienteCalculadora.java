package org.example.Calculadora;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClienteCalculadora {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost", 5000);
            PrintWriter salida = new PrintWriter(
                    socket.getOutputStream(), true
            );
            Scanner sc = new Scanner(System.in);

            while(true) {
                System.out.print("que quieres hacer? Calcular/Salir");
                String orden = sc.nextLine();
                if(orden.equalsIgnoreCase("Salir")){
                    System.out.println("comunicacion cerrada");
                    socket.close();
                    break;
                } else
                System.out.print("Introduce el primer numero: ");
                String mensaje1 = sc.nextLine();
                System.out.print("Introduce el segundo numero: ");
                String mensaje2 = sc.nextLine();
                System.out.print("Introduce la operacion: ");
                String Operacion = sc.nextLine();
                salida.println(orden);
                salida.println(mensaje1);
                salida.println(mensaje2);
                salida.println(Operacion);


                BufferedReader entrada = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())
                );
                String resultado = entrada.readLine();
                System.out.println("resultado: " + resultado);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
