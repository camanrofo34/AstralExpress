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
public class PassengerEntity implements Serializable{
    String idPassenger;
    String idType;
    String homeAdress;

    public PassengerEntity(String idPassenger, String idType, String homeAdress) {
        this.idPassenger = idPassenger;
        this.idType = idType;
        this.homeAdress = homeAdress;
    }   
}
