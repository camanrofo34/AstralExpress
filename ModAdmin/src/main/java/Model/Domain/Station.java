package Model.Domain;

import java.io.Serializable;

public class Station implements Serializable {
    private String idStation;
    private String stationName;

    public Station(String idStation, String stationName) {
        this.idStation = idStation;
        this.stationName = stationName;
    }

    public static Station returnNullStation() {
        return new Station("", "");
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
