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
    /**
     * Constructor
     * @param uri
     */
    public RoutesModel(String uri) {
        this.uri = uri;
        messenger = new Messenger("");
    }
    /**
     * This method is used to get the uri
     * @return String - Uri
     */
    public String retunUri() {
        return uri;
    }

    public Messenger getMessenger() {
        return messenger;
    }
    /**
     * This method is used to create a route
     * @param stations - List of stations
     * @param idTrain - Id of the train
     * @param departureTime - Departure time
     * @return Boolean - Boolean
     * @throws Exception - Exception
     */
    public Boolean createRoute(List<String> stations, String idTrain, String departureTime) throws Exception {
        RouteManagerServerInterface routeManagerServerInterface = (RouteManagerServerInterface) Naming.lookup(uri);
        return routeManagerServerInterface.createRoute(stations, idTrain, departureTime);
    }
    /**
     * This method is used to get the routes
     * @return List<Route> - List of routes
     * @throws Exception - Exception
     */
    public List<Route> getRoutes() throws Exception {
        RouteManagerClientInterface routeManagerServerInterface = (RouteManagerClientInterface) Naming.lookup(uri);
        return routeManagerServerInterface.getRoutes();
    }
    /**
     * This method is used to get the trains
     * @return String[] - List of trains
     * @throws Exception - Exception
     */
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
    /**
     * This method is used to get the shortest path
     * @param idTrain - Id of the train
     * @return Boolean - List of stations
     * @throws Exception - Exception
     */
    public Boolean deleteRoute(String idTrain) throws Exception {
        RouteManagerServerInterface routeManagerServerInterface = (RouteManagerServerInterface) Naming.lookup(uri);
        return routeManagerServerInterface.deleteRoute(idTrain);
    }
}
