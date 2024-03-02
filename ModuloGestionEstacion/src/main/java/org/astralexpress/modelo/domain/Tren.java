/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import org.model.LinkedList.singly.LinkedList;

/**
 *
 * @author PC 4060TI
 */
public class Tren {
    private int idtTren;
    private String nombreTren;
    private double kilometraje;
    private int capacidadVagones;
    Marca marca;
    LinkedList<Vagon> vagones;
    
    private enum Marca { Mercedez_Benz, Arnold }
    
    private boolean iniciarTren(){
        if (capacidadVagones % 3 == 1) return false;
        for (int i=0; i<capacidadVagones/2; i++){
            
        }
    }
}
