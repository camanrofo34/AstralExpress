package model.crud.visitor;

import model.domain.PassengerContact;

public class PassengerContactVisitor implements PersonVisitor<PassengerContact> {

    /**
     * Method to visit a person
     * @param person
     * @return person
     */
    @Override
    public PassengerContact visit(PassengerContact person) {
        return person;
    }
}
