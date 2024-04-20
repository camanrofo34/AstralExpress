package Model.Services;

import Model.CRUD.Repository.TrainRepository;
import Model.Domain.Brand;
import Model.Domain.Train;
import Model.Environment.Environment;
import Model.Environment.IdGenerator;
import Model.Interfaces.CRUD.TrainRepoInterface;
import Model.Interfaces.Communication.SendToClient.TrainManagerClientInterface;
import Model.Interfaces.Communication.SendToServer.TrainManagerServerInterface;
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
