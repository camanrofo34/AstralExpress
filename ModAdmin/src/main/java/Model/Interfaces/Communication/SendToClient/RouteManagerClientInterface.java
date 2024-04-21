package Model.Interfaces.Communication.SendToClient;

import Model.Domain.Station;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface RouteManagerClientInterface extends Remote {
    List<Station> getShortestPath(Station station1, Station station2) throws Exception;
    List<String> getTrainsId() throws Exception;
}
