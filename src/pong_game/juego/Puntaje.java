package pong_game.juego;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Puntaje extends Rectangle {

    public static int WIDTH;
    public static int HEIGHT;
    private int jugador1;
    private int jugador2;

    public Puntaje(int width, int height){
        Puntaje.WIDTH = width;
        Puntaje.HEIGHT = height;
    }

    public int getJugador1() {
        return jugador1;
    }

    public int getJugador2() {
        return jugador2;
    }

    public void setJugador1(int jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(int jugador2) {
        this.jugador2 = jugador2;
    }

    public void dibujar (Graphics g){
        //linea blanca
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas",Font.PLAIN,60));
        g.drawLine(WIDTH/2,0, WIDTH/2, HEIGHT);
        //mostrar puntos
        g.drawString(String.valueOf(jugador1),WIDTH/2 - 33 - 80,50);
        g.drawString(String.valueOf(jugador2),WIDTH/2 + 80,50);
    }

}
