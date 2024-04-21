package Model.Services;

import Model.CRUD.Repository.RailRepository;
import Model.CRUD.Repository.RouteRepository;
import Model.CRUD.Repository.StationRepository;
import Model.CRUD.Repository.TrainRepository;
import Model.Domain.Station;
import Model.Domain.Train;
import Model.Domain.mapRoute.Rail;
import Model.Domain.mapRoute.Route;
import Model.Domain.mapRoute.TrainRailsMap;
import Model.Interfaces.CRUD.StationsRepoInterface;
import Model.Interfaces.CRUD.TrainRepoInterface;
import Model.Interfaces.Communication.SendToClient.RouteManagerClientInterface;
import Model.Interfaces.Communication.SendToServer.RouteManagerServerInterface;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

import javax.swing.*;
import java.rmi.server.UnicastRemoteObject;

public class RoutesManagerService extends UnicastRemoteObject implements RouteManagerClientInterface, RouteManagerServerInterface {

    private TrainRailsMap map;

    public RoutesManagerService() throws Exception {
        super();
    }


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
    @Override
    public Boolean createRoute(List<String> stations, String idTrain) throws Exception {
        StationsRepoInterface stationRepository = new StationRepository("src/main/resources/Model/JSONFiles/stations.json");
        ArrayList<Station> stationsList = new ArrayList<>(11);
        Iterator<String> iterator = stations.iterator();
        while (iterator.hasNext()) {
            Station station = stationRepository.getStation(iterator.next());
            stationsList.add(station);
        }
        RailRepository railRepository = new RailRepository("src/main/resources/Model/JSONFiles/rails.json");
        List<Rail> routes = new ArrayList<>();
        for (int i = 0; i < stationsList.size() - 1; i++) {
            Station stationOrigin = stationsList.get(i);
            Station stationDestination = stationsList.get(i + 1);
            Rail rail = railRepository.getRail(stationOrigin, stationDestination);
            System.out.println(rail.getDistance());
            routes.add(rail);
        }
        TrainRepoInterface trainRepository = new TrainRepository("src/main/resources/Model/JSONFiles/trains.json");
        Train train = trainRepository.getTrain(idTrain);
        Route route = new Route(routes.toArray(new Rail[]{}), train);
        RouteRepository routeRepository = new RouteRepository("src/main/resources/Model/JSONFiles/routes.json");
        return routeRepository.insert(route);
    }
    @Override
    public List<String> getTrainsId() throws Exception {
        TrainRepoInterface trainRepository = new TrainRepository("src/main/resources/Model/JSONFiles/trains.json");
        List<Train> trains = trainRepository.getTrains();
        List<String> trainsId = new ArrayList<>();
        Iterator<Train> iterator = trains.iterator();
        while (iterator.hasNext()){
            Train train = iterator.next();
            trainsId.add(train.getIdTrain());
        }
        return trainsId;
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
