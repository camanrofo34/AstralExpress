package dataStructures.graph;

import dataStructures.Array;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;
import dataStructures.PriorityQueue;

public class Graph {
    private int vertices;
    private ArrayList<ArrayList<Edge>> listaAdyacencia;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            listaAdyacencia.add(new ArrayList<Edge>());
        }
    }

    /**
     * Add an edge from origin to destiny with a weight in one direction
     * @param origin
     * @param destiny
     * @param weight
     */
    public void addDirectedEdge(int origin, int destiny, int weight) {
        listaAdyacencia.get(origin).add(new Edge(destiny, weight));
    }

    /**
     * Add an edge from origin to destiny with a weight in both directions
     * @param origin
     * @param destiny
     * @param weight
     */
    public void addNonDirectedEdge(int origin, int destiny, int weight) {
        addDirectedEdge(origin, destiny, weight);
        addDirectedEdge(destiny, origin, weight);
    }


    /**
     * Dijkstra algorithm to find the shortest path from src to destiny
     * @param src
     * @param destiny
     * @return
     */
    public List<Integer> dijkstraWithPath(int src, int destiny) {
        Array<Integer> distancia = new Array<>(vertices); // Distance from src to each vertex
        Array<Boolean> visitado = new Array<>(vertices); // Visited flag for each vertex
        PriorityQueue<Edge> pq = new PriorityQueue<>(500); // Priority queue for vertices
        Array<Integer> predecessor = new Array<>(vertices); // Predecessor vertex for path reconstruction

        for (int i = 0; i < vertices; i++) {
            distancia.add(Integer.MAX_VALUE);
            visitado.add(false);
        }

        pq.insert(new Edge(src, 0));
        distancia.set(src, 0);

        while (!pq.isEmpty()) {
            Edge x = pq.extract();
            int u = x.getDestino();
            visitado.set(u, true);
            Iterator<Edge> iter = listaAdyacencia.get(u).iterator();

            while (iter.hasNext()) {
                Edge y = iter.next();
                int v = y.getDestino();
                int peso = y.getPeso();

                if (!visitado.get(v) && distancia.get(u) + peso < distancia.get(v)) {
                    distancia.set(v, distancia.get(u) + peso);
                    predecessor.set(v, u);
                    pq.insert(new Edge(v, distancia.get(v)));
                }
            }
        }

        ArrayList<Integer> path = new ArrayList<>();
        if (distancia.get(destiny) < Integer.MAX_VALUE) {
            int current = destiny;
            while (current != src) {
                path.addFirst(current);
                current = predecessor.get(current);
            }
            path.addFirst(src);
        }

        //The path
        return path;
    }
}

