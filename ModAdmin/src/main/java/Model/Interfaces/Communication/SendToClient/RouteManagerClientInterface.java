package Model.Interfaces.Communication.SendToClient;

import Model.Domain.Station;
import dataStructures.Interfaces.List;

public interface RouteManagerClientInterface {
    List<Station> getShortestPath(Station station1, Station station2) throws Exception;
}
