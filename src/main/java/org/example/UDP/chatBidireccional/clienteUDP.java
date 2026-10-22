package org.example.UDP.chatBidireccional;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class clienteUDP {
    public static void main(String[] args){
        try(DatagramSocket socket = new DatagramSocket()) {
            InetAddress ipServidor= InetAddress.getByName("localhost");
            int puerto = 5000;
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.print("cliente: ");
                String mensaje = sc.nextLine();
                DatagramPacket paqueteAEnviar = new DatagramPacket(mensaje.getBytes(StandardCharsets.UTF_8), mensaje.getBytes(StandardCharsets.UTF_8).length, ipServidor, puerto);
                socket.send(paqueteAEnviar);
                if (mensaje.equalsIgnoreCase("exit") || mensaje.equalsIgnoreCase("exit")) {
                    break;
                }
                byte[] buffer = new byte[1024];
                DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
                socket.receive(paqueteRecibido);
                String respuesta = new String(paqueteRecibido.getData(), paqueteRecibido.getOffset(), paqueteRecibido.getLength());
                System.out.println("Servidor: " + respuesta);
            }
        } catch (UnknownHostException e){
            System.out.println("error: noe ncontro la ip del servidor");
            e.printStackTrace();
        } catch (SocketException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
