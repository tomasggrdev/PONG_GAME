package pong_game.juego;

import java.awt.*;
import java.awt.event.*;

public class Raqueta extends Rectangle {

    private int id;
    private int velocidadY;
    private int velocidad = 10;


    public Raqueta(int x, int y, int anchoRaqueta, int altoRaqueta, int id) {
        super(x, y, anchoRaqueta, altoRaqueta);
        this.id = id;
    }

    public void cambiarDireccionY(int direccionY) {
        velocidadY = direccionY;
    }

    public void mover() {
        y = y + velocidadY;
    }

    public void dibujar(Graphics g) {
        if (id == 1) {
            g.setColor(Color.BLUE);
        }
        if (id == 2) {
            g.setColor(Color.RED);
        }

        g.fillRect(x, y, width, height);

    }

    public void keyPressed(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    cambiarDireccionY(-velocidad);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    cambiarDireccionY(velocidad);
                }
                break;


            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    cambiarDireccionY(-velocidad);
                    mover();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    cambiarDireccionY(velocidad);
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    cambiarDireccionY(0);

                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    cambiarDireccionY(0);
                }
                break;

            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    cambiarDireccionY(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    this.cambiarDireccionY(0);
                }
                break;
        }
    }
}
