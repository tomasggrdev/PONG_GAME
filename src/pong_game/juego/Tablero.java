package pong_game.juego;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Tablero extends JPanel implements Runnable {

    static final int WITH =1500;
    static final int HEIGHT = (int)(Tablero.WITH*(0.5555));
    static final Dimension TAMANO_PANTALLA = new Dimension(WITH,HEIGHT);
    static final int DIAMETRO_BOLA = 20;
    static final int ANCHO_RAQUETA = 25;
    static final int Alto_RAQUETA = 110;
    Thread hiloJuego ;
    Image imagen;
    Graphics graficos;
    
    Thread musicaJuego;
    Random random;
    Raqueta raqueta1;
    Raqueta raqueta2;
    Bola bola;
    Puntaje puntaje;

    public Tablero(){
        establecerRaquetas();
        establecerBola();
        puntaje = new Puntaje(WITH,HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new ActionListener());
        this.setPreferredSize(TAMANO_PANTALLA);

        hiloJuego = new Thread(this);
        hiloJuego.start();

        
        


    }

    public void establecerBola(){
        random = new Random();
        bola = new Bola(WITH/2 - DIAMETRO_BOLA/2, random.nextInt(HEIGHT - DIAMETRO_BOLA/2),DIAMETRO_BOLA,DIAMETRO_BOLA);
    }
    public void establecerRaquetas(){
        raqueta1 = new Raqueta(0,HEIGHT/2 - (Alto_RAQUETA/2),ANCHO_RAQUETA,Alto_RAQUETA,1);
        raqueta2 = new Raqueta(WITH - ANCHO_RAQUETA,HEIGHT/2 - (Alto_RAQUETA/2),ANCHO_RAQUETA,Alto_RAQUETA,2);

    }

    public void paint(Graphics g){
        imagen = createImage(getWidth(),getHeight());
        graficos = imagen.getGraphics();
        dibujar(graficos);
        g.drawImage(imagen,0,0,this);

    }

    public void dibujar(Graphics g){
        raqueta1.dibujar(g);
        raqueta2.dibujar(g);
        bola.dibujar(g);
        puntaje.dibujar(g);
    }
    public void mover(){
        raqueta1.mover();
        raqueta2.mover();
        bola.mover();
    }
    public void chekearColision(){
        //frenar paletas en los limites verticales
        if(raqueta1.y <= 0) raqueta1.y = 0;
        if(raqueta1.y >= HEIGHT-Alto_RAQUETA)  raqueta1.y = HEIGHT-Alto_RAQUETA;
        if(raqueta2.y <= 0) raqueta2.y = 0;
        if(raqueta2.y >= HEIGHT-Alto_RAQUETA)  raqueta2.y = HEIGHT-Alto_RAQUETA;
        //Hacer que la pelota rebote en los limites verticales
        if(bola.y <= 0 ) bola.cambiarDireccionY(-bola.getVelocidadY());
        if(bola.y >= HEIGHT - DIAMETRO_BOLA ) bola.cambiarDireccionY(-bola.getVelocidadY());
        //Hacer que la pelota interactue con las raquetas
        if(bola.intersects(raqueta1) || bola.intersects(raqueta2)){
            bola.cambiarDireccionX(-bola.getVelocidadX());
            if(bola.getVelocidadX() > 0){
                bola.setVelocidadX(bola.getVelocidadX()+1);

            } else {
                bola.setVelocidadX(bola.getVelocidadX()-1);
            }
            if(bola.getVelocidadY() > 0){
                bola.setVelocidadY(bola.getVelocidadY()+1);

            } else {
                bola.setVelocidadY(bola.getVelocidadY()-1);
            }
        }
        //Dar puntos al ganador y reestablecer el juego
        if(bola.x <= 0){
            puntaje.setJugador2(puntaje.getJugador2()+1);
            establecerRaquetas();
            establecerBola();
        }
        if(bola.x >= WITH - DIAMETRO_BOLA){
            puntaje.setJugador1(puntaje.getJugador1()+1);
            establecerRaquetas();
            establecerBola();
        }
        if(puntaje.getJugador1() == 10 || puntaje.getJugador2() == 10){
            musicaJuego.stop();
        }

    }
    public void run(){
        //game loop
        long ultimaVez = System.nanoTime();
        double fotogramasPorSegundo = 60.0;
        double nanoSegundo = 1000000000/ fotogramasPorSegundo;
        double delta = 0;
        while(true){
            long now = System.nanoTime();
            delta += (now - ultimaVez)/nanoSegundo;
            ultimaVez = now;
            if(delta >= 1){
                mover();
                chekearColision();
                repaint();
                delta--;
            }

        }
    }
    public class ActionListener extends KeyAdapter{

        public void keyPressed(KeyEvent e){
            raqueta1.keyPressed(e);
            raqueta2.keyPressed(e);
        }

        public void keyReleased(KeyEvent e){
            raqueta1.keyReleased(e);
            raqueta2.keyReleased(e);
        }

    }
}
