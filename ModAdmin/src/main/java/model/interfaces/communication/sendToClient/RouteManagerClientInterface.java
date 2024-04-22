package model.interfaces.communication.sendToClient;

import model.domain.Station;
import model.domain.Train;
import model.domain.mapRoute.Route;
import dataStructures.ArrayList;
import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface RouteManagerClientInterface extends Remote {
    /**
     * Get the Trains Id
     * @return
     * @throws Exception
     */
    List<String> getTrainsId() throws Exception;

    /**
     * Get the Routes
     * @return
     * @throws Exception
     */
    List<Route> getRoutes() throws Exception;
}
