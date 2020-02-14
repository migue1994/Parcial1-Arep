package edu.eci.arem.parcial.cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

/**
 * Cliente que se encarga de enviar peticiones al servidor
 */
public class Cliente {

    /**
     * Método principal
     * @param args argumentos
     * @throws IOException IO Exception
     */
    public static void main(String[] args) throws IOException {
     Socket echoSocket = null;
     PrintWriter out = null;
     BufferedReader in = null;
   
    try {
        SocketAddress sockaddr = new InetSocketAddress("www.yahoo.com", 80);
        echoSocket = new Socket();
        echoSocket.connect(sockaddr, 10000);
        out = new PrintWriter(echoSocket.getOutputStream(), true); 
        in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
   
    } catch (UnknownHostException e) {
        System.err.println("Don’t know about host!.");
        System.exit(1);
    } catch (IOException e) {
        System.err.println("Couldn’t get I/O for " + "the connection to: localhost.");
        System.exit(1);
    }
        BufferedReader stdIn = new BufferedReader( new InputStreamReader(System.in));
        String userInput;
   
    while ((userInput = stdIn.readLine()) != null) {
        out.println(userInput);
        System.out.println(in .readLine());
    
    }
        out.close(); in .close();
        stdIn.close();
        echoSocket.close();
    }
}