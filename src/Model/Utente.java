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
public class Utente {
    private String nickname;
    private int punti;
    private int ID;

    public Utente(String nickname, int id, int punti) {
        this.nickname = nickname;
        this.ID = id;
        this.punti = punti;
    }
    
    public void addPoints(int points) {
        this.punti += punti;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPunti() {
        return punti;
    }

    public void setPunti(int punti) {
        this.punti = punti;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    
}
