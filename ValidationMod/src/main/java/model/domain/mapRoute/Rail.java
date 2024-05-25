package model.domain.mapRoute;

import model.domain.Station;

import java.io.Serializable;

public class Rail implements Serializable {
    private Station station1;
    private Station station2;
    private int distance;

    public Rail(Station station1, Station station2, int distance) {
        this.station1 = station1;
        this.station2 = station2;
        this.distance = distance;
    }

    public Station getStation1() {
        return station1;
    }

    public void setStation1(Station station1) {
        this.station1 = station1;
    }

    public Station getStation2() {
        return station2;
    }

    public void setStation2(Station station2) {
        this.station2 = station2;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
