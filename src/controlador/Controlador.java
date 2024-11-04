package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import modelo.Bola;

public class Controlador implements Initializable {
    @FXML
    Pane panel;
    @FXML
    Circle bolaAzul;
    Bola miBola;

    AnimationTimer timer;
    boolean pararTodo, pararAzul;

    public Controlador() {

        pararAzul = false;
        timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if (!pararAzul) {
                if (((miBola.getBola().getLayoutX() + miBola.getSentidoX() + 10) >= 800) || ((miBola.getBola().getLayoutX() + miBola.getSentidoX() - 10) <= 0)) {
                    pararAzul=true;
                }
                miBola.getBola().setLayoutX(miBola.getBola().getLayoutX()+miBola.getSentidoX());
            } else {
                miBola.getBola().setFill(Color.RED);
                timer.stop(); //game over
            }
            if (!pararAzul) {
                if (((miBola.getBola().getLayoutY() + miBola.getSentidoY() + 10) >= 800) || ((miBola.getBola().getLayoutY() + miBola.getSentidoY() - 10) <= 0)) {
                    pararAzul=true;
                }
                miBola.getBola().setLayoutY(miBola.getBola().getLayoutY()+miBola.getSentidoY());
            } else {
                timer.stop(); //game over
            }
           
            }

        };
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        panel.setFocusTraversable(true);
        timer.start();
        miBola = new Bola(bolaAzul);

    }

    public void teclaPulsada(KeyEvent tecla) {
        KeyCode code = tecla.getCode();
        switch (code) {
            case UP:
                miBola.setSentidoX(0);
                miBola.setSentidoY(-1);
                break;
            case DOWN:
                miBola.setSentidoX(0);
                miBola.setSentidoY(+1);
                break;
            case RIGHT:
                miBola.setSentidoX(+1);
                miBola.setSentidoY(0);
                break;
            case LEFT:
                miBola.setSentidoX(-1);
                miBola.setSentidoY(0);
                break;
            default:
                break;
        }
    }
}
