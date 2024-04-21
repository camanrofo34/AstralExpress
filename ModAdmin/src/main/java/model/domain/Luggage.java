package model.domain;

import java.io.Serializable;

public class Luggage implements Serializable {
    private String idVagon;
    private String idPassenger;

    private double weight;

    public Luggage(String idVagon, String idPassenger, double weight) {
        this.idVagon = idVagon;
        this.idPassenger = idPassenger;
        this.weight = weight;
    }

    public String getIdVagon() {
        return idVagon;
    }

    public String getIdPassenger() {
        return idPassenger;
    }

    public void setIdVagon(String idVagon) {
        this.idVagon = idVagon;
    }

    public void setIdPassenger(String idPassenger) {
        this.idPassenger = idPassenger;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
