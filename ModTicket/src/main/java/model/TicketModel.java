package model;

import dataStructures.Array;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;
import model.domain.Station;
import model.domain.Train;
import model.interfaces.communication.sendToServer.TicketBuyInterface;

import java.rmi.Naming;

public class TicketModel {
    String uri;

    public TicketModel(String uri) {
        this.uri = uri;
    }

    public Boolean buyTicket(String names, String lastName, String idType, String idNumber, String address, Array<String> phone, String seatType, String contactName, String contactPhones, String weight, List<Train> trains, List<String> stations) throws Exception {
        TicketBuyInterface ticketBuyInterface = (TicketBuyInterface) Naming.lookup(uri);
        return ticketBuyInterface.buyTicket(names, lastName, idType, idNumber, address, phone, seatType, contactName, contactPhones, weight, trains, stations);
    }

    public Station getStation(String stationName) throws Exception {
        TicketBuyInterface ticketBuyInterface = (TicketBuyInterface) Naming.lookup(uri);
        return ticketBuyInterface.getStation(stationName);
    }

    public List<String> getStationsForShortPath(Station station1, Station station2) throws Exception {
        TicketBuyInterface ticketBuyInterface = (TicketBuyInterface) Naming.lookup(uri);
        List<Station> stations = ticketBuyInterface.getShortestPath(station1, station2);
        Iterator<Station> iterator1 = stations.iterator();
        while (iterator1.hasNext()) {
            Station station = iterator1.next();
        }
        List<String> stationsName = new ArrayList<>();
        Iterator<Station> iterator = stations.iterator();
        while (iterator.hasNext()) {
            Station station = iterator.next();
            stationsName.add(station.getStationName());
        }
        return stationsName;
    }

    public List<Train> getTrains(List<String> stations) throws Exception {
        TicketBuyInterface ticketBuyInterface = (TicketBuyInterface) Naming.lookup(uri);
        ArrayList<Station> stationsList = (ArrayList<Station>) ticketBuyInterface.getStations(stations);
        return ticketBuyInterface.getTrainsFromThePath(stationsList);
    }
}
