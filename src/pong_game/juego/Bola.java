package pong_game.juego;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Bola extends Rectangle {

    private Random random;
    private int velocidadY;
    private int velocidadX;
    private int velocidad = 3;

    public int getVelocidadY() {
        return velocidadY;
    }

    public int getVelocidadX() {
        return velocidadX;
    }

    public void setVelocidadY(int velocidadY) {
        this.velocidadY = velocidadY;
    }

    public void setVelocidadX(int velocidadX) {
        this.velocidadX = velocidadX;
    }

    public Bola(int x, int y, int ancho, int alto){
        super(x,y,ancho,alto);
        random = new Random();
        int randomDireccionX = random.nextInt(2);
        if(randomDireccionX == 0){
            randomDireccionX--;
        }
        cambiarDireccionX(randomDireccionX*velocidad);
        int randomDireccionY = random.nextInt(2);
        if(randomDireccionY == 0){
            randomDireccionY--;
        }
        cambiarDireccionY(randomDireccionY*velocidad);
    }
    public void cambiarDireccionX(int randomX){
        velocidadX = randomX;
    }

    public void cambiarDireccionY(int randomY){
        velocidadY = randomY;
    }

    public void mover(){
        x += velocidadX;
        y += velocidadY;
    }
    public void dibujar(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x,y, height, width);
    }

}
