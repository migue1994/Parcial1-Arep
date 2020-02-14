package edu.eci.arem.parcial.server;

import java.net.*;

import edu.eci.arem.parcial.appServices.LogicaNegocio;

import java.io.*;

/**
 * Servidor web
 */
public class HttpServer {
 public static void main(String[] args) throws IOException {

    ServerSocket serverSocket = null;
    try {
        serverSocket = new ServerSocket(getPort());
    } catch (IOException e) {
        System.err.println("Could not listen on port: 35000.");
        System.exit(1);
    }

    while(true){
        Socket clientSocket = null;
        try {
            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        LogicaNegocio ln = new LogicaNegocio();
        while ((inputLine = in .readLine()) != null) {
            System.out.println("Received: " + inputLine);
            ln.getEntrada(inputLine);
            ln.mergeSort(ln.getNumDatos(), ln.getNumDatos().length);
            ln.printAnswer();
            
        if (! in .ready()) {
            break;
        }
        }
        // outputLine = ln.printAnswer();
        // out.println(outputLine);
        out.close(); in .close();
        clientSocket.close();
        }
    
    }
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }
}