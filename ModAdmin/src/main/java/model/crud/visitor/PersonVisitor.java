package model.crud.visitor;

import model.domain.abstractClasses.AbstractPerson;

public interface PersonVisitor<E extends AbstractPerson> {

    /**
     * Method to visit a person
     * @param element
     * @return
     */
    E visit(E element);
}
