package model.interfaces.crud;

import dataStructures.Interfaces.List;
import model.domain.PassengerVagon;

public interface PassengerVagonRepoInterface {
    /**
     * Get all PassengerVagons from the repository
     * @return List of PassengerVagons
     */
    List<PassengerVagon> getPassengerVagons();
    /**
     * Insert a PassengerVagon in the repository
     * @param passengerVagon PassengerVagon to be inserted
     * @return true if the PassengerVagon was inserted, false if not
     */
    Boolean insert(PassengerVagon passengerVagon);
    /**
     * Delete a PassengerVagon in the repository
     * @param passengerVagon PassengerVagon to be deleted
     * @return true if the PassengerVagon was deleted, false if not
     */
    Boolean delete(PassengerVagon passengerVagon);
    /**
     * Update a PassengerVagon in the repository
     * @param passengerVagon PassengerVagon to be updated
     * @return true if the PassengerVagon was updated, false if not
     */
    Boolean update(PassengerVagon passengerVagon);
    /**
     * Get a PassengerVagon from the repository
     * @param idVagon PassengerVagon to be obtained
     * @return PassengerVagon if the PassengerVagon was found, null if not
     */
    PassengerVagon getPassengerVagon(String idVagon);
}
