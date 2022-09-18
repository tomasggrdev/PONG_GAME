package pong_game.juego;

import java.awt.*;
import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import javax.swing.*;

public class Puntaje extends Rectangle {

    public static int WIDTH;
    public static int HEIGHT;
    private int jugador1;
    private int jugador2;
    private long timer;
    private int gameMode;

    public Puntaje(int width, int height, int gameMode){
        Puntaje.WIDTH = width;
        Puntaje.HEIGHT = height;
        timer = System.currentTimeMillis();
        this.gameMode = gameMode;
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
    
    public void guardarPuntaje(String nombre){
        
        try
        {   
            // leyendo archivo
            FileInputStream file = new FileInputStream("src/pong_game/juego/puntajes.txt");
            ObjectInputStream in = new ObjectInputStream(file);
              
            // deserializando archivo
            RegistroPuntaje object1 = (RegistroPuntaje)in.readObject();
              
            in.close();
            file.close();
            
            object1.agregarPuntaje(nombre,((System.currentTimeMillis() - timer)/100));
            
            FileOutputStream file1 = new FileOutputStream("src/pong_game/juego/puntajes.txt");
            ObjectOutputStream out = new ObjectOutputStream(file1);
              
            // seriaizando objeto
            out.writeObject(object1);
              
            out.close();
            file.close();
              
            
        } catch(IOException e)
        {
            System.out.println(e.getMessage());
        } catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void dibujar (Graphics g){
        //linea blanca
        g.setColor(Color.WHITE);
        g.setFont(new Font("Consolas",Font.PLAIN,60));
        g.drawLine(WIDTH/2,0, WIDTH/2, HEIGHT);
        //mostrar puntos
        g.drawString(String.valueOf(jugador1),WIDTH/2 - 33 - 80,50);
        g.drawString(String.valueOf(jugador2),WIDTH/2 + 80,50);
        if(gameMode == 1){
            g.drawString(String.valueOf((System.currentTimeMillis() - timer)/100),WIDTH/4 - 80,50);
            }
    }

}
