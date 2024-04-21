package model.interfaces.communication.sendToServer;

import model.domain.Brand;
import model.domain.Train;

import java.rmi.Remote;

public interface TrainManagerServerInterface extends Remote {
    Boolean addTrain(String trainName, int i, double v, Brand brandByName) throws Exception;

    Boolean removeTrain(Train train) throws Exception;

    Boolean updateTrain(Train train) throws Exception;
}
