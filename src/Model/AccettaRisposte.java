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

/**
 *
 * @author Quick Fix Demons
 */
public class AccettaRisposte extends Thread {
    private Socket socket;
    private List<PrintWriter> output;
    private Scanner scanner;
    private int ID;
    private boolean inseritoNome;
    private List<Utente> utenti;
    private Settings impostazioni;

    public AccettaRisposte(String name, Socket s, List<PrintWriter> out, List<Utente> users, int IDConnessione, Settings imp) {
        super(name);
        this.ID = IDConnessione;
        this.socket = s;
        this.output = out;
        this.utenti = users;
        this.inseritoNome = false;
        this.impostazioni = imp;
        try {
            scanner = new Scanner(socket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(true) {
            String msg = scanner.nextLine();
            if(!inseritoNome) {
                this.setName(msg);
                utenti.add(new Utente(msg, ID, 0));
                inseritoNome = true;
            }
            else {
                // Da salvare la risposta
                // Nick - Risposta - Tempo
                String[] datiRisposta = msg.split(" - ");
                int risposta = Integer.parseInt(datiRisposta[1]);
                if(risposta == impostazioni.getDomandaAttuale().getRispostaCorretta()) {
                    String nickname = datiRisposta[0];
                    for(Utente u : utenti) {
                        if(u.getNickname().equals(nickname)) {
                            u.addPoints(Integer.parseInt(datiRisposta[2]));
                            send("Risposta corretta (" + datiRisposta[2] + "s)");
                        }
                    }
                }
                else {
                    send("Risposta sbagliata.");
                }
            }
        }
    }
    
    public void send(String msg) {
        for(int i = 0; i<output.size(); i++) {
            if(i == this.ID) {
                output.get(i).println(msg);
            }
        }
    }
}
