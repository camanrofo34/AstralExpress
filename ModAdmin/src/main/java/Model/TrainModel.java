package Model;

import DataStructures.Interfaces.List;
import Model.Domain.Train;
import Model.Interfaces.Communication.SendToClient.TrainManagerClientInterface;

import java.rmi.Naming;

public class TrainModel {
    private final String uri;

    public TrainModel(String uri) {
        this.uri = uri;
    }

    public List<Train> getTrains () throws Exception{
        TrainManagerClientInterface trainManagerClientInterface = (TrainManagerClientInterface) Naming.lookup(uri);
        return trainManagerClientInterface.getTrains();
    }

}
