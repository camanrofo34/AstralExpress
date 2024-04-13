package DataStructures.Graph;

import DataStructures.Array;
import DataStructures.ArrayList;
import DataStructures.PriorityQueue;
import Model.Domain.Route;

public class Graph {
    private Array<ArrayList<Route>> graph;
    private int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        graph = new Array<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            graph.set(i, new ArrayList<>());
        }
    }

    public Boolean addRoute(Route route) {
        graph.get(Integer.parseInt(route.getOrigin().getIdStation())).add(route);
        graph.get(Integer.parseInt(route.getDestination().getIdStation())).add(route);
        return true;
    }




    public Array<ArrayList<Route>> getGraph() {
        return graph;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setGraph(Array<ArrayList<Route>> graph) {
        this.graph = graph;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

}
