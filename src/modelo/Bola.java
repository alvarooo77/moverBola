package modelo;

import javafx.scene.shape.Circle;

public class Bola {
    private Circle bola;
    private int sentidoY;
    private int sentidoX;

    //Constructor
    public Bola(Circle bola) {
        this.bola = bola;
        this.sentidoY = 0;
        this.sentidoX = 0;
        
    }

    //Getter and Setter
    public Circle getBola() {
        return bola;
    }
    public void setBola(Circle bola) {
        this.bola = bola;
    }
    public int getSentidoY() {
        return sentidoY;
    }
    public void setSentidoY(int sentidoY) {
        this.sentidoY = sentidoY;
    }
    public int getSentidoX() {
        return sentidoX;
    }
    public void setSentidoX(int sentidoX) {
        this.sentidoX = sentidoX;
    }
    

    
}
