package model.interfaces.crud;

import model.domain.Passenger;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface PassengerRepoInterface extends Remote {
    /**
     * Insert a Passenger in the repository
     * @param passenger Passenger to be inserted
     * @return true if the Passenger was inserted, false if not
     */
    Boolean insert(Passenger passenger) throws Exception;
    /**
     * Delete a Passenger in the repository
     * @param passenger Passenger to be deleted
     * @return true if the Passenger was deleted, false if not
     */
    Boolean delete(Passenger passenger) throws Exception;
    /**
     * Update a Passenger in the repository
     * @param passenger Passenger to be updated
     * @return true if the Passenger was updated, false if not
     */
    Boolean update(Passenger passenger) throws Exception;
    /**
     * Get a Passenger from the repository
     * @param idPassenger Passenger to be obtained
     * @return Passenger if the Passenger was found, null if not
     */
    Passenger getPassenger(String idPassenger) throws Exception;
    /**
     * Get all Passengers from the repository
     * @return List of Passengers
     */
    List<Passenger> getPassengers() throws Exception;
}
