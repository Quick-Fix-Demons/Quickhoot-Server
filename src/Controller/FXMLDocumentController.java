/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Quick Fix Demons
 */
public class FXMLDocumentController implements Initializable {
    AccettaClient thread;
    InviaDomande send;
    AccettaRisposte receive;
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        // Fine accettazione client
        thread.ferma();
        
        // Ricezione e invio domande e risposte
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Fase accettazione client
        thread = new AccettaClient();
        thread.start();
        
    } 
    
}
