/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import java.io.Serializable;

/**
 * @author PC 4060TI
 */
public class PassengerEntity implements Serializable {
    String idPassenger;
    String idType;
    String homeAdress;
    String names;
    String lastNames;
    String phoneNumbers;

    public PassengerEntity(String idPassenger, String idType, String homeAdress, String names, String lastNames, String phoneNumbers) {
        this.idPassenger = idPassenger;
        this.idType = idType;
        this.homeAdress = homeAdress;
        this.names = names;
        this.lastNames = lastNames;
        this.phoneNumbers = phoneNumbers;
    }


}
