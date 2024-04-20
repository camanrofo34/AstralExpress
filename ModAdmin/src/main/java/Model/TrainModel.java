package Model;

import Model.Domain.Brand;
import Model.Domain.Train;
import Model.Interfaces.Communication.SendToClient.TrainManagerClientInterface;
import Model.Interfaces.Communication.SendToServer.TrainManagerServerInterface;
import Model.Messenger.Messenger;
import dataStructures.Interfaces.List;

import java.rmi.Naming;

public class TrainModel {
    private final String uri;

    private Messenger messenger;

    public TrainModel(String uri) {
        this.messenger = new Messenger("");
        this.uri = uri;
    }

    public List<Train> getTrains() throws Exception {
        TrainManagerClientInterface trainManagerClientInterface = (TrainManagerClientInterface) Naming.lookup(uri);
        return trainManagerClientInterface.getTrains();
    }

    public Boolean addTrain(String trainName, int i, double v, Brand brandByName) throws Exception {
        TrainManagerServerInterface trainManagerClientInterface = (TrainManagerServerInterface) Naming.lookup(uri);
        return trainManagerClientInterface.addTrain(trainName, i, v, brandByName);
    }

    public Boolean editTrain(Train train) throws Exception {
        TrainManagerServerInterface trainManagerClientInterface = (TrainManagerServerInterface) Naming.lookup(uri);
        return trainManagerClientInterface.updateTrain(train);
    }

    public Boolean deleteTrain(Train train) throws Exception {
        TrainManagerServerInterface trainManagerClientInterface = (TrainManagerServerInterface) Naming.lookup(uri);
        return trainManagerClientInterface.removeTrain(train);
    }

    public Messenger getMessenger() {
        return messenger;
    }

}
