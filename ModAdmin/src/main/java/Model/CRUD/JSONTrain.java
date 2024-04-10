package Model.CRUD;

import DataStructures.Interfaces.List;
import Model.CRUD.Shared.FileJsonAdapter;
import Model.Domain.Train;

public class JSONTrain {
    private static final String TRAIN_FILE_PATH = "trains.json";
    private final FileJsonAdapter<Train> fileJsonAdapter;

    public JSONTrain() {
        this.fileJsonAdapter = FileJsonAdapter.getInstance();
    }

    public List<Train> getTrains() {
        return fileJsonAdapter.getObjects(TRAIN_FILE_PATH, Train[].class);
    }


    public Boolean writeTrains(List<Train> trains) {
        return fileJsonAdapter.writeObjects(TRAIN_FILE_PATH, trains);
    }

}
