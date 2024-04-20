package Model.CRUD.Visitor;

import Model.Domain.Employee;

public class EmployeeVisitor implements PersonVisitor<Employee> {
    @Override
    public Employee visit(Employee person) {
        return person;
    }
}
