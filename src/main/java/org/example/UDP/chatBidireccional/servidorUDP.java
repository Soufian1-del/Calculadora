package org.example.UDP.chatBidireccional;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class servidorUDP {
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket(5000)) {
            System.out.println("servidor UDP esperando");
            Scanner sc = new Scanner(System.in);
            while(true){
                byte[] buffer = new byte[1024];
                DatagramPacket paqueteAenviar = new DatagramPacket(buffer, buffer.length);
                socket.receive(paqueteAenviar);
                String envio = new String(paqueteAenviar.getData(), paqueteAenviar.getOffset(), paqueteAenviar.getLength());
                System.out.println("Cliente: " + envio);
                if (envio.equalsIgnoreCase("exit") || envio.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.print("Servidor: ");
                String PaqueteARecibidr = sc.nextLine();
                DatagramPacket paqueteAEnviar = new DatagramPacket(PaqueteARecibidr.getBytes(StandardCharsets.UTF_8), PaqueteARecibidr.getBytes(StandardCharsets.UTF_8).length, paqueteAenviar.getAddress(), paqueteAenviar.getPort());
                socket.send(paqueteAEnviar);

            }
            } catch (SocketException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
