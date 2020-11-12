/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickhootserver.Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alessio
 */
public class Settings {
    private List<String> domande;
    private int port;

    public Settings() {
        this.domande = new ArrayList<>();
        this.port = 9991;
        
        domande.add("Prova prima domanda");
        domande.add("Prova seconda domanda");
        domande.add("Prova terza domanda");
    }
    
}
