/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import org.model.io.array.Array;



/**
 *
 * @author PC 4060TI
 */
public class PassengerContact extends AbstractPerson{

    public PassengerContact(String names, String lastNames, Array<String> phoneNumbers) {
        super(names, lastNames, phoneNumbers);
    }
    
    public static PassengerContact returnEmptyPassengerContact(){
        return new PassengerContact("", "", new Array<>(1));
    }
    
}
