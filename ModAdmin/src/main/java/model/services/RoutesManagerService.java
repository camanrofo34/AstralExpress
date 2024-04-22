package model.services;

import model.crud.repository.RailRepository;
import model.crud.repository.RouteRepository;
import model.crud.repository.StationRepository;
import model.crud.repository.TrainRepository;
import model.domain.Station;
import model.domain.Train;
import model.domain.mapRoute.Rail;
import model.domain.mapRoute.Route;
import model.interfaces.crud.RailRepoInterface;
import model.interfaces.crud.RouteRepoInterface;
import model.interfaces.crud.StationsRepoInterface;
import model.interfaces.crud.TrainRepoInterface;
import model.interfaces.communication.sendToClient.RouteManagerClientInterface;
import model.interfaces.communication.sendToServer.RouteManagerServerInterface;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

import java.io.Serial;
import java.rmi.server.UnicastRemoteObject;

public class RoutesManagerService extends UnicastRemoteObject implements RouteManagerClientInterface, RouteManagerServerInterface {
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @throws Exception
     */
    public RoutesManagerService() throws Exception {
        super();
    }
    /**
     * This method is used to get the shortest path
     * @param idTrain - Id of the train
     * @return Boolean - List of stations
     * @throws Exception - Exception
     */
    @Override
    public Boolean deleteRoute(String idTrain) throws Exception {
        TrainRepoInterface trainRepository = new TrainRepository("src/main/resources/Model/JSONFiles/trains.json");
        Train train = trainRepository.getTrain(idTrain);
        if (train.getInRoute()){
            train.setInRoute(false);
            trainRepository.update(train);
            RouteRepoInterface routeRepository = new RouteRepository("src/main/resources/Model/JSONFiles/routes.json");
            return routeRepository.delete(idTrain);
        } else {
            return false;
        }
    }

    /**
     * This method is used to create a route
     * @param stations - List of stations
     * @param idTrain - Id of the train
     * @param departureTime - Departure time
     * @return Boolean - True if the route was created, false otherwise
     * @throws Exception - Exception
     */
    @Override
    public Boolean createRoute(List<String> stations, String idTrain, String departureTime) throws Exception {
        StationsRepoInterface stationRepository = new StationRepository("src/main/resources/Model/JSONFiles/stations.json");
        ArrayList<Station> stationsList = new ArrayList<>();
        Iterator<String> iterator = stations.iterator();
        while (iterator.hasNext()) {
            Station station = stationRepository.getStation(iterator.next());
            stationsList.add(station);
        }
        RailRepoInterface railRepoInterface = new RailRepository("src/main/resources/Model/JSONFiles/rails.json");
        List<Rail> routes = new ArrayList<>();
        for (int i = 0; i < stationsList.size() - 1; i++) {
            Station stationOrigin = stationsList.get(i);
            Station stationDestination = stationsList.get(i + 1);
            Rail rail = railRepoInterface.getRail(stationOrigin, stationDestination);
            System.out.println(rail.getDistance());
            routes.add(rail);
        }
        TrainRepoInterface trainRepository = new TrainRepository("src/main/resources/Model/JSONFiles/trains.json");
        Train train = trainRepository.getTrain(idTrain);
        if (!train.getInRoute()){
            train.setInRoute(true);
            trainRepository.update(train);
            Route route = new Route(departureTime, routes.toArray(new Rail[]{}), train);
            RouteRepoInterface routeRepository = new RouteRepository("src/main/resources/Model/JSONFiles/routes.json");
            return routeRepository.insert(route);
        } else {
            return false;
        }
    }

    /**
     * This method is used to get the stations from the JSON file
     * @return List<Station> - List of stations
     * @throws Exception - Exception
     */
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
    /**
     * This method is used to get the routes from the JSON file
     * @return List<Route> - List of routes
     * @throws Exception - Exception
     */
    @Override
    public List<Route> getRoutes() throws Exception {
        RouteRepoInterface routeRepository = new RouteRepository("src/main/resources/Model/JSONFiles/routes.json");
        return routeRepository.getRoutes();
    }


}
