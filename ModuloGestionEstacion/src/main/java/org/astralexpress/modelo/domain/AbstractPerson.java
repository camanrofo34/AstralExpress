/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.domain;

import org.model.array.Array;

/**
 *
 * @author PC 4060TI
 */
public class AbstractPerson {
        protected String names;
    protected String lastNames;
    protected Array<String> phoneNumbers;

    protected AbstractPerson() {
        this.names = "";
        this.lastNames = "";
        this.phoneNumbers = new Array<>(1);
    }

    protected AbstractPerson(String names, String lastNames, Array<String> phoneNumbers) {
        this.names = names;
        this.lastNames = lastNames;
        this.phoneNumbers = phoneNumbers;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public Array<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Array<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
