package Model.CRUD.Repository.Entities;

import Model.Domain.mapRoute.Rail;

public class RouteEntity {

    private String departureHour;
    private String arrivalHour;
    private String idTrain;
    private Rail[] rails;

    private int distance;

    public RouteEntity(String departureHour, String arrivalHour, String idTrain, Rail[] rails, int distance) {
        this.departureHour = departureHour;
        this.arrivalHour = arrivalHour;
        this.idTrain = idTrain;
        this.rails = rails;
        this.distance = distance;
    }

    public String getIdTrain() {
        return idTrain;
    }

    public void setIdTrain(String idTrain) {
        this.idTrain = idTrain;
    }

    public Rail[] getRails() {
        return rails;
    }

    public void setRails(Rail[] rails) {
        this.rails = rails;
    }

    public String getDepartureHour() {
        return departureHour;
    }

    public void setDepartureHour(String departureHour) {
        this.departureHour = departureHour;
    }

    public String getArrivalHour() {
        return arrivalHour;
    }

    public void setArrivalHour(String arrivalHour) {
        this.arrivalHour = arrivalHour;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
