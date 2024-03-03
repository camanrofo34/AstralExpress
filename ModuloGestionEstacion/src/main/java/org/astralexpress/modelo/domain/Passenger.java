/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import org.model.array.Array;

/**
 *
 * @author admin
 */
public class Passenger extends AbstractPerson{
    private String idPassenger;
    private String idType;
    private String homeAdress;

    public Passenger(String idPassenger, String idType, String homeAdress, String names, String lastNames, Array<String> phoneNumbers) {
        super(names, lastNames, phoneNumbers);
        this.idPassenger = idPassenger;
        this.idType = idType;
        this.homeAdress = homeAdress;
    }

    
    
    
}
