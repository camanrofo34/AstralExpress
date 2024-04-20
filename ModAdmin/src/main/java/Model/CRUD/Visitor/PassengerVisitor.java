package Model.CRUD.Visitor;

import Model.Domain.Passenger;

public class PassengerVisitor implements PersonVisitor<Passenger> {
    @Override
    public Passenger visit(Passenger person) {
        return person;
    }
}
