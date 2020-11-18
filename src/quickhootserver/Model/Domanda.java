/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickhootserver.Model;

/**
 *
 * @author andrea
 */
public class Domanda {
    private String domanda;
    private int tempo=60;
    
    public Domanda(String d, int t){
        this.domanda=d;
        //this.tempo=t;
    }

    public String getDomanda() {
        return domanda;
    }

    public int getTempo() {
        return tempo;
    }

    public void setDomanda(String domanda) {
        this.domanda = domanda;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
    
    
}
