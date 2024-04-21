package model.crud.visitor;

import model.domain.Passenger;

public class PassengerVisitor implements PersonVisitor<Passenger> {
    @Override
    public Passenger visit(Passenger person) {
        return person;
    }
}
