/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import org.model.io.array.Array;

import java.io.Serializable;


/**
 *
 * @author admin
 */
public class Passenger extends AbstractPerson implements Serializable{
    private String idPassenger;
    private String idType;
    private String homeAdress;
    private PassengerContact passengerContact;

    public Passenger(String idPassenger, String idType, String homeAdress, PassengerContact passengerContact, String names, String lastNames, Array<String> phoneNumbers) {
        super(names, lastNames, phoneNumbers);
        this.idPassenger = idPassenger;
        this.idType = idType;
        this.homeAdress = homeAdress;
        this.passengerContact = passengerContact;
    }
    
    public static Passenger returnNullPassenger(){
        return new Passenger("", "", "", PassengerContact.returnEmptyPassengerContact(), "", "", new Array<>(1));
    }

    
    
}
