package Model.CRUD.Repository.Entities;

import Model.Domain.mapRoute.Rail;

public class RouteEntity {
    private String idTrain;
    private Rail[] rails;

    public RouteEntity(String idTrain, Rail[] rails){
        this.idTrain = idTrain;
        this.rails = rails;
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
}
