package model.interfaces.communication.sendToClient;

import model.domain.Train;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface TrainManagerClientInterface extends Remote {
    /**
     * Get the Trains
     * @return
     * @throws Exception
     */
    List<Train> getTrains() throws Exception;


}
