/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.astralexpress.modelo.repositorio;

import org.astralexpress.modelo.domain.AbstractVagon;
import org.astralexpress.modelo.domain.Brand;
import org.astralexpress.modelo.domain.Train;
import org.astralexpress.shared.FileJsonAdapter;
import org.astralexpress.shared.FileJsonInterface;
import org.model.io.LinkedList.LinkedList;
import org.model.io.array.Array;
import org.model.util.collection.Collection;
import org.model.util.iterator.Iterator;
import org.model.util.list.List;

/**
 * @author PC 4060TI
 */
public class TrainRepository {

    private FileJsonInterface<TrainEntity> fileJson;
    private String pathFile;

    public TrainRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public Train getTrain(String idTrain) {
        TrainEntity[] trainsEntity = fileJson.getObjects(pathFile, TrainEntity[].class);
        Array<TrainEntity> trainEntity = new Array<>(trainsEntity);
        Iterator<TrainEntity> iterator = trainEntity.iterator();
        while (iterator.hasNext()) {
            TrainEntity trainE = iterator.next();
            if (trainE.idTrain.equals(idTrain)) {
                ChargeVagonRepository CVR = new ChargeVagonRepository("src\\main\\java\\org\\astralexpress/database/chargeVagon.json");
                PassengersVagonRepository PVR = new PassengersVagonRepository("src\\main\\java\\org\\astralexpress/database/passengerVagon.json");
                LinkedList<AbstractVagon> vagons = new LinkedList<>();
                vagons.add((Collection) CVR.getChargeVagons(idTrain));
                vagons.add((Collection) PVR.getPassangerVagons(idTrain));
                return new Train(trainE.trainName, trainE.idTrain, Integer.parseInt(trainE.capacity), Double.parseDouble(trainE.mileage), Brand.getBrandByName(trainE.brand), vagons);
            }
        }
        return Train.getNullTrain();
    }

    public List<Train> getTrains() {
        List<Train> trains = new LinkedList<>();
        TrainEntity[] trainsEntity = fileJson.getObjects(pathFile, TrainEntity[].class);
        Array<TrainEntity> trainEntity = new Array<>(trainsEntity);
        Iterator<TrainEntity> iterator = trainEntity.iterator();
        while (iterator.hasNext()) {
            TrainEntity trainE = iterator.next();
            ChargeVagonRepository CVR = new ChargeVagonRepository("src\\main\\java\\org\\astralexpress/database/chargeVagon.json");
            PassengersVagonRepository PVR = new PassengersVagonRepository("src\\main\\java\\org\\astralexpress/database/passengerVagon.json");
            LinkedList<AbstractVagon> vagons = new LinkedList<>();
            vagons.add((Collection) CVR.getChargeVagons(trainE.idTrain));
            vagons.add((Collection) PVR.getPassangerVagons(trainE.idTrain));
            trains.add(new Train(trainE.trainName, trainE.idTrain, Integer.parseInt(trainE.capacity), Double.parseDouble(trainE.mileage), Brand.getBrandByName(trainE.brand), vagons));
        }
        return trains;
    }

    public boolean addTrain(Train train) {
        TrainEntity trainEntity = new TrainEntity(train.getTrainName(), train.getIdTrain(), String.valueOf(train.getCapacity()), String.valueOf(train.getMileage()), train.getBrand().name());
        return fileJson.writeObject(pathFile, trainEntity);
    }
}
