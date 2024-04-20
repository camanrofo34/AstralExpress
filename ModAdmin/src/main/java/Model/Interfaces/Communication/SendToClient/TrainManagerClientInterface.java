package Model.Interfaces.Communication.SendToClient;

import Model.Domain.Train;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface TrainManagerClientInterface extends Remote {

    List<Train> getTrains() throws Exception;


}
