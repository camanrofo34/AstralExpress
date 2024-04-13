package Model.Interfaces.CRUD;

import DataStructures.Interfaces.List;
import Model.CRUD.Repository.Entities.TrainEntity;
import Model.Domain.Train;

import java.rmi.Remote;

public interface TrainRepoInterface extends Remote {
    Boolean insert(Train train) throws Exception;

    Boolean delete(Train train) throws Exception;

    Boolean update(Train train) throws Exception;

    Train getTrain(String idTrain) throws Exception;

    List<Train> getTrains() throws Exception;
}
