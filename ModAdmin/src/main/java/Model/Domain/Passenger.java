package Model.Domain;

import DataStructures.Array;
import Model.Domain.AbstractClasses.AbstractPerson;

public class Passenger extends AbstractPerson {
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

    public static Passenger returnNullPassenger() {
        return new Passenger("", "", "", PassengerContact.returnEmptyPassengerContact(), "", "", new Array<>(1));
    }

}
