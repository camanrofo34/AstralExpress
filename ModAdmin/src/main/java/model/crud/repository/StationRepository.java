package model.crud.repository;

import model.crud.repository.entities.StationEntity;
import model.crud.shared.FileJsonAdapter;
import model.crud.shared.FileJsonInterface;
import model.domain.Station;
import model.interfaces.CRUD.StationsRepoInterface;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

public class StationRepository implements StationsRepoInterface {
    private final FileJsonInterface<StationEntity> fileJson;
    private final String pathFile;

    public StationRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    @Override
    public Boolean insert(Station station) {
        List<StationEntity> stations = fileJson.getObjects(pathFile, StationEntity[].class);
        StationEntity stationEntity = new StationEntity(station.getIdStation(), station.getStationName());
        stations.add(stationEntity);
        return fileJson.writeObjects(pathFile, stations);
    }

    @Override
    public Boolean delete(Station station) {
        List<StationEntity> stations = fileJson.getObjects(pathFile, StationEntity[].class);
        StationEntity stationEntity = new StationEntity(station.getIdStation(), station.getStationName());
        stations.remove(stationEntity);
        return fileJson.writeObjects(pathFile, stations);
    }

    @Override
    public Boolean update(Station station) {
        ArrayList<StationEntity> stations = (ArrayList<StationEntity>) fileJson.getObjects(pathFile, StationEntity[].class);
        StationEntity stationEntity = new StationEntity(station.getIdStation(), station.getStationName());
        for (int i = 0; i < stations.size(); i++) {
            if (stations.get(i).getIdStation().equals(station.getIdStation())) {
                stations.set(i, stationEntity);
                return fileJson.writeObjects(pathFile, stations);
            }
        }
        return false;
    }

    @Override
    public Station getStation(String nameStation) {
        List<StationEntity> stations = fileJson.getObjects(pathFile, StationEntity[].class);
        System.out.println(stations.size());
        Iterator<StationEntity> it = stations.iterator();
        while (it.hasNext()) {
            StationEntity stationEntity = it.next();
            if (stationEntity.getStationName().equals(nameStation)) {
                return new Station(stationEntity.getIdStation(), stationEntity.getStationName());
            }
        }
        return Station.returnNullStation();
    }
    @Override
    public Station getStationById(String idStation) {
        List<StationEntity> stations = fileJson.getObjects(pathFile, StationEntity[].class);
        Iterator<StationEntity> it = stations.iterator();
        while (it.hasNext()) {
            StationEntity stationEntity = it.next();
            if (stationEntity.getIdStation().equals(idStation)) {
                return new Station(stationEntity.getIdStation(), stationEntity.getStationName());
            }
        }
        return null;
    }

    @Override
    public List<Station> getAllStations() throws Exception {
        List<StationEntity> stations = fileJson.getObjects(pathFile, StationEntity[].class);
        List<Station> stationsList = new ArrayList<>();
        Iterator<StationEntity> it = stations.iterator();
        while (it.hasNext()) {
            StationEntity stationEntity = it.next();
            stationsList.add(new Station(stationEntity.getIdStation(), stationEntity.getStationName()));
        }
        return stationsList;
    }
}
