package model.domain;

import dataStructures.Array;
import model.domain.abstractClasses.AbstractPerson;

public class PassengerContact extends AbstractPerson {
    public PassengerContact(String idPerson, String names, String lastNames, Array<String> phoneNumbers) {
        super(idPerson, names, lastNames, phoneNumbers);
    }

    public static PassengerContact returnNullPassengerContact() {
        return new PassengerContact("", "", "", new Array<>(1));
    }

}
