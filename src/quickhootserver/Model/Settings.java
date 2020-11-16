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
 * @author Quick Fix Demons
 */
public class Settings {
    public static final int PORT = 9991;
    private static List<String> questions;
    
    public Settings() {
        this.questions = new ArrayList<>();
        
        questions.add("Prova prima domanda");
        questions.add("Prova seconda domanda");
        questions.add("Prova terza domanda");
    }
    
}
