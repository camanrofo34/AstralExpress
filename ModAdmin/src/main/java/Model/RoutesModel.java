package Model;

import Model.Interfaces.Communication.SendToClient.RouteManagerClientInterface;
import Model.Interfaces.Communication.SendToServer.RouteManagerServerInterface;
import Model.Messenger.Messenger;
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

    public Boolean createRoute(List<String> stations, String idTrain) throws Exception {
        RouteManagerServerInterface routeManagerServerInterface = (RouteManagerServerInterface) Naming.lookup(uri);
        return routeManagerServerInterface.createRoute(stations, idTrain);
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
}
