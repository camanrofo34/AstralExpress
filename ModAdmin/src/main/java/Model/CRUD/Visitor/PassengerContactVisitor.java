package Model.CRUD.Visitor;

import Model.Domain.PassengerContact;

public class PassengerContactVisitor implements PersonVisitor<PassengerContact>{
    @Override
    public PassengerContact visit(PassengerContact person) {
        return person;
    }
}
