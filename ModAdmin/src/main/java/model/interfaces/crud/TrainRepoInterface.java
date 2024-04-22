package model.interfaces.crud;

import model.domain.Train;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface TrainRepoInterface extends Remote {
    /**
     * Insert a Train in the repository
     * @param train Train to be inserted
     * @return true if the Train was inserted, false if not
     */
    Boolean insert(Train train) throws Exception;

    /**
     * Delete a Train in the repository
     * @param train Train to be deleted
     * @return true if the Train was deleted, false if not
     */
    Boolean delete(Train train) throws Exception;
    /**
     * Update a Train in the repository
     * @param train Train to be updated
     * @return true if the Train was updated, false if not
     */
    Boolean update(Train train) throws Exception;
    /**
     * Get a Train from the repository
     * @param idTrain Train to be obtained
     * @return Train if the Train was found, null if not
     */
    Train getTrain(String idTrain) throws Exception;
    /**
     * Get all Trains from the repository
     * @return List of Trains
     */
    List<Train> getTrains() throws Exception;
}
