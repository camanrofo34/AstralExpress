package Model.Interfaces.Communication.SendToClient;

import dataStructures.Interfaces.List;
import Model.Domain.Train;

import java.rmi.Remote;

public interface TrainManagerClientInterface extends Remote {

    List<Train> getTrains() throws Exception;


}