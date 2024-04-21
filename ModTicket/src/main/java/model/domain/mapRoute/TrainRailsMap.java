package model.domain.mapRoute;

import dataStructures.ArrayList;
import dataStructures.Interfaces.List;
import dataStructures.graph.Graph;
import model.domain.Station;

import java.io.Serializable;

public class TrainRailsMap implements Serializable {
    Graph map;

    public TrainRailsMap(int vertices, ArrayList<Rail> rails) {
        map = new Graph(vertices);
        for (int i = 0; i < rails.size(); i++) {
            map.agregarAristaNoDirigida(Integer.parseInt(rails.get(i).getStation1().getIdStation()), Integer.parseInt(rails.get(i).getStation2().getIdStation()), rails.get(i).getDistance());
        }
    }

    public Graph getMap() {
        return map;
    }

    public List<Integer> getShortestPath(Station station1, Station station2) {
        return map.dijkstraWithPath(Integer.parseInt(station1.getIdStation()), Integer.parseInt(station2.getIdStation()));
    }
}
