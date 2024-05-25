package model.domain;

import java.io.Serializable;

public class Luggage implements Serializable {
    private String idPassenger;

    private double weight;

    public Luggage(String idPassenger, double weight) {
        this.idPassenger = idPassenger;
        this.weight = weight;
    }

    public String getIdPassenger() {
        return idPassenger;
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
