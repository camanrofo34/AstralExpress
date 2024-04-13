package Model.CRUD.Repository;

import DataStructures.ArrayList;
import DataStructures.Interfaces.Iterator;
import DataStructures.Interfaces.List;
import Model.CRUD.Repository.Entities.TrainEntity;
import Model.CRUD.Shared.FileJsonAdapter;
import Model.CRUD.Shared.FileJsonInterface;
import Model.Domain.Brand;
import Model.Domain.Train;
import Model.Interfaces.CRUD.TrainRepoInterface;

public class TrainRepository implements TrainRepoInterface {
    private final FileJsonInterface<TrainEntity> fileJson;
    private final String pathFile;

    public TrainRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    @Override
    public Boolean insert(Train train){
        List<TrainEntity> trains = fileJson.getObjects(pathFile, TrainEntity[].class);
        TrainEntity trainEntity = new TrainEntity(train.getTrainName(), train.getIdTrain(), String.valueOf(train.getCapacity()), String.valueOf(train.getMileage()), train.getBrand().toString());
        trains.add(trainEntity);
        return fileJson.writeObjects(pathFile, trains);
    }

    @Override
    public Boolean delete(Train train){
        List<TrainEntity> trains = fileJson.getObjects(pathFile, TrainEntity[].class);
        TrainEntity trainEntity = new TrainEntity(train.getTrainName(), train.getIdTrain(), String.valueOf(train.getCapacity()), String.valueOf(train.getMileage()), train.getBrand().toString());
        trains.remove(trainEntity);
        return fileJson.writeObjects(pathFile, trains);
    }

    @Override
    public Boolean update(Train train){
        ArrayList<TrainEntity> trains = (ArrayList<TrainEntity>) fileJson.getObjects(pathFile, TrainEntity[].class);
        TrainEntity trainEntity = new TrainEntity(train.getTrainName(), train.getIdTrain(), String.valueOf(train.getCapacity()), String.valueOf(train.getMileage()), train.getBrand().toString());
        for (int i=0; i<trains.size(); i++){
            if (trains.get(i).getIdTrain().equals(train.getIdTrain())){
                trains.set(i, trainEntity);
                return fileJson.writeObjects(pathFile, trains);
            }
        }
        return false;
    }

    @Override
    public Train getTrain(String idTrain){
        List<TrainEntity> trains = fileJson.getObjects(pathFile, TrainEntity[].class);
        Iterator<TrainEntity> it = trains.iterator();
        while (it.hasNext()){
            TrainEntity trainEntity = it.next();
            if (trainEntity.getIdTrain().equals(idTrain)){
                return new Train(trainEntity.getTrainName(), trainEntity.getIdTrain(), Integer.parseInt(trainEntity.getCapacity()), Float.parseFloat(trainEntity.getMileage()), Brand.valueOf(trainEntity.getBrand()));
            }
        }
        return Train.getNullTrain();
    }

    @Override
    public List<Train> getTrains(){
        List<TrainEntity> trains = fileJson.getObjects(pathFile, TrainEntity[].class);
        List<Train> trainsList = new ArrayList<>();
        Iterator<TrainEntity> it = trains.iterator();
        while (it.hasNext()){
            TrainEntity trainEntity = it.next();
            trainsList.add(new Train(trainEntity.getTrainName(), trainEntity.getIdTrain(), Integer.parseInt(trainEntity.getCapacity()), Float.parseFloat(trainEntity.getMileage()), Brand.valueOf(trainEntity.getBrand())));
        }
        return trainsList;
    }
}
