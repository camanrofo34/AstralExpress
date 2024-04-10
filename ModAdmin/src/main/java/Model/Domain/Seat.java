package Model.Domain;

public class Seat {
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
