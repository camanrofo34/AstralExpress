/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import java.io.Serializable;

/**
 *
 * @author PC 4060TI
 */
public class PassengersVagonEntity implements Serializable{
    String idVagon;

    public PassengersVagonEntity(String idVagon, String idSeatInit) {
        this.idVagon = idVagon;
    }
    
}
