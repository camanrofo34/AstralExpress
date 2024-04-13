package Model.Domain;

import java.io.Serializable;

public class Luggage implements Serializable {
    private String idPassenger;
    private String idVagon;

    public Luggage(String idPassenger, String idVagon) {
        this.idPassenger = idPassenger;
        this.idVagon = idVagon;
    }
}
