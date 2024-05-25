package model;

import dataStructures.Array;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;
import model.domain.Ticket;
import model.interfaces.communication.toClient.TicketManagerServiceToClient;
import model.interfaces.communication.toServer.TicketManagerServiceToServer;
import model.domain.Station;
import model.domain.Train;

import java.rmi.Naming;

public class TicketModel {
    String uri;

    public TicketModel(String uri) {
        this.uri = uri;
    }

    /**
     * method to buy a ticket
     * @param names
     * @param lastName
     * @param idType
     * @param idNumber
     * @param address
     * @param phone
     * @param seatType
     * @param contactName
     * @param contactPhones
     * @param weight
     * @param trains
     * @param stations
     * @return
     * @throws Exception
     */
    public Ticket buyTicket(String names, String lastName, String idType, String idNumber, String address, Array<String> phone, String seatType, String contactName, String contactPhones, String weight, List<Train> trains, List<String> stations) throws Exception {
        TicketManagerServiceToServer ticketBuyInterface = (TicketManagerServiceToServer) Naming.lookup(uri);
        return ticketBuyInterface.buyTicket(names, lastName, idType, idNumber, address, phone, seatType, contactName, contactPhones, weight, trains, stations);
    }
    /**
     * Method to get the station
     * @param stationName
     * @return
     * @throws Exception
     */
    public Station getStation(String stationName) throws Exception {
        TicketManagerServiceToClient ticketBuyInterface = (TicketManagerServiceToClient) Naming.lookup(uri);
        return ticketBuyInterface.getStation(stationName);
    }
    /**
     * Method to get the stations for the short path
     * @param station1
     * @param station2
     * @return
     * @throws Exception
     */
    public List<String> getStationsForShortPath(Station station1, Station station2) throws Exception {
        TicketManagerServiceToClient ticketBuyInterface = (TicketManagerServiceToClient) Naming.lookup(uri);
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
    /**
     * Method to get the trains
     * @param stations
     * @return
     * @throws Exception
     */
    public List<Train> getTrains(List<String> stations) throws Exception {
        TicketManagerServiceToClient ticketBuyInterface = (TicketManagerServiceToClient) Naming.lookup(uri);
        ArrayList<Station> stationsList = (ArrayList<Station>) ticketBuyInterface.getStations(stations);
        return ticketBuyInterface.getTrainsFromThePath(stationsList);
    }

}
