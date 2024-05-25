package model.interfaces.communication.toClient;

import dataStructures.ArrayList;
import dataStructures.Interfaces.List;
import model.domain.Station;
import model.domain.Ticket;
import model.domain.Train;

import java.rmi.Remote;

public interface TicketManagerServiceToClient extends Remote {
    List<Ticket> getTicketSearch(String ticket) throws Exception;

    List<Ticket> getTicketOrden(String idTrain) throws Exception;

    List<Station> getShortestPath(Station station1, Station station2) throws Exception;

    Station getStation(String stationName) throws Exception;

    List<Train> getTrainsFromThePath(ArrayList<Station> stations) throws Exception;

    List<Station> getStations(List<String> stations) throws Exception;
}
