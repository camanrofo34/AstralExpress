package model.interfaces.CRUD;

import model.domain.PassengerContact;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface PassengerContactRepoInterface extends Remote {
    Boolean insert(PassengerContact passengerContact) throws Exception;

    Boolean delete(PassengerContact passengerContact) throws Exception;

    Boolean update(PassengerContact passengerContact) throws Exception;

    PassengerContact getPassengerContact(String idPassenger) throws Exception;

    List<PassengerContact> getPassengerContacts() throws Exception;
}
