package model.interfaces.communication.sendToClient;

import model.domain.Station;
import model.domain.Train;
import model.domain.mapRoute.Route;
import dataStructures.ArrayList;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface RouteManagerClientInterface extends Remote { ;
    List<String> getTrainsId() throws Exception;

    List<Train> getTrainsFromThePath(ArrayList<Station> stations) throws Exception;

    List<Route> getRoutes() throws Exception;
}
