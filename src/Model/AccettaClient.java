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
    private List<Socket> listaSocket;
    private List<PrintWriter> output;
    private List<AccettaRisposte> listaInoltra;
    private List<Utente> utenti;
    private InviaDomande startGame;
    Settings impostazioni;
    
    public AccettaClient() {
        this.exit = false;
        impostazioni = new Settings();
    }
    
    @Override
    public void run() {
        try {
            
            ServerSocket serverSocket = new ServerSocket(Settings.PORT);
            System.out.println("Server up, running and listening");
            
            listaSocket = new ArrayList<>();
            output = new ArrayList<>();
            listaInoltra = new ArrayList<>();
            utenti = new ArrayList<>();
            
            int i = 0;
            
            while(!exit) {
                listaSocket.add(serverSocket.accept());
                
                System.out.println("Numero di connessioni accettate: " + listaSocket.size());
                output.add(new PrintWriter(listaSocket.get(i).getOutputStream(), true));
                listaInoltra.add(new AccettaRisposte("Utente" + i, listaSocket.get(i), output, utenti, i, impostazioni));
                listaInoltra.get(i).start();
                i++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void ferma() {
        exit = true;
        startGame = new InviaDomande(output, utenti, impostazioni);
        startGame.start();
    }

    public List<Socket> getListaSocket() {
        return listaSocket;
    }

    public void setListaSocket(List<Socket> listaSocket) {
        this.listaSocket = listaSocket;
    }

    public List<PrintWriter> getOutput() {
        return output;
    }

    public void setOutput(List<PrintWriter> output) {
        this.output = output;
    }

    public List<AccettaRisposte> getListaInoltra() {
        return listaInoltra;
    }

    public void setListaInoltra(List<AccettaRisposte> listaInoltra) {
        this.listaInoltra = listaInoltra;
    }

    public List<Utente> getUtenti() {
        return utenti;
    }

    public void setUtenti(List<Utente> utenti) {
        this.utenti = utenti;
    }
    
}
