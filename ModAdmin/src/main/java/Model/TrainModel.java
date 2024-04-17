package Model;

import Model.Interfaces.Communication.SendToServer.TrainManagerServerInterface;
import Model.Messenger.Messenger;
import Model.Services.TrainManagerService;
import dataStructures.Interfaces.List;
import Model.Domain.Train;
import Model.Interfaces.Communication.SendToClient.TrainManagerClientInterface;

import java.rmi.Naming;

public class TrainModel {
    private final String uri;

    private Messenger messenger;

    public TrainModel(String uri) {
        this.messenger = new Messenger("");
        this.uri = uri;
    }

    public List<Train> getTrains () throws Exception{
        TrainManagerClientInterface trainManagerClientInterface = (TrainManagerClientInterface) Naming.lookup(uri);
        return trainManagerClientInterface.getTrains();
    }

    public Boolean addTrain(Train train) throws Exception {
        TrainManagerServerInterface trainManagerClientInterface = (TrainManagerServerInterface) Naming.lookup(uri);
        return trainManagerClientInterface.addTrain(train);
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
