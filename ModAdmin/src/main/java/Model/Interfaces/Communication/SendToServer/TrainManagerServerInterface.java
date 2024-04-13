package Model.Interfaces.Communication.SendToServer;

import Model.Domain.Train;

import java.rmi.Remote;

public interface TrainManagerServerInterface extends Remote {
    Boolean addTrain(Train train) throws Exception;

    Boolean removeTrain(Train train) throws Exception;

    Boolean updateTrain(Train train) throws Exception;
}
