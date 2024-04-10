package Model.CRUD.Visitor;

import Model.Domain.AbstractClasses.AbstractPerson;

public interface PersonVisitor <E extends AbstractPerson>{
    E visit(E element);
}
