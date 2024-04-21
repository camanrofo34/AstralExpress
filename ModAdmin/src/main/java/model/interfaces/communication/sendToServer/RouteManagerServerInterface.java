package model.interfaces.communication.sendToServer;

import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface RouteManagerServerInterface extends Remote {
    Boolean deleteRoute(String idTrain) throws Exception;

    public Boolean createRoute(List<String> stations, String idTrain, String departureTime) throws Exception;
}
