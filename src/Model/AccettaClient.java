/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Quick Fix Demons
 */
public class AccettaClient extends Thread {
    private boolean exit;

    public AccettaClient() {
        this.exit = false;
    }
    
    @Override
    public void run() {
        try {
            // Fare una classe utente
            // Con socket, punti, nickname
            
            ServerSocket serverSocket = new ServerSocket(Settings.PORT);
            System.out.println("Server up, running and listening");
            
            List<Socket> listaSocket = new ArrayList<>();
            List<PrintWriter> output = new ArrayList<>();
            List<InoltraMessaggi> listaInoltra = new ArrayList<>();
            List<String> utenti = new ArrayList<>();
            int i = 0;
            
            while(!exit) {
                listaSocket.add(serverSocket.accept());
                
                System.out.println("Numero di connessioni accettate: " + listaSocket.size());
                output.add(new PrintWriter(listaSocket.get(i).getOutputStream(), true));
                listaInoltra.add(new InoltraMessaggi("Utente" + i, listaSocket.get(i), output, utenti, i));
                listaInoltra.get(i).start();
                i++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void ferma() {
        exit = true;
    }
    
}