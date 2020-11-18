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
        
        questions.add(new Domanda("Prova domanda 1", 10, true, 0));
        questions.add(new Domanda("Prova domanda 2", 20, false, new String[] {
            "Risposta 1",
            "Risposta 2",
            "Risposta 3",
            "Risposta 4"
        }, 3));
        questions.add(new Domanda("Prova domanda 3", 30, true, 1));
        
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
