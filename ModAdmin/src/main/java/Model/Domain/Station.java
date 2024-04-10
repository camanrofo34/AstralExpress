package Model.Domain;

public class Station {
    private String idStation;
    private String stationName;

    public Station(String idStation, String stationName) {
        this.idStation = idStation;
        this.stationName = stationName;
    }

    public static Station returnNullStation() {
        return new Station("", "");
    }
}
