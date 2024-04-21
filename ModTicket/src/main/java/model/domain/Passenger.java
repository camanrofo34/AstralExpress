package model.domain;

import dataStructures.Array;
import model.domain.abstractClasses.AbstractPerson;

public class Passenger extends AbstractPerson {
    private String idType;
    private String homeAdress;
    private PassengerContact passengerContact;

    public Passenger(String idPassenger, String idType, String homeAdress, PassengerContact passengerContact, String names, String lastNames, Array<String> phoneNumbers) {
        super(idPassenger, idType, lastNames, phoneNumbers);
        this.idType = idType;
        this.homeAdress = homeAdress;
        this.passengerContact = passengerContact;
    }

    public static Passenger returnNullPassenger() {
        return new Passenger("", "", "", PassengerContact.returnNullPassengerContact(), "", "", new Array<>(1));
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getHomeAdress() {
        return homeAdress;
    }

    public void setHomeAdress(String homeAdress) {
        this.homeAdress = homeAdress;
    }

    public PassengerContact getPassengerContact() {
        return passengerContact;
    }

    public void setPassengerContact(PassengerContact passengerContact) {
        this.passengerContact = passengerContact;
    }
}
