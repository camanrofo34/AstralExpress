package model.interfaces.communication.sendToServer;

import dataStructures.Interfaces.List;
import model.domain.Station;

import java.rmi.Remote;

public interface TicketBuyInterface extends Remote {
    Boolean buyTicket() throws Exception;

    List<Station> getShortestPath(Station station1, Station station2) throws Exception;

    Station getStation(String stationId) throws Exception;
}
