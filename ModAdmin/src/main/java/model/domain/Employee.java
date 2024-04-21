package model.domain;

import model.domain.abstractClasses.AbstractPerson;
import dataStructures.Array;

public class Employee extends AbstractPerson {
    public Employee(String idPerson, String names, String lastNames, Array<String> phoneNumbers) {
        super(idPerson, names, lastNames, phoneNumbers);
    }

    public Employee() {
        super("", "", "", new Array<>(1));
    }

    public static Employee getNullEmployee() {
        return new Employee();
    }


}
