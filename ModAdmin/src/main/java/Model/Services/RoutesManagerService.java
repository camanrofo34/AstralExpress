package Model.Services;

import Model.CRUD.Repository.RouteRepository;
import Model.CRUD.Repository.StationRepository;
import Model.Domain.Station;
import Model.Domain.Train;
import Model.Domain.mapRoute.Route;
import Model.Domain.mapRoute.TrainRailsMap;
import Model.Interfaces.CRUD.StationsRepoInterface;
import Model.Interfaces.Communication.SendToClient.RouteManagerClientInterface;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

public class RoutesManagerService implements RouteManagerClientInterface {

    private TrainRailsMap map;


    @Override
    public List<Station> getShortestPath(Station station1, Station station2) throws Exception {
        map.getShortestPath(station1, station2);
        Iterator<Integer> iterator = map.getShortestPath(station1, station2).iterator();
        List<Station> stations = new ArrayList<>();
        while (iterator.hasNext()) {
            StationsRepoInterface stationRepository = new StationRepository("src/main/resources/Model/JSONFiles/stations.json");
            Station station = stationRepository.getStation(iterator.next().toString());
            stations.add(station);
        }
        return stations;
    }

    public List<Train> getTrainsFromThePath(ArrayList<Station> stations) throws Exception {
        ArrayList<Train> trains = new ArrayList<>();
        Station stationDestination = null;
        RouteRepository routeRepository = new RouteRepository("src/main/resources/Model/JSONFiles/routes.json");
        List<Route> routes = routeRepository.getRoutes();
        for (int i = 0; i < stations.size() - 1; i++) {
            Station stationOrigin = stations.get(i);
            if (i + 1 < stations.size()) {
                stationDestination = stations.get(i + 1);

            }

        }
        return trains;
    }


}
