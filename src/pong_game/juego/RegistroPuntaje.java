/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pong_game.juego;
import java.io.*;
import java.util.*;
/**
 *
 * @author Dm
 */
public class RegistroPuntaje implements Serializable {
    private static final long serialVersionUID = -5358925216554609930L;
    
    private TreeMap<String,Long> records;
    
    public RegistroPuntaje(){
        records = new TreeMap();
    } 
    
    public void agregarPuntaje(String nombre, long puntaje){
        
        
        nombre = nombre.toUpperCase();
        if(records.get(nombre) != null){
            if(puntaje > records.get(nombre)){
                records.replace(nombre, puntaje);
            }
        } else {
            records.put(nombre, puntaje);
        }
        
    }

    public TreeMap<String, Long> getRecords() {
        return records;
    }
    

    
     
}

