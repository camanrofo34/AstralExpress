package model;

import model.domain.mapRoute.Route;
import model.interfaces.communication.sendToClient.RouteManagerClientInterface;
import model.interfaces.communication.sendToServer.RouteManagerServerInterface;
import model.messenger.Messenger;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;
import java.rmi.Naming;

public class RoutesModel {

    private String uri;
    private Messenger messenger;

    public RoutesModel(String uri) {
        this.uri = uri;
        messenger = new Messenger("");
    }

    public String retunUri() {
        return uri;
    }

    public Messenger getMessenger() {
        return messenger;
    }

    public Boolean createRoute(List<String> stations, String idTrain, String departureTime) throws Exception {
        RouteManagerServerInterface routeManagerServerInterface = (RouteManagerServerInterface) Naming.lookup(uri);
        return routeManagerServerInterface.createRoute(stations, idTrain, departureTime);
    }

    public List<Route> getRoutes() throws Exception {
        RouteManagerClientInterface routeManagerServerInterface = (RouteManagerClientInterface) Naming.lookup(uri);
        return routeManagerServerInterface.getRoutes();
    }

    public String[] getTrains() throws Exception {
        RouteManagerClientInterface routeManagerServerInterface = (RouteManagerClientInterface) Naming.lookup(uri);
        List<String> trains = routeManagerServerInterface.getTrainsId();
        Iterator<String> iterator = trains.iterator();
        String[] trainBox = new String[trains.size()];
        int i=0;
        while (iterator.hasNext()) {
            trainBox[i++] = iterator.next();
        }
        return trainBox;
    }

    public Boolean deleteRoute(String idTrain) throws Exception {
        RouteManagerServerInterface routeManagerServerInterface = (RouteManagerServerInterface) Naming.lookup(uri);
        return routeManagerServerInterface.deleteRoute(idTrain);
    }
}
