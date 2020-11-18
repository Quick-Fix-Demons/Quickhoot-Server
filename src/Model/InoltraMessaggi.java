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
public class InoltraMessaggi extends Thread {
    private Socket socket;
    private List<PrintWriter> output;
    private Scanner scanner;
    private int ID;
    private boolean inseritoNome;
    private List<String> utenti;

    public InoltraMessaggi(String name, Socket s, List<PrintWriter> out, List<String> users, int IDConnessione) {
        super(name);
        this.ID = IDConnessione;
        this.socket = s;
        this.output = out;
        this.utenti = users;
        this.inseritoNome = false;
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
                utenti.add(msg);
                inseritoNome = true;
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
