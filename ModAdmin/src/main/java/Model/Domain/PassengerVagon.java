package Model.Domain;

import Model.Domain.AbstractClasses.AbstractVagon;

public class PassengerVagon extends AbstractVagon {
    PriorityQueue<Seat> seats;

    public PassengersVagon(PriorityQueue<Seat> seats, String idVagon) {
        super(idVagon);
        this.seats = seats;
    }

    public static PassengersVagon returnNullPassengersVagon() {
        return new PassengersVagon(new PriorityQueue<>(3), "");
    }
}
