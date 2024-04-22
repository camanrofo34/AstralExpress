package model;

import model.domain.Brand;
import model.domain.Train;
import model.interfaces.communication.sendToClient.TrainManagerClientInterface;
import model.interfaces.communication.sendToServer.TrainManagerServerInterface;
import model.messenger.Messenger;
import dataStructures.Interfaces.List;

import java.rmi.Naming;

public class TrainModel {
    private final String uri;

    private Messenger messenger;
    /**
     * Constructor
     * @param uri
     */
    public TrainModel(String uri) {
        this.messenger = new Messenger("");
        this.uri = uri;
    }
    /**
     * This method is used to get the uri
     * @return String - Uri
     */
    public List<Train> getTrains() throws Exception {
        TrainManagerClientInterface trainManagerClientInterface = (TrainManagerClientInterface) Naming.lookup(uri);
        return trainManagerClientInterface.getTrains();
    }
    /**
     * This method is used to get the uri
     * @return String - Uri
     */
    public Boolean addTrain(String trainName, int i, double v, Brand brandByName) throws Exception {
        TrainManagerServerInterface trainManagerClientInterface = (TrainManagerServerInterface) Naming.lookup(uri);
        return trainManagerClientInterface.addTrain(trainName, i, v, brandByName);
    }
    /**
     * This method is used to get the uri
     * @return String - Uri
     */
    public Boolean editTrain(Train train) throws Exception {
        TrainManagerServerInterface trainManagerClientInterface = (TrainManagerServerInterface) Naming.lookup(uri);
        return trainManagerClientInterface.updateTrain(train);
    }
    /**
     * This method is used to get the uri
     * @return String - Uri
     */
    public Boolean deleteTrain(Train train) throws Exception {
        TrainManagerServerInterface trainManagerClientInterface = (TrainManagerServerInterface) Naming.lookup(uri);
        return trainManagerClientInterface.removeTrain(train);
    }
    /**
     * This method is used to get the uri
     * @return String - Uri
     */
    public Messenger getMessenger() {
        return messenger;
    }

}
