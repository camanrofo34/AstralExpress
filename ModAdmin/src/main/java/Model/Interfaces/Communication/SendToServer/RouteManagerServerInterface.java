package Model.Interfaces.Communication.SendToServer;

import dataStructures.Interfaces.List;

import java.rmi.Remote;

public interface RouteManagerServerInterface extends Remote {
    public Boolean createRoute(List<String> stations, String idTrain) throws Exception;
}
