package model.interfaces.communication.sendToServer;

import model.domain.Brand;
import model.domain.Train;

import java.rmi.Remote;

public interface TrainManagerServerInterface extends Remote {
    /**
     * Add a train
     * @param trainName
     * @param i
     * @param v
     * @param brandByName
     * @return
     * @throws Exception
     */
    Boolean addTrain(String trainName, int i, double v, Brand brandByName) throws Exception;
    /**
     * Remove a train
     * @param train
     * @return
     * @throws Exception
     */
    Boolean removeTrain(Train train) throws Exception;
    /**
     * Update a train
     * @param train
     * @return
     * @throws Exception
     */
    Boolean updateTrain(Train train) throws Exception;
}
