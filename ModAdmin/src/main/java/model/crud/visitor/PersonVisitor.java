package model.crud.visitor;

import model.domain.abstractClasses.AbstractPerson;

public interface PersonVisitor<E extends AbstractPerson> {
    E visit(E element);
}
