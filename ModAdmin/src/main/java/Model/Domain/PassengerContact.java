package Model.Domain;

import DataStructures.Array;
import Model.Domain.AbstractClasses.AbstractPerson;

public class PassengerContact extends AbstractPerson {
    public PassengerContact(String names, String lastNames, Array<String> phoneNumbers) {
        super(names, lastNames, phoneNumbers);
    }

    public static PassengerContact returnEmptyPassengerContact() {
        return new PassengerContact("", "", new Array<>(1));
    }

}
