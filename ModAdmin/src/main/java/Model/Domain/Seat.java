package Model.Domain;

import java.io.Serializable;

public class Seat implements Serializable {
    private String idSeat;
    private Classe Class;

    public Seat(String idSeat, Classe Classe) {
        this.idSeat = idSeat;
        this.Class = Classe;
    }

    public static Seat returnNullSeat() {
        return new Seat("", Classe.findByPriority("Estandar"));
    }

}
