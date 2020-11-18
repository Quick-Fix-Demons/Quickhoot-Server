/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Quick Fix Demons
 */
public class Domanda {
    private String question;
    private int tempoRisposta;
    private boolean trueOrFalse;
    private String[] risposte;
    private int rispostaCorretta;

    /**
     * Per domande con 4 risposte.
     * @param question
     * @param tempoRisposta
     * @param trueOrFalse
     * @param risposte
     * @param rispostaCorretta 
     */
    public Domanda(String question, int tempoRisposta, boolean trueOrFalse, String[] risposte, int rispostaCorretta) {
        this.question = question;
        this.tempoRisposta = tempoRisposta;
        this.trueOrFalse = trueOrFalse;
        this.risposte = risposte;
    }
    
    /**
     * Per domande vero o falso.
     * @param question
     * @param tempoRisposta
     * @param trueOrFalse
     * @param rispostaCorretta 
     */
    public Domanda(String question, int tempoRisposta, boolean trueOrFalse, int rispostaCorretta) {
        this.question = question;
        this.tempoRisposta = tempoRisposta;
        this.trueOrFalse = trueOrFalse;
        this.risposte = null;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getTempoRisposta() {
        return tempoRisposta;
    }

    public void setTempoRisposta(int tempoRisposta) {
        this.tempoRisposta = tempoRisposta;
    }

    public boolean isTrueOrFalse() {
        return trueOrFalse;
    }

    public void setTrueOrFalse(boolean trueOrFalse) {
        this.trueOrFalse = trueOrFalse;
    }

    public String[] getRisposte() {
        return risposte;
    }

    public void setRisposte(String[] risposte) {
        this.risposte = risposte;
    }

    public int getRispostaCorretta() {
        return rispostaCorretta;
    }

    public void setRispostaCorretta(int rispostaCorretta) {
        this.rispostaCorretta = rispostaCorretta;
    }
    
}
