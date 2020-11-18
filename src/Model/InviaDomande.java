/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Quick Fix Demons
 */
public class InviaDomande extends Thread {
    private Socket socket;
    private List<PrintWriter> output;
    private Scanner scanner;
    private int ID;
    private boolean inseritoNome;
    private List<Utente> utenti;
    private Settings impostazioni;

    public InviaDomande(List<PrintWriter> out, List<Utente> users, Settings imp) {
        super();
        this.output = out;
        this.utenti = users;
        this.inseritoNome = false;
        this.impostazioni = imp;
    }

    @Override
    public void run() {
        for(Domanda d : impostazioni.getQuestions()) {
            if(impostazioni.getIndiceDomanda() == 0) {
                send("Iniziamo con il gioco!");
            }
            else {
                send("Ottimo lavoro, prossima domanda!\n");
            }
            send("Domanda N." + (impostazioni.getIndiceDomanda() + 1) + ": " + d.getQuestion());
            if(!d.isTrueOrFalse()) {
                for(int i = 0; i< d.getRisposte().length; i++) {
                    send("Risposta #" + (i + 1) + ": " + d.getRisposte()[i]);
                }
            }
            try {
                Thread.sleep(d.getTempoRisposta() * 1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Go next");
            impostazioni.incrementaIndice();
            
        }
        send("Fine partita!\nClassifica: COMING SOON");
    }
    
    public void send(String msg) {
        for(int i = 0; i<output.size(); i++) {
            output.get(i).println(msg);
        }
    }
}
