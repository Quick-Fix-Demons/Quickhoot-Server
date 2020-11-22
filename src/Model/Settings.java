/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Quick Fix Demons
 */
public class Settings {
    public static final int PORT = 9991;
    private static List<Domanda> questions;
    private int indiceDomanda;
    
    public Settings() {
        this.questions = new ArrayList<>();
        
        questions.add(new Domanda("\"Sommo\" è il cognome del sommo?", 20, true, 0));
        questions.add(new Domanda("In quante persone hanno lavorato al progetto?", 20, false, new String[] {
            "0",
            "4",
            "2",
            "86"
        }, 0));
        questions.add(new Domanda("Tolve è un grande uomo.", 20, true, 1));
        
        this.indiceDomanda = 0;
    }

    public List<Domanda> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Domanda> questions) {
        Settings.questions = questions;
    }

    public int getIndiceDomanda() {
        return indiceDomanda;
    }

    public void setIndiceDomanda(int indiceDomanda) {
        this.indiceDomanda = indiceDomanda;
    }
    
    public Domanda getDomandaAttuale() {
        return this.questions.get(indiceDomanda);
    }
    
    public void incrementaIndice() {
        this.indiceDomanda++;
    }
    
}
