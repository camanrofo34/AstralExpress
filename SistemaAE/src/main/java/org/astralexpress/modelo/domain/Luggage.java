/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import java.io.Serializable;

/**
 * @author PC 4060TI
 */
public class Luggage implements Serializable {
    private String idPassenger;
    private String idVagon;

    public Luggage(String idPassenger, String idVagon) {
        this.idPassenger = idPassenger;
        this.idVagon = idVagon;
    }


}
