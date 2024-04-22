package model.crud.visitor;

import model.domain.Employee;

public class EmployeeVisitor implements PersonVisitor<Employee> {
    /**
     * Method to visit a person
     * @param person
     * @return person
     */
    @Override
    public Employee visit(Employee person) {
        return person;
    }
}
