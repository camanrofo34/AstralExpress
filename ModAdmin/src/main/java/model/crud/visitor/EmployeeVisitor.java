package model.crud.visitor;

import model.domain.Employee;

public class EmployeeVisitor implements PersonVisitor<Employee> {
    @Override
    public Employee visit(Employee person) {
        return person;
    }
}
