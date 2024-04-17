package Model.CRUD.Repository.Entities;

public class RailEntity {
    private String idOriginStation;
    private String idDestinationStation;
    private String distance;

    public RailEntity(String idOriginStation, String idDestinationStation, String distance) {
        this.idOriginStation = idOriginStation;
        this.idDestinationStation = idDestinationStation;
        this.distance = distance;
    }

    public String getIdOriginStation() {
        return idOriginStation;
    }

    public void setIdOriginStation(String idOriginStation) {
        this.idOriginStation = idOriginStation;
    }

    public String getIdDestinationStation() {
        return idDestinationStation;
    }

    public void setIdDestinationStation(String idDestinationStation) {
        this.idDestinationStation = idDestinationStation;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
