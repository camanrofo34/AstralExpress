/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import java.io.Serializable;

/**
 * @author PC 4060TI
 */
public class Seat implements Serializable {

    private String idSeat;
    private Classe Class;

    public Seat(String idSeat, Classe Classe) {
        this.idSeat = idSeat;
        this.Class = Classe;
    }

    public static Seat returnNullSeat() {
        return new Seat("", Classe.findByPriority("Estandar"));
    }

}
