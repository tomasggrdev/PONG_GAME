package pong_game.juego;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Frame extends JFrame {

    private Tablero tablero;

    public Frame(int gameMode) {
        
        tablero = new Tablero(this,gameMode);
        this.add(tablero);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
    
    public Frame(int gameMode, String nombre) {
        
        tablero = new Tablero(this,gameMode,nombre);
        this.add(tablero);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    
    
    
}
