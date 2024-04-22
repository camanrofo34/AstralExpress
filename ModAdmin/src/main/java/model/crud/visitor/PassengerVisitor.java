package model.crud.visitor;

import model.domain.Passenger;

public class PassengerVisitor implements PersonVisitor<Passenger> {

    /**
     * Method to visit a person
     * @param person
     * @return person
     */
    @Override
    public Passenger visit(Passenger person) {
        return person;
    }
}
