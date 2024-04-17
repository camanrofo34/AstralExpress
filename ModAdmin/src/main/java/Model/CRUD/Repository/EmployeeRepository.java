package Model.CRUD.Repository;

import dataStructures.Array;
import dataStructures.ArrayList;
import dataStructures.Interfaces.Iterator;
import dataStructures.Interfaces.List;
import Model.CRUD.Repository.Entities.EmployeeEntity;
import Model.Domain.Employee;
import Model.CRUD.Shared.FileJsonAdapter;
import Model.CRUD.Shared.FileJsonInterface;
import Model.Interfaces.CRUD.EmployeeRepoInterface;

public class EmployeeRepository implements EmployeeRepoInterface {
    private final FileJsonInterface<EmployeeEntity> fileJson;
    private final String pathFile;

    public EmployeeRepository(String pathFile) {
        this.pathFile = pathFile;
        this.fileJson = FileJsonAdapter.getInstance();
    }

    public Boolean insert(Employee employee){
        List<EmployeeEntity> employees = getEmployeeEntityList();
        EmployeeEntity employeeEntity = new EmployeeEntity(employee.getIdPerson(), employee.getNames(), employee.getLastNames(), employee.getPhoneNumbersString());
        employees.add(employeeEntity);
        return fileJson.writeObjects(pathFile, employees);
    }

    public Boolean delete(Employee employee){
        List<EmployeeEntity> employees = getEmployeeEntityList();
        EmployeeEntity employeeEntity = new EmployeeEntity(employee.getIdPerson(), employee.getNames(), employee.getLastNames(), employee.getPhoneNumbersString());
        employees.remove(employeeEntity);
        return fileJson.writeObjects(pathFile, employees);
    }

    public Boolean update(Employee employee){
        ArrayList<EmployeeEntity> employees = (ArrayList<EmployeeEntity>) getEmployeeEntityList();
        EmployeeEntity employeeEntity = new EmployeeEntity(employee.getIdPerson(), employee.getNames(), employee.getLastNames(), employee.getPhoneNumbersString());
        int index = employees.indexOf(employeeEntity);
        employees.set(index, employeeEntity);
        return fileJson.writeObjects(pathFile, employees);
    }

    public Employee getEmployee (String idEmployee){
        List<EmployeeEntity> employees = getEmployeeEntityList();
        Iterator<EmployeeEntity> it = employees.iterator();
        while (it.hasNext()){
            EmployeeEntity employeeEntity = it.next();
            if (employeeEntity.getIdPerson().equals(idEmployee)){
                return new Employee(employeeEntity.getIdPerson(), employeeEntity.getNames(), employeeEntity.getLastNames(),
                        new Array<String> (employeeEntity.getPhoneNumbers().split(",")));
            }
        }
        return Employee.getNullEmployee();
    }

    private List<EmployeeEntity> getEmployeeEntityList() {
        return fileJson.getObjects(pathFile, EmployeeEntity[].class);
    }

    public List<Employee> getEmployees (){
        List<EmployeeEntity> employees = getEmployeeEntityList();
        List<Employee> employeesList = new ArrayList<>();
        Iterator<EmployeeEntity> it = employees.iterator();
        while (it.hasNext()){
            EmployeeEntity employeeEntity = it.next();
            employeesList.add(new Employee(employeeEntity.getIdPerson(), employeeEntity.getNames(), employeeEntity.getLastNames(),
                    new Array<String> (employeeEntity.getPhoneNumbers().split(","))));
        }
        return employeesList;
    }
}
