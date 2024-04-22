package model.interfaces.communication.sendToServer;

import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface RouteManagerServerInterface extends Remote {
    /**
     * Delete a route in the repository
     * @param idTrain
     * @return
     * @throws Exception
     */
    Boolean deleteRoute(String idTrain) throws Exception;

    /**
     * Create a route in the repository
     * @param stations
     * @param idTrain
     * @param departureTime
     * @return
     * @throws Exception
     */
    public Boolean createRoute(List<String> stations, String idTrain, String departureTime) throws Exception;
}
