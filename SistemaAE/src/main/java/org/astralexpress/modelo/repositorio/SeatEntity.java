/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import java.io.Serializable;

/**
 * @author PC 4060TI
 */
public class SeatEntity implements Serializable {
    String idSeat;
    String Class;

    public SeatEntity(String idSeat, String Class) {
        this.idSeat = idSeat;
        this.Class = Class;
    }
}
