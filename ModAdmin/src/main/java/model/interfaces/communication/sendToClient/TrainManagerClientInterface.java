package model.interfaces.communication.sendToClient;

import model.domain.Train;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface TrainManagerClientInterface extends Remote {

    List<Train> getTrains() throws Exception;


}
