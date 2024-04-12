package Model.CRUD.Repository.Entities;

public class StationEntity {
    private String idStation;
    private String stationName;

    public StationEntity(String idStation, String stationName) {
        this.idStation = idStation;
        this.stationName = stationName;
    }

    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
}
