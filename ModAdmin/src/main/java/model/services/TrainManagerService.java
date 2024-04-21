package model.services;

import model.crud.repository.TrainRepository;
import model.domain.Brand;
import model.domain.Train;
import model.environment.Environment;
import model.environment.IdGenerator;
import model.interfaces.CRUD.TrainRepoInterface;
import model.interfaces.communication.sendToClient.TrainManagerClientInterface;
import model.interfaces.communication.sendToServer.TrainManagerServerInterface;
import dataStructures.ArrayList;
import dataStructures.Interfaces.List;

import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TrainManagerService extends UnicastRemoteObject implements TrainManagerClientInterface, TrainManagerServerInterface {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String jsonTrainsPath;

    public TrainManagerService() throws RemoteException {
        super();
        ArrayList<String> properties = Environment.getInstance().getVariables();
        jsonTrainsPath = properties.get(3) + "trains.json";
    }

    @Override
    public List<Train> getTrains() throws Exception {
        TrainRepoInterface trainRepo = new TrainRepository(jsonTrainsPath);
        return trainRepo.getTrains();
    }

    @Override
    public Boolean addTrain(String trainName, int i, double v, Brand brandByName) throws Exception {
        TrainRepoInterface trainRepo = new TrainRepository(jsonTrainsPath);
        Train train = new Train(trainName, "T"+ IdGenerator.generateTrainId(), i, v, brandByName);
        return trainRepo.insert(train);
    }

    @Override
    public Boolean removeTrain(Train train) throws Exception {
        TrainRepository trainRepo = new TrainRepository(jsonTrainsPath);
        if (train.getInRoute()){
            return false;
        }
        return trainRepo.delete(train);
    }

    @Override
    public Boolean updateTrain(Train train) throws Exception {
        TrainRepository trainRepo = new TrainRepository(jsonTrainsPath);
        if (train.getInRoute()){
            return false;
        }
        return trainRepo.update(train);
    }
}
