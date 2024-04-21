package model.crud.visitor;

import model.domain.PassengerContact;

public class PassengerContactVisitor implements PersonVisitor<PassengerContact> {
    @Override
    public PassengerContact visit(PassengerContact person) {
        return person;
    }
}
