package model.interfaces.CRUD;

import model.domain.Train;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface TrainRepoInterface extends Remote {
    Boolean insert(Train train) throws Exception;

    Boolean delete(Train train) throws Exception;

    Boolean update(Train train) throws Exception;

    Train getTrain(String idTrain) throws Exception;

    List<Train> getTrains() throws Exception;
}
