package Model.Interfaces.CRUD;

import DataStructures.Interfaces.List;
import Model.Domain.PassengerContact;

import java.rmi.Remote;

public interface PassengerContactRepoInterface extends Remote {
    Boolean insert(PassengerContact passengerContact) throws Exception;

    Boolean delete(PassengerContact passengerContact) throws Exception;

    Boolean update(PassengerContact passengerContact) throws Exception;

    PassengerContact getPassengerContact(String idPassenger) throws Exception;

    List<PassengerContact> getPassengerContacts() throws Exception;
}
