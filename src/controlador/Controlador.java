package controlador;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

public class Controlador implements Initializable {
    @FXML
    Pane panel;
    @FXML
    Circle bolaAzul;

    @FXML
    Circle bolaRoja;

    AnimationTimer timer;
    int sentidoAzul;
    int sentidoRojo;
    boolean pararTodo, pararRojo, pararAzul;

    public Controlador() {

        sentidoAzul = 1;
        sentidoRojo = -1;
        pararTodo = false;
        pararAzul = false;
        pararRojo = false;
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!pararTodo) {
                    if (!pararAzul) {
                        if ((bolaAzul.getLayoutX() + sentidoAzul + 10) >= 800) {
                            sentidoAzul = sentidoAzul * -1;
                        } else if ((bolaAzul.getLayoutX() + sentidoAzul - 10) <= 0) {
                            sentidoAzul = sentidoAzul * -1;
                        }
                        bolaAzul.setLayoutX(bolaAzul.getLayoutX() + sentidoAzul);
                    } else {
                        sentidoAzul = 0;
                    }
                    if (!pararRojo) {
                        if ((bolaRoja.getLayoutX() + sentidoRojo + 10) >= 800) {
                            sentidoRojo = sentidoRojo * -1;
                        } else if ((bolaRoja.getLayoutX() + sentidoRojo - 10) <= 0) {
                            sentidoRojo = sentidoRojo * -1;
                        }
                        bolaRoja.setLayoutX(bolaRoja.getLayoutX() + sentidoRojo);
                    } else {
                        sentidoRojo = 0;
                    }
                } else {
                    sentidoRojo = 0;
                    sentidoAzul = 0;
                }
            }

        };
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        panel.setFocusTraversable(true);
        timer.start();

    }

    public void teclaPulsada(KeyEvent tecla) {
        KeyCode code = tecla.getCode();
        switch (code) {
            case R:
                if (pararRojo == true) {
                    sentidoRojo = 1;
                    pararRojo = false;
                } else {
                    pararRojo = true;
                }
                break;
            case A:
                if (pararAzul == true) {
                    sentidoAzul = 1;
                    pararAzul = false;
                } else {
                    pararAzul = true;
                }
                break;
            case T:
                pararTodo = true;
                break;
            case E:
                pararTodo = false;
                pararAzul = false;
                pararRojo = false;
                sentidoAzul = 1;
                sentidoRojo = -1;
                break;
            default:

                break;
        }

    }
}
