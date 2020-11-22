/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Quick Fix Demons
 */
public class InviaDomande extends Thread {
    //private Socket socket; 
    //private Scanner scanner;
    //private int ID;
    
    private List<Utente> utenti;
    private Settings impostazioni;
    private List<PrintWriter> output;

    public InviaDomande(List<PrintWriter> out, List<Utente> users, Settings imp) {
        super();
        this.output = out;
        this.utenti = users;
        this.impostazioni = imp;
    }

    @Override
    public void run() {
        for(Domanda d : impostazioni.getQuestions()) {
            if(impostazioni.getIndiceDomanda() == 0) {
                send("Iniziamo con il gioco!");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            else {
                send("Ottimo lavoro, prossima domanda!");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            
            String pacchetto = "Domanda N." + (impostazioni.getIndiceDomanda() + 1) + ": " + d.getQuestion();
            if(!d.isTrueOrFalse()) {
                for(int i = 0; i< d.getRisposte().length; i++) {
                    pacchetto += " - " + (i + 1) + ") " + d.getRisposte()[i];
                }
            }
            else {
                pacchetto += " - VERO - FALSO";
            }
            send(pacchetto);
            try {
                Thread.sleep(d.getTempoRisposta() * 1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println("Go next");
            impostazioni.incrementaIndice();
        }
        send("Fine partita!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        String classifica = "";
        utenti.sort(Comparator.comparing(Utente::getPunti));
        for(int i = 0; i<utenti.size(); i++) {
            classifica += "#" + (i + 1) + " " + utenti.get(i).getNickname() + "\n";
        }
        send(classifica);
    }
    
    public void send(String msg) {
        for(int i = 0; i<output.size(); i++) {
            output.get(i).println(msg);
        }
    }
}
