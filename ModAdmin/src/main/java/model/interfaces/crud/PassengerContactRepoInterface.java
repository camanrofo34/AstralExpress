package model.interfaces.crud;

import model.domain.PassengerContact;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface PassengerContactRepoInterface extends Remote {
    /**
     * Insert a PassengerContact in the repository
     * @param passengerContact PassengerContact to be inserted
     * @return true if the PassengerContact was inserted, false if not
     */
    Boolean insert(PassengerContact passengerContact) throws Exception;

    /**
     * Delete a PassengerContact in the repository
     * @param passengerContact PassengerContact to be deleted
     * @return true if the PassengerContact was deleted, false if not
     */
    Boolean delete(PassengerContact passengerContact) throws Exception;
    /**
     * Update a PassengerContact in the repository
     * @param passengerContact PassengerContact to be updated
     * @return true if the PassengerContact was updated, false if not
     */
    Boolean update(PassengerContact passengerContact) throws Exception;
    /**
     * Get a PassengerContact from the repository
     * @param idPassenger PassengerContact to be obtained
     * @return PassengerContact if the PassengerContact was found, null if not
     */
    PassengerContact getPassengerContact(String idPassenger) throws Exception;
    /**
     * Get all PassengerContacts from the repository
     * @return List of PassengerContacts
     */
    List<PassengerContact> getPassengerContacts() throws Exception;
}
