package model.services;

import dataStructures.Array;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;
import model.crud.repository.RailRepository;
import model.crud.repository.RouteRepository;
import model.crud.repository.StationRepository;
import model.crud.repository.TicketRepository;
import model.domain.*;
import model.domain.mapRoute.Rail;
import model.domain.mapRoute.Route;
import model.domain.mapRoute.TrainRailsMap;
import model.environment.IdGenerator;
import model.interfaces.crud.RailRepoInterface;
import model.interfaces.crud.RouteRepoInterface;
import model.interfaces.crud.StationsRepoInterface;
import model.interfaces.communication.sendToClient.TicketSearchInterface;
import model.interfaces.communication.sendToServer.TicketBuyInterface;

import java.io.Serial;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

public class TicketManagerService extends UnicastRemoteObject implements TicketBuyInterface, TicketSearchInterface {
    private TrainRailsMap map;
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * Constructor
     * @throws RemoteException
     */
    public TicketManagerService() throws RemoteException {
        super();
    }

    @Override
    public Ticket getTicket(String ticket) throws Exception {
        return null;
    }
    @Override
    public Boolean buyTicket(String names, String lastName, String idType, String idNumber, String address, Array<String> phone, String seatType, String contactName, String contactPhones, String weight, List<Train> trains, List<String> stations) throws Exception {
        String idTicket = "B"+ IdGenerator.generateTicketId();
        Date date = new Date();
        String dateStr = date.toString();
        List<Station> stationsList = getStations(stations);
        Ticket ticket = new Ticket(idTicket, dateStr, "00:00", "00:00", new Passenger(idNumber, idType,
                address, new PassengerContact(idNumber, contactName, "", new Array<>(contactPhones.split(","))),
                names, lastName, phone),
                new PassengerContact(idNumber, contactName, "", new Array<>(contactPhones.split(","))),
                idNumber, IdType.valueOf(idType), 0.0, Classe.valueOf(seatType), new Luggage("", idNumber, Double.parseDouble(weight)),
                trains, stationsList);
        TicketRepository ticketRepository = new TicketRepository("src/main/resources/model/JSONFiles/tickets.json");
        return ticketRepository.insert(ticket);
    }
    }

    /**
     * This method is used to get the shortest path
     * @param station1 - Station 1
     * @param station2 - Station 2
     * @return List of stations
     * @throws Exception - Exception
     */
    @Override
    public List<Station> getShortestPath(Station station1, Station station2) throws Exception {
        RailRepoInterface railRepoInterface = new RailRepository("src/main/resources/model/JSONFiles/rails.json");
        List<Rail> routes = railRepoInterface.getRails();
        map = new TrainRailsMap(11, routes);
        map.getShortestPath(station1, station2);
        Iterator<Integer> iterator = map.getShortestPath(station1, station2).iterator();
        List<Station> stations = new ArrayList<>();
        StationsRepoInterface stationRepository = new StationRepository("src/main/resources/model/JSONFiles/stations.json");
        while (iterator.hasNext()) {
            Station station = stationRepository.getStationById(iterator.next().toString());
            stations.add(station);
        }
        return stations;
    }

    /**
     * This method is used to get the station
     * @param stationName - Name of the station
     * @return Station
     * @throws Exception - Exception
     */
    @Override
    public Station getStation(String stationName) throws Exception {
        StationRepository stationRepository = new StationRepository("src/main/resources/model/JSONFiles/stations.json");
        Station station = stationRepository.getStation(stationName);
        return station;
    }
    /**
     * This method is used to get the trains from the path
     * @param stations - List of stations
     * @return List of trains
     * @throws Exception - Exception
     */
    @Override
    public List<Train> getTrainsFromThePath(ArrayList<Station> stations) throws Exception {
        ArrayList<Train> trains = new ArrayList<>();
        RouteRepoInterface routeRepository = new RouteRepository("src/main/resources/Model/JSONFiles/routes.json");
        ArrayList<Route> routes = (ArrayList<Route>) routeRepository.getRoutes();
        for (int i = 0; i < stations.size() - 1; i++) {
            Station stationOrigin = stations.get(i);
            Station stationDestination = stations.get(i + 1);
            for (int j = 0; j < routes.size(); j++) {
                Route route = routes.get(j);
                if (route.containRail(stationOrigin, stationDestination)) {
                    Train train = route.getTrain();
                    trains.add(train);
                }
            }
        }
        return trains;
    }
    /**
     * This method is used to get the stations
     * @param stations - List of stations
     * @return List of stations
     * @throws Exception - Exception
     */
    @Override
    public List<Station> getStations(List<String> stations) throws Exception {
        StationsRepoInterface stationRepository = new StationRepository("src/main/resources/model/JSONFiles/stations.json");
        ArrayList<Station> stationsList = new ArrayList<>();
        Iterator<String> iterator = stations.iterator();
        while (iterator.hasNext()) {
            String stationId = iterator.next();
            Station station = stationRepository.getStation(stationId);
            stationsList.add(station);
        }
        return stationsList;
    }
}
