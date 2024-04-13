package Model.Domain;

public class Route {
    private Station origin;
    private Station destination;
    private int distance;

    public Route(Station origin, Station destination, int distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    public Station getOrigin() {
        return origin;
    }

    public void setOrigin(Station origin) {
        this.origin = origin;
    }

    public Station getDestination() {
        return destination;
    }

    public void setDestination(Station destination) {
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
