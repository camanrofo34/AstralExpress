package Model.Domain;

import DataStructures.Array;
import Model.Domain.AbstractClasses.AbstractPerson;

public class Employee extends AbstractPerson {
    private String idEmployee;

    public Employee() {
        this.idEmployee = "";
    }

    public Employee(String idEmpleado) {
        this.idEmployee = idEmpleado;
    }

    public Employee(String names, String lastNames, Array<String> phoneNumbers) {
        super(names, lastNames, phoneNumbers);
    }

    public Employee(String idEmployee, String names, String lastNames, Array<String> phoneNumbers) {
        super(names, lastNames, phoneNumbers);
        this.idEmployee = idEmployee;
    }

    public static Employee getNullEmployee() {
        return new Employee();
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }


}
