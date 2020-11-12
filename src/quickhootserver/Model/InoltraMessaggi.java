/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickhootserver.Model;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Alessio
 */
public class InoltraMessaggi extends Thread {
    private Socket socket;
    private List<PrintWriter> output;
    private Scanner scanner;
    private int ID;
    private boolean inseritoNome;
    private List<String> utenti;
    private String welcomeMSG[];
    private Random rand;

    public InoltraMessaggi(String name, Socket s, List<PrintWriter> out, List<String> users, int IDConnessione) {
        super(name);
        this.ID = IDConnessione;
        this.socket = s;
        this.output = out;
        this.utenti = users;
        this.inseritoNome = true;
        try {
            scanner = new Scanner(socket.getInputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String[] messaggi = {
            "è entrato nella chat gamer123 brrrr",
            "è entrato, tenete la mia birra.",
            "è pronto a spaccare.",
            "tic toc, il tempo scorre.",
            "spero che tu abbia della pizza.",
            "è entrato, accendete le luci che sembra una sagra."
        };
        this.welcomeMSG = messaggi;
        rand = new Random();
    }

    @Override
    public void run() {
        while(true) {
            String msg = scanner.nextLine();
            if(inseritoNome) {
                this.setName(msg);
                utenti.add(msg);
                inseritoNome = false;
                msg += " " + welcomeMSG[rand.nextInt(welcomeMSG.length)];
                send(msg);
            }
            else if(msg.startsWith("/")) {
                if(msg.toLowerCase().equals("/end")) {
                    send(this.getName() + " è uscito dalla chat WTF BRO");
                    utenti.remove(this.getName());
                    try {
                        socket.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    this.interrupt();
                }
                else if(msg.toLowerCase().equals("/userlist")) {
                    String risposta = "Lista utenti online:\n";
                    for(int i = 0; i<utenti.size(); i++) {
                        risposta += "- " + utenti.get(i);
                        if(i != utenti.size()-1) risposta += "\n";
                    }
                    output.get(this.ID).println(risposta);
                }
                else {
                    output.get(this.ID).println("Comando non trovato.");
                }
            }
            else {
                send(this.getName() + ": " + msg);
            }
        }
    }
    
    public void send(String msg) {
        for(int i = 0; i<output.size(); i++) {
            if(i != this.ID) {
                output.get(i).println(msg);
            }
        }
    }
}
