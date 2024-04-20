package Model.CRUD.Repository;

import Model.CRUD.Repository.Entities.TrainEntity;
import Model.CRUD.Shared.FileJsonAdapter;
import Model.CRUD.Shared.FileJsonInterface;
import Model.Domain.Brand;
import Model.Domain.ChargeVagon;
import Model.Domain.PassengerVagon;
import Model.Domain.Train;
import Model.Interfaces.CRUD.TrainRepoInterface;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

public class TrainRepository implements TrainRepoInterface {
    private final FileJsonInterface<TrainEntity> fileJson;
    private final String pathFile;

    public TrainRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    @Override
    public Boolean insert(Train train) throws Exception {
        List<TrainEntity> trains = fileJson.getObjects(pathFile, TrainEntity[].class);
        PassengerVagonRepository passengerVagonRepository = new PassengerVagonRepository("src/main/resources/Model/JSONFiles/passengerVagons.json");
        ChargeVagonRepository chargeVagonRepository = new ChargeVagonRepository("src/main/resources/Model/JSONFiles/chargeVagons.json");
        TrainEntity trainEntity = new TrainEntity(train.getTrainName(), train.getIdTrain(), String.valueOf(train.getCapacity()), String.valueOf(train.getMileage()), train.getBrand().toString(), Boolean.toString(train.getInRoute()));
        trains.add(trainEntity);
        Iterator<PassengerVagon> it = train.getPassengersVagon().iterator();
        while (it.hasNext()) {
            PassengerVagon passengerVagon = it.next();
            passengerVagonRepository.insert(passengerVagon);
        }
        Iterator<ChargeVagon> it2 = train.getChargeVagon().iterator();
        while (it2.hasNext()) {
            ChargeVagon chargeVagon = it2.next();
            chargeVagonRepository.insert(chargeVagon);
        }
        return fileJson.writeObjects(pathFile, trains);
    }

    @Override
    public Boolean delete(Train train) {
        List<TrainEntity> trains = fileJson.getObjects(pathFile, TrainEntity[].class);
        TrainEntity trainEntity = new TrainEntity(train.getTrainName(), train.getIdTrain(), String.valueOf(train.getCapacity()), String.valueOf(train.getMileage()), train.getBrand().toString(), Boolean.toString(train.getInRoute()));
        trains.remove(e -> e.getIdTrain().equals(trainEntity.getIdTrain()));
        PassengerVagonRepository passengerVagonRepository = new PassengerVagonRepository("src/main/resources/Model/JSONFiles/passengerVagons.json");
        ChargeVagonRepository chargeVagonRepository = new ChargeVagonRepository("src/main/resources/Model/JSONFiles/chargeVagons.json");
        Iterator<PassengerVagon> it = train.getPassengersVagon().iterator();
        while (it.hasNext()) {
            PassengerVagon passengerVagon = it.next();
            passengerVagonRepository.delete(passengerVagon);
        }
        Iterator<ChargeVagon> it2 = train.getChargeVagon().iterator();
        while (it2.hasNext()) {
            ChargeVagon chargeVagon = it2.next();
            chargeVagonRepository.delete(chargeVagon);
        }
        return fileJson.writeObjects(pathFile, trains);
    }

    @Override
    public Boolean update(Train train) {
        ArrayList<TrainEntity> trains = (ArrayList<TrainEntity>) fileJson.getObjects(pathFile, TrainEntity[].class);
        TrainEntity trainEntity = new TrainEntity(train.getTrainName(), train.getIdTrain(), String.valueOf(train.getCapacity()), String.valueOf(train.getMileage()), train.getBrand().toString(), Boolean.toString(train.getInRoute()));
        for (int i = 0; i < trains.size(); i++) {
            if (trains.get(i).getIdTrain().equals(train.getIdTrain())) {
                trains.set(i, trainEntity);
                return fileJson.writeObjects(pathFile, trains);
            }
        }
        PassengerVagonRepository passengerVagonRepository = new PassengerVagonRepository("src/main/resources/Model/JSONFiles/passengerVagons.json");
        ChargeVagonRepository chargeVagonRepository = new ChargeVagonRepository("src/main/resources/Model/JSONFiles/chargeVagons.json");
        Iterator<PassengerVagon> it = train.getPassengersVagon().iterator();
        while (it.hasNext()) {
            PassengerVagon passengerVagon = it.next();
            passengerVagonRepository.update(passengerVagon);
        }
        Iterator<ChargeVagon> it2 = train.getChargeVagon().iterator();
        while (it2.hasNext()) {
            ChargeVagon chargeVagon = it2.next();
            chargeVagonRepository.update(chargeVagon);
        }
        return false;
    }

    @Override
    public Train getTrain(String idTrain) {
        List<TrainEntity> trains = fileJson.getObjects(pathFile, TrainEntity[].class);
        Iterator<TrainEntity> it = trains.iterator();
        while (it.hasNext()) {
            TrainEntity trainEntity = it.next();
            if (trainEntity.getIdTrain().equals(idTrain)) {
                PassengerVagonRepository passengerVagonRepository = new PassengerVagonRepository("src/main/resources/Model/JSONFiles/passengerVagons.json");
                ChargeVagonRepository chargeVagonRepository = new ChargeVagonRepository("src/main/resources/Model/JSONFiles/chargeVagons.json");
                List<PassengerVagon> passengerVagons = passengerVagonRepository.getPassengerVagons();
                passengerVagons.remove(e -> !e.getIdVagon().startsWith(idTrain + "-"));
                List<ChargeVagon> chargeVagons = chargeVagonRepository.getChargeVagons();
                chargeVagons.remove(e -> !e.getIdVagon().startsWith(idTrain + "-"));
                return new Train(trainEntity.getTrainName(), trainEntity.getIdTrain(), Integer.parseInt(trainEntity.getCapacity()), Float.parseFloat(trainEntity.getMileage()),
                        Brand.valueOf(trainEntity.getBrand()), Boolean.parseBoolean(trainEntity.getInRoute()) ,passengerVagons, chargeVagons);
            }
        }
        return Train.getNullTrain();
    }

    @Override
    public List<Train> getTrains() {
        List<TrainEntity> trains = fileJson.getObjects(pathFile, TrainEntity[].class);
        List<Train> trainsList = new ArrayList<>();
        Iterator<TrainEntity> it = trains.iterator();
        while (it.hasNext()) {
            TrainEntity trainEntity = it.next();
            trainsList.add(new Train(trainEntity.getTrainName(), trainEntity.getIdTrain(), Integer.parseInt(trainEntity.getCapacity()), Float.parseFloat(trainEntity.getMileage()), Brand.valueOf(trainEntity.getBrand()), Boolean.parseBoolean(trainEntity.getInRoute())));
        }
        return trainsList;
    }
}
