package model.crud.repository;

import model.crud.repository.entities.EmployeeEntity;
import model.crud.shared.FileJsonAdapter;
import model.crud.shared.FileJsonInterface;
import model.domain.Employee;
import model.interfaces.CRUD.EmployeeRepoInterface;
import dataStructures.Array;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;

public class EmployeeRepository implements EmployeeRepoInterface {
    private final FileJsonInterface<EmployeeEntity> fileJson;
    private final String pathFile;

    public EmployeeRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public Boolean insert(Employee employee) {
        List<EmployeeEntity> employees = getEmployeeEntityList();
        EmployeeEntity employeeEntity = new EmployeeEntity(employee.getIdPerson(), employee.getNames(), employee.getLastNames(), employee.getPhoneNumbersString());
        employees.add(employeeEntity);
        return fileJson.writeObjects(pathFile, employees);
    }

    public Boolean delete(Employee employee) {
        List<EmployeeEntity> employees = getEmployeeEntityList();
        EmployeeEntity employeeEntity = new EmployeeEntity(employee.getIdPerson(), employee.getNames(), employee.getLastNames(), employee.getPhoneNumbersString());
        employees.remove(e -> e.getIdPerson().equals(employeeEntity.getIdPerson()));
        return fileJson.writeObjects(pathFile, employees);
    }

    public Boolean update(Employee employee) {
        ArrayList<EmployeeEntity> employees = (ArrayList<EmployeeEntity>) getEmployeeEntityList();
        EmployeeEntity employeeEntity = new EmployeeEntity(employee.getIdPerson(), employee.getNames(), employee.getLastNames(), employee.getPhoneNumbersString());
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getIdPerson().equals(employeeEntity.getIdPerson())) {
                employees.set(i, employeeEntity);
                break;
            }
        }
        return fileJson.writeObjects(pathFile, employees);
    }

    public Employee getEmployee(String idEmployee) {
        List<EmployeeEntity> employees = getEmployeeEntityList();
        Iterator<EmployeeEntity> it = employees.iterator();
        while (it.hasNext()) {
            EmployeeEntity employeeEntity = it.next();
            if (employeeEntity.getIdPerson().equals(idEmployee)) {
                return new Employee(employeeEntity.getIdPerson(), employeeEntity.getNames(), employeeEntity.getLastNames(),
                        new Array<String>(employeeEntity.getPhoneNumbers().split(",")));
            }
        }
        return Employee.getNullEmployee();
    }

    private List<EmployeeEntity> getEmployeeEntityList() {
        return fileJson.getObjects(pathFile, EmployeeEntity[].class);
    }

    public List<Employee> getEmployees() {
        List<EmployeeEntity> employees = getEmployeeEntityList();
        List<Employee> employeesList = new ArrayList<>();
        Iterator<EmployeeEntity> it = employees.iterator();
        while (it.hasNext()) {
            EmployeeEntity employeeEntity = it.next();
            employeesList.add(new Employee(employeeEntity.getIdPerson(), employeeEntity.getNames(), employeeEntity.getLastNames(),
                    new Array<String>(employeeEntity.getPhoneNumbers().split(","))));
        }
        return employeesList;
    }
}
