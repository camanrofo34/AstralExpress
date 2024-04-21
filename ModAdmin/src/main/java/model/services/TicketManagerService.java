package model.services;

import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;
import model.crud.repository.RailRepository;
import model.crud.repository.RouteRepository;
import model.crud.repository.StationRepository;
import model.domain.Station;
import model.domain.Ticket;
import model.domain.mapRoute.Rail;
import model.domain.mapRoute.Route;
import model.domain.mapRoute.TrainRailsMap;
import model.interfaces.CRUD.StationsRepoInterface;
import model.interfaces.communication.sendToClient.TicketSearchInterface;
import model.interfaces.communication.sendToServer.TicketBuyInterface;

import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TicketManagerService extends UnicastRemoteObject implements TicketBuyInterface, TicketSearchInterface {
    private TrainRailsMap map;
    @Serial
    private static final long serialVersionUID = 1L;

    public TicketManagerService() throws RemoteException {
        super();
    }

    @Override
    public Ticket getTicket(String ticket) throws Exception {
        return null;
    }

    @Override
    public Boolean buyTicket() throws Exception {
        return null;
    }

    @Override
    public List<Station> getShortestPath(Station station1, Station station2) throws Exception {
        RailRepository railRepository = new RailRepository("src/main/resources/model/JSONFiles/rails.json");
        List<Rail> routes = railRepository.getRails();
        map = new TrainRailsMap(11, routes);
        map.getShortestPath(station1, station2);
        Iterator<Integer> iterator = map.getShortestPath(station1, station2).iterator();
        List<Station> stations = new ArrayList<>();
        StationsRepoInterface stationRepository = new StationRepository("src/main/resources/model/JSONFiles/stations.json");
        while (iterator.hasNext()) {
            Station station = stationRepository.getStation(iterator.next().toString());
            stations.add(station);
        }
        return stations;
    }

    @Override
    public Station getStation(String stationId) throws Exception {
        StationRepository stationRepository = new StationRepository("src/main/resources/model/JSONFiles/stations.json");
        return stationRepository.getStation(stationId);
    }
}
