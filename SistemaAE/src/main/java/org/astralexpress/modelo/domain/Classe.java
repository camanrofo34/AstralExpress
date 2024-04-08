/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package org.astralexpress.modelo.domain;

import java.io.Serializable;

/**
 * @author PC 4060TI
 */
public enum Classe implements Serializable {
    Estandar(0), Ejecutivo(1), Premium(2);

    private int prioridad;

    private Classe(int prioridad) {
        this.prioridad = prioridad;
    }

    public static Classe findByPriority(String prioridad) {
        for (Classe clase : Classe.values()) {
            if (clase.getPrioridad() == Integer.parseInt(prioridad)) {
                return clase;
            }
        }
        return null;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

}
