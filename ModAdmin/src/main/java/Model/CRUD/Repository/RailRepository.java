package Model.CRUD.Repository;

import Model.CRUD.Repository.Entities.RailEntity;
import Model.CRUD.Shared.FileJsonAdapter;
import Model.CRUD.Shared.FileJsonInterface;
import Model.Domain.Station;
import Model.Domain.mapRoute.Rail;
import Model.Interfaces.CRUD.StationsRepoInterface;
import dataStructures.ArrayList;
import dataStructures.Interfaces.List;

public class RailRepository {
    private final FileJsonInterface<RailEntity> fileJson;
    private final String pathFile;

    public RailRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public List<Rail> getRails() throws Exception {
        StationsRepoInterface stationRepository = new StationRepository("src/main/java/Model/CRUD/Repository/Files/stations.json");
        ArrayList<RailEntity> rails = (ArrayList<RailEntity>) fileJson.getObjects(pathFile, RailEntity[].class);
        List<Rail> railsList = new ArrayList<>();
        for (int i = 0; i < rails.size(); i++) {
            RailEntity railEntity = rails.get(i);
            Station station1 = stationRepository.getStationById(railEntity.getIdOriginStation());
            Station station2 = stationRepository.getStationById(railEntity.getIdDestinationStation());
            railsList.add(new Rail(station1, station2, Integer.parseInt(railEntity.getDistance())));
        }
        return railsList;
    }

    public Rail getRail(Station station1, Station station2) throws Exception {
        StationsRepoInterface stationRepository = new StationRepository("src/main/resources/Model/JSONFiles/stations.json");
        ArrayList<RailEntity> rails = (ArrayList<RailEntity>) fileJson.getObjects(pathFile, RailEntity[].class);
        for (int i = 0; i < rails.size(); i++) {
            RailEntity railEntity = rails.get(i);
            Station stationOrigin = stationRepository.getStationById(railEntity.getIdOriginStation());
            Station stationDestination = stationRepository.getStationById(railEntity.getIdDestinationStation());
            if (stationOrigin.getIdStation().equals(station1.getIdStation()) && stationDestination.getIdStation().equals(station2.getIdStation())) {
                //System.out.println(stationOrigin.getIdStation());
                //System.out.println(stationDestination.getIdStation());
                return new Rail(station1, station2, Integer.parseInt(railEntity.getDistance()));
            }
        }
        return null;
    }
}
