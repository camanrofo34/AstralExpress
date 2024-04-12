package Model.Domain;

import DataStructures.Array;
import Model.Domain.AbstractClasses.AbstractPerson;

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
