package Model.CRUD;

import DataStructures.Interfaces.List;
import Model.CRUD.Shared.FileJsonAdapter;
import Model.Domain.Employee;

public class JSONEmployee {
    private static final String FILE_NAME = "employee.json";
    private final FileJsonAdapter<Employee> fileJsonAdapter;

    public JSONEmployee() {
        this.fileJsonAdapter = FileJsonAdapter.getInstance();
    }

    public List<Employee> getEmployees() {
        return fileJsonAdapter.getObjects(FILE_NAME, Employee[].class);
    }

    public Boolean writeEmployees(List<Employee> employees) {
        return fileJsonAdapter.writeObjects(FILE_NAME, employees);
    }


}
