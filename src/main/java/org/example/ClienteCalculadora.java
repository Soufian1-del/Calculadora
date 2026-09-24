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
            String mensaje1 = "5";
            String mensaje2 = "3";

            salida.println(mensaje1);
            salida.println(mensaje2);

            BufferedReader entrada = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            String resultado = entrada.readLine();
            System.out.println("resultado: "+ resultado);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
